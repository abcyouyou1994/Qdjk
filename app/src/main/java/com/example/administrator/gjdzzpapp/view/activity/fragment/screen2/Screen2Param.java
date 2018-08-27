package com.example.administrator.gjdzzpapp.view.activity.fragment.screen2;

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

public class Screen2Param extends BaseFragment {
   private Button s2pSetting,s2pSelect,s2pClear;
   private EditText s2pwidth,s2pheight,s2type,s2datap,s2OEp,s2ll;
   private Spinner s2st,s2OE,s2Data,s2lightl;
   private ArrayAdapter<String>s2stAdapter,s2OEAdapter,s2DataAdapter,s2LightlAdapter;
   private String[] s2st_item,polarity_item,S2lightl_item;
   private String Datap,OEp,scantype,ll;

   private BluetoothService bls;
    @Override
    protected View getSuccessView() {
       View view=View.inflate(getActivity(),R.layout.screen2_fragment,null);
       initView(view);
        return view;
    }

    private void initView(View view) {
        s2pSetting=(Button)view.findViewById(R.id.s2p_setting);
        s2pSelect=(Button)view.findViewById(R.id.s2p_select);
        s2pClear=(Button)view.findViewById(R.id.s2p_clear);
        s2pwidth=(EditText)view.findViewById(R.id.screen2_width);
        s2pheight=(EditText)view.findViewById(R.id.screen2_height);
        s2type=(EditText)view.findViewById(R.id.scans2_type);
        s2datap=(EditText)view.findViewById(R.id.s2datapp) ;
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
        s2st.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.scantype);
                scantype=EncodingTool.getsctype(item[i]);
            }
        });
        s2OE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.polarity);
                OEp=EncodingTool.getpolarity(item[i]);
            }
        });
        s2Data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.polarity);
                Datap=EncodingTool.getpolarity(item[i]);
            }
        });
        s2lightl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.lightlevel);
                ll=EncodingTool.getlightlevel(item[i]);
            }
        });
        s2pSetting.setOnClickListener(this);
        s2pSelect.setOnClickListener(this);
        s2pClear.setOnClickListener(this);
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
            case R.id.s2p_setting:
               s2pSettinginfo();
                break;
            case R.id.s2p_select:
                s2pSelectinfo();
                break;
            case R.id.s2p_clear:
               clear();
                break;
        }
    }

    private void clear() {

    }

    private void s2pSelectinfo() {
        String senddata=DecodingTool.getpackage(null,0,CMD.rsp);
        send(senddata);
    }

    private void s2pSettinginfo() {
       String s=DecodingTool.numToHex8(Integer.valueOf(s2pwidth.getText().toString()))+DecodingTool.numToHex8(Integer.valueOf(s2pheight.getText().toString()))+Datap+OEp+scantype+"ff"+ll;
        String senddata=DecodingTool.getpackage(s,s.length(),CMD.ssp);
        send(senddata);
    }
}
