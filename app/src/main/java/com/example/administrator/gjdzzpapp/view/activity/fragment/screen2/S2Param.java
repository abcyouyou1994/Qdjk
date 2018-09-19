package com.example.administrator.gjdzzpapp.view.activity.fragment.screen2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;


public class S2Param extends BaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private Button s2pSetting,s2pSelect,s2pClear,s2pfinish;
    private EditText s2pwidth,s2pheight,s2type,s2datap,s2OEp,s2ll;
    private Spinner s2st,s2OE,s2Data,s2lightl;
    private ArrayAdapter<String>s2stAdapter,s2OEAdapter,s2DataAdapter,s2LightlAdapter;
    private String[] s2st_item,polarity_item,S2lightl_item;
    private String Datap,OEp,scantype,ll;




    @Override
    public View initView() {
        mActivity=(bleDebug)getActivity();
        View view=View.inflate(mActivity,R.layout.s2param_fragment,null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        s2OE.setOnItemSelectedListener(this);
        s2Data.setOnItemSelectedListener(this);
        s2lightl.setOnItemSelectedListener(this);
        s2pSetting.setOnClickListener(this);
        s2pSelect.setOnClickListener(this);
        s2pClear.setOnClickListener(this);
        s2pfinish.setOnClickListener(this);
    }

    @Override
    public View initData() {
        return null;
    }

    public View initView(View view) {

        s2pSetting=(Button)view.findViewById(R.id.s2p_setting);
        s2pSelect=(Button)view.findViewById(R.id.s2p_select);
        s2pClear=(Button)view.findViewById(R.id.s2p_clear);
        s2pfinish=(Button)view.findViewById(R.id.s2p_finish);
        s2pwidth=(EditText)view.findViewById(R.id.screen2_width);
        s2pheight=(EditText)view.findViewById(R.id.screen2_height);
        s2type=(EditText)view.findViewById(R.id.scans2_type);
        s2datap=(EditText)view.findViewById(R.id.s2data_p) ;
        s2OEp=(EditText)view.findViewById(R.id.s2OE);
        s2ll=(EditText)view.findViewById(R.id.s2ll);
        s2st=(Spinner)view.findViewById(R.id.scan_type) ;
        s2st_item=getResources().getStringArray(R.array.scantype);
        s2stAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,s2st_item);
        s2stAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2st.setAdapter(s2stAdapter);
        s2OE=(Spinner)view.findViewById(R.id.s2OE_polority);
        polarity_item=getResources().getStringArray(R.array.polarity);
        s2OEAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,polarity_item);
        s2OEAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2OE.setAdapter(s2stAdapter);
        s2Data=(Spinner)view.findViewById(R.id.s2data_polority);
        s2DataAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,polarity_item);
        s2Data.setAdapter(s2stAdapter);
        s2lightl=(Spinner)view.findViewById(R.id.s2lightl) ;
        S2lightl_item=getResources().getStringArray(R.array.lightlevel);
        s2LightlAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,S2lightl_item);
        s2LightlAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2lightl.setAdapter(s2LightlAdapter);

        return view;
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.s2p_setting:
                s2pSetting();
                break;
            case R.id.s2p_select:
                s2pSelect();
                break;
            case R.id.s2p_clear:
                s2pClear();
                break;
            case R.id.s2p_finish:
                s2pFinish();
                break;
        }
    }

    private void s2pFinish() {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(new S2Param());
    }

    private void s2pClear() {
    }

    private void s2pSelect() {
    }

    private void s2pSetting() {

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
