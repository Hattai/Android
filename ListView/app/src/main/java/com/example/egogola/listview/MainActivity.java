package com.example.egogola.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstCities;
    private CityAdapter cityAdapter;
    private List<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.populate();
        lstCities = (ListView) findViewById(R.id.lstCities);
        cityAdapter = new CityAdapter(cities, this);
        lstCities.setAdapter(cityAdapter);

        lstCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Vou Para " + cities.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void populate() {
        cities = new ArrayList<String>();
        cities.add("Curitiba");
        cities.add("São Paulo");
        cities.add("São José");
        cities.add("Salvador");
    }
}
















