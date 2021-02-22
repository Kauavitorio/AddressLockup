package com.example.findaddress.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.findaddress.R;
import com.example.findaddress.Threads.AsyncEND;

import java.util.List;

public class AdapterAddress extends ArrayAdapter<AsyncEND> {

    private final List<AsyncEND> mlist;
    private final Context mcontext;
    private  String cep, street, complement, district, local, state, ibge, gia, ddd ,siafi;

    public AdapterAddress(@NonNull Context context, int resource, List<AsyncEND> objects) {
        super(context, resource, objects);
        this.mlist = objects;
        this.mcontext = context;
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.list_address,null);
        }


        return view;

    }
}
