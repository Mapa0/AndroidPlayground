package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edSenha;
    Button btLogar;

    public boolean login(String email, String senha){
        if(email.trim().equals("")||
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edEmail.setError("Preencha.");
            edEmail.requestFocus();
            return false;
        }
        if(senha.trim().equals("")){
            edSenha.setError("Preencha.");
            edSenha.requestFocus();
            return false;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        btLogar = findViewById(R.id.btLogar);

        btLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = edEmail.getText().toString();
                String senha = edSenha.getText().toString();
                //a função trim() remove os espaços da String

                if(login(email,senha)){
                    Intent i = new Intent(
                            MainActivity.this,
                            MainActivity2.class
                    );
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),
                            "O e-mail digitado foi: " + email +
                                    "e a senha digitada foi: " + senha,
                            Toast.LENGTH_LONG).show();
                }
                }
        });
    }
}