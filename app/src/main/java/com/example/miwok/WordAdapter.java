package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param resource is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> resource,int colorResourceId) {
        super(context, 0, resource);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.my_simple_layout, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        englishTextView.setText(currentWord.get_english());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView hindiTextView = (TextView) listItemView.findViewById(R.id.hindi);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        hindiTextView.setText(currentWord.get_hindi());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView default_imageView = (ImageView)listItemView.findViewById(R.id.default_image);
        // Check if an image is provided for this word or not
        if(currentWord.hasImage()){
            // If an image is available, display the provided image based on the resource ID
            default_imageView.setImageResource(currentWord.get_image());
            // Make sure the view is visible
            default_imageView.setVisibility(View.VISIBLE);
        }else{
            // Otherwise hide the ImageView (set visibility to GONE)
            default_imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        //one way to add onlick is to add in all java class and another way is to add in the wordadapter
//        MediaPlayer music = MediaPlayer.create(this.getContext(), currentWord.get_music());
//
//        listItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                music.start();
//            }
//        });

//        englishTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                music.start();
//            }
//        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
