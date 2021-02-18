package com.example.findaddress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findaddress.Classes.MaskEditUtil;
import com.example.findaddress.Threads.AsyncCEP;

public class Find_with_postal_code extends AppCompatActivity {
    TextView txt_aguardando_cep, txt_resultOf;
    TextView txt_address_cep, txt_complement_cep, txt_district_cep, txt_localidade_cep,txt_state_cep, txt_ibge_cep, txt_gia_cep, txt_ddd_cep, txt_siafi_cep;
    EditText edittext_CEP;
    CardView cardBtnSearch, cardBtnGoBack, cardBtnNewSearch;
    ConstraintLayout baseSearch, baseResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_with_postal_code);
        txt_aguardando_cep = findViewById(R.id.txt_aguardando_cep);
        edittext_CEP = findViewById(R.id.edittext_CEP);
        cardBtnSearch = findViewById(R.id.cardBtnSearch);
        cardBtnGoBack = findViewById(R.id.cardBtnGoBack);
        cardBtnNewSearch = findViewById(R.id.cardBtnNewSearch);
        baseSearch = findViewById(R.id.baseSearch);
        baseResult = findViewById(R.id.baseResult);
        txt_address_cep = findViewById(R.id.txt_address_cep);
        txt_complement_cep = findViewById(R.id.txt_complement_cep);
        txt_district_cep = findViewById(R.id.txt_district_cep);
        txt_localidade_cep = findViewById(R.id.txt_localidade_cep);
        txt_state_cep = findViewById(R.id.txt_state_cep);
        txt_ibge_cep = findViewById(R.id.txt_ibge_cep);
        txt_gia_cep = findViewById(R.id.txt_gia_cep);
        txt_ddd_cep = findViewById(R.id.txt_ddd_cep);
        txt_siafi_cep = findViewById(R.id.txt_siafi_cep);
        txt_resultOf = findViewById(R.id.txt_resultOf);
        edittext_CEP.addTextChangedListener(MaskEditUtil.mask(edittext_CEP, MaskEditUtil.FORMAT_CEP));
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        baseSearch.setVisibility(View.VISIBLE);
        baseResult.setVisibility(View.GONE);

        edittext_CEP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                String cep_inserido = edittext_CEP.getText().toString();
                if (edittext_CEP.getText().length() > 0){
                    txt_aguardando_cep.setText("Cep: "+ cep_inserido);
                }else {
                    txt_aguardando_cep.setText("Aguardando CEP");
                }
            }
        });

        cardBtnSearch.setOnClickListener(v -> {
            if (edittext_CEP.getText().length() == 9){
                String cep = edittext_CEP.getText().toString();
                AsyncCEP asyncCEP = new AsyncCEP(txt_address_cep, txt_complement_cep, txt_district_cep , txt_localidade_cep, txt_state_cep, txt_ibge_cep, txt_gia_cep, txt_ddd_cep, txt_siafi_cep, cep);
                asyncCEP.execute();
                baseResult.setVisibility(View.VISIBLE);
                baseSearch.setVisibility(View.GONE);
                txt_resultOf.setText("Esses são os resultados de: "+ cep);
                imm.hideSoftInputFromWindow(edittext_CEP.getWindowToken(), 0);
            }else{
                Toast.makeText(this, "CEP preenchido incorretamente!!", Toast.LENGTH_SHORT).show();
                edittext_CEP.requestFocus();
                imm.showSoftInput(edittext_CEP, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        cardBtnNewSearch.setOnClickListener(v -> LimparTudo());

        cardBtnGoBack.setOnClickListener(v -> finish());
    }

    @SuppressLint("SetTextI18n")
    public void LimparTudo(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        txt_aguardando_cep.setText("Aguardando CEP");
        edittext_CEP.setText(null);
        txt_address_cep.setText("Endereço: ");
        txt_complement_cep.setText("Complemento:");
        txt_district_cep.setText("Bairro: ");
        txt_localidade_cep.setText("Localidade: ");
        txt_state_cep.setText("Estado: ");
        txt_ibge_cep.setText("IBGE: ");
        txt_gia_cep.setText("GIA: ");
        txt_ddd_cep.setText("DDD: ");
        txt_siafi_cep.setText("SIAFI: ");
        baseResult.setVisibility(View.GONE);
        baseSearch.setVisibility(View.VISIBLE);
        edittext_CEP.requestFocus();
        imm.showSoftInput(edittext_CEP, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}