package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;


public class ngo_table extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_table);

        button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7506731178"));
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:7021495653"));
                startActivity(intent1);
            }
        });

        button2 = findViewById(R.id.btn3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:9769037682"));
                startActivity(intent2);
            }
        });

        button3 = findViewById(R.id.btn4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:9769312232"));
                startActivity(intent3);
            }
        });

        button4 = findViewById(R.id.btn5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                intent4.setData(Uri.parse("tel:9819309628"));
                startActivity(intent4);
            }
        });

        button5 = findViewById(R.id.btn6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Intent.ACTION_DIAL);
                intent5.setData(Uri.parse("tel:9820443499"));
                startActivity(intent5);
            }
        });

        button6 = findViewById(R.id.btn7);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Intent.ACTION_DIAL);
                intent6.setData(Uri.parse("tel:7977200709"));
                startActivity(intent6);
            }
        });

        button7 = findViewById(R.id.btn8);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Intent.ACTION_DIAL);
                intent7.setData(Uri.parse("tel:8734508215"));
                startActivity(intent7);
            }
        });

        button8 = findViewById(R.id.btn9);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Intent.ACTION_DIAL);
                intent8.setData(Uri.parse("tel:5329071782"));
                startActivity(intent8);
            }
        });

        button9 = findViewById(R.id.btn10);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(Intent.ACTION_DIAL);
                intent9.setData(Uri.parse("tel:6347621890"));
                startActivity(intent9);
            }
        });
    }
}