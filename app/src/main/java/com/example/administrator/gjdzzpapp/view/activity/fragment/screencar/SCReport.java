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


public class SCReport extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Spinner carId,carmd,carmode,carcolor;
    private ArrayAdapter<String> caridAdapter,carmdAdapter,carmodeAdapter,carcolorAdapter;
    private String[]carId_item,carmd_item,carmode_item,carcolor_item;
    private Button carRSetting,carRSelect,carRClear,carFinish;
    private EditText carID_edit,carmd_edit,carmode_edit,carcolor_edit;
    String carid,carmds,carmodes,carcs;
    @Override
    public View initView() {
        mActivity=(MainActivity)getActivity();
        View view=View.inflate(mActivity, R.layout.screport_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        carID_edit=(EditText)view.findViewById(R.id.carnum);
        carmd_edit=(EditText)view.findViewById(R.id.car_d);
        carmode_edit=(EditText)view.findViewById(R.id.carmode);
        carcolor_edit=(EditText)view.findViewById(R.id.carc);
        carId=(Spinner)view.findViewById(R.id.scar_num);
        carId_item=getResources().getStringArray(R.array.carnum);
        caridAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,carId_item);
        caridAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carId.setAdapter(caridAdapter);
        carmd=(Spinner)view.findViewById(R.id.car_direct);
        carmd_item=getResources().getStringArray(R.array.cardirect);
        carmdAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,carmd_item);
        carmdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carmd.setAdapter(carmdAdapter);
        carmode=(Spinner)view.findViewById(R.id.car_mode);
        carmode_item=getResources().getStringArray(R.array.carmodex);
        carmodeAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,carmode_item);
        carmodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carmode.setAdapter(carmodeAdapter);
        carcolor=(Spinner)view.findViewById(R.id.car_color);
        carcolor_item=getResources().getStringArray(R.array.color);
        carcolorAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,carcolor_item);
        carcolorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carcolor.setAdapter(carcolorAdapter);
        carRSetting=(Button)view.findViewById(R.id.carr_setting);
        carRSelect=(Button)view.findViewById(R.id.carr_select);
        carRClear=(Button)view.findViewById(R.id.carr_clear);
        carFinish=(Button)view.findViewById(R.id.scr_finish);
        carId.setOnItemSelectedListener(this);
        carmd.setOnItemSelectedListener(this);
        carmode.setOnItemSelectedListener(this);
        carcolor.setOnItemSelectedListener(this);
        carRSetting.setOnClickListener(this);
        carRSelect.setOnClickListener(this);
        carRClear.setOnClickListener(this);
        carFinish.setOnClickListener(this);
    }

    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scr_finish:
                finishscar();
                break;
            case R.id.carr_select:
                selectcar();
                break;
            case R.id.carr_setting:
                settingcar();
                break;
            case R.id.carr_clear:
                clearcar();
                break;
        }

    }

    private void clearcar() {
    }

    private void settingcar() {
    }

    private void selectcar() {
    }

    private void finishscar() {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(new ScFragment());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
