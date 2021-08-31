package com.johhns.BaseDatos_Semana_5.Adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.johhns.BaseDatos_Semana_5.Vista.Fragmentos.Fragmento_Mascotas;
import com.johhns.BaseDatos_Semana_5.Vista.Fragmentos.Perfil;
//
public class PageAdapter extends FragmentStateAdapter {

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragmento_Mascotas();
            case 1:
                return new Perfil();
        }
        return null;    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
