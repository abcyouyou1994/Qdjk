package com.example.administrator.gjdzzpapp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * User: Losileeya (847457332@qq.com)
 * Date: 2016-09-11
 * Time: 14:32
 * 类描述：
 *
 * @version :
 */
public class BaseMvpActivity<V extends BaseMvpView> extends AppCompatActivity implements BaseMvpView {
    private ProgressDialog progressDialog;//登录进度条

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);//实例化progressDialog
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showLoding(String msg) {
        progressDialog.setMessage(msg);//设置进度条加载内容
        if (!progressDialog.isShowing())//如果进度条没有显示
            progressDialog.show();//显示进度条
    }

    @Override
    public void hideLoding() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
