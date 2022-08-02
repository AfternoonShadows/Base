package com.example.myapplication1;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AudioRecoding extends AppCompatActivity {
    private AudioRecord audioRecord;
    private File file;
    private File recodingFile;
    private int bufferSizeInBytes = 0;
    private boolean isrecoding = false;
    private AudioTrack audioTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_recoding);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(audioRecord != null){
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
        }
    }

    public void AudioRecodingRecoding(View view){
        final byte data[] = new byte[bufferSizeInBytes];
        try {
            file = new File(Environment.getExternalStorageDirectory().getCanonicalPath()+"/recoding");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!file.exists()) {
            file.mkdir();
            Log.e("not file", String.valueOf(file));
        }else{
            Log.e("file", String.valueOf(file));
        }
        recodingFile = new File(file+"/"+recodData()+".pcm");
        if(recodingFile.exists()) {
            recodingFile.delete();
        }
        bufferSizeInBytes = 2*AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT);
        if(audioRecord == null)
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,44100,
                    AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT,bufferSizeInBytes);
        audioRecord.startRecording();
        isrecoding = true ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileOutputStream inputRecoding = null;
                try {
                    inputRecoding = new FileOutputStream(recodingFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if(inputRecoding != null) {
                    while(isrecoding){
                        int read = audioRecord.read(data,0,bufferSizeInBytes);
                        if(AudioRecord.ERROR_INVALID_OPERATION != read){
                            try {
                                inputRecoding.write(data);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
        Log.e("AudioRecodingRecoding", String.valueOf(view.getId()));
    }
    public void AudioRecodingStop(View view){
        isrecoding = false;
        if(audioRecord != null) {
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
        }
        Log.e("AudioRecodingStop", String.valueOf(view.getId()));
    }
    public void AudioRecodingPlay(View view){
        final byte data[] = new byte[bufferSizeInBytes];
        audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,44100,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT,
                data.length,AudioTrack.MODE_STATIC);
        audioTrack.write(data,0,data.length);
        audioTrack.play();
        Log.e("AudioRecodingPlay", String.valueOf(view.getId()));
    }
    public void AudioRecodingQuit(View view){
        if(audioRecord != null)
        {
            audioTrack.stop();
            audioTrack.release();
            audioTrack = null;
        }
        Log.e("AudioRecodingQuit", String.valueOf(view.getId()));
    }
    public String recodData(){
        String data = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Log.e("simpleDateFormat", simpleDateFormat.format(date));
        return simpleDateFormat.format(date);
    }
}
