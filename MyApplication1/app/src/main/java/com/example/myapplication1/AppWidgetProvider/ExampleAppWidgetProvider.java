package com.example.myapplication1.AppWidgetProvider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.myapplication1.R;


/**
 *
 **/
public class ExampleAppWidgetProvider extends AppWidgetProvider {
    private final String TAG = this.getClass().getSimpleName();
    private static final String CLICK_ACTION = "com.example.RemoteView.action.CLICK";

    /**
     * 调用此方法可以按 AppWidgetProviderInfo中的 updatePeriodMillis 属性定义的时间间隔来更新应用微件.
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d(TAG, "onUpdate: appWidgetIds.length = " + appWidgetIds.length);
        final int counter = appWidgetIds.length;
        for (int i = 0; i < counter; i++) {
            OnWidgetUpdate(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    /**
     * 当首次放置微件时以及每当调整微件的大小时，会调用此方法。
     * 您可以使用此回调来根据微件的大小范围显示或隐藏内容。
     * 您可以通过调用 getAppWidgetOptions() 来获取大小范围，该方法会返回包含以下各项的 Bundle：
     * OPTION_APPWIDGET_MIN_WIDTH - 包含微件实例的当前宽度的下限（以 dp 为单位）。
     * OPTION_APPWIDGET_MIN_HEIGHT - 包含微件实例的当前高度的下限（以 dp 为单位）。
     * OPTION_APPWIDGET_MAX_WIDTH - 包含微件实例的当前宽度的上限（以 dp 为单位）。
     * OPTION_APPWIDGET_MAX_HEIGHT - 包含微件实例的当前高度的上限（以 dp 为单位）。
     * 此回调是在 API 级别 16 (Android 4.1) 中引入的。如果您实现此回调，请确保您的应用不依赖于它，因为在旧款设备上不会调用它。
     */
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.e(TAG, "onAppWidgetOptionsChanged");
    }

    /**
     * 每次从应用微件托管应用中删除应用微件时，都会调用此方法。
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.e(TAG, "onDeleted");
    }

    /**
     * 首次创建应用微件的实例时，会调用此方法。
     * 例如，如果用户添加应用微件的两个实例，只有首次添加时会调用此方法。
     * 如果您需要打开一个新的数据库或执行只需要对所有应用微件实例执行一次的其他设置，则此方法非常合适。
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.e(TAG, "onEnabled");
    }

    /**
     * 从应用微件托管应用中删除了应用微件的最后一个实例时，会调用此方法。
     * 您应使用此方法来清理在 onEnabled(Context) 中完成的所有工作，如删除临时数据库。
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.e(TAG, "onDisabled");
    }

    /**
     * 针对每个广播调用此方法，并且是在上述各个回调方法之前调用。
     * 您通常不需要实现此方法，因为默认的 AppWidgetProvider 实现会过滤所有应用微件广播并视情况调用上述方法。
     * 广播
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.e(TAG, "onReceive: action = " + intent.getAction());
        // 这里判断自定义的action,并实现action。例如，控件被单击之后，执行一个动画：旋转图片一周，通过不断的更新RemoveViews来实现
        if (intent.getAction().equals(CLICK_ACTION)) {
            context.startService(new Intent(context,ExampleAPPWidgetProviderService.class));
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            remoteViews.setViewVisibility(R.id.img_widget, View.INVISIBLE);
            // getInstance得到已经创建的对象，updateAppWidget更新内容，
            // 参数第一个(ComponentName provider) 获取需要更新的微件，第二个(RemoteViews views) 更新的内容
            AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context,ExampleAppWidgetProvider.class),remoteViews);
        }
    }

    // 实现控件更新
    private void OnWidgetUpdate(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        Log.e(TAG, "OnWidgetUpdate: appWidgetId = " + appWidgetId);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        /**
         * 设置RemoteViews对象以使用RemoteView适配器。
         * 此适配器通过指定的意图连接到RemoteViewsService。
         * 这就是填充数据的方式。
         */
//        remoteViews.setRemoteAdapter(R.id.img_widget, new Intent(context, ExampleAPPWidgetProviderService.class));
        interactToRemoteViews(context, remoteViews);
//        remoteViews.setEmptyView(R.id.img_widget, R.id.txt_text);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    // RemoteViews的交互事件：注册监听器，单击发送广播
    private void interactToRemoteViews(Context context, RemoteViews remoteViews) {
        Intent intent = new Intent();
        // 设置action,Manifest里面的receiver已经注册过
        intent.setAction(CLICK_ACTION);
        // 设置包名
        intent.setPackage("com.example.myapplication1");
        // 发送广播，当前widget的onReceive里面
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        // 设置点击事件
        remoteViews.setOnClickPendingIntent(R.id.img_widget, pendingIntent);
    }
}
