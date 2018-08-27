package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.prorocol.CMD;
import com.example.administrator.gjdzzpapp.prorocol.DecodingTool;
import com.example.administrator.gjdzzpapp.prorocol.EncodingTool;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;

public class CarReport extends BaseFragment {
    private Spinner carId,carmd,carmode,carcolor;
    private ArrayAdapter<String>caridAdapter,carmdAdapter,carmodeAdapter,carcolorAdapter;
    private String[]carId_item,carmd_item,carmode_item,carcolor_item;
    private Button carRSetting,carRSelect,carRClear;
    private EditText carID_edit,carmd_edit,carmode_edit,carcolor_edit;
    String carid,carmds,carmodes,carcs;
    private BluetoothService bls;
    @Override
    protected View getSuccessView() {
        View view=View.inflate(getActivity(), R.layout.screencar_report_fragment,null);
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
        carId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String []item=getResources().getStringArray(R.array.carnum);
                carid=EncodingTool.getcarid(item[i]);
            }
        });
        carmd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.cardirect);
                carmds=EncodingTool.getmodx(item[i]);
            }
        });
        carmode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.carmodex);
                carmodes=EncodingTool.getcarmx(item[i]);
            }
        });
        carcolor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[]item=getResources().getStringArray(R.array.color);
                carcs=EncodingTool.getscreenColor(item[i]);
            }
        });
        carRSetting.setOnClickListener(this);
        carRSelect.setOnClickListener(this);
        carRClear.setOnClickListener(this);
    }

    @Override
    public void send(String s) {
        bls.SendData(s);
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.carr_setting:
                setting();
                break;
            case R.id.carr_select:
                select();
                break;
            case R.id.carr_clear:
                clear();
                break;
        }
    }

    private void clear() {

    }

    private void select() {
        String senddata=DecodingTool.getpackage(null,0,CMD.rcs);
        send(senddata);
    }

    private void setting() {
        String s=carid+carmds+carmode+carcolor;
        String Sendata=DecodingTool.getpackage(s,s.length(),CMD.cs);
        send(Sendata);
    }
}
