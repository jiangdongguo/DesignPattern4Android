package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;

import com.jiangdg.proxy.R;

/** 普通通知
 * Created by jianddongguo on 2018/3/22.
 */

public class NotifyNormal extends Notify {

    public NotifyNormal(Context ctx) {
        super(ctx);
    }

    @Override
    void send() {
        // 创建通知
        Notification notification = mBuilder.build();
        // 自定义普通通知视图
        RemoteViews rootView = new RemoteViews(mContext.getPackageName(), R.layout.layout_notify_normal);
        notification.contentView = rootView;
        // 发送通知
        mNotifyManager.notify(0,notification);
    }

    @Override
    void cancel() {
        mNotifyManager.cancel(0);
    }
}
