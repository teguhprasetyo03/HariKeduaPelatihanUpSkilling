package com.googles.harikedua;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HitungHitungDuit extends AppCompatActivity {
    // buat variabel global
    EditText edtNilaiPertama, edtNilaiKedua;
    Button btnHitung;
    TextView tvHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        // Panggil View
        setContentView( R.layout.hitung_duit );
        // inisialisasi
        edtNilaiPertama = (EditText) findViewById( R.id.edt_nilai_pertama );
        edtNilaiKedua = (EditText) findViewById( R.id.edt_nilai_kedua );
        btnHitung = (Button) findViewById( R.id.btn_hitung );
        tvHasil = (TextView) findViewById( R.id.tv_hasil );

        // listener button
        btnHitung.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungHitungDuit();
            }
        } );

    }

    private void hitungHitungDuit() {
        // Buat Variabel untuk Ambil nilai di edit text
        String ambilNilaiPertama = edtNilaiPertama.getText().toString();
        String ambilNilaiKedua = edtNilaiKedua.getText().toString();

        // validasi
        if (ambilNilaiPertama.isEmpty() || ambilNilaiKedua.isEmpty()) {
            Toast.makeText( this, "Isi woyyy edit text bambang", Toast.LENGTH_SHORT ).show();
        } else {

            // penjumlahan dari nilai 1 dan 2
            Float hasil = Float.parseFloat( ambilNilaiPertama ) * Float.parseFloat( ambilNilaiKedua );
            tvHasil.setText( "Hasilnya adalah " + hasil );

            // dialog
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder( this );

            // atribut title dan message
            alertDialog.setTitle( "Hasil dari penjumlahan" );
            alertDialog.setMessage( " Hasilnya adalah " + hasil );
            alertDialog.setCancelable( false );

            // positif button ada parameter("nama button" , listener)
            alertDialog.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        edtNilaiPertama.setText( "" );
                        edtNilaiKedua.setText( "" );

                }
            });

            // negative button ada parameter("nama button" , listener)
            alertDialog.setNegativeButton( "NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // intent pindah activity
                    // punya 2 parameter(context/activity di berasal , pindah kemana )
                    Intent pindahKeActivityLain = new Intent(HitungHitungDuit.this , WebViewActivity.class  );
                    // di start / mulai
                    startActivity( pindahKeActivityLain );
                }
            });
            alertDialog.show();

        }
    }
}
