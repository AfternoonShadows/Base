package com.example.myapplication1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * assignment
 **/
public class EnumAssignment extends AppCompatActivity {
    public enum num {
        RED(1),
        BLUE(2),
        yellow(10);
        private int value;

        num(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("num.RED = ", String.valueOf(num.RED));
        Log.d("num.RED = ", String.valueOf(num.RED.getValue()));
        Log.d("num.RED = ", String.valueOf(num.BLUE));
        Log.d("num.RED = ", String.valueOf(num.BLUE.getValue()));
        Log.d("num.RED = ", String.valueOf(num.yellow));
        Log.d("num.RED = ", String.valueOf(num.yellow.getValue()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
