package com.example.miwok;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NumberOnClickListner extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(),"NumbersActivity",Toast.LENGTH_LONG).show();
//        Intent intent=new Intent(MainActivity.class,NumbersActivity.class);
//        startActivity(intent);

    }


}
