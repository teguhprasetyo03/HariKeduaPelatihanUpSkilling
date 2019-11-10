package com.googles.harikedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    // global varibel
    WebView webViewYoutube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web_view );

        // inisialisasi(setiap variabel widget butuh banget inisialisasi)
        webViewYoutube = (WebView) findViewById( R.id.webview_youtube );
        // atribut
        webViewYoutube.loadUrl( "https://youtube.com" );
        webViewYoutube.getSettings().setJavaScriptEnabled( true );
        webViewYoutube.setWebViewClient( new WebViewClient() );
    }

    @Override
    public void onBackPressed() {
        if (webViewYoutube.canGoBack()){
            webViewYoutube.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
