package com.example.findaddress.Threads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.findaddress.Classes.LoadingDialog;
import com.example.findaddress.Find_with_postal_code;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class AsyncCEP extends AsyncTask {
    ConstraintLayout baseResult, baseSearch, baseLoading;
    @SuppressLint("StaticFieldLeak")
    TextView txt_address_cep, txt_complement_cep, txt_district_cep, txt_localidade_cep,txt_state_cep, txt_ibge_cep, txt_gia_cep, txt_ddd_cep, txt_siafi_cep;
    String cep;

    public AsyncCEP(ConstraintLayout baseResult, ConstraintLayout baseSearch, ConstraintLayout baseLoading, TextView txt_address_cep, TextView txt_complement_cep, TextView txt_district_cep, TextView txt_localidade_cep, TextView txt_state_cep, TextView txt_ibge_cep, TextView txt_gia_cep, TextView txt_ddd_cep, TextView txt_siafi_cep, String cep ) {
        this.baseResult = baseResult;
        this.baseSearch = baseSearch;
        this.baseLoading = baseLoading;
        this.txt_address_cep = txt_address_cep;
        this.txt_complement_cep = txt_complement_cep;
        this.txt_district_cep = txt_district_cep;
        this.txt_localidade_cep = txt_localidade_cep;
        this.txt_state_cep = txt_state_cep;
        this.txt_ibge_cep = txt_ibge_cep;
        this.txt_gia_cep = txt_gia_cep;
        this.txt_ddd_cep = txt_ddd_cep;
        this.txt_siafi_cep = txt_siafi_cep;
        this.cep = cep;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        baseSearch.setVisibility(View.GONE);

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return JsonHandler.getJson("https://viacep.com.br/ws/" + cep + "/json/");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(Object address) {
        super.onPostExecute(address);
        try {
            JSONObject jsonObject = new JSONObject((String) address);
            txt_address_cep.setText("Endereço: " + jsonObject.getString("logradouro"));
            txt_complement_cep.setText("Complemento: " + jsonObject.getString("complemento"));
            txt_district_cep.setText("Bairro: " + jsonObject.getString("bairro"));
            txt_localidade_cep.setText("Localidade: " + jsonObject.getString("localidade"));
            txt_state_cep.setText("Estado: " + jsonObject.getString("uf"));
            txt_ibge_cep.setText("IBGE: " + jsonObject.getString("ibge"));
            txt_gia_cep.setText("GIA: " + jsonObject.getString("gia"));
            txt_ddd_cep.setText("DDD: " + jsonObject.getString("ddd"));
            txt_siafi_cep.setText("SIAFI: " + jsonObject.getString("siafi"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
