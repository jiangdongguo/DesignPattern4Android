package com.jiangdg.builder.standard;

/**Builder，建造一个Dialog对象的各个部分(部件)的抽象接口
 * Created by jianddongguo on 2018/3/4.
 */

public abstract class Builder {
    // 图标
    public abstract void setIcon(int id);
    // 标题
    public abstract void setTitle(String title);
    // 内容
    public abstract void setMessage(String[] content);
    // 操作
    public abstract void setOnDialogClickListener(String confirmText,String cancelText,Dialog.OnDialogClickListener listener);
    // 创建Dialog
    public abstract Dialog create();
}
