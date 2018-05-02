package com.example.android.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {


    MediaPlayer musicPlayer;
    SeekBar sbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        sbar = (SeekBar)findViewById(R.id.seekBar  );

        getSystemService( Context.AUDIO_SERVICE );
        sbar = (SeekBar)findViewById(R.id.seekBar);
        final AudioManager audioManager = (AudioManager) getSystemService( Context.AUDIO_SERVICE );
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sbar.setMax(maxVolume);
        sbar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i ,0);
            }



            
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {Log.d("Start", "Called");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {Log.d("Stop", "Called");
            }
        } );
    }
    public void play(View view) {
        musicPlayer = MediaPlayer.create(this,R.raw.a_ha);
        musicPlayer.start();

    }

    public void pause(View view) {
        musicPlayer.pause();
    }

    public void stop(View view) {
        musicPlayer.stop();
    }

}