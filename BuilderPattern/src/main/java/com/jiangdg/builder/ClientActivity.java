package com.jiangdg.builder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jiangdg.builder.simplify.AlertDialog2;
import com.jiangdg.builder.standard.AlertDialogBuilder;
import com.jiangdg.builder.standard.Dialog;
import com.jiangdg.builder.standard.Director;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStandardClick(View view) {
        AlertDialogBuilder alertBuidler = new AlertDialogBuilder(this);
        Director alertDirect = new Director(alertBuidler);
        alertDirect.construct(R.mipmap.ic_launcher, "AlertDialog标准版", new String[]{"这是标准版测试"},
                "确认", "取消", new Dialog.OnDialogClickListener() {
            @Override
            public void onCancle() {
                showToast("取消操作");
            }

            @Override
            public void onConfirm(String content) {
                showToast("确认，打印内容："+content);
            }
        });
        alertBuidler.create().show();
    }

    public void onSimplifyWay(View view) {
        AlertDialog2.Builder mBuilder = new AlertDialog2.Builder(ClientActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("AlertDialog简化版")
                .setMessage(new String[]{"这是简化版测试"})
                .setOnDialogClickListener("确认", "取消", new Dialog.OnDialogClickListener() {
                    @Override
                    public void onCancle() {
                        showToast("取消操作");
                    }

                    @Override
                    public void onConfirm(String content) {
                        showToast("确认，打印内容："+content);
                    }
                });
        mBuilder.create().show();
    }

    private void showToast(String msg) {
        Toast.makeText(ClientActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
