package com.example.charlesmarques.myapplication;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, CEP> {

    private final String cep;

    public HttpService(String cep) {
        this.cep = cep;
    }

    @Override
    protected CEP doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
      /*  if (this.cep != null && this.cep.length() == 8) {*/
            try {
                URL url = new URL("http://192.168.108.241:7010/balanco/continentes/2013");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }

                Gson gson = new Gson();
               BalancoComercialPorContinente[] user = gson.fromJson(resposta.toString(), BalancoComercialPorContinente[].class);
                for (int i = 0; i < user.length; i++){
                    Log.d("maria", user[i].getContinente());
                }

        } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.getMessage();
            }
        /*}*/
        return new Gson().fromJson(resposta.toString(), CEP.class);
    }


  /* public String ChamadaGet (){
       String retorno = "";
        try {
            URL url = new URL("http://192.168.0.16:443/balanco/continentes/2013");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            HttpClient oHttpClient = new DefaultHttpClient();
            HttpGet chamada = new HttpGet();


            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            String reponseBody = oHttpClient.execute(chamada,responseHandler);

            retorno = reponseBody ;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
        return retorno;
    }*/
}

