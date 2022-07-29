package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    private Button addTable;
    private Button deleteTable;
    private TableLayout tableLayout;
    private String[] a = new String[]{"1","2","3","4","5","6"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        recyclerAdapterlinearlayout activutyAdapter = new recyclerAdapterlinearlayout(a);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(activutyAdapter);
//        TextView tv = findViewById(R.id.textview);
//        Drawable [] drawables = tv.getCompoundDrawables();
//        drawables[1].setBounds(50,20,150,100);
//        tv.setCompoundDrawables(drawables[0],drawables[1],drawables[2],drawables[3]);
//        init();
    }
    /*
    public void init(){
        addTable = findViewById(R.id.add_table);
        deleteTable = findViewById(R.id.delete_table);
        tableLayout = findViewById(R.id.table);
        addTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow tableRow =new TableRow(getApplicationContext());
                tableLayout.addView(tableRow);
            }
        });
        deleteTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = tableLayout.getChildCount();
                Log.e("表格长度：",""+length);
                if(length>0)
                {
                    tableLayout.removeAllViews();
                }
            }
        });
    }

     */
}