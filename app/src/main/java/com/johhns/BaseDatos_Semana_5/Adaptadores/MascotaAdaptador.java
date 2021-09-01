package com.johhns.BaseDatos_Semana_5.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johhns.BaseDatos_Semana_5.Modelo.ConstructorMascotas;
import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;
import com.johhns.BaseDatos_Semana_5.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ViewHolder> {

    ArrayList<Mascota> aMascotas ;
    Activity   activity ;

    public MascotaAdaptador(ArrayList<Mascota>  p_mascotas, Activity activity ) {
        this.aMascotas = p_mascotas ;
        this.activity  = activity ;
    }

// 1

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.mascota , null, false ) ;
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity) ;
        holder.v_foto.setImageResource( aMascotas.get(position).getFoto() );
        holder.v_nombre.setText( aMascotas.get(position).getNombre() );
        holder.v_rating.setText( String.valueOf( constructorMascotas.obtenerLikesMascota(aMascotas.get(position) ) ) );
        holder.v_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad ;
                String clase = v.getContext().getClass().getName().toString() ;
                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity) ;
                    constructorMascotas.darLikeMascota( aMascotas.get(position) );
                    ///holder.v_rating.setText( String.valueOf( aMascotas.get(position).getRating() ) );
                    holder.v_rating.setText( String.valueOf( constructorMascotas.obtenerLikesMascota( aMascotas.get(position) ) ) );
            }
        });

    }

    @Override
    public int getItemCount() {
        return aMascotas.size() ;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView v_foto ;
        TextView v_nombre, v_rating ;
        ImageButton v_boton ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v_foto   = itemView.findViewById(R.id.imgFoto) ;
            v_nombre = itemView.findViewById(R.id.txtNombre) ;
            v_rating = itemView.findViewById(R.id.txtRating) ;
            v_boton = itemView.findViewById(R.id.btnLike);
        }
    }
}
