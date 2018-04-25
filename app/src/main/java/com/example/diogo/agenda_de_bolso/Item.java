package com.example.diogo.agenda_de_bolso;

public class Item {
    private String nome;
    private String nomeTraduzido;
    private String frase;

    public Item(String nome, String nomeTraduzido, String frase){
        this.nome = nome;
        this.nomeTraduzido = nomeTraduzido;
        this.frase = frase;
    }
    public String getNome() {
        return nome;
    }


    public String getNomeTraduzido() {
        return nomeTraduzido;
    }

    public String getFrase() {
        return frase;
    }

}
