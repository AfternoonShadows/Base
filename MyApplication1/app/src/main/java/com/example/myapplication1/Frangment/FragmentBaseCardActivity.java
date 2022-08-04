package com.example.myapplication1.Frangment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication1.R;


public class FragmentBaseCardActivity extends AppCompatActivity {
    private Spinner orientation_spinner,card_spinner;
    private TextView textView,textView1;
    private CheckBox checkBox,checkBox1,checkBox2,checkBox3,checkBox4;
    private Button jump_button;
    private String title = null;
    private String direction = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base_card_activity);
        init();
    }
//    初始化
    public void init()
    {
        orientation_spinner = findViewById(R.id.orientation_spinner);
        card_spinner = findViewById(R.id.card_spinner);
        textView = findViewById(R.id.fragmentBaseCardRelativeLayoutTopText);
        textView1 = findViewById(R.id.fragmentBaseCardRelativeLayoutButtonText);
        jump_button = findViewById(R.id.jump_button);
        //设置Adapter了
        orientation_spinner.setAdapter(Spinner(getResources().getStringArray(R.array.FragmentOrientationSpinner)));
        //设置Adapter了
        card_spinner.setAdapter(Spinner(getResources().getStringArray(R.array.FragmentCardSpinner)));
        jump_button.setOnClickListener(new OnClickListener());
        //监听Spinner的操作
        orientation_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        card_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                title = Spinner(getResources().getStringArray(R.array.FragmentCardSpinner)).getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
//    获取button按钮事件
    public class OnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.jump_button){
                textView.setText(title);
                textView1.setText(title);
                Log.e("OnClickListener","R.id.jump_button");
            }else{
                Log.e("OnClickListener","not R.id.jump_button");
            }
        }
    }
// Adapter
    public ArrayAdapter<String> Spinner(String [] resources){
        //设置ArrayAdapter内置的item样式-这里是单行显示样式
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, resources);
        //这里设置的是Spinner的样式 ， 输入 simple_之后会提示有4人，如果专属spinner的话该是俩种，在特殊情况可自己定义样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        return adapter;
    }

}
