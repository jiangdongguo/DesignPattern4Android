package com.jiangdg.proxy.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jianddongguo on 2018/3/22.
 */

public class ClientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NotifyProxy notifyProxy = new NotifyProxy(this);
        notifyProxy.send();
    }
}
