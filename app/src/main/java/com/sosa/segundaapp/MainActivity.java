package com.sosa.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button siguiente1;
    private EditText entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();
    }

    private void inicializarVista() {
        siguiente1 = findViewById(R.id.BTSiguiente1);
        entrada = findViewById(R.id.ETEntrada);
        siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivitySegunda.class);

                i.putExtra("entrada", entrada.getText().toString());
                startActivity(i);
            }
        });
    }
}