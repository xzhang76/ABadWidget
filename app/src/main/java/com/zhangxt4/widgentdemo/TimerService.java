package com.zhangxt4.widgentdemo;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 当widget被添加到屏幕上时，就会启动这个service
 * Created by zhangxt4 on 2016/2/21.
 */
public class TimerService extends Service {
    private Timer mTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        // 在Timer定时器的TimerTask()中完成当timer到期时执行的操作
        //一秒中执行一次(1000),没有延迟(0)
        mTimer.schedule( new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = "这真是一个很挫的widget " + simpleDateFormat.format(new Date()); // 使用SimpleDateFormat格式化当前时间

                // 使用RemoteViews为widget布局中的TextView设置时间字符串
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.time_widget);
                remoteViews.setTextViewText(R.id.id_widgettv, time);

                //使用AppWidgetManager刷新Widget
                AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());
                ComponentName componentName = new ComponentName(getApplicationContext(), TimeWidgetProvider.class); //这是包名
                manager.updateAppWidget(componentName, remoteViews);
            }
        }, 0, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer = null;
    }
}
