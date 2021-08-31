package com.johhns.BaseDatos_Semana_5.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.johhns.BaseDatos_Semana_5.Adaptadores.PageAdapter;
import com.johhns.BaseDatos_Semana_5.R;
import com.johhns.BaseDatos_Semana_5.Vista.Fragmentos.Fragmento_Mascotas;
import com.johhns.BaseDatos_Semana_5.Vista.Fragmentos.Perfil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar    barra1 ;
    private TabLayout  tabs ;
    private ViewPager2  viewPager;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra1 = findViewById( R.id.barra_ppl ) ;
        tabs = findViewById(R.id.miTabLayout1);
        viewPager = findViewById(R.id.viewPager1);

        viewPager.setAdapter( new PageAdapter( getSupportFragmentManager() , getLifecycle() ) );
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab( tabs.getTabAt(position) );
            }
        });

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        } );

        if ( barra1 != null ){
            setSupportActionBar(barra1);
        }

    }

    private ArrayList<Fragment> agregarFragmentos() {
        ArrayList<Fragment> fragmentos = new ArrayList<>() ;
        fragmentos.add(new Fragmento_Mascotas()) ;
        fragmentos.add(new Perfil()) ;
        return fragmentos;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcionSeleccionada = item.getItemId() ;
        switch (opcionSeleccionada ){
            case R.id.acerca:
                Intent opcion1 = new Intent(this, AcercaDe.class) ;
                startActivity(opcion1);
                break;
            case R.id.contactos:
                Intent opcion2 = new Intent(this, Contacto.class) ;
                startActivity(opcion2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}