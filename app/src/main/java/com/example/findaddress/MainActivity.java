package com.example.findaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    CardView BtnFindForPostalCode, BtnFindForaddress;
    ImageView ImgGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnFindForPostalCode = findViewById(R.id.BtnFindForPostalCode);
        BtnFindForaddress = findViewById(R.id.BtnFindForaddress);
        ImgGitHub = findViewById(R.id.ImgGitHub);

        RoundedBitmapDrawable img = RoundedBitmapDrawableFactory.create(getResources(), String.valueOf(R.drawable.cardbg));
        img.setCornerRadius(20);

        BtnFindForPostalCode.setOnClickListener(v -> {
            Intent goTo_findwithpostalCode = new Intent(MainActivity.this, Find_with_postal_code.class);
            startActivity(goTo_findwithpostalCode);
        });

        BtnFindForaddress.setOnClickListener(v -> {
            Toast.makeText(this, R.string.indevelopment, Toast.LENGTH_LONG).show();
            //  Intent goTo_findwithaddress = new Intent(MainActivity.this,Find_with_address.class);
            //  startActivity(goTo_findwithaddress);
        });

        ImgGitHub.setOnClickListener(v -> {
            String url = "https://github.com/Kauavitorio/AddressLockup";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }
}