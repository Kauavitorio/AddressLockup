package com.example.findaddress.Threads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class AsyncCEP extends AsyncTask {
    @SuppressLint("StaticFieldLeak")
    TextView txt_address_cep, txt_complement_cep, txt_district_cep, txt_localidade_cep,txt_state_cep, txt_ibge_cep, txt_gia_cep, txt_ddd_cep, txt_siafi_cep;
    String cep;

    public AsyncCEP(TextView txt_address_cep, TextView txt_complement_cep, TextView txt_district_cep, TextView txt_localidade_cep, TextView txt_state_cep, TextView txt_ibge_cep, TextView txt_gia_cep, TextView txt_ddd_cep, TextView txt_siafi_cep, String cep ) {
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        String carregando = "Carregando...";
        txt_address_cep.setText("Endereço: " + carregando);
        txt_complement_cep.setText("Complemento: " + carregando);
        txt_district_cep.setText("Bairro: " + carregando);
        txt_localidade_cep.setText("Localidade: " + carregando);
        txt_state_cep.setText("Estado: " + carregando);
        txt_ibge_cep.setText("IBGE: " + carregando);
        txt_gia_cep.setText("GIA: " + carregando);
        txt_ddd_cep.setText("DDD: " + carregando);
        txt_siafi_cep.setText("SIAFI: " + carregando);
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

