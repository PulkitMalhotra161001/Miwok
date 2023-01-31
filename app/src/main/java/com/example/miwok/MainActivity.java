package com.example.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

//        NumberOnClickListner nb=new NumberOnClickListner();
        // Find the View that shows the numbers category
        TextView num=(TextView)findViewById(R.id.numbers);
//        num.setOnClickListener(nb);

        // Set a click listener on that View
        num.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent=new Intent(MainActivity.this,NumbersActivity.class);

                // Start the new activity
                startActivity(intent);
            }
        });

        // Find the View that shows the family category
        TextView fam=(TextView)findViewById(R.id.family);

        // Set a click listener on that View
        fam.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent intent=new Intent(MainActivity.this,FamilyActivity.class);

                // Start the new activity
                startActivity(intent);
            }
        });

        // Find the View that shows the colors category
        TextView col=(TextView)findViewById(R.id.colors);

        // Set a click listener on that View
        col.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent intent=new Intent(MainActivity.this,ColorsActivity.class);

                // Start the new activity
                startActivity(intent);
            }
        });


        // Find the View that shows the phrases category
        TextView pha=(TextView)findViewById(R.id.phrases);

        // Set a click listener on that View
        pha.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent intent=new Intent(MainActivity.this,PhrasesActivity.class);

                // Start the new activity
                startActivity(intent);
            }
        });

//        ArrayList<word> words=new ArrayList<>();
//        words.add(new word("One","एक"));
//        words.add(new word("Two","दो"));
//        words.add(new word("Three","तीन"));
//        words.add(new word("Four","चार"));
//        words.add(new word("Five","पांच"));
//        words.add(new word("Six","छह"));
//        words.add(new word("Seven","सात"));
//        words.add(new word("Eight","आठ"));
//        words.add(new word("Nine","नौ"));
//        words.add(new word("Ten","दस"));
//        WordAdapter wp=new WordAdapter(this, words);
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(wp);

    }

//    public void openNumbersActivity(View view) {
//        Intent intent=new Intent(this,NumbersActivity.class);
//        startActivity(intent);
//    }
//
//    public void openFamilyMembersActivity(View view) {
//        Intent intent=new Intent(this,FamilyActivity.class);
//        startActivity(intent);
//    }
//
//    public void openColorsActivity(View view) {
//        Intent intent=new Intent(this,ColorsActivity.class);
//        startActivity(intent);
//    }
//
//    public void openPhrasesActivity(View view) {
//        Intent intent=new Intent(this,PhrasesActivity.class);
//        startActivity(intent);
//    }
}