package com.example.myapplication11111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.window.SplashScreen;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText password,username;
    Button btnlogin,account;
    Spinner spinner;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;
    DatabaseReference reference;
    FirebaseUser firebaseUser;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser !=null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=(EditText) findViewById(R.id.password);
        username=(EditText) findViewById(R.id.username);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        spinner=(Spinner) findViewById(R.id.spinner);
        account=(Button)findViewById(R.id.account);
        auth=FirebaseAuth.getInstance();
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                if (item.equals("Admin")) {
                    Intent intent = new Intent(MainActivity.this,  Admin.class);
                    startActivity(intent);

                } else if (username.getText().toString().equals("user1") && password.getText().toString().equals("user1") && item.equals("User")) {
                    Intent intent = new Intent(MainActivity.this, User.class);
                    startActivity(intent);


                } else if (username.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter email", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter password", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    auth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                               Toast.makeText(MainActivity.this,"login",Toast.LENGTH_LONG).show();
                               Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                               startActivity(intent);
                            }
                        }
                    });

                  //  register();


                }
                password.getText().clear();
                username.getText().clear();
                username.requestFocus();


            }

        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }


}