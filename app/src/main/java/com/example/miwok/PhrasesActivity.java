package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer audio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);



        // Create a list of words
        final ArrayList<Word> phrases_list=new ArrayList<>();
        phrases_list.add(new Word("How are you?","क्या हाल है?",R.raw.how_are_you));
        phrases_list.add(new Word("Where are you going?","कहां जा रहा है?",R.raw.where_are_you_going));
        phrases_list.add(new Word("What is your name?","तुम्हारा नाम क्या हे?",R.raw.what_is_your_name));
        phrases_list.add(new Word("My name is...","मेरा नाम है...",R.raw.my_name_is));
        phrases_list.add(new Word("How are you feeling?","तुम्हे कैसा लग रहा है?",R.raw.how_are_you_feeling));
        phrases_list.add(new Word("I’m feeling good.","मैं अच्छा महसूस कर रहा हूँ।",R.raw.im_feeling_good));
        phrases_list.add(new Word("Are you coming?","क्या आप आ रहे हैं?",R.raw.are_you_coming));
        phrases_list.add(new Word("Yes, I’m coming.","हाँ, आ रहा हूं।",R.raw.yes_im_coming));
        phrases_list.add(new Word("Let’s go.","चलिए चलते हैं।",R.raw.lets_go));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter wp=new WordAdapter(this, phrases_list,R.color.category_phrases);

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
                Word word = phrases_list.get(i);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                audio= MediaPlayer.create(PhrasesActivity.this,word.get_music());

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