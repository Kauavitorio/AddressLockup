package com.example.findaddress.Threads;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  Copyright (c) 2021 Kaua Vitorio
 *  Official repository https://github.com/Kauavitorio/AddressLockup
 *  Responsible developer: https://github.com/Kauavitorio
 **/

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
            Log.d("ErroNetwork",e.toString());
            e.printStackTrace();
        }

        return text_json;
    }

}
