package com.example.diogo.agenda_de_bolso;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Familiares extends AppCompatActivity {
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        final ArrayList<Item> familiares = new ArrayList<>();
        Button btnNovo = findViewById(R.id.btnNovo);
        ListView list = findViewById(R.id.lista);
        adapter = new ItemAdapter(this,familiares);
        list.setAdapter(adapter);


        Item a = new Item ("Tio","Uncle","I'm a very affectionate uncle, very affectionate uncle.");
        familiares.add(a);

        Item b = new Item ("Tia","Aunt","I'm a very affectionate aunt, very affectionate uncle.");
        familiares.add(b);

        Item c = new Item ("Sobrinho","Nephew","And then, from the extended family - brothers, cousins, nephews, parents, grand parents - we move on to the polygamous family.");
        familiares.add(c);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Item a = (Item) parent.getItemAtPosition(i);
                //Toast.makeText(getApplicationContext(),a.getFrase(),Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(Familiares.this).create();
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
        list.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                familiares.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }

        });


        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    View v = getLayoutInflater().inflate(R.layout.layout_novo_item, null);
                    final AlertDialog alert = new AlertDialog.Builder(Familiares.this).create();
                    alert.setView(v);

                    alert.setTitle(String.format(getResources().getString(R.string.novoItem)));
                    alert.setButton(AlertDialog.BUTTON_POSITIVE,"Novo", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            try{
                                final EditText etNovoNome = ((Dialog) arg0).findViewById(R.id.etNomeNovo);
                                final EditText etTraducao= ((Dialog) arg0).findViewById(R.id.etTraducao);
                                final EditText etFrase= ((Dialog) arg0).findViewById(R.id.etFrase);

                                if((etNovoNome.getText().length() == 0)||(etTraducao.getText().length() == 0) || (etFrase.getText().length()==0)){
                                    alert.dismiss();
                                    Toast.makeText(Familiares.this, String.format(getResources().getString(R.string.veifiqueOsCampos)), Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Item a = new Item (etNovoNome.getText().toString(),etTraducao.getText().toString(),etFrase.getText().toString());
                                    familiares.add(a);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(Familiares.this, String.format(getResources().getString(R.string.adicionado)), Toast.LENGTH_SHORT).show();
                                }

                            }catch (Exception E){
                                AlertDialog alertDialog = new AlertDialog.Builder(Familiares.this).create();
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
                    AlertDialog alertDialog = new AlertDialog.Builder(Familiares.this).create();
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
}
