package com.example.myapplication11111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class food_display extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    public static List<GalleryModelClass> galleryList;
    public GridView gridView;
    public foodAdapter myAdapter;
   // private int FS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Order");
        setContentView(R.layout.activity_food_display);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        galleryList = new ArrayList<>();
        gridView = (GridView) findViewById(R.id.gridview);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("food");
        DatabaseReference addValueEventLister;
        mDatabaseRef = addValueEventLister(new ValueEventListener() {

            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot Snapshot : dataSnapshot.getChildren()) ;
                {
                    GalleryModelClass img = dataSnapshot.getValue(GalleryModelClass.class);
                    galleryList.add(img);

                }
                myAdapter=new foodAdapter(food_display.this,R.layout.gallery_design,galleryList);

                gridView.setAdapter(myAdapter);
                return gridView.setOnClickListener(new AdapterView.OnItemClickListener() {


                                                       @Override
                                                       public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                                           {

                                                               Intent intent = new Intent(food_display.this, FoodFullSceenActivity.class);
                                                               intent.putExtra("postion", position);
                                                               startActivity(intent);

                                                           });

                                                       }
                                                   });


            }
            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
    }
}



