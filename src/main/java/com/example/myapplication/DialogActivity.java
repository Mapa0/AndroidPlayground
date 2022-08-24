package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    Button dialogShowButton;
    Switch dialogSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        dialogShowButton = findViewById(R.id.dialogShow);
        dialogSwitch = findViewById(R.id.switch1);

        dialogSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(dialogSwitch.isChecked()){
                    dialogSwitch.setText("Dialogo de confirmação");
                }
                else{
                    dialogSwitch.setText("Dialogo neutro");
                }
            }
        });

        dialogShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogSwitch.isChecked()){
                    AlertDialog.Builder janela = new AlertDialog.Builder(DialogActivity.this);
                    janela.setTitle("Dialogo de confirmacao");
                    janela.setMessage("Clique no botão de ok para voltar");
                    //janela.setNeutralButton("Botão ok", null);
                    janela.setPositiveButton("Botão de ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(
                                    DialogActivity.this,
                                    MainActivity2.class
                            );
                            startActivity(intent);
                        }
                    });
                    janela.setNegativeButton("Botão de Cancelar", null);
                    janela.show();
                }
                else{
                    AlertDialog.Builder janela = new AlertDialog.Builder(DialogActivity.this);
                    janela.setTitle("Dialogo neutro");
                    janela.setMessage("Mensagem da janela");
                    janela.setIcon(R.drawable.ifms);
                    janela.setNeutralButton("Botão ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"Neutro", Toast.LENGTH_SHORT).show();
                        }
                    });
                    janela.show();
                }
            }
        });

    }
}