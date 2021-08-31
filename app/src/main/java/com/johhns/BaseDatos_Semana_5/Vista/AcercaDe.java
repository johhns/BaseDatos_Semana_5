package com.johhns.BaseDatos_Semana_5.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.johhns.BaseDatos_Semana_5.R;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar barra_acciones = findViewById( R.id.miActionBar1 ) ;
        setSupportActionBar(barra_acciones);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//

    }
}