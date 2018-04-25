package com.example.diogo.agenda_de_bolso;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item>{


    public ItemAdapter(@NonNull Context context, @NonNull List<Item> objects) {
        super(context, 0 ,objects);
    }
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View listItemView   = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }
        Item current=getItem(position);
        TextView nome = listItemView.findViewById(R.id.tvNome);
        TextView nomeTraduzido = listItemView.findViewById(R.id.tvNomeTraduzido);

          nome.setText(current.getNome().toString());
          nomeTraduzido.setText(current.getNomeTraduzido().toString());

        return listItemView;
    }
}
