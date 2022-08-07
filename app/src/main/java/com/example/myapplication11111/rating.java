package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class rating extends AppCompatActivity {
    RatingBar ratingBar;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ratingBar=findViewById(R.id.rating_bar);
        btn_submit=findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Start", Toast.LENGTH_SHORT).show();
            }
        });
    }
}