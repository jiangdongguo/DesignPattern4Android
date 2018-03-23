package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.RemoteViews;

import com.jiangdg.proxy.MainActivity;
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
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0,
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/andrexpert")), PendingIntent.FLAG_CANCEL_CURRENT);
        mBuilder.setContentTitle("普通通知");
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher));
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setAutoCancel(true);
        // 创建Notification
        Notification notification = mBuilder.build();
        // 发送通知
        mNotifyManager.notify(0,notification);
    }

    @Override
    void cancel() {
        mNotifyManager.cancel(0);
    }
}
