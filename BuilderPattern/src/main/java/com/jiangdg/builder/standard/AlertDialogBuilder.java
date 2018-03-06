package com.jiangdg.builder.standard;

import android.content.Context;
import android.widget.TextView;

/**
 * Builder具体实现类，用于建造AlertDialog各部件
 * Created by jianddongguo on 2018/3/4.
 */

public class AlertDialogBuilder extends Builder {
    private Dialog mDialog = new AlertDialog();
    private Context mContext;

    public AlertDialogBuilder(Context ctx) {
        mContext = ctx.getApplicationContext();
    }

    @Override
    public void setIcon(int id) {
        mDialog.setIcon(id);
    }

    @Override
    public void setTitle(String title) {
        mDialog.setTitle(title);
    }

    @Override
    public void setMessage(String[] content) {
        if (content != null || content.length > 0) {
            TextView tv = new TextView(mContext);
            tv.setText(content[0]);
            tv.setTextSize(16);
            mDialog.setContentView(tv);
        }
    }

    @Override
    public void setOnDialogClickListener(String confirmText, String cancelText, Dialog.OnDialogClickListener listener) {
        mDialog.setClickButton(confirmText, cancelText,listener);
    }


    @Override
    public Dialog create() {
        return mDialog;
    }
}
