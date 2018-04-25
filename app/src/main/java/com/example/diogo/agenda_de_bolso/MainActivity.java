package com.example.diogo.agenda_de_bolso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView alimentos = findViewById(R.id.tvAlimentos);
        alimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Alimentos.class);
                startActivity(intent);
            }
        });

        TextView numeros = findViewById(R.id.tvNumeros);
        numeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Numeros.class);
                startActivity(intent);
            }
        });

        TextView familiares = findViewById(R.id.tvNomesFamiliares);
        familiares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Familiares.class);
                startActivity(intent);
            }
        });

        TextView expressoes = findViewById(R.id.tvExpressoes);
        expressoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Expressoes.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
