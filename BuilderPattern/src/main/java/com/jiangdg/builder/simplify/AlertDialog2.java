package com.jiangdg.builder.simplify;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiangdg.builder.R;
import com.jiangdg.builder.standard.Dialog;

/**
 * 简化建造者模式
 * Created by jianddongguo on 2018/3/4.
 */

public class AlertDialog2 {
    protected int mIcon;
    protected String mTitle;
    protected String mCancelText;
    protected String mConfirmText;
    protected Context mCtx;
    protected Dialog.OnDialogClickListener mClickListener;
    private View mContentView;
    private WindowManager mWindowManager;
    private View mRootView;

    public AlertDialog2(Context ctx) {
        this.mCtx = ctx.getApplicationContext();
    }

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
        this.mContentView = view;
    }

    public void setClickButton(String confirmText, String cancelText, Dialog.OnDialogClickListener listener) {
        this.mCancelText = cancelText;
        this.mConfirmText = confirmText;
        this.mClickListener = listener;
    }

    public void show() {
        // 使用WindowManager添加View到Window
        mWindowManager = (WindowManager) mCtx.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT
                , WindowManager.LayoutParams.WRAP_CONTENT);
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.width = 800;
        params.height = 600;
        params.gravity = Gravity.CENTER;

        mRootView = LayoutInflater.from(mCtx).inflate(R.layout.layout_dialog, null);
        ImageView ivIcon = (ImageView) mRootView.findViewById(R.id.iv_dialog_icon);
        ivIcon.setImageResource(mIcon);
        TextView tvTitle = (TextView) mRootView.findViewById(R.id.tv_dialog_title);
        tvTitle.setText(mTitle);
        LinearLayout contentLayout = (LinearLayout) mRootView.findViewById(R.id.llayout_content);
        contentLayout.addView(mContentView);
        Button btnCancel = (Button) mRootView.findViewById(R.id.btn_cancel);
        btnCancel.setText(mCancelText);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onCancle();
                }
                dismiss();
            }
        });
        Button btnConfirm = (Button) mRootView.findViewById(R.id.btn_confirm);
        btnConfirm.setText(mConfirmText);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContentView instanceof TextView) {
                    if (mClickListener != null) {
                        mClickListener.onConfirm((String) ((TextView) mContentView).getText());
                    }
                }
                dismiss();
            }
        });

        mWindowManager.addView(mRootView, params);
    }

    public void dismiss() {
        if (mWindowManager != null) {
            mWindowManager.removeView(mRootView);
        }
    }

    /**
     * 建造者，AlertDialog内部类
     * 此处采用链式调用
     */
    public static class Builder {
        private Context mCtx;
        private AlertDialog2 mDialog;

        public Builder(Context ctx) {
            this.mCtx = ctx;
            mDialog = new AlertDialog2(mCtx);
        }

        public Builder setIcon(int id) {
            mDialog.setIcon(id);
            return this;
        }

        public Builder setTitle(String title) {
            mDialog.setTitle(title);
            return this;
        }

        public Builder setMessage(String[] content) {
            if (content != null || content.length > 0) {
                TextView tv = new TextView(mCtx);
                tv.setText(content[0]);
                tv.setTextSize(16);
                mDialog.setContentView(tv);
            }
            return this;
        }

        public Builder setOnDialogClickListener(String confirmText, String cancelText, Dialog.OnDialogClickListener listener) {
            mDialog.setClickButton(confirmText, cancelText, listener);
            return this;
        }

        public AlertDialog2 create() {
            return mDialog;
        }
    }
}
