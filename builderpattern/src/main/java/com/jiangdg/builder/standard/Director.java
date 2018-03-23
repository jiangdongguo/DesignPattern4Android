package com.jiangdg.builder.standard;

/**Director层，
 * Created by jianddongguo on 2018/3/4.
 */

public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public void construct(int iconId, String title, String[] content, String confirmText, String cancelText, Dialog.OnDialogClickListener listener) {
        mBuilder.setIcon(iconId);
        mBuilder.setTitle(title);
        mBuilder.setMessage(content);
        mBuilder.setOnDialogClickListener(confirmText,cancelText,listener);
    }
}
