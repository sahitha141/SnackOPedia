 package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.ktx.Firebase;

 public class feedback extends AppCompatActivity {
     private Firebase Ref;
    private EditText username,feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        username=(EditText) findViewById(R.id.username);
        feedback=(EditText) findViewById(R.id.feedback);
    }

     public void feedbacksent(View view) {
     }
 }