package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.view.View;
import android.widget.Button;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.FragmentFactory;

public class ScreenCarFragment extends BaseFragment {
    private Button carReport,carParam,carRoad;
    @Override
    protected View getSuccessView() {
        View view=View.inflate(getActivity(),R.layout.screencar_fragment,null);
        initView(view);
        setListener();
        return view;
    }

    private void setListener() {
        carParam.setOnClickListener(this);
        carReport.setOnClickListener(this);
        carRoad.setOnClickListener(this);
    }

    private void initView(View v) {
        carParam=v.findViewById(R.id.car_param);
        carReport=v.findViewById(R.id.car_report);
        carRoad=v.findViewById(R.id.car_road);
    }

    @Override
    public void send(String s) {

    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.car_param:
                FragmentFactory.crescByid(R.id.car_param);
                break;
            case R.id.car_report:
                FragmentFactory.crescByid(R.id.car_report);
                break;
            case R.id.car_road:
                FragmentFactory.crescByid(R.id.car_road);
                break;
                }
    }
}
