package com.example.myapplication11111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class brkfast   extends AppCompatActivity {
    RecyclerView recyclerView;
    BDMyAdapter bdMyAdapter;
    ArrayList<modelBdetails> list;

    SearchView searchView;
    ProgressBar progress;
    DatabaseReference root=FirebaseDatabase.getInstance().getReference("Food").child("Breakfast");
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brkfast);

      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // searchView = findViewById(R.id.search1);
       // Intent intent=getIntent();
       // String s=intent.getStringExtra("breakfast");
        recyclerView = findViewById(R.id.breakfast1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        auth=FirebaseAuth.getInstance();

        progress = findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);

        list = new ArrayList<>();
        bdMyAdapter = new BDMyAdapter(this, list);
        recyclerView.setAdapter(bdMyAdapter);

        list=new ArrayList<>();
        bdMyAdapter=new BDMyAdapter(this,list);
        recyclerView.setAdapter(bdMyAdapter);


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    modelBdetails modelBdetails = dataSnapshot.getValue(modelBdetails.class);
                    list.add(modelBdetails);

                }
                bdMyAdapter.notifyDataSetChanged();
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}




