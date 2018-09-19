package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.gjdzzpapp.R;


public class SdmFragment extends BaseFragment implements View.OnClickListener {
    private Button Sdmsetting_btn,Sdmselect_btn,Sdmclear_btn;
    private EditText sdmpid,sdmrid;
    @Override
    public View initView() {
        View view=View.inflate(getActivity(), R.layout.sdm_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        sdmpid=(EditText)view.findViewById(R.id.dm_id);
        sdmrid=(EditText)view.findViewById(R.id.dm_roadid);
        Sdmclear_btn=(Button)view.findViewById(R.id.dm_clear);
        Sdmsetting_btn=(Button)view.findViewById(R.id.dm_setting);
        Sdmselect_btn=(Button)view.findViewById(R.id.dm_select);
        Sdmselect_btn.setOnClickListener(this);
        Sdmsetting_btn.setOnClickListener(this);
        Sdmclear_btn.setOnClickListener(this);
    }

    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View view) {

    }
}
