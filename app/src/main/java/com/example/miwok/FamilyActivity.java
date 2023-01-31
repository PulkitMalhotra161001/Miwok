package com.example.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("Father","पिता",R.drawable.family_father,R.raw.father));
        words.add(new Word("Mother","माता",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Son","बेटा",R.drawable.family_son,R.raw.son));
        words.add(new Word("Daughter","बेटी",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("Older sister","बड़ी बहन",R.drawable.family_older_sister,R.raw.older_sister));
        words.add(new Word("Younger sister","छोटी बहन",R.drawable.family_younger_sister,R.raw.younger_sister));
        words.add(new Word("Older brother","बड़ा भाई",R.drawable.family_older_brother,R.raw.older_brother));
        words.add(new Word("Younger brother","छोटा भाई",R.drawable.family_younger_brother,R.raw.younger_brother));
        words.add(new Word("Grandfather","दादा",R.drawable.family_grandfather,R.raw.grandfather));
        words.add(new Word("Grandmother","दादी",R.drawable.family_grandmother,R.raw.grandmother));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter wp=new WordAdapter(this, words,R.color.category_family);

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
                Word word = words.get(i);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                audio= MediaPlayer.create(FamilyActivity.this,word.get_music());

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