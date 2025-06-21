package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewdetails extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<details> list;
    DatabaseReference databaseReference;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetails);
        recyclerView=findViewById(R.id.recyclerview);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        ActivityCompat.requestPermissions(viewdetails.this,new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    details user = dataSnapshot.getValue(details.class);
                    list.add(user);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}