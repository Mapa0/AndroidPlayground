package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton rd1;
    RadioButton rd2;
    RadioButton rd3;

    private void changeRadioButtonText(String text, RadioButton[] radioButtonArray){
        for(RadioButton rd : radioButtonArray) {
            rd.setText(text);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        radioGroup = findViewById(R.id.radioGroup);
        rd1 = findViewById(R.id.radioButton);
        rd2 = findViewById(R.id.radioButton2);
        rd3 = findViewById(R.id.radioButton3);
        RadioButton[] radioButtonArray = {rd1,rd2,rd3};

        changeRadioButtonText("Desmarcado", radioButtonArray);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                changeRadioButtonText("Desmarcado", radioButtonArray);
                switch(checkedId){
                    case R.id.radioButton:
                        rd1.setText("CheckBox 1 MARCADO");
                        break;
                    case R.id.radioButton2:
                        rd2.setText("CheckBox 2 MARCADO");
                        break;
                    case R.id.radioButton3:
                        rd3.setText("CheckBox 3 MARCADO");
                        break;

                }
            }
        });

    }
}