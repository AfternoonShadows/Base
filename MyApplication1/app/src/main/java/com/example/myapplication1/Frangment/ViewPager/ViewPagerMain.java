package com.example.myapplication1.Frangment.ViewPager;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerMain extends AppCompatActivity {
    private ViewPager viewPager;
    private List<View> list;
//    private List<String> list1;
    private PagerAdapter pagerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_viewpager_main);
        viewPager = findViewById(R.id.FragmentViewpagerMainViewpager);
        viewPager.setOffscreenPageLimit(3);
//        获取布局对象管理器
        LayoutInflater layoutInflater = getLayoutInflater();
        list = new ArrayList<View>();
        list.add(layoutInflater.inflate(R.layout.fragment_viewpager_layoutone,null));
        list.add(layoutInflater.inflate(R.layout.fragment_viewpager_layouttwo,null));
        list.add(layoutInflater.inflate(R.layout.fragment_viewpager_layoutthree,null));
        /*
        list1 = new ArrayList<String>();
        list1.add("e");
        list1.add("tow");
        list1.add("three");
         */
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }
//            判断pager的一个view是否和instantiatetem方法返回的object有关联
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
//            从当前位置删除指定位置的view
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }
//            第一，将当前视图添加到container中，第二返回当前view
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
//                同一个xml文件不同内容的切换
                /*
                View view = View.inflate(ViewPagerMain.this,R.layout.fragment_viewpager_layoutone,null);
                TextView textView = view.findViewById(R.id.FragmentViewpaperTest);
                textView.setText(list1.get(position));
                container.addView(view);
                return view;
                 */
//                多个xml文件值之间的切换
                container.addView(list.get(position));
                return list.get(position);

            }
//            标题
            @Override
            public CharSequence getPageTitle(int position) {
                return super.getPageTitle(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
    }
    public void FragmentViewpagerMainButton(View view){
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.e("skAffinity",activityInfo.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
