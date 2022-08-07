package com.example.myapplication11111;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;*/

public class Register extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;
    DatabaseReference reference;
    FirebaseUser firebaseUser;
    EditText  inputUsername, inputEmail, inputPassword, confirmPassword;
    Button btnregister;
    TextView alreadyhaveaccount;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser !=null){
            Intent intent = new Intent(Register.this,HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
          // startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        inputUsername=findViewById(R.id.inputUsername);
        btnregister = findViewById(R.id.btnregister);
        alreadyhaveaccount=findViewById(R.id.alreadyhaveaccount);
        auth=FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent (Register.this,MainActivity.class);
                startActivity(intent);
           }
       });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
                Intent intent=new Intent(Register.this,HomeActivity.class);
                startActivity(intent);
            }

        });
    }

    private void PerforAuth() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmpassword1 = confirmPassword.getText().toString();
        if (!email.matches(emailPattern)) {
            inputEmail.setError("Enter Correct Email");
        }
        else if (password.isEmpty() || password.length() < 6) {
            inputPassword.setError("Enter correct password");
        }
        else  if (!inputPassword.getText().toString().equals(confirmpassword1)) {
            confirmPassword.setError("Password not match both field");
        } else {
            Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();
            register(inputUsername.getText().toString(), email, password);

           // Intent intent = new Intent(Register.this, HomeActivity.class);
           // startActivity(intent);
        }
    }

        private void sendUserToNextActivity () {
            Intent intent = new Intent(Register.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    private void register(String username,String email,String password){
        try {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        FirebaseUser firebaseUser = auth.getCurrentUser();
                        String userid =firebaseUser.getUid();
                        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                        HashMap<String ,String> hashMap = new HashMap<>();
                        hashMap.put("id",userid);
                        hashMap.put("username",username);
                        hashMap.put("password",password);

                        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Register.this,"succss",Toast.LENGTH_SHORT).show();
                                     Intent intent = new Intent(Register.this,MainActivity.class);
                                     //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                     startActivity(intent);
                                }
                            }
                        });
                    }else{
                       // prog1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Register.this,"Error:"+task.getException(),Toast.LENGTH_SHORT).show();

                    }

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

