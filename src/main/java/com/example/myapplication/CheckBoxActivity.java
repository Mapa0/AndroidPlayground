package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        bt = findViewById(R.id.btn1);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Checkbox 1 " + cb1.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Checkbox 2 " + cb2.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Checkbox 3 " + cb3.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        bt.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Toast.makeText(getApplicationContext(),  "Status: "+ cb1.isChecked()+ cb2.isChecked() + cb3.isChecked(), Toast.LENGTH_LONG).show();
           }
        });

    }
}