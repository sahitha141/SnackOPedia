package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class food_display extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    public static List<GalleryModelClass> galleryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);
    }
}