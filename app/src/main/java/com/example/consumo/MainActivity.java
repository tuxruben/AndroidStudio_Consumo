package com.example.consumo;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Usuario> listaUsuarios;
    Retrofit cliente;
    ApiService apiService, mAPIService;
    TextView tvResult;
    EditText txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=findViewById(R.id.tvResultado);
        txtNombre=findViewById(R.id.txtNombre);
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaUsuarios().enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call,
                                   Response<List<Usuario>> response) {
                Log.i("Cliente","Cliente Android");
                tvResult.setText("Datos del servicio PHP \n");
                if (response.isSuccessful()){
                    listaUsuarios=response.body();
                    for (Usuario usuario:listaUsuarios){
                        Log.i("Usuario",usuario.toString());
                        tvResult.append(usuario.toString());
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.i("Error",t.getMessage());

            }
        });
    }
    public void ObtenerUsuario(View view) {
        String nombre=txtNombre.getText().toString();
        cliente= new
                Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.obtenerUsuario(nombre).enqueue(new
                                                          Callback<List<Usuario>>() {
                                                              @Override
                                                              public void onResponse(Call<List<Usuario>> call,
                                                                                     Response<List<Usuario>> response) {
                                                                  Log.i("Correcto","Datos del servicio PHP \n");
                                                                  tvResult.setText("Datos del servicio PHP \n");
                                                                  if (response.isSuccessful()){

                                                                      listaUsuarios=response.body();

                                                                      for (Usuario usuario:listaUsuarios){
                                                                          Log.i("Usuario",usuario.toString());
                                                                          tvResult.append(usuario.toString());
                                                                      }
                                                                  }
                                                              }
                                                              @Override
                                                              public void onFailure(Call<List<Usuario>> call, Throwable t) {
                                                                  Log.i("Error",t.getMessage());
                                                              }
                                                          });
    }

}