package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    //campo de busca
    SearchView searchView;
    //lista de itens
    ListView listView;

    ArrayList<String> arrayListItens = new ArrayList<>();
    ArrayAdapter<String> meuAdapter;
    ArrayList<String> arrayListItensCopia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        searchView  = findViewById(R.id.searchView1);
        listView  = findViewById(R.id.listView1);

        arrayListItens.add("CheckBox");
        arrayListItens.add("RadioButton");
        arrayListItens.add("Janela de Diálogo");
        arrayListItens.add("Buttons");
        arrayListItens.add("Spinner");
        arrayListItens.add("Calculator");

        arrayListItensCopia = new ArrayList<>(arrayListItens);

        //adapter: vincular arrayList com a ListView
        meuAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayListItens
        );

        //...usando o adapter. Aqui a lista é atualizada/exibida
        listView.setAdapter(meuAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position é o índice do item na AdapterView.
                if (position ==0){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            CheckBoxActivity.class
                    );
                    startActivity(intent);
                }
                if (position ==1){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            RadioActivity.class
                    );
                    startActivity(intent);
                }
                if (position ==2){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            DialogActivity.class
                    );
                    startActivity(intent);
                }
                if (position ==3){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            MainActivityButtons.class
                    );
                    startActivity(intent);
                }
                if (position ==4){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            MainActivityButtons.class
                    );
                    startActivity(intent);
                }
                if (position ==5){
                    Intent intent = new Intent(
                            MainActivity2.this,
                            CalculatorActivity.class
                    );
                    startActivity(intent);
                }
            }
        });

        //expande item
        searchView.setIconified(false);
        //fecha o teclado
        searchView.clearFocus();

        //ouvinte do searchView para mudanças na digitação
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //este método é chamado no submit
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            //este método é chamado ao digitar
            @Override
            public boolean onQueryTextChange(String s) {
                //forma 1: utilizar filter pronto
                //MainActivity2.this.meuAdapter.getFilter().filter(s);

                //forma 2: fazer a busca manualmente
                //método para atualizar itens do arraylist
                fazerBusca(s);
                //atualiza lista com arrayList alterado
                meuAdapter.notifyDataSetChanged();

                return false;
            }
        });
    }

    private void fazerBusca(String s) {
        //limpando o array
        arrayListItens.clear();

        s = s.toLowerCase();

        //percorre array de cópia com todos os itens e busca
        for(String item: arrayListItensCopia){
            if(item.toLowerCase().contains(s)){
                //se item encontrado, adicionada de volta no array
                arrayListItens.add(item);
            }
        }
    }
}