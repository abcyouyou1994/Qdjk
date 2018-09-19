package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.MainActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.ScFragment;


public class ScRoad extends BaseFragment implements View.OnClickListener {
    private Button setting_btn,select_btn,clear_btn,start_btn,estation_btn,lstation_btn,ends_btn,scroadFinish;
    private EditText addressId,roadId,stationsum;

    @Override
    public View initView()
    {
        View view=View.inflate(mActivity, R.layout.scroad_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        addressId=(EditText)view.findViewById(R.id.adressId);
        roadId=(EditText)view.findViewById(R.id.roadidc);
        stationsum=(EditText)view.findViewById(R.id.stationnum);
        setting_btn=(Button)view.findViewById(R.id.croasetting);
        select_btn=(Button)view.findViewById(R.id.croadselect);
        clear_btn=(Button)view.findViewById(R.id.croadclear);
        start_btn=(Button)view.findViewById(R.id.carstart);
        estation_btn=(Button)view.findViewById(R.id.carostation);
        lstation_btn=(Button)view.findViewById(R.id.carlstation);
        ends_btn=(Button)view.findViewById(R.id.carestation);
        scroadFinish=(Button)view.findViewById(R.id.scroad_finish);
        setting_btn.setOnClickListener(this);
        select_btn.setOnClickListener(this);
        clear_btn.setOnClickListener(this);
        start_btn.setOnClickListener(this);
        estation_btn.setOnClickListener(this);
        lstation_btn.setOnClickListener(this);
        ends_btn.setOnClickListener(this);
        scroadFinish.setOnClickListener(this);
    }

    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.croasetting:
                carroadSetting();
                break;
            case R.id.croadselect:
                carroadSelect();
                break;
            case R.id.carr_clear:
                carroadClear();
                break;
            case R.id.scroad_finish:
                carroadFinish();
                break;

        }
    }

    private void carroadFinish() {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(new ScFragment());
    }

    private void carroadClear() {
    }

    private void carroadSelect() {

    }

    private void carroadSetting() {

    }
}
