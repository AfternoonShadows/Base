package com.example.myapplication1.MVP.presenter;

import android.util.Log;

import com.example.myapplication1.MVP.model.Model;
import com.example.myapplication1.MVP.view.IView;
/*
测试定义父类，通过子类初始化，调用时，会先调用父类里面的方法，在执行子类里面的方法，回调时，如果之类和父类实现同一个方法则会多次回调他.
父类可以通过子类初始化，但是子类不能通过父类初始化，因为子类拥有父类所有的方法和变量，父类不一定有子类的方法
Present iPresenter = new Presentone(MvpView.this);
 */
public class Presentone{
}
