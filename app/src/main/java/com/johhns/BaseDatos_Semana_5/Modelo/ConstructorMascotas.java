package com.johhns.BaseDatos_Semana_5.Modelo;

import android.content.Context;

import com.johhns.BaseDatos_Semana_5.BaseDatos.BaseDatosMascotas;
import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;
import com.johhns.BaseDatos_Semana_5.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context contexto ;
    private static final int LIKE = 1;

    public ConstructorMascotas( Context contexto) {
        this.contexto = contexto ;
    }

    public ArrayList<Mascota> obtenerDatos() {
        ArrayList<Mascota> arrayMascotas = new ArrayList<>();
        BaseDatosMascotas db = new BaseDatosMascotas(contexto);
        arrayMascotas.add( new Mascota( R.drawable.lazy , "Lazy" , 7 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.manchas , "Manchas" , 5 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.oso , "Oso" , 2 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.punky , "Punky" , 4 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.rex , "Rex" , 3 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.rocky , "Rocky" , 5 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.romi , "Romy" , 4 ) ) ;
        return arrayMascotas ;
    }
//
}
