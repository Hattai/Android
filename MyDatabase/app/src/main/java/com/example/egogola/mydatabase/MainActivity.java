package com.example.egogola.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lstProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstProdutos = (ListView) findViewById(R.id.lstProdutos);
        ProdutoAdapter produtoAdapter = new ProdutoAdapter(this);
        lstProdutos.setAdapter(produtoAdapter);
        DataStore.sharedInstance().addProduto(new Produto("Jack Daniels", 15, 10));
    }
}
