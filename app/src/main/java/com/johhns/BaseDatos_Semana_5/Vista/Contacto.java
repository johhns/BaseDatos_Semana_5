package com.johhns.BaseDatos_Semana_5.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.johhns.BaseDatos_Semana_5.R;

public class Contacto extends AppCompatActivity {

    TextInputEditText te_nombre, te_correo, te_mensaje ;
    Button            bt_enviar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
//
        Toolbar barra_acciones = findViewById( R.id.miActionBar2 ) ;
        setSupportActionBar(barra_acciones);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        te_nombre  = findViewById(R.id.txtEditNombreUsr) ;
        te_correo  = findViewById(R.id.txtEditCorreo)    ;
        te_mensaje = findViewById(R.id.txtEditMensaje)   ;
        bt_enviar  = findViewById(R.id.btnEnviar)        ;

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( Intent.ACTION_SEND ) ;
                i.putExtra(Intent.EXTRA_EMAIL , Uri.parse( te_correo.getText().toString() ) ) ;
                i.putExtra(Intent.EXTRA_SUBJECT,"Mensaje de ," + te_nombre.getText().toString() ) ;
                i.putExtra(Intent.EXTRA_TEXT, te_mensaje.getText().toString() ) ;
                i.setType("text/plain") ;
                startActivity(i);
            }
        });



    }
}