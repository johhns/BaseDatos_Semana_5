package com.johhns.BaseDatos_Semana_5.Presentador;

import android.content.Context;

import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;
import com.johhns.BaseDatos_Semana_5.Vista.Fragmentos.InterfaseFragmentoMascota;
import com.johhns.BaseDatos_Semana_5.Modelo.ConstructorMascotas;

import java.util.ArrayList;

public class PresentadorMascotas implements InterfasePresentadorMascota {

   private InterfaseFragmentoMascota iRVFragmento ;
   private Context contexto ;
   private ConstructorMascotas constructorMascota ;
   private ArrayList<Mascota> mascotas ;

    public PresentadorMascotas( InterfaseFragmentoMascota iRVFragmento, Context contexto ) {
        this.iRVFragmento = iRVFragmento ;
        this.contexto     = contexto ;
        obtenerMascotas();
    }
///
    @Override
    public void obtenerMascotas() {
       constructorMascota = new ConstructorMascotas( contexto ) ;
       mascotas = constructorMascota.obtenerDatos() ;
       mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
      iRVFragmento.inicializarAdaptadorRV(iRVFragmento.crearAdaptador(mascotas));
      iRVFragmento.generarLinearLayoutVertical();
    }
}
