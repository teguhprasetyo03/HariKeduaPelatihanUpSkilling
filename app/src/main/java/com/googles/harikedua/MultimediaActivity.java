package com.googles.harikedua;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MultimediaActivity extends AppCompatActivity {
    // variabel videoview
    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_multimedia );
        // inisialisasi
         videoView = (VideoView) findViewById( R.id.video_view );

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        getSupportActionBar().hide();

        // set video dimana di simpan
         videoView.setVideoURI( Uri.parse( "android.resource://"+getPackageName()+"/"+R.raw.video ) );
         mediaController = new MediaController( this );
         mediaController.setAnchorView( videoView );
         videoView.setMediaController( mediaController );
         videoView.start();


    }
}
