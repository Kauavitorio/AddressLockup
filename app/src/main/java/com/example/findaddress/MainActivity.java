package com.example.findaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CardView BtnFindForPostalCode, BtnFindForaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnFindForPostalCode = findViewById(R.id.BtnFindForPostalCode);
        BtnFindForaddress = findViewById(R.id.BtnFindForaddress);

        RoundedBitmapDrawable img = RoundedBitmapDrawableFactory.create(getResources(), String.valueOf(R.drawable.cardbg));
        img.setCornerRadius(20);

        BtnFindForPostalCode.setOnClickListener(v -> {
            Intent goTo_findwithpostalCode = new Intent(MainActivity.this, Find_with_postal_code.class);
        });

    }
}