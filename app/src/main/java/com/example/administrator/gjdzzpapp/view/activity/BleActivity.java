package com.example.administrator.gjdzzpapp.view.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.adapter.deviceAdapter;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.entity.DeviceDataBean;
import com.example.administrator.gjdzzpapp.presenter.impl.BleAPresenterImpl;
import com.example.administrator.gjdzzpapp.view.inter.IBluetoothView;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;

import java.util.List;

public class BleActivity extends BaseMvpActivity implements IBluetoothView {
private BleAPresenterImpl mbleAPresenterImpl;
private ListView device_list;
private ArrayAdapter<String>mAdapter;
private Button btn_scan;
private DeviceDataBean mdeviceDataBean;
private List<BluetoothDevice> deviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble);

        initViewBind();
    }

    private void initViewBind() {


        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mbleAPresenterImpl.scan();
            }
        });
        device_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(BleActivity.this,parameter2.class);
                intent.putExtra("device",deviceList.get(i));
                mbleAPresenterImpl.cancel();

                startActivity(intent);
            }
        });
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag, int btn_flag) {
        switch (btn_flag){
            case 1:
                if(responseFlag==IMainAView.RESPONSE_ONE){
                    mdeviceDataBean=(DeviceDataBean)response;
                    deviceList=mdeviceDataBean.getDeviceList();
                    deviceAdapter deviceadapter=new deviceAdapter(BleActivity.this,deviceList);
                    device_list.setAdapter(deviceadapter);

                    if(mAdapter!=null){
                        showToast("扫描到的设备有：");
                    }
                }
                break;
            case 2:

                break;
        }
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editText(String s) {

    }


}
