package com.example.proyectodiseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irIniciar(View v){
        Intent i = new Intent(this, PacienteActivity.class);
        startActivity(i);

    }

    public void irRegistrarse(View v){
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);

    }
}