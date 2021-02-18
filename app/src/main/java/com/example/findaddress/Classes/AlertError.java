package com.example.findaddress.Classes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.findaddress.R;

/**
 *  Copyright (c) 2021 Kaua Vitorio
 *  Official repository https://github.com/Kauavitorio/AddressLockup
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class AlertError {

    private final Activity activity;
    private AlertDialog dialog;

    public AlertError(Activity myactivity){
        activity = myactivity;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    public void  startLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_error,null));

        dialog = builder.create();
        dialog.show();

    }

   public void dimissDialog(){
        dialog.dismiss();
    }
}
