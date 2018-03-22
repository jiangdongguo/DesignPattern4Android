package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

import com.jiangdg.proxy.R;

/**
 * Created by jianddongguo on 2018/3/22.
 */

public class NotifyHeadsUp extends Notify {
    public NotifyHeadsUp(Context ctx) {
        super(ctx);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    void send() {
        // 创建通知
        Notification notification = mBuilder.build();
        notification.contentView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_normal);
        notification.bigContentView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_big);
        notification.headsUpContentView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_headsup);
        // 发送通知
        mNotifyManager.notify(0,notification);
    }

    @Override
    void cancel() {
        mNotifyManager.cancel(0);
    }
}
