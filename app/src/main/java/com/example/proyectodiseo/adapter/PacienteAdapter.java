package com.example.proyectodiseo.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectodiseo.R;
import com.example.proyectodiseo.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PacienteAdapter extends FirestoreRecyclerAdapter<Paciente,PacienteAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PacienteAdapter(@NonNull FirestoreRecyclerOptions<Paciente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Paciente model) {

        holder.nombre.setText(Paciente.getNombre());
        holder.apellido.setText(Paciente.getApellido());


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_paciente_single,
                parent,false);
        return new ViewHolder(v);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, apellido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre= itemView.findViewById(R.id.nombre);
            apellido= itemView.findViewById(R.id.apellido);
        }
    }
}
