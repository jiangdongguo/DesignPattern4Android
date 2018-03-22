package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.jiangdg.proxy.MainActivity;
import com.jiangdg.proxy.R;

/**
 * Created by jianddongguo on 2018/3/22.
 */

public class NotifyBig extends Notify {
    public NotifyBig(Context ctx) {
        super(ctx);
    }

    @Override
    void send() {
        // 创建通知
        Notification notification = mBuilder.build();
        notification.contentView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_normal);
        notification.bigContentView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_big);
        // 发送通知
        mNotifyManager.notify(0,notification);
    }

    @Override
    void cancel() {
        mNotifyManager.cancel(0);
    }
}
