package com.example.egogola.mydatabase;

import android.content.Context;

import java.util.List;

/**
 * Created by egogola on 01/09/2016.
 */
public class DataStore {
    private static DataStore instance = null;
    private BarDatabase database;
    private List<Produto> produtos;
    private Context context;

    protected DataStore() {
    }

    public static DataStore sharedInstance() {
        if (instance == null) instance = new DataStore();
        return instance;
    }

    public void setContext(Context context){
        this.context = context;
        database = new BarDatabase(context);
        produtos = database.getAll();
    }

    public List<Produto> getProdutos(){
        return produtos;
    }

    public Produto getProduto(int position) {
        return produtos.get(position);
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
        database.insertProduto(produto);
    }

    public void editProduto(Produto produto, int position){
        produtos.set(position, produto);
        database.updateProduto(produto);
    }

    public void removeProduto(int position){
        Produto produto = produtos.get(position);
        database.removeProduto(produto);
        produtos.remove(position);
    }
}


















