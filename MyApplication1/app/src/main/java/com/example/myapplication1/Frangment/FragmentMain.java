package com.example.myapplication1.Frangment;

import android.content.Intent;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication1.Frangment.FrangmentAdapter.FragmentRecyclerAdapter;
import com.example.myapplication1.R;

public class FragmentMain extends AppCompatActivity {
    private Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentmain);

        RecyclerView recyclerView = findViewById(R.id.frangmentrecyclerview);
//        getResources().getStringArray(R.array.FragmentMainListArray) 获取String.xml数组里面的数组
        FragmentRecyclerAdapter fragmentRecyclerAdapter = new FragmentRecyclerAdapter(getResources().getStringArray(R.array.FragmentMainListArray));
//        设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        设置布局方式setting the layout mode
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fragmentRecyclerAdapter);

//        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());

        fragmentRecyclerAdapter.setOnItemClickListenerFragment(new FragmentRecyclerAdapter.OnItemClickListenerFragment() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        intent = null;
                        intent = new Intent(FragmentMain.this , FragmentBaseCardActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    default:
                        break;
                }
                TextView textView = view.findViewById(R.id.fragmentListTextview);
                Toast.makeText(FragmentMain.this,textView.getText()+" "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(FragmentMain.this,"长按:"+fragmentRecyclerAdapter.TV(position)+" "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
