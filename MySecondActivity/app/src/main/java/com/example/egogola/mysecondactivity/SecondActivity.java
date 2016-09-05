package com.example.egogola.mysecondactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by egogola on 02/09/2016.
 */
public class SecondActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String nome = getIntent().getStringExtra("Nome");

        Toast.makeText(this, "Escolha uma das opções, " + nome, Toast.LENGTH_SHORT).show();

        String[] itens = new String[] {
          "Curitiba","Floripa", "Gramado","São Paulo"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                itens
        );
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent data = new Intent();

        switch (position) {
            case 0:
                data.putExtra("Retorno","Curitiba");
                break;
            case 1:
                data.putExtra("Retorno","Floripa");
                break;
            case 2:
                data.putExtra("Retorno","Gramado");
                break;
            case 3:
                data.putExtra("Retorno","São Paulo");
                break;
            default:
                data.putExtra("Retorno","Osasco");
                break;
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}










