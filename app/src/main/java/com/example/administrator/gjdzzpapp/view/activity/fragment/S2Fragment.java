package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.MainActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.S2Param;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.S2Report;


public class S2Fragment extends BaseFragment implements View.OnClickListener {
    private Button s2_param,s2_report;
    private S2Param s2Param;
    private S2Report s2Report;
    private Fragment mcont;

    @Override
    public View initView() {
      View view=View.inflate(mActivity,R.layout.s2_fragment,null);
      s2_param=(Button)view.findViewById(R.id.s2_btn_params);
      s2_report=(Button)view.findViewById(R.id.s2_btn_report);
      mcont=new S2Fragment();
      s2Param=new S2Param();
      s2Report=new S2Report();
      s2_param.setOnClickListener(this);
      s2_report.setOnClickListener(this);
        return view;
    }

    @Override
    public View initData() {

        return null;
    }
    public void switchContent(Fragment fragment) {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(fragment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.s2_btn_params:
                mActivity.setTitle("两字屏参数设置");
                s2Param=new S2Param();
                switchContent(s2Param);
                break;
            case R.id.s2_btn_report:
                mActivity.setTitle("两字屏报站设置");
                switchContent(s2Report);
                break;
        }
    }
}
