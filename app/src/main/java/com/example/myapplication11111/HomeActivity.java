package com.example.myapplication11111;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    CardView drinks,lunch,fastfood,hotdrinks,icecream;
    CardView brkfast;
    ImageView brk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        brkfast=findViewById(R.id.brkfast);
        brk=(ImageView)findViewById(R.id.brk);
        drinks=findViewById(R.id.drinks);
        lunch=findViewById(R.id.lunch);
        fastfood=findViewById(R.id.fastfood);
        hotdrinks=findViewById(R.id.fastfood);
       drawerLayout=findViewById(R.id.drawer_layout);

       brk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(HomeActivity.this,brkfast.class);
               intent.putExtra("breakfast","Breakfast");
               startActivity(intent);
           }
       });
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,drinks.class);
                startActivity(intent);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,lunch.class);
                startActivity(intent);
            }
        });
        fastfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,fastfood.class);
                startActivity(intent);
            }
        });
        hotdrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,hotdrinks.class);
                startActivity(intent);
            }
        });
    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer((GravityCompat.START));
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void clickAboutus(View view){
        Intent intent=new Intent(HomeActivity.this,About_us.class);
        startActivity(intent);
    }
    public void ClickHome(View view){
        recreate();
    }

    public void ClickFeedback(View view){
        Intent intent=new Intent(HomeActivity.this,feedback.class);
        startActivity(intent);
    }
    public void ClickRating(View view){
        Intent intent=new Intent(HomeActivity.this,rating.class);
        startActivity(intent);

    }


    public void ClickLogout(View view) {
        //close app
        logout(this);
    }

    public void logout(final Activity activity) {
        //initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(HomeActivity.this,Register.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //initialize intent
        Intent intent = new Intent(activity, aClass);
        //set flog
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);


    }



}

