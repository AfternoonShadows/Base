package com.example.myapplication1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaRecoding extends AppCompatActivity {
    private File file ;
    private File filePast ;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    int i = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediorecording);
        RequestPermission();
    }
    public void submit(View view){
        startRecoding();
    }
    public void startRecoding(){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"Storage is true",Toast.LENGTH_SHORT).show();
          }else{
            Toast.makeText(this,"Storage is false",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(i==0){
            file = new File(getExternalFilesDir(null)+"/recoding");
            if(!file.exists()) {
                file.mkdir();
                Log.e("not file", String.valueOf(file));
            }else{
                Log.e("file", String.valueOf(file));
            }
            if(mediaRecorder == null) {
                mediaRecorder = new MediaRecorder();
            }
//
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//            
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//            recodData()
            filePast = new File(file.getPath()+"/"+"music"+".war");
            if(filePast.exists())
                filePast.delete();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mediaRecorder.setOutputFile(filePast);
            }
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaRecorder.start();
            i = 1;
        } else if(i == 1){
            try {
                Log.e("最大振幅", String.valueOf(20*Math.log10(Math.abs(mediaRecorder.getMaxAmplitude()))));
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }catch (RuntimeException e){
                mediaRecorder.reset();
                mediaRecorder.release();
                mediaRecorder = null;
            }
            i = 2;
            Log.e("i=", String.valueOf(i));
        }else if(i == 2){
            mediaPlayer = new MediaPlayer();
            try {
                FileInputStream fileInputStream = new FileInputStream(filePast);
                mediaPlayer.setDataSource(fileInputStream.getFD());
                mediaPlayer.prepare();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        Log.e("mediaPlayer",what+" "+extra);
                        return false;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            i = 4;
            Log.e("i=", String.valueOf(i));
        }else if(i == 4) {
            if(mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer = null;
            }
            i = 5;
            Log.e("i=", String.valueOf(i));
        }
    }
    public void RequestPermission()
    {
        if( ContextCompat.checkSelfPermission(MediaRecoding.this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MediaRecoding.this, new String []{Manifest.permission.RECORD_AUDIO},1);
        }
        if( ContextCompat.checkSelfPermission(MediaRecoding.this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MediaRecoding.this, new String []{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
        if( ContextCompat.checkSelfPermission(MediaRecoding.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MediaRecoding.this, new String []{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }
    public String recodData(){
        String data = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Log.e("simpleDateFormat", simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }
}
