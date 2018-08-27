package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.prorocol.CMD;
import com.example.administrator.gjdzzpapp.prorocol.DecodingTool;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;

public class CarRoad extends BaseFragment {
    private Button setting_btn,select_btn,clear_btn,start_btn,estation_btn,lstation_btn,ends_btn;
    private EditText addressId,roadId,stationsum;
    private BluetoothService bls;
    @Override
    protected View getSuccessView() {
        View view=View.inflate(getActivity(), R.layout.screencar_fg,null);
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
        setting_btn.setOnClickListener(this);
        select_btn.setOnClickListener(this);
        clear_btn.setOnClickListener(this);
        start_btn.setOnClickListener(this);
        estation_btn.setOnClickListener(this);
        lstation_btn.setOnClickListener(this);
        ends_btn.setOnClickListener(this);
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
        case R.id.croasetting:
            setting();
            break;
        case R.id.croadselect:
            select();
            break;
        case R.id.croadclear:
            clear();
            break;
        case R.id.carstart:
            start();
            break;
        case R.id.carostation:
            station(1);
            break;
        case R.id.carlstation:
            station(2);
            break;
        case R.id.carestation:
            station(3);
    }
    }

    private void station(int i) {
        String carpoint=null;
        switch (i){
            case 1:
              carpoint=DecodingTool.numToHex8(CMD.ostation);
              break;
            case 2:
                carpoint=DecodingTool.numToHex8(CMD.lostation);
                break;
            case 3:
                carpoint=DecodingTool.numToHex8(CMD.estation);
                break;
        }
        String s=DecodingTool.numToHex8(CMD.carzt2)+carpoint;
        String sendData=DecodingTool.getpackage(s,s.length(),CMD.xcxlxxzbsz);
    }

    private void start() {
        String s=DecodingTool.numToHex8(CMD.carzt1)+DecodingTool.numToHex8(CMD.usualpoint);
        String senddata=DecodingTool.getpackage(s,s.length()/2,CMD.xcxlxxzbsz);
        send(senddata);
    }

    private void clear() {

    }

    private void select() {
        String sendData=DecodingTool.getpackage(null,0,CMD.xlxxdq);
        send(sendData);
    }

    private void setting() {
        String roadid=DecodingTool.word2hexstr(roadId.getText().toString());
        String s=DecodingTool.numToHex8(Integer.valueOf(addressId.getText().toString()))+roadid.length()+roadid+
                DecodingTool.numToHex8(Integer.valueOf(stationsum.getText().toString()));
        String senddata=DecodingTool.getpackage(s,s.length()/2, CMD.xlxxsz);
        send(senddata);
    }
}
