package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.sql.Struct;

public class ForgotPassword extends AppCompatActivity {

    EditText forgot_email;
    Button forgot_btn;
    String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        forgot_email=findViewById(R.id.forgot_email);
        forgot_btn=findViewById(R.id.forgt_btn);

        auth=FirebaseAuth.getInstance();

        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });


    }
    private void validateEmail(){
        email=forgot_email.getText().toString().trim();
        if (email.isEmpty()){
            forgot_email.setError("Enter Your Email");
        }
        else {
            forgot_Password();
        }
    }

    private void  forgot_Password(){
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this, "Please Check You Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPassword.this,Login.class));
                            finish();
                        }
                        else {
                            Toast.makeText(ForgotPassword.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
