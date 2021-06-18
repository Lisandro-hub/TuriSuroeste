package com.example.turisuroeste;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.viewHolder>{

    ArrayList<Turismo> listadeDatos;

    public ListaAdaptador(ArrayList<Turismo> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new viewHolder(vistaDelItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
        holder.actualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nombreActividad;
        ImageView fotoActividad;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreActividad=itemView.findViewById(R.id.nombreActividad);
            fotoActividad=itemView.findViewById(R.id.fotoActividad);
        }

        public void actualizarDatos(Turismo turismo) {
            nombreActividad.setText(turismo.getNombreActividad());
            fotoActividad.setImageResource(turismo.getFotoActividad());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("datosTurismo",turismo);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

