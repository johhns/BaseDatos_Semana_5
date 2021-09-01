package com.johhns.BaseDatos_Semana_5.BaseDatos;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class BaseDatosMascotas  extends SQLiteOpenHelper {

    private Context context;

    public BaseDatosMascotas(@Nullable Context context) {
        super(context, "mascotas_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        crearTablaMascotas(sqLiteDatabase) ;
        crearTablaLikes(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MSC_TB_MASCOTAS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MSC_TB_LIKES");
        onCreate(sqLiteDatabase);
    }
    //2

    private void crearTablaMascotas(SQLiteDatabase db){
       String  comando = "CREATE TABLE MSC_TB_MASCOTAS (";
       comando += "ID_MASCOTA  INTEGER PRIMARY KEY AUTOINCREMENT , " ;
       comando += "NOMBRE      TEXT , " ;
       comando += "IMAGEN      INTEGER  " ;
       comando += ") ; " ;
       db.execSQL(comando);
    }

    private void crearTablaLikes(SQLiteDatabase db){
        String  comando = "CREATE TABLE MSC_TB_LIKES (";
        comando += "ID_LIKE     INTEGER PRIMARY KEY AUTOINCREMENT , " ;
        comando += "ID_MASCOTA  INTEGER , " ;
        comando += "LIKES       INTEGER , " ;
        comando += "FOREIGN KEY ( ID_MASCOTA ) REFERENCES MSC_TB_MASCOTAS( ID_MASCOTA ) " ;
        comando += ") ; " ;
        db.execSQL(comando);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM MSC_TB_MASCOTAS " ;
        SQLiteDatabase db = this.getWritableDatabase() ;
        Cursor registros = db.rawQuery( query , null) ;

        while ( registros.moveToNext() ) {
            Mascota mascotaActual = new Mascota() ;
            mascotaActual.setId_mascota(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT SUM(LIKES) FROM MSC_TB_LIKES WHERE ID_MASCOTA = " + mascotaActual.getId_mascota() ;
            Cursor regLikes = db.rawQuery(queryLikes,null);
            if (regLikes.moveToNext()) {
                mascotaActual.setRating(regLikes.getInt(0));
            } else {
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual) ;

        }
        db.close();

        return mascotas ;
    }


    public void insertarMascota( ContentValues contentValues ){
      SQLiteDatabase db = this.getWritableDatabase();
      db.insert("MSC_TB_MASCOTAS",null, contentValues) ;
      db.close();
    }

    public void insertarLikeMascota( ContentValues contentValues ){
        SQLiteDatabase db = this.getWritableDatabase() ;
        db.insert("MSC_TB_LIKES",null,contentValues) ;
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
       int likes = 0 ;
       String query = "SELECT SUM(LIKES) LIKES FROM MSC_TB_LIKES WHERE ID_MASCOTA = " + mascota.getId_mascota() ;
       SQLiteDatabase db = this.getWritableDatabase() ;
       Cursor registros =  db.rawQuery( query , null ) ;
        if ( registros.moveToNext() ) {
            likes = registros.getInt(0) ;
        }
        db.close();
       return likes ;
    }


}
