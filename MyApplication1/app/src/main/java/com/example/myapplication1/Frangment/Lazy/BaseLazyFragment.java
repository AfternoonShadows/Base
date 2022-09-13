package com.example.myapplication1.Frangment.Lazy;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class BaseLazyFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    public boolean mHaveLoadData; // 表示是否已经请求过数据

    protected boolean mLoadDataFinished; // 表示数据是否已经请求完毕
    private View mRootView;

    // 表示开始加载数据, 但不表示数据加载已经完成
    public abstract void loadDataStart();

    // 表示找控件完成, 给控件们设置数据不会报空指针了
    public boolean mViewInflateFinished;

    @Override
    public void onAttach(Context context) {
        Log.e(TAG, "onAttach");
        Log.e(TAG," getClass : "+getClass());
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        if (mRootView != null) {
            return mRootView;
        }
        mRootView = initRootView(inflater, container, savedInstanceState);
        findViewById(mRootView);
        mViewInflateFinished = true;
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");
    }

    //    加载组件
    protected abstract void findViewById(View view);

    //    获取视图
    protected abstract View initRootView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView");
        super.onDestroyView();
        mRootView = null;
        mHaveLoadData = false;
        mViewInflateFinished = false;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG, "onDetach");
        super.onDetach();
    }

    //    只有和ViewPager组合使用才有效
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e(TAG, "setUserVisibleHint, isVisibleToUser = " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
        // 如果还没有加载过数据 && 用户切换到了这个fragment
        // 那就开始加载数据
        if (!mHaveLoadData && isVisibleToUser) {
            loadDataStart();
            mHaveLoadData = true;
        }
    }

    //    通过FragmentTransaction 的add hide show方法来控制fragment的显示隐藏
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }
}
