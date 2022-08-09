package com.example.myapplication1.CallBack;

import android.util.Log;

import com.example.myapplication1.R;

public class You{
    private String who;
    private ContentCallBack contentCallBack;
    public void setcall(String who ,String question,ContentCallBack contentCallBack){
        this.contentCallBack = contentCallBack;
        this.who = who;
        Log.e("You:",who+" call phone inquiry " + question);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Log.e("You:",who+" answer");
                    contentCallBack.ContentCallBackResualt("123");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
