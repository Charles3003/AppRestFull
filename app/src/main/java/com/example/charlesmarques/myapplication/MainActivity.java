package com.example.charlesmarques.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {

    private  Button btnBuscarCep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cep = findViewById(R.id.etMain_cep);
        final TextView resposta = findViewById(R.id.etMain_resposta);

        Button btnBuscarCep = findViewById(R.id.id_buscar);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    CEP retorno = new HttpService(cep.getText().toString()).execute().get();
                    resposta.setText(retorno.toString());

                   /* HttpService oHttpService = new HttpService("");
                    oHttpService.ChamadaGet();*/

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }
}
