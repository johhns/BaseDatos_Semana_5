package com.johhns.BaseDatos_Semana_5.Modelo;

import android.content.ContentValues;
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

        insertarMascotas(db);

        /*
        arrayMascotas.add( new Mascota( R.drawable.lazy , "Lazy" , 7 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.manchas , "Manchas" , 5 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.oso , "Oso" , 2 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.punky , "Punky" , 4 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.rex , "Rex" , 3 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.rocky , "Rocky" , 5 ) ) ;
        arrayMascotas.add( new Mascota( R.drawable.romi , "Romy" , 4 ) ) ;
        */
       // return arrayMascotas ;
        return db.obtenerTodasLasMascotas() ;
    }

    public void insertarMascotas( BaseDatosMascotas db ){
        ContentValues contentValues = new ContentValues() ;
        contentValues.put("Nombre","Lazy");
        contentValues.put("Imagen", R.drawable.lazy );
        db.insertarMascota( contentValues );


        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Manchas");
        contentValues.put("Imagen", R.drawable.manchas );
        db.insertarMascota( contentValues );

        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Oso");
        contentValues.put("Imagen", R.drawable.oso );
        db.insertarMascota( contentValues );

        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Punky");
        contentValues.put("Imagen", R.drawable.punky );
        db.insertarMascota( contentValues );

        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Rex");
        contentValues.put("Imagen", R.drawable.rex );
        db.insertarMascota( contentValues );

        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Rocky");
        contentValues.put("Imagen", R.drawable.rocky );
        db.insertarMascota( contentValues );

        contentValues = new ContentValues() ;
        contentValues.put("Nombre","Romy");
        contentValues.put("Imagen", R.drawable.romi );
        db.insertarMascota( contentValues );


    }

  public void darLikeMascota(Mascota mascota){
      BaseDatosMascotas db = new BaseDatosMascotas(contexto) ;
      ContentValues contentValues = new ContentValues() ;
      contentValues.put("ID_MASCOTA",mascota.getId_mascota());
      contentValues.put("LIKES",LIKE);
      db.insertarLikeMascota(contentValues);
  }

  public int obtenerLikesMascota( Mascota mascota ){
      BaseDatosMascotas db = new BaseDatosMascotas(contexto);
      return db.obtenerLikesMascota(mascota);
  }

//
}
