package com.example.proyectodiseo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectodiseo.adapter.PacienteAdapter;
import com.example.proyectodiseo.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PacienteActivity extends AppCompatActivity {
    Button registrar_paciente;
    RecyclerView mRecycler;
    PacienteAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        mFirestore=FirebaseFirestore.getInstance();
        mRecycler=findViewById(R.id.recycler_view);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("Paciente");
        FirestoreRecyclerOptions<Paciente> firestoreRecyclerOptions=
                new FirestoreRecyclerOptions.Builder<Paciente>().setQuery(query, Paciente.class).build();

        mAdapter = new PacienteAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        registrar_paciente = findViewById(R.id.btn_registro_paciente);

        registrar_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarPacienteFragment fm = new RegistrarPacienteFragment();
                fm.show(getSupportFragmentManager(),"Navegar");
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        mAdapter.stopListening();
    }

}