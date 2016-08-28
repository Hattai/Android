package br.com.crusoandroid.escolha_layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String escolha = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImage(View view) {
        RadioGroup grp = (RadioGroup) findViewById(R.id.grupo);
        RadioButton coca = (RadioButton) findViewById(R.id.cocacola);
        RadioButton pepsi = (RadioButton) findViewById(R.id.pepsi);
        RadioButton fanta = (RadioButton) findViewById(R.id.fanta);
        RadioButton soda = (RadioButton) findViewById(R.id.soda);
        ImageView i = (ImageView) findViewById(R.id.imgEscolha);


        if (coca.isChecked()) {
            escolha = "Coca-Cola";
            i.setImageResource(R.drawable.coca_cola);
        } else if (pepsi.isChecked()) {
            escolha = "Pepsi";
            i.setImageResource(R.drawable.pepsi);
        } else if (fanta.isChecked()) {
            escolha = "Fanta";
            i.setImageResource(R.drawable.fanta);
        } else if (soda.isChecked()) {
            escolha = "Soda";
            i.setImageResource(R.drawable.soda);
        }
    }

    public void toastEscolha(View view) {
//        Button btn = (Button) findViewById(R.id.btnEscolha);
        Toast.makeText(MainActivity.this, "Você Escolheu: " + escolha, Toast.LENGTH_LONG).show();
    }
}


