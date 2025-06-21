package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class Upload_Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private  static final String CHANNEL_ID="MY NOTIFICATION";
    Button btnsubmit;
    EditText inputUsername,inputContact,inputother;
    Spinner inputfoodtype,inputfoodquantity,inputcity;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_details);

        btnsubmit=findViewById(R.id.btnSubmit);
        inputUsername=findViewById(R.id.inputUsername);
        inputContact=findViewById(R.id.inputContact);




        inputfoodtype=findViewById(R.id.inputfoodtype);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.food_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputfoodtype.setAdapter(adapter);
        inputfoodtype.setOnItemSelectedListener(this);

        // Create and set up the custom adapter with white text color
        WhiteTextSpinnerAdapter adapter1 = new WhiteTextSpinnerAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.food_type));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputfoodtype.setAdapter(adapter1);
        inputfoodtype.setOnItemSelectedListener(this);




        inputfoodquantity=findViewById(R.id.inputfoodquantity);

        ArrayAdapter<CharSequence>adapterquantity=ArrayAdapter.createFromResource(this,R.array.food_quantity, android.R.layout.simple_spinner_item);
        adapterquantity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputfoodquantity.setAdapter(adapterquantity);
        inputfoodquantity.setOnItemSelectedListener(this);

        // Create and set up the custom adapter with white text color
        WhiteTextSpinnerAdapter adapter4 = new WhiteTextSpinnerAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.food_quantity));
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputfoodquantity.setAdapter(adapter4);
        inputfoodquantity.setOnItemSelectedListener(this);



        inputcity=findViewById(R.id.inputcity);

        ArrayAdapter<CharSequence>adaptercity=ArrayAdapter.createFromResource(this,R.array.city, android.R.layout.simple_spinner_item);
        adaptercity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputcity.setAdapter(adaptercity);
        inputcity.setOnItemSelectedListener(this);

        // Create and set up the custom adapter with white text color
        WhiteTextSpinnerAdapter adapter5 = new WhiteTextSpinnerAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.city));
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputcity.setAdapter(adapter5);
        inputcity.setOnItemSelectedListener(this);

        databaseUsers= FirebaseDatabase.getInstance().getReference();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel CHANNEL = new NotificationChannel("MY NOTIFICATION","MY NOTIFICATION", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(CHANNEL);}

        btnsubmit.setOnClickListener(new OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputUsername.getText().toString())){
                    inputUsername.setError("Username cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(inputContact.getText().toString())){
                    inputContact.setError("Contact Number cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(inputContact.getText().toString())){
                    inputContact.setError("Contact Number cannot be empty");
                    return;
                }

                InsertData();

                NotificationCompat.Builder builder= new NotificationCompat.Builder(Upload_Details.this,"MY NOTIFICATION");
                builder.setContentTitle("Food Save");
                builder.setContentText("New donor available");
                builder.setSmallIcon(R.drawable.notification);
                builder.setAutoCancel(true);
                builder.setChannelId(CHANNEL_ID);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(Upload_Details.this);
                notificationManagerCompat.notify(1,builder.build());
            }
        });





    }




    //end of on create method


    String selectedfoodtype;
    String selectedfoodquantity;
    String selectedfoodcity;
    public void InsertData() {
        String name=inputUsername.getText().toString();
        String contact=inputContact.getText().toString();

        String food=selectedfoodtype;
        String quantity=selectedfoodquantity;
        String city=selectedfoodcity;
        String id = databaseUsers.push().getKey();

        details user= new details(name,contact,food,quantity,city);
        databaseUsers.child("users").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Upload_Details.this, "Food Details Inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        selectedfoodtype = adapterView.getItemAtPosition(i).toString();
//        selectedfoodquantity = adapterView.getItemAtPosition(i).toString();
//        selectedfoodcity = adapterView.getItemAtPosition(i).toString();
//
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int viewId = adapterView.getId();

        if (viewId == R.id.inputfoodtype) {
            selectedfoodtype = adapterView.getItemAtPosition(i).toString();
        } else if (viewId == R.id.inputfoodquantity) {
            selectedfoodquantity = adapterView.getItemAtPosition(i).toString();
        } else if (viewId == R.id.inputcity) {
            selectedfoodcity = adapterView.getItemAtPosition(i).toString();
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

