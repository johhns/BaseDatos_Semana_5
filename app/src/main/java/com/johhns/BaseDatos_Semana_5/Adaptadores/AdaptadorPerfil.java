package com.johhns.BaseDatos_Semana_5.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;
import com.johhns.BaseDatos_Semana_5.R;

import java.util.ArrayList;

public class AdaptadorPerfil extends RecyclerView.Adapter<AdaptadorPerfil.ViewHolder> {

    ArrayList<Mascota> aMascotas ;
    Activity  activity ;

    public AdaptadorPerfil( ArrayList<Mascota>  p_mascotas, Activity activity ) {
        this.aMascotas = p_mascotas ;
        this.activity  = activity ;
    }

    @NonNull
    @Override
    public AdaptadorPerfil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.perfil_mascota , null, false ) ;
        return new AdaptadorPerfil.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPerfil.ViewHolder holder, int position) {
        holder.v_foto.setImageResource( aMascotas.get(position).getFoto() );
        holder.v_rating.setText( String.valueOf( aMascotas.get(position).getRating() ) );
    };

//

    @Override
    public int getItemCount() {
        return aMascotas.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView v_foto ;
        TextView  v_rating ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v_foto   = itemView.findViewById(R.id.imgFoto2) ;
            v_rating = itemView.findViewById(R.id.txtRating2) ;
        }
    }
}
