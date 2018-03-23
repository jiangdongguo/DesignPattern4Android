package com.jiangdg.proxy.demo1;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0,
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/andrexpert")), PendingIntent.FLAG_CANCEL_CURRENT);
        mBuilder.setContentTitle("普通通知");
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher));
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setAutoCancel(true);

        mBuilder.setVisibility(Notification.VISIBILITY_PUBLIC);
        Notification notification = mBuilder.build();
        mBuilder.setFullScreenIntent()
        // 发送通知
        mNotifyManager.notify(0,notification);
    }

    @Override
    void cancel() {
        mNotifyManager.cancel(0);
    }
}
