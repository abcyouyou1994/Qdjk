package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.MainActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.ScFragment;


public class SCParam extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button carpSetting,carpSelect,carpClear,carpfinish;
    private Spinner OEpority,Datapority,scanType,lightl;
    private EditText swidth,sheight;
    String []pority_item,st_item,ll_item;
    String scantype,OEp,Datap,ll;
    ArrayAdapter<String> OEadapter,Dataadapter,stadapter,llAdapter;
    @Override
    public View initView() {
        mActivity=(MainActivity)getActivity();
        View view=View.inflate(mActivity, R.layout.scparam_fragment,null);
        initView(view);
        return view;
    }
    private void initView(View view) {
        carpSetting=(Button)view.findViewById(R.id.scarp_setting);
        carpSelect=(Button)view.findViewById(R.id.scarp_select);
        carpClear=(Button)view.findViewById(R.id.scarp_clear);
        carpfinish=(Button)view.findViewById(R.id.scp_finish);
        OEpority=(Spinner)view.findViewById(R.id.scarOE_polority);
        pority_item=getResources().getStringArray(R.array.polarity);
        OEadapter=new ArrayAdapter <String>(view.getContext(),android.R.layout.simple_spinner_item,pority_item);
        OEadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OEpority.setAdapter(OEadapter);
        Datapority=(Spinner)view.findViewById(R.id.scardata_polority);
        Dataadapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,pority_item);
        Dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Datapority.setAdapter(Dataadapter);
        scanType=(Spinner)view.findViewById(R.id.scan_type_sc);
        st_item=getResources().getStringArray(R.array.scantype);
        stadapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,st_item);
        scanType.setAdapter(stadapter);
        lightl=(Spinner)view.findViewById(R.id.scarlightl);
        ll_item=getResources().getStringArray(R.array.lightlevel);
        llAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,ll_item);
        llAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lightl.setAdapter(llAdapter);
        swidth=(EditText)view.findViewById(R.id.screencar_width);
        sheight=(EditText)view.findViewById(R.id.screencar_height);
        carpSetting.setOnClickListener(this);
        carpSelect.setOnClickListener(this);
        carpClear.setOnClickListener(this);
        OEpority.setOnItemSelectedListener(this);
        carpfinish.setOnClickListener(this);
        Datapority.setOnItemSelectedListener(this);
        scanType.setOnItemSelectedListener(this);
        lightl.setOnItemSelectedListener(this);
    }
    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scarp_setting:
                settingscarp();
                break;
            case R.id.scarp_select:
                selectscarp();
                break;
            case R.id.scarp_clear:
                clearscarp();
                break;
            case R.id.scp_finish:
                finishscp();
        }
    }

    private void clearscarp() {
    }

    private void selectscarp() {

    }

    private void finishscp() {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(new ScFragment());
    }

    private void settingscarp() {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
