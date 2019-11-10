package com.googles.harikedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvUang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main);
        // ini muncul pada log
        Log.e("TAG", "ini onCreate method");
        // ini muncul pada toast
        Toast.makeText( this, "Ini on Create", Toast.LENGTH_SHORT ).show();
        // buat method
        hitungDuit();
    }

    private void hitungDuit() {
        // buat variabel duit saya
        Double uangTransportHariIni = 25000.0;
        Double uangTransportBesok3Hari = 75000.0;
        Double hasilUangtransportSeluruhnya = uangTransportHariIni + uangTransportBesok3Hari;

        Toast.makeText( this, "Hasil Uang Transport Sebesar Rp :"
                +hasilUangtransportSeluruhnya, Toast.LENGTH_SHORT ).show();
        //Buat variabel textview
        tvUang = (TextView) findViewById(R.id.tv_uang);
        tvUang.setText("Hasil Uang Transport sebesar Rp " +hasilUangtransportSeluruhnya);
    }
}
