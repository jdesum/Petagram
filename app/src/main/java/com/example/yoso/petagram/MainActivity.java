package com.example.yoso.petagram;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Llamada del método FAB
        agregarFAB();
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
                        .show();


            }
        });
    }
}
