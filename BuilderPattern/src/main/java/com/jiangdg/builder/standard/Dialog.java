package com.jiangdg.builder.standard;

import android.content.Context;
import android.view.View;

/**Product层，产品类
 * Created by jianddongguo on 2018/3/4.
 */

public abstract class Dialog {
    protected int mIcon;
    protected String mTitle;
    protected View mContentView;
    protected String mCancelText;
    protected String mConfirmText;
    protected Context mCtx;
    protected OnDialogClickListener mClickListener;

    public interface OnDialogClickListener {
        void onCancle();
        void onConfirm(String content);
    }

    public void setIcon(int icon) {
        this.mIcon = icon;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }


    public void setContentView(View view) {
        this.mCtx = view.getContext();
        this.mContentView = view;
    }

    public void setClickButton(String confirmText,String cancelText,OnDialogClickListener listener) {
        this.mCancelText = cancelText;
        this.mConfirmText = confirmText;
        this.mClickListener = listener;
    }

    public abstract void show();

    public abstract void dismiss();
}
