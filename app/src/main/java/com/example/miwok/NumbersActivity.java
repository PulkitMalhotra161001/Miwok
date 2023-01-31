package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> no_list=new ArrayList<>();
        no_list.add(new Word("One","एक",R.drawable.number_one,R.raw.one));
        no_list.add(new Word("Two","दो",R.drawable.number_two,R.raw.two));
        no_list.add(new Word("Three","तीन",R.drawable.number_three,R.raw.three));
        no_list.add(new Word("Four","चार",R.drawable.number_four,R.raw.four));
        no_list.add(new Word("Five","पांच",R.drawable.number_five,R.raw.five));
        no_list.add(new Word("Six","छह",R.drawable.number_six,R.raw.six));
        no_list.add(new Word("Seven","सात",R.drawable.number_seven,R.raw.seven));
        no_list.add(new Word("Eight","आठ",R.drawable.number_eight,R.raw.eight));
        no_list.add(new Word("Nine","नौ",R.drawable.number_nine,R.raw.nine));
        no_list.add(new Word("Ten","दस",R.drawable.number_ten,R.raw.ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter wp=new WordAdapter(this, no_list,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);



//        ArrayAdapter<String> ap=new ArrayAdapter<>(this, R.layout.my_simple_layout,list);
//        ArrayAdapter<String> ap=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(ap);
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
                Word word = no_list.get(i);

                //print current details of the @Word class in logcat (search it by pasting "Current Word" in search box
                Log.v("NumbersActivity","Current Word : "+word.toString());

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                audio= MediaPlayer.create(NumbersActivity.this,word.get_music());

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