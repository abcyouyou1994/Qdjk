package com.example.administrator.gjdzzpapp.view.activity.fragment.screencar;

import android.bluetooth.BluetoothDevice;
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
import com.example.administrator.gjdzzpapp.prorocol.constantValue;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BasePagerFragment;

public class CarParam extends BasePagerFragment {
    private BluetoothService bls;
    private Button carpSetting,carpSelect,carpClear;
    private Spinner OEpority,Datapority,scanType,lightl;
    private EditText swidth,sheight;
    String []pority_item,st_item,ll_item;
    String scantype,OEp,Datap,ll;
    ArrayAdapter<String> OEadapter,Dataadapter,stadapter,llAdapter;
    public  View getSuccessView(){
        View view=View.inflate(getActivity(), R.layout.screencar,null);
        initView(view);
        setListener();
        return view;
    }

    private void setListener() {

    }

    private void initView(View view) {
        carpSetting=(Button)view.findViewById(R.id.scarp_setting);
        carpSelect=(Button)view.findViewById(R.id.scarp_select);
        carpClear=(Button)view.findViewById(R.id.scarp_clear);
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
        OEpority.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.polarity);
                OEp=EncodingTool.getpolarity(item[i]);
            }
        });
        Datapority.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.polarity);
                Datap=EncodingTool.getpolarity(item[i]);
            }
        });
        scanType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.scantype);
                scantype=EncodingTool.getsctype(item[i]);
            }
        });
        lightl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.lightlevel);
                ll=EncodingTool.getlightlevel(item[i]);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scarp_setting:
                settingpar();
                break;
            case R.id.scarp_select:
                select();
                break;
            case R.id.scarp_clear:
                clear();
                break;
        }
    }

    private void clear() {

    }

    private void select() {
        String senddata=DecodingTool.getpackage(null,0,CMD.rsp);
        send(senddata);
    }

    private void settingpar() {
        String s=swidth.getText().toString()+sheight.getText().toString()+Datap+OEp+scantype+"ff"+ll;
         String senddata=DecodingTool.getpackage(s,s.length(),CMD.ssp);
         send(senddata);
    }


    @Override
    protected void receiveData(String s) {

    }

    @Override
    protected void setActionBar() {

    }

    @Override
    protected void showToast(String msg) {

    }

    @Override
    public void send(String s) {
        bls.SendData(s);
    }
}
