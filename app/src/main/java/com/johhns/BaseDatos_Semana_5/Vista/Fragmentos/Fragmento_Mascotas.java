package com.johhns.BaseDatos_Semana_5.Vista.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johhns.BaseDatos_Semana_5.Adaptadores.MascotaAdaptador;
import com.johhns.BaseDatos_Semana_5.Modelo.Mascota;
import com.johhns.BaseDatos_Semana_5.Presentador.PresentadorMascotas;
import com.johhns.BaseDatos_Semana_5.R;

import java.util.ArrayList;


public class Fragmento_Mascotas extends Fragment implements InterfaseFragmentoMascota {

    //private ArrayList<Mascota> arrayMascotas ;
    private  RecyclerView recView ;
    private PresentadorMascotas presentador ;

//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_fragmento__mascotas, container, false);
        recView =  v.findViewById(R.id.rcView1);
        ///crear_mascotas();
        presentador = new PresentadorMascotas( this, getContext() ) ;

        return v ;
    }

    @Override
    public void generarLinearLayoutVertical() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascota) {
        MascotaAdaptador adapter = new MascotaAdaptador(mascota,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        recView.setAdapter(adaptador);
    }


}