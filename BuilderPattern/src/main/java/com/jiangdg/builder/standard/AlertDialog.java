package com.jiangdg.builder.standard;

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

/**
 * Dialog，产品具体实现类
 * Created by jianddongguo on 2018/3/4.
 */

public class AlertDialog extends Dialog {
    private WindowManager mWindowManager;
    private View mRootView;

    @Override
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
                    if(mClickListener != null) {
                        mClickListener.onConfirm((String) ((TextView) mContentView).getText());
                    }
                }
                dismiss();
            }
        });

        mWindowManager.addView(mRootView, params);
    }

    @Override
    public void dismiss() {
        if(mWindowManager != null) {
            mWindowManager.removeView(mRootView);
        }
    }
}
