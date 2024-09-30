package com.example.mariowonderswitch;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar el NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainer);

        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            // Referenciar el BottomNavigationView
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            NavigationUI.setupWithNavController(bottomNavigationView, navController);

            // Listener personalizado para los elementos del menú
            bottomNavigationView.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.action_back) {
                    // Si es posible retroceder, hacerlo
                    if (navController.getCurrentDestination() != null && navController.getPreviousBackStackEntry() != null) {
                        navController.popBackStack();
                    }
                    return true;
                } else if (itemId == R.id.action_next) {
                    // Avanzar al siguiente fragmento basado en el actual
                    if (navController.getCurrentDestination() != null) {
                        int currentDestinationId = navController.getCurrentDestination().getId();
                        if (currentDestinationId == R.id.imageFragment1) {
                            navController.navigate(R.id.action_imageFragment1_to_imageFragment2);
                        } else if (currentDestinationId == R.id.imageFragment2) {
                            navController.navigate(R.id.action_imageFragment2_to_imageFragment3);
                        } else if (currentDestinationId == R.id.imageFragment3) {
                            navController.navigate(R.id.action_imageFragment3_to_imageFragment1); // O navega a cualquier destino que elijas
                        }
                    }
                    return true;
                } else if (itemId == R.id.action_go_next_activity) {
                    // Navegar a la siguiente actividad
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            });
        }
    }
}
