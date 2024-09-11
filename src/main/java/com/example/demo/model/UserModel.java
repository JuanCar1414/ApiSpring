package com.example.demo.model;

public class UserModel {
    public String nome;
    public String descricao;
    public double preco;
    public String categoria;

    UserModel(String nome, String descricao, double preco, String categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
