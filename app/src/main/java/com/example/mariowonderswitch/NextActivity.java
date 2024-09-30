package com.example.mariowonderswitch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



public class NextActivity extends AppCompatActivity {

    // IDs de los ítems del menú
    private MenuItem backItem;
    private MenuItem videoItem;
    private MenuItem webItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_next);
        setSupportActionBar(toolbar);

        // Habilitar la acción de "volver atrás" en el toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Inflar el menú del Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú desde el archivo XML
        getMenuInflater().inflate(R.menu.next_activity_menu, menu);

        // Obtener los ítems del menú de forma manual
        backItem = menu.findItem(menu.getItem(0).getItemId());
        videoItem = menu.findItem(menu.getItem(1).getItemId());
        webItem = menu.findItem(menu.getItem(2).getItemId());

        return true;
    }

    // Manejar los clics de los ítems del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item == backItem) {
            // Cambiar la lógica para volver a MainActivity
            Intent intent = new Intent(NextActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Eliminar todas las actividades anteriores de la pila
            startActivity(intent);
            return true;
        } else if (item == videoItem) {
            // Mostrar el fragmento de video
            showFragment(new VideoFragment());
            Toast.makeText(this, "Mostrando el video...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item == webItem) {
            // Mostrar el fragmento de la página web
            showFragment(new WebFragment());
            Toast.makeText(this, "Mostrando la página web...", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Método para mostrar un fragmento
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);  // Permitir volver al fragmento anterior
        transaction.commit();
    }
}
