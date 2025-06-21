package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        SharedPreferences sharedpreferences = getSharedPreferences (  "shared_prefs", MODE_PRIVATE) ;
        String username = sharedpreferences. getString("Username", ""). toString();
        Toast.makeText(getApplicationContext(), "Welcome "+ username,Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomePage.this,Login.class));
            }
        });

        CardView contact = findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,activity_contactUs.class));
            }
        });



        CardView aboutus = findViewById(R.id.aboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,About_us.class));
            }
        });

        CardView view = findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  startActivity(new Intent(HomePage.this, viewdetails.class));
            }
        });



    }


}