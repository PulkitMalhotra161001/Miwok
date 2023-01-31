package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> colors_list=new ArrayList<>();
        colors_list.add(new Word("Red","लाल",R.drawable.color_red,R.raw.red));
        colors_list.add(new Word("Gray","स्लेटी",R.drawable.color_gray,R.raw.grey));
        colors_list.add(new Word("Green","हरा",R.drawable.color_green,R.raw.green));
        colors_list.add(new Word("Dusty yellow","धूलदार पीला",R.drawable.color_dusty_yellow,R.raw.dusty_yellow));
        colors_list.add(new Word("Mustard yellow","सरसों पीली",R.drawable.color_mustard_yellow,R.raw.mustad_yellow));
        colors_list.add(new Word("White","सफ़ेद",R.drawable.color_white,R.raw.white));
        colors_list.add(new Word("Black","काला",R.drawable.color_black,R.raw.black));
        colors_list.add(new Word("Brown","भूरा",R.drawable.color_brown,R.raw.brown));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter wp=new WordAdapter(this, colors_list,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(wp);

        //one way to add onlick is to add in all java class and another way is to add in the wordadapter
        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = colors_list.get(i);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                audio= MediaPlayer.create(ColorsActivity.this,word.get_music());

                // Start the audio file
                audio.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    /**
                     * This listener gets triggered when the {@link MediaPlayer} has completed
                     * playing the audio file.
                     */
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        // Now that the sound file has finished playing, release the media player resources.
                        releaseMediaPlayer();
                    }
                });

            }
        });

    }

    //stop when user gets outside the activity
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (audio != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            audio.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            audio = null;
        }
    }

}