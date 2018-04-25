package com.example.diogo.agenda_de_bolso;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Alimentos extends AppCompatActivity {
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lista);
        final ArrayList<Item> alimentos = new ArrayList<>();
        Button btnNovo = findViewById(R.id.btnNovo);
        ListView list = findViewById(R.id.lista);
        adapter = new ItemAdapter(this,alimentos);
        list.setAdapter(adapter);


        Item a = new Item ("Nome teste","Nome traduzido teste","frase teste");
        alimentos.add(a);

        Item b = new Item ("Nome teste","Nome traduzido teste","frase teste");
        alimentos.add(b);

        Item c = new Item ("Nome teste","Nome traduzido teste","frase teste");
        alimentos.add(c);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Item a = (Item) parent.getItemAtPosition(i);
                //Toast.makeText(getApplicationContext(),a.getFrase(),Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(Alimentos.this).create();
                alertDialog.setTitle("Aplicação em uma frase:");
                alertDialog.setMessage(a.getFrase());

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                alimentos.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }

        });


        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    View v = getLayoutInflater().inflate(R.layout.layout_novo_item, null);
                    final AlertDialog alert = new AlertDialog.Builder(Alimentos.this).create();
                    alert.setView(v);

                    alert.setTitle("Novo Item");
                    alert.setButton(AlertDialog.BUTTON_POSITIVE,"Novo", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            try{
                                final EditText etNovoNome = ((Dialog) arg0).findViewById(R.id.etNomeNovo);
                                final EditText etTraducao= ((Dialog) arg0).findViewById(R.id.etTraducao);
                                final EditText etFrase= ((Dialog) arg0).findViewById(R.id.etFrase);

                                if((etNovoNome.getText().length() == 0)||(etTraducao.getText().length() == 0) || (etFrase.getText().length()==0)){
                                    alert.dismiss();
                                    Toast.makeText(Alimentos.this, "Verifique os campos!", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Item a = new Item (etNovoNome.getText().toString(),etTraducao.getText().toString(),etFrase.getText().toString());
                                    alimentos.add(a);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(Alimentos.this, "Adicionado !", Toast.LENGTH_SHORT).show();
                                }

                            }catch (Exception E){
                                AlertDialog alertDialog = new AlertDialog.Builder(Alimentos.this).create();
                                alertDialog.setTitle("Opssss");
                                alertDialog.setMessage("Ocorreu um erro ao adicionar, verifique e tente novamente ");

                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                            }
                        }
                    });
                    alert.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            alert.dismiss();
                        }
                    });
                    AlertDialog alerta = alert;
                    alerta.show();

                }catch (Exception e){
                    AlertDialog alertDialog = new AlertDialog.Builder(Alimentos.this).create();
                    alertDialog.setTitle("Opssss");
                    alertDialog.setMessage("Ocorreu um erro ao editar, verifique e tente novamente ");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Enviar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
