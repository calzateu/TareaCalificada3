package com.calzateu.tareacalificada;

import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder> {
    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    //Va a inflar el layout y lo pasará ViewHolder para que obtenga los Views
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la vista con cada View
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombreCV.setText(mascota.getNombre());
        contactoViewHolder.tvNumeroLike.setText(mascota.getNumLikes() + "");

        contactoViewHolder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mascota.getCambiarNumeroLikes() == 0){
                    contactoViewHolder.imgLike.setImageResource(R.drawable.fondo_amarillo);
                    mascota.setCambiarNumeroLikes(1);
                    contactoViewHolder.tvNumeroLike.setText(mascota.getNumLikes() + 1 + "");
                    mascota.setNumLikes(mascota.getNumLikes() + 1);
                }
                else{
                    contactoViewHolder.imgLike.setImageResource(R.drawable.fondo);
                    mascota.setCambiarNumeroLikes(0);
                    contactoViewHolder.tvNumeroLike.setText(mascota.getNumLikes() - 1 + "");
                    mascota.setNumLikes(mascota.getNumLikes() - 1);
                }
            }
        });
    }

    //Cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto, imgNumeroLike;
        private ImageButton imgLike;
        private TextView tvNombreCV, tvNumeroLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgLike = (ImageButton) itemView.findViewById(R.id.imgLike);
            imgNumeroLike = (ImageView) itemView.findViewById(R.id.imgNumeroLike);
            tvNumeroLike = (TextView) itemView.findViewById(R.id.tvNumeroLike);
        }
    }
}
