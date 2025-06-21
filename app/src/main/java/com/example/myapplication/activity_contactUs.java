package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class activity_contactUs extends AppCompatActivity {
    EditText login_email,edit_query;
    Button query_btn;
    TextView call_redirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        login_email = findViewById(R.id.login_email);
        edit_query = findViewById(R.id.edit_query);
        query_btn =findViewById(R.id.query_btn);
        call_redirect = findViewById(R.id.call_redirect);

        query_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"savefoodforall@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,("App FeedBack or Query"));
                i.putExtra (Intent.EXTRA_TEXT,  "Email: " + login_email.getText() +"\n Query/Feedback: "+ edit_query.getText ()) ;
                try {
                    startActivity(Intent.createChooser(i,"Please Select Mail"));
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(), "There are no email clients", Toast.LENGTH_SHORT).show();
                }

            }
        });
        call_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 9769037682"));
                startActivity(callIntent);
            }
        });
    }
}