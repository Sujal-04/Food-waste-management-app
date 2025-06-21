package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<details> list;

    String text;



    public MyAdapter(Context context, ArrayList<details> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_foodentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        details user=list.get(position);
        holder.name.setText(user.getInputUsername());
        holder.contact.setText(user.getInputContact());
        holder.type.setText(user.getInputfoodtype());
        holder.quantity.setText(user.getInputfoodquantity());
        holder.city.setText(user.getInputcity());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, contact, type, quantity, city;
        View rootView;
        Button book;

        CheckBox cb1;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView=itemView;
            name = itemView.findViewById(R.id.textname);
            contact = itemView.findViewById(R.id.textcontact);
            type=itemView.findViewById(R.id.texttype);
            quantity=itemView.findViewById(R.id.textQuantity);
            city=itemView.findViewById(R.id.textcity);
            book=itemView.findViewById(R.id.book);
            cb1=itemView.findViewById(R.id.cb1);




            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Number= contact.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+ Number));
                    rootView.getContext().startActivity(i);


                }
            });

            cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (cb1.isChecked()){
                        String Number= contact.getText().toString();
                        Intent Sms=new Intent((Intent.ACTION_VIEW));
                        Sms.setType("vnd.android-dir/mms-sms");
                        Sms.putExtra("address",Number);
                        Sms.putExtra("sms_body","Your Order will be completed By ");
                        cb1.setEnabled(false);
                        rootView.getContext().startActivity(Sms);

                    }

                }
            });





        }


    }
    }

