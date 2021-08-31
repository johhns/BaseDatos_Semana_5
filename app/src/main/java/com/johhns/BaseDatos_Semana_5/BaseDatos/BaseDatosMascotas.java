package com.johhns.BaseDatos_Semana_5.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    }
    //2

    private void crearTablaMascotas(SQLiteDatabase db){
       String  comando = "Create Table msc_tb_mascotas (";
       comando += "Id_Mascota  Integer Primary Key AutoIncrement , " ;
       comando += "Nombre      Text , " ;
       comando += "Image       Integer , " ;
       comando += ") ; " ;
       db.execSQL(comando);
    }

    private void crearTablaLikes(SQLiteDatabase db){
        String  comando = "Create Table msc_tb_likes (";
        comando += "Id_Like     Integer Primary Key AutoIncrement , " ;
        comando += "Id_Mascota  Integer , " ;
        comando += "Likes       Integer , " ;
        comando += "Foreign Key ( Id_mascotas ) References msc_tb_mascotas( Id_Mascota ) " ;
        comando += ") ; " ;
        db.execSQL(comando);
    }


}
