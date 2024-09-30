package com.example.mariowonderswitch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebFragment extends Fragment {

    public WebFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        // Configurar el WebView
        WebView webView = view.findViewById(R.id.webView);

        // Configurar el WebViewClient para mantener la navegación dentro del WebView
        webView.setWebViewClient(new WebViewClient());

        // Configurar WebChromeClient para manejo de elementos multimedia y JS
        webView.setWebChromeClient(new WebChromeClient());

        // Configuración de ajustes del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // Habilitar JavaScript
        webSettings.setDomStorageEnabled(true);  // Habilitar almacenamiento DOM para evitar problemas de almacenamiento local
        webSettings.setLoadsImagesAutomatically(true);  // Cargar imágenes automáticamente
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);  // Permitir que JS abra nuevas ventanas

        // Habilitar caché para optimizar el rendimiento

        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        // Habilitar zoom si es necesario
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);  // Esconder controles de zoom nativos

        // Cargar la URL de la página
        webView.loadUrl("https://www.nintendo.com/es-cl/store/products/super-mario-bros-wonder-switch/?srsltid=AfmBOoqfzkeFqhqI3NcQXWBLPJsPNfsMyW4_skuvxCpw0IVBkfJQTUZK");

        return view;
    }
}
