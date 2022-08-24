package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityButtons
        extends AppCompatActivity implements View.OnClickListener{

    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buttons);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt1){
            Toast.makeText(getApplicationContext(),
                    "botão 1",
                    Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.bt2){
            Toast.makeText(getApplicationContext(),
                    "botão 2",
                    Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.bt3){
            Toast.makeText(getApplicationContext(),
                    "botão 3",
                    Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.bt4){
            Toast.makeText(getApplicationContext(),
                    "botão 4",
                    Toast.LENGTH_SHORT).show();
        }
    }
}