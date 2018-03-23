package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;


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
    }

    abstract void send();

    abstract void cancel();
}
