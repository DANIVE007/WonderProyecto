package com.example.mariowonderswitch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    public VideoFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        // Configurar el WebView para mostrar el video de YouTube
        WebView webView = view.findViewById(R.id.videoWebView);

        // Permitir ejecución de JavaScript en el WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Establecer un WebViewClient para que el contenido se muestre dentro de la app
        webView.setWebViewClient(new WebViewClient());

        // Habilitar WebChromeClient para manejar contenido multimedia
        webView.setWebChromeClient(new WebChromeClient());

        // Cargar el video de YouTube con autoplay
        webView.loadUrl("https://www.youtube.com/embed/CHq6QKlDpv4?autoplay=1&mute=1");

        return view;
    }
}
