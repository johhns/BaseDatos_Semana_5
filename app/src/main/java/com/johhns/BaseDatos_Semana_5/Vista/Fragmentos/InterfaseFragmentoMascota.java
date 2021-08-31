package com.johhns.BaseDatos_Semana_5.Vista.Fragmentos;

import com.johhns.BaseDatos_Semana_5.Adaptadores.MascotaAdaptador;
import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;

import java.util.ArrayList;

public interface InterfaseFragmentoMascota {

    public void generarLinearLayoutVertical() ;

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascota);

    public  void inicializarAdaptadorRV(MascotaAdaptador adaptador) ;

    //
}
