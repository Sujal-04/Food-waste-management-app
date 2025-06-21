package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText login_email,login_password;
    Button login_btn;
    TextView signup_redirect,forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();
        login_email=findViewById(R.id.login_email);
        login_password=findViewById(R.id.login_password);
        login_btn=findViewById(R.id.login_btn);
        signup_redirect=findViewById(R.id.signup_redirect);
        forgot=findViewById(R.id.forgot);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=login_email.getText().toString().trim();
                String pass=login_password.getText().toString().trim();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Login.this,HomePage.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Login.this, "Login Failed, Please Check Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                    else {
                        login_password.setError("Password Cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    login_email.setError("Email Cannot be empty");
                }
                else {
                    login_email.setError("Please enter valid email");
                }
            }
        });

        signup_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ForgotPassword.class));
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(Login.this, MainActivity.class));
        finish();
        finishAffinity();
    }
}