package com.example.administrator.gjdzzpapp.presenter.impl;

import android.content.SharedPreferences;

import com.example.administrator.gjdzzpapp.model.impl.MainAModelImpl;
import com.example.administrator.gjdzzpapp.model.inter.IMainAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.presenter.inter.IMainAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;

import java.io.File;

/**
 * 具体的业务实现类
 */
public class MainAPresenterImpl implements IMainAPresenter {
    private IMainAView mIMainAView;
    private IMainAModel mIMainAModel;
    private SharedPreferences pref;
    public static SharedPreferences.Editor editor;


    public MainAPresenterImpl(IMainAView aIMainAView) {
        mIMainAView = aIMainAView;
        mIMainAModel = new MainAModelImpl();
    }

    @Override
    public void login() {
        if (mIMainAView.getusername().equals("") || mIMainAView.getPassword().equals("")) {
            mIMainAView.showToast("请输入用户名或密码");
        } else {

            mIMainAView.showLoding("正在登录中...");//loginView的ui逻辑处理
            mIMainAModel.login(mIMainAView.getusername(), mIMainAView.getPassword(), new CallBack() {
                @Override
                public void onSuccess(Object response) {//成功的情况

                    mIMainAView.hideLoding();
                    mIMainAView.response(mIMainAModel, IMainAView.RESPONSE_ONE);//返回对象，参数结果
                    mIMainAView.showToast("登录成功");

                }

                @Override
                public void onError(String t) {//失败的情况
                    mIMainAView.hideLoding();
                    mIMainAView.response("我是空的", IMainAView.RESPONSE_TWO);//返回对象，参数结果
                    mIMainAView.showToast(t);
                }

                @Override
                public void onDataChange(String data) {

                }
            });
        }
    }

    @Override
    public void rememberp() {
       if(mIMainAView.getCheck()) {
           editor.putBoolean("remember",true);
           editor.putString("username",mIMainAView.getusername());
           editor.putString("password",mIMainAView.getPassword());
           editor.commit();
       }

    }

    @Override
    public void forgetp() {

    }
}
