package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class user_option extends AppCompatActivity {
    Button form,Ngo_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_option);
        form = findViewById(R.id.form);
        Ngo_contact = findViewById(R.id.Ngo_contact);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_option.this,Upload_Details.class));
            }
        });
        Ngo_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_option.this,ngo_table.class));
            }
        });
    }
}