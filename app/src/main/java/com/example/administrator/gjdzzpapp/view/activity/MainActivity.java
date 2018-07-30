package com.example.administrator.gjdzzpapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.presenter.impl.MainAPresenterImpl;
import com.example.administrator.gjdzzpapp.presenter.inter.IMainAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;

public class MainActivity extends BaseMvpActivity implements IMainAView {
    private EditText et_phone, et_password;
    private Button btn_login;

    private IMainAPresenter mIMainAPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainAPresenter = new MainAPresenterImpl(this);
        setContentView(R.layout.activity_main);

        initViewBind();
    }

    private void initViewBind() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIMainAPresenter.login();
            }
        });
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }


    /*用来做请求完成之后的操作*/
    @Override
    public <T> void response(T response, int responseFlag) {
        Log.e("response", "response:" + response.toString() + "responseFlag:" + responseFlag);
        if (response != null && responseFlag == IMainAView.RESPONSE_ONE) {//如果返回对象不为空，并且response的返回值为1，表示成功
            Intent intent = new Intent(MainActivity.this, TwoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /*对外提供用户手机号和密码*/
    @Override
    public String getPhone() {
        return et_phone.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }
}
