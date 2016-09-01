package com.example.egogola.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by egogola on 31/08/2016.
 */
public class CityAdapter  extends BaseAdapter {

    private List<String> cities;
    private Context context;

    public CityAdapter(List<String> cities, Context context){
        this.cities = cities;
        this.context = context;
    }


    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_city, parent, false);
        TextView txtCity = (TextView) view.findViewById(R.id.txtCity);
        txtCity.setText(cities.get(position));

        return view;
    }
}
















