package com.zhangxt4.weatherwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangxt4 on 2016/2/21.
 */
public class TimeWidgetProvider extends AppWidgetProvider {

    @Override
    public void onEnabled(Context context) {
        // 第一个widget在屏幕被添加
        // 被添加时就启动service
        super.onEnabled(context);
        context.startService(new Intent(context, TimerService.class));
    }

    @Override
    public void onDisabled(Context context) {
        // 最好一个widget从屏幕移除
        super.onDisabled(context);
        context.stopService(new Intent(context, TimerService.class));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // widget被从屏幕移除
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //使用RemoteView和AppWidgetManager刷新widget
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
