package com.example.myapplication1.AppWidgetProvider;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class ExampleAPPWidgetProviderService extends RemoteViewsService {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.e(TAG, "onGetViewFactory");
        return new StackRemoteViewsFactory(new ArrayList<>());
    }
}

class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    private final String TAG = this.getClass().getSimpleName();
    List<String> mList;

    public StackRemoteViewsFactory(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDataSetChanged() {
        Log.e(TAG, "onDataSetChanged");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
    }

    @Override
    public int getCount() {
        Log.e(TAG, "getCount");
        return mList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Log.e(TAG, "getViewAt: " + position);
        return null;
    }

    @Override
    public RemoteViews getLoadingView() {
        Log.e(TAG, "getLoadingView");
        return null;
    }

    @Override
    public int getViewTypeCount() {
        Log.e(TAG, "getViewTypeCount");
        return 0;
    }

    @Override
    public long getItemId(int getItemId) {
        Log.e(TAG, "getItemId: " + getItemId);
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        Log.e(TAG, "hasStableIds");
        return false;
    }
}
