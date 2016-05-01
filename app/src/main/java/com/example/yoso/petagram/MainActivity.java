package com.example.yoso.petagram;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Declaración
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    // Objeto de tipo adaptador
    Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Llamada del método FAB
        agregarFAB();

        // Declarar nuestro Swipe Refresh No hace falta instanciarlo
        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        //Declarar un arreglo de String
        String[] planetas = getResources().getStringArray(R.array.planetas);
        // Layout simple de item en lista de los planetas
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Invoca el método refrescar contenido
                refrescandoContenido();
            }
        });
    }

    // Método refrescando el contenido
    public void  refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }



    // Método agregar FAB
    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
        // En el momento de cliquear el FAB
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mensaje Toast en desuso
                // Toast.makeText(MainActivity.this, "Pulsaste el botón", Toast.LENGTH_SHORT).show();
                // Toast.makeText(MainActivity.this, getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();

                // Mensaje Snackbar
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Cuando hace click
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        // Cambiar el color el texto
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();


            }
        });
    }
}
