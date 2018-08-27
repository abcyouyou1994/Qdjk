package com.example.administrator.gjdzzpapp.view.activity.fragment.screen2;

import android.view.View;
import android.widget.Button;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.utils.startUtils;

public class Screen2Fragment extends BaseFragment {
  //按钮设置
    private Button screen2Param,screen2Report;
    @Override
    protected View getSuccessView() {
        View view=View.inflate(getActivity(), R.layout.screen2_activity_home,null);
        initview(view);
        setListener();
        return view;

    }

    private void setListener() {
        screen2Report.setOnClickListener(this);
        screen2Param.setOnClickListener(this);
    }


    private void initview(View view) {
        screen2Param=(Button)view.findViewById(R.id.s2param_btn);
        screen2Report=(Button)view.findViewById(R.id.s2report_btn);
    }

    @Override
    public void send(String s) {

    }

    public void OnDestoryView(){
        super.onDestroyView();
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        startUtils.startActivityById(getActivity(),view.getId());
    }
}
