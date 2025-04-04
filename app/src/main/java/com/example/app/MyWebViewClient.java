//package com.example.app;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//class MyWebViewClient extends WebViewClient {
//
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        String hostname;
//
//        // YOUR HOSTNAME
//        hostname = "pro-tic.mx";
//
//        Uri uri = Uri.parse(url);
//        if (url.startsWith("file:") || uri.getHost() != null && uri.getHost().endsWith(hostname)) {
//            return false;
//        }
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        view.getContext().startActivity(intent);
//        return true;
//    }
//}
package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Uri uri = Uri.parse(url);
        String hostname = uri.getHost(); // Obtiene el host de la URL (ej: "app.pro-tic.mx")

        // Permite cargar en el WebView:
        // 1. Archivos locales (file://)
        // 2. URLs de tu dominio principal (pro-tic.mx)
        // 3. URLs de tus subdominios (app.pro-tic.mx, api.pro-tic.mx, etc.)
        if (url.startsWith("file:") ||
                hostname != null &&
                        (hostname.equals("pro-tic.mx") ||
                                hostname.endsWith(".pro-tic.mx"))) {  // <- ¡Clave para subdominios!
            return false; // Permite que el WebView cargue la URL
        }

        // Si no es tu dominio, abre en navegador externo
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}