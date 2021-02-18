package com.example.findaddress.Threads;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonHandler {

    public static String getJson(String txt_url){
        InputStream inputStream = null;
        String text_json = "";
        try {
            URL url = new URL(txt_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String linha = "";
            while ((linha = bufferedReader.readLine()) != null ){
                text_json += "\n"+linha;
            }
        } catch (Exception e) {
            //Toast.makeText(activity, "Ouve um erro, por favor, verificar o cep informado\nCaso o erro persista, contate o desenvolvedor", Toast.LENGTH_LONG).show();
            Log.d("ErroNetwork",e.toString());
        }

        return text_json;
    }

}
