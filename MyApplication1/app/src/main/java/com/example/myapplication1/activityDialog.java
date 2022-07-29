package com.example.myapplication1;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class activityDialog extends AppCompatActivity {
    private View dialog1;
    private View dialog2;
    private View dialog3;
    private View dialog4;
    private View dialog5;
    private View dialog6;
    private View dialog7;
    private View dialog8;
    private View dialog9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialog1 = findViewById(R.id.dialog1);
        dialog2 = findViewById(R.id.dialog2);
        dialog3 = findViewById(R.id.dialog3);
        dialog4 = findViewById(R.id.dialog4);
        dialog5 = findViewById(R.id.dialog5);
        dialog6 = findViewById(R.id.dialog6);
        dialog7 = findViewById(R.id.dialog7);
        dialog8 = findViewById(R.id.dialog8);
        dialog9 = findViewById(R.id.dialog9);
        dialog1.setOnClickListener(new Click());
        dialog2.setOnClickListener(new Click());
        dialog3.setOnClickListener(new Click());
        dialog4.setOnClickListener(new Click());
        dialog5.setOnClickListener(new Click());
        dialog6.setOnClickListener(new Click());
        dialog7.setOnClickListener(new Click());
        dialog8.setOnClickListener(new Click());
        dialog9.setOnClickListener(new Click());

    }
    class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dialog1:
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(activityDialog.this);
                    alertDialog.setIcon(R.drawable.ic_launcher_background);
                    alertDialog.setTitle("我是标题");
                    alertDialog.setMessage("对话框内容");
                    alertDialog.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                       @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"sure",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog.setNegativeButton("pass", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"pass",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog.setNegativeButton("middle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"middle",Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    });
                    alertDialog.create().show();
                    break;
                case R.id.dialog2:
                    String items[] = {"w","t","y"};
                    AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(activityDialog.this);
                    alertDialog2.setIcon(R.drawable.ic_launcher_background);
                    alertDialog2.setTitle("列表对话框");
                    alertDialog2.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,items[which],Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog2.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"sure",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog2.setNegativeButton("pass", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"pass",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog2.create().show();
                    Toast.makeText(activityDialog.this,"列表对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog3:
                    String items3[] = {"w","t","y"};
                    AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(activityDialog.this);
                    alertDialog3.setIcon(R.drawable.ic_launcher_background);
                    alertDialog3.setTitle("列表对话框");
                    alertDialog3.setSingleChoiceItems(items3,1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,items3[which],Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog3.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"sure",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog3.setNegativeButton("pass", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"pass",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog3.create().show();
                    Toast.makeText(activityDialog.this,"单选列表对话框",Toast.LENGTH_SHORT).show();
                  break;
                case R.id.dialog4:
                    String items4[] = {"w","t","y"};
                    AlertDialog.Builder alertDialog4 = new AlertDialog.Builder(activityDialog.this);
                    alertDialog4.setIcon(R.drawable.ic_launcher_background);
                    alertDialog4.setTitle("列表对话框");
                    alertDialog4.setMultiChoiceItems(items4, null, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    Toast.makeText(activityDialog.this,items4[which],Toast.LENGTH_SHORT).show();
                                }
                            });
                            alertDialog4.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(activityDialog.this, "sure", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog4.setNegativeButton("pass", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(activityDialog.this,"pass",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog4.create().show();
                    Toast.makeText(activityDialog.this,"多选列表对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog5:
                    Toast.makeText(activityDialog.this,"半自定义对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog6:
                    AlertDialog.Builder alertDialog5 = new AlertDialog.Builder(activityDialog.this,R.style.DialogStyle);
                    View view = View.inflate(activityDialog.this , R.layout.textview,null);
                    alertDialog5.setView(view);
                    alertDialog5.show();
                    Toast.makeText(activityDialog.this,"自定义对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog7:
                    ProgressDialog progressDialog = new ProgressDialog(activityDialog.this);
                    progressDialog.setMessage("start......");
                    progressDialog.show();
                    Toast.makeText(activityDialog.this,"圆形进度条对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog8:
                    ProgressDialog progressDialog1 = new ProgressDialog(activityDialog.this);
                    progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog1.setMessage("start......");
                    progressDialog1.setMax(100);
                    progressDialog1.show();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        int p = 0;
                        @Override
                        public void run() {
                            progressDialog1.setProgress(p+=5);
                            if(p==100) {
                                timer.cancel();
                                progressDialog1.cancel();
                            }
                        }
                    },0,1000);
                    Toast.makeText(activityDialog.this,"水平进度条对话框",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dialog9:
                    Toast.makeText(activityDialog.this,"9",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
