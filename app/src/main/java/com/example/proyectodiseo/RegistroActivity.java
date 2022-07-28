package com.example.proyectodiseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity {
    Button estudiante;
    Button fisio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        estudiante = (Button) findViewById(R.id.btn_estudiante);
        estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroActivity.this,EstudianteActivity.class);
                startActivity(i);
            }
        });

        fisio = (Button) findViewById(R.id.btn_Fisioterapeuta);
        fisio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroActivity.this,FisioActivity.class);
                startActivity(i);
            }
        });
    }
}