package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.jiangdg.proxy.MainActivity;
import com.jiangdg.proxy.R;

/**代理模式统一接口(抽象类)
 * Created by jianddongguo on 2018/3/22.
 */

public abstract class Notify {
    protected Context mContext;
    protected NotificationManager mNotifyManager;
    protected Notification.Builder mBuilder;

    public Notify(Context ctx) {
        this.mContext = ctx;
        // 获取管理notification的系统服务
        mNotifyManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        // 获取建造notification的Builder对象
        mBuilder = new Notification.Builder(ctx);
        // 设置图标
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        // 设置点击intent
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext,0
                ,new Intent(mContext, MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
    }

    abstract void send();

    abstract void cancel();
}
