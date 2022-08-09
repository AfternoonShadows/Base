package com.example.myapplication1.CallBack;

import android.util.Log;public class them {
    public them(){
        You you = new You();
        Log.e("them:","start");
        you.setcall("them", "", new ContentCallBack() {
            @Override
            public void ContentCallBackResualt(String resualt) {
                Log.e("them:",resualt);
            }
        });
    }
}
