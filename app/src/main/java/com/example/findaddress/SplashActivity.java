package com.example.findaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressSplash;
    CardView cardBtnTryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressSplash = findViewById(R.id.progressSplash);
        cardBtnTryAgain = findViewById(R.id.cardBtnTryAgain);

        cardBtnTryAgain.setVisibility(View.GONE);

        lookfornetwork();
        //LoadingSplash loadingSplash = new LoadingSplash();
        //loadingSplash.start();

        cardBtnTryAgain.setOnClickListener(v -> {
            lookfornetwork();
            cardBtnTryAgain.setVisibility(View.GONE);
        });

    }

    public void lookfornetwork(){
        ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cn.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            LoadingSplash loadingSplash = new LoadingSplash();
            loadingSplash.start();
        }
        else{
            LoadingSplashNoNet loadingSplashNoNet = new LoadingSplashNoNet();
            loadingSplashNoNet.start();
        }
    }

    public class LoadingSplash extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 91; i++) {
                int loading = 10;
                try {
                    Thread.sleep(loading);
                    progressSplash.setProgress(i);
                    if (i == 90){
                        Intent gotoPrincipal = new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(gotoPrincipal);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class LoadingSplashNoNet extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 31; i++) {
                int loading = 30;
                try {
                    Thread.sleep(loading);
                    progressSplash.setProgress(i);
                    if (i == 30){
                        runOnUiThread(() -> {
                            cardBtnTryAgain.setVisibility(View.VISIBLE);
                            Toast.makeText(SplashActivity.this, "Você não esta conectado à internet\nNão terá atualização de novas informações", Toast.LENGTH_LONG).show();
                        });
                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}