package com.example.myapplication1.AndroidTest;

import android.util.Log;

/**
 *
 **/
public class ImplementationTestExample {
    private final String TAG = this.getClass().getSimpleName();
    public int a;

    public ImplementationTestExample() {
    }

    public ImplementationTestExample(int a) {
        this.a = a;
    }

    public void run() {
        Log.d(TAG, "void run: " + a);
    }

    public int run(int a) {
        Log.d(TAG, "int run: " + a);
        return a;
    }
    public class InnerClassExample implements Runnable{
        private String TAG = "ImplementationTestExample.InnerClassExample";
        @Override
        public void run() {
            Log.d(TAG,"run ");
        }
    }
}
