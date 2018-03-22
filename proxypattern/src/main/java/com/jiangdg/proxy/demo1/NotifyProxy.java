package com.jiangdg.proxy.demo1;

import android.content.Context;
import android.os.Build;

/**
 * Created by jianddongguo on 2018/3/22.
 */

public class NotifyProxy extends Notify {
    private Notify mNotify;

    public NotifyProxy(Context ctx) {
        super(ctx);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mNotify = new NotifyBig(ctx);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mNotify = new NotifyBig(ctx);
        } else {
            mNotify = new NotifyNormal(ctx);
        }
    }

    @Override
    void send() {
        // 调用实际的send方法
        mNotify.send();
    }

    @Override
    void cancel() {
        // 调用实际的cancel方法
        mNotify.cancel();
    }
}
