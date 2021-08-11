package com.sosa.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySegunda extends AppCompatActivity {
    private TextView salida;
    private Button siguiente2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        inicializarVista();
    }
    private void inicializarVista(){
        salida = findViewById(R.id.ETSalida);
        String msj = getIntent().getStringExtra("entrada");
        Log.d("msj",msj);
        salida.setText(msj);
        siguiente2 = findViewById(R.id.BTSiguiente2);
        siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivitySegunda.this, ActivityTercera.class);
                startActivity(i);
            }
        });
    }
}