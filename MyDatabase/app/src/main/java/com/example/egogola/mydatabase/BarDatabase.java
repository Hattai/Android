package com.example.egogola.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egogola on 01/09/2016.
 */
public class BarDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "bar.sqlite";
    private static final int DB_VERSION = 1;
    Context context;


    public BarDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists cardapio(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " + "preco INTEGER, " + "estoque INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertProduto(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("preco", produto.getPreco());
        values.put("estoque", produto.getEstoque());
        Long id = db.insert("cardapio","",values);
        produto.setId(id);
        db.close();
    }

    public void updateProduto(Produto produto){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("preco", produto.getPreco());
        values.put("estoque", produto.getEstoque());
        String _id = String.valueOf(produto.getId());
        int count = db.update("cardapio", values, "_id=?", new String[]{_id});
        db.close();
    }

    public void removeProduto(Produto produto){
        SQLiteDatabase db = getWritableDatabase();
        String _id = String.valueOf(produto.getId());
        int count = db.delete("cardapio", "_id=?", new String[]{_id});
        db.close();
    }


    public List<Produto> getAll(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("cardapio", null, null, null, null, null, null, null);
        List<Produto> produtos = new ArrayList<Produto>();

        if (cursor.moveToFirst()) {
            do {
                Produto produto = new Produto(cursor.getString(cursor.getColumnIndex("nome")),
                                        cursor.getInt(cursor.getColumnIndex("preco")),
                                        cursor.getInt(cursor.getColumnIndex("estoque")));
                produto.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                produtos.add(produto);

            } while (cursor.moveToNext());
        }
        return produtos;
    }

}















