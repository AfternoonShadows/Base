package com.example.myapplication1.AndroidTest;

import android.util.Log;

/**
 *
 **/
public class ImplementationTestNoPublicExample {
    private final String TAG = this.getClass().getSimpleName();
    private int a;
    final int b = 0;
    static int c = 0;

    public ImplementationTestNoPublicExample() {
    }
    public void start(){

    }
    private ImplementationTestNoPublicExample(int a) {
        this.a = a;
    }

    private void run() {
        Log.d(TAG, "void run: a = " + a + " b = " + b + " c = " + c);
    }

    private int run(int a) {
        Log.d(TAG, "int run: a = " + a + " b = " + b + " c = " + c);
        return a;
    }

    private class InnerClassExample implements Runnable {
        private String TAG = "ImplementationTestNoPublicExample.InnerClassExample";
        private String d;

        private InnerClassExample(String d) {
            this.d = d;
        }

        @Override
        public void run() {
            Log.d(TAG, "run: d = " + d);
        }
    }
}
