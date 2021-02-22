package com.example.findaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.findaddress.Adapters.AdapterAddress;
import com.example.findaddress.Threads.AsyncEND;

import java.util.ArrayList;

public class Find_with_address extends AppCompatActivity {
    TextView txt_aguardando_cep, txt_insertstate, txt_insertcity, txt_insertstreet;
    EditText edittext_state, edittext_city, edittext_street;
    CardView cardBtnSearch;
    String State = "", City = "", Street = "";
    ListView listView_Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_with_address);
        Ids();

        edittext_state.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                if (edittext_state.getText().length() > 0){
                    State = edittext_state.getText().toString();
                    txt_aguardando_cep.setText(State + "/" + City + "/" + Street);
                }else {
                    txt_aguardando_cep.setText(R.string.aguardando_end);
                    State = "";
                }
            }
        });

        edittext_city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                if (edittext_city.getText().length() > 0){
                    City = edittext_city.getText().toString();
                    txt_aguardando_cep.setText(State + "/" + City + "/" + Street);
                }else {
                    txt_aguardando_cep.setText(R.string.aguardando_end);
                    City = "";
                }
            }
        });

        edittext_street.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                if (edittext_street.getText().length() > 0){
                    Street = edittext_street.getText().toString();
                    txt_aguardando_cep.setText(State + "/" + City + "/" + Street);
                }else {
                    txt_aguardando_cep.setText(R.string.aguardando_end);
                    Street = "";
                }
            }
        });
    }

    private void Ids() {
        txt_aguardando_cep = findViewById(R.id.txt_aguardando_cep);
        txt_insertstate = findViewById(R.id.txt_insertstate);
        txt_insertcity = findViewById(R.id.txt_insertcity);
        txt_insertstreet = findViewById(R.id.txt_insertstreet);
        edittext_state = findViewById(R.id.edittext_state);
        edittext_city = findViewById(R.id.edittext_city);
        edittext_street = findViewById(R.id.edittext_street);
        cardBtnSearch = findViewById(R.id.cardBtnSearch);
    }

}