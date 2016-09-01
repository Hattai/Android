package com.example.egogola.mytext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnUponClick(View view){
        EditText enterName = (EditText) findViewById(R.id.enterName);
        TextView textName = (TextView) findViewById(R.id.textName);

        textName.setText(enterName.getText().toString());

    }
}

