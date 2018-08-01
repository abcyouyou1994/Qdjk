package com.example.administrator.gjdzzpapp.presenter.impl;

import com.example.administrator.gjdzzpapp.model.impl.TwoAModelImpl;
import com.example.administrator.gjdzzpapp.model.inter.ITwoAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.presenter.inter.ITwoAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;
import com.example.administrator.gjdzzpapp.view.inter.ITwoAView;

public class TwoAPresenterImpl implements ITwoAPresenter {
    private ITwoAView mITwoAView;
    private ITwoAModel mITwoAModel;

    public TwoAPresenterImpl(ITwoAView aITwoAView) {
        mITwoAView = aITwoAView;
        mITwoAModel = new TwoAModelImpl();
    }

    @Override
    public void getData() {
        mITwoAModel.getData(mITwoAView.getToken(), new CallBack() {
            @Override
            public void onSuccess(Object response) {
                mITwoAView.response(response, IMainAView.RESPONSE_ONE);
                mITwoAView.showToast("数据请求成功");
            }

            @Override
            public void onError(String t) {
                mITwoAView.response(mITwoAModel, IMainAView.RESPONSE_TWO);
                mITwoAView.showToast(t);
            }
        });
    }

    @Override
    public void getBle() {

    }
}
