package com.example.proyectodiseo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarPacienteFragment extends DialogFragment {
    Button registrar_paciente;
    EditText nombre, apellido, edad, peso, altura, email_paciente;
    private FirebaseFirestore mfirestore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registrar_paciente, container, false);

        mfirestore =FirebaseFirestore.getInstance();

        nombre=v.findViewById(R.id.et_nombre);
        apellido=v.findViewById(R.id.et_apellido);
        edad=v.findViewById(R.id.et_edad);
        peso=v.findViewById(R.id.et_peso);
        altura=v.findViewById(R.id.et_altura);
        email_paciente=v.findViewById(R.id.et_email_paciente);
        registrar_paciente=v.findViewById(R.id.btn_registro_paciente);

        registrar_paciente.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String nombreP = nombre.getText().toString().trim();
                String apellidoP = apellido.getText().toString().trim();
                String edadP = edad.getText().toString().trim();
                String pesoP = peso.getText().toString().trim();
                String alturaP = altura.getText().toString().trim();
                String emailP = email_paciente.getText().toString().trim();

                if(nombreP.isEmpty() && apellidoP.isEmpty() && edadP.isEmpty() && pesoP.isEmpty() &&
                        alturaP.isEmpty() && emailP.isEmpty()) {
                    Toast.makeText(getContext(), "Ingresar los datos",
                            Toast.LENGTH_SHORT).show();
                }else{
                    postPaciente(nombreP,apellidoP,edadP,pesoP,alturaP,emailP);
                }
            }
        });


        return v;
    }
    private void postPaciente(String nombreP, String apellidoP, String edadP, String pesoP, String alturaP, String emailP) {
        Map<String,Object> map=new HashMap<>();
        map.put("nombre",nombreP);
        map.put("apellido",apellidoP);
        map.put("edad",edadP);
        map.put("peso",pesoP);
        map.put("altura",alturaP);
        map.put("email",emailP);

        mfirestore.collection("paciente").add(map).addOnSuccessListener(
                new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getContext(),
                                "Paciente creado exitosamente",Toast.LENGTH_SHORT).show();
                        getDialog().dismiss();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }
}