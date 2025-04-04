package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();

        // Configuraciones esenciales
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Para Single-Page Apps (React/Angular)

        // Manejo de cookies (importante para subdominios)
        CookieManager.getInstance().setAcceptThirdPartyCookies(mWebView, true);

        // Asigna el WebViewClient personalizado
        mWebView.setWebViewClient(new MyWebViewClient());

        // Carga el subdominio
        mWebView.loadUrl("https://farmaceutica.pro-tic.mx");  // URL con subdominio
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}