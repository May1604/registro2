package com.example.proyectodiseo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EstudianteActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText emailEst;
    private EditText contrasenaEst;
    private EditText confContrasenaEst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        mAuth = FirebaseAuth.getInstance();

        emailEst=findViewById(R.id.et_correo);
        contrasenaEst=findViewById(R.id.et_contrasenaEst);
        confContrasenaEst=findViewById(R.id.confContrasenaEst);
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void RegistrarEstudiante(View view){

        if (contrasenaEst.getText().toString().equals(confContrasenaEst.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(emailEst.getText().toString(),contrasenaEst.getText().toString() )
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser(); //se registra correctamente el usuario
                                Intent i =new Intent(getApplicationContext(),MainActivity.class); //regresa a la página de inicio
                                startActivity(i);
                            } else{
                                Toast.makeText(getApplicationContext(),"No se pudo crear el usuario",Toast.LENGTH_SHORT).show();;

                            }
                        }
                    });
        }else {
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }
    }
}