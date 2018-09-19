package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.MainActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.SCParam;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.SCReport;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.ScRoad;


public class ScFragment extends BaseFragment implements View.OnClickListener {
    Button scBtnp,scBtnr,scBtnroad;
    @Override
    public View initView() {

        View view=View.inflate(mActivity,R.layout.sc_fragment,null);
        scBtnp=(Button)view.findViewById(R.id.sc_btn_param);
        scBtnr=(Button)view.findViewById(R.id.sc_btn_report);
        scBtnroad=(Button)view.findViewById(R.id.sc_btn_road);
        scBtnp.setOnClickListener(this);
        scBtnr.setOnClickListener(this);
        scBtnroad.setOnClickListener(this);
        return view;
    }
    public void switchContent(Fragment fragment) {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(fragment);
    }
    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sc_btn_param:
                mActivity.setTitle("小车屏参数设置");
                switchContent(new SCParam());
                break;
            case R.id.sc_btn_report:
                mActivity.setTitle("小车屏报站");
                switchContent(new SCReport());
                break;
            case R.id.sc_btn_road:
                mActivity.setTitle("小车屏线路设置");
                switchContent(new ScRoad());
                break;
        }
    }
}
