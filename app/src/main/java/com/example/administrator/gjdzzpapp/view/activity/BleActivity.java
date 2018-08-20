package com.example.administrator.gjdzzpapp.view.activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.example.administrator.gjdzzpapp.presenter.inter.IBleAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IBluetoothView;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;

import java.util.ArrayList;
import java.util.List;

public class BleActivity extends BaseMvpActivity implements IBluetoothView, AdapterView.OnItemClickListener {
    private ListView device_list;
    private Button btn_scan,btn_back;
    private ArrayList<String> mArrayAdapter = new ArrayList<>();
    private ArrayList<BluetoothDevice> devices = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    private BluetoothAdapter bltAdapter=BluetoothAdapter.getDefaultAdapter();
    private deviceAdapter adapter;
    private IBleAPresenter iBleAPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ActionBar actionBar = getActionBar();
        //actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble);

        checkBle();
        initViewBind();

    }

    @SuppressLint("WrongConstant")
    private void checkBle() {
        if(bltAdapter==null){
            Toast.makeText(this, "对不起，您的设备不支持蓝牙！", 0).show();
        }
        if(bltAdapter.isEnabled()){
            Toast.makeText(this, "蓝牙已经打开！", 0).show();
        }
        if(!bltAdapter.isEnabled()){
            bltAdapter.enable();
        }
    }

    private void initViewBind() {

        btn_back=(Button)findViewById(R.id.btn_back_ble);
        btn_scan=(Button)findViewById(R.id.btn_scan_ble);
        device_list=(ListView)findViewById(R.id.list_devicelist_ble);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BleActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scan();
            }
        });
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mArrayAdapter);
        device_list.setAdapter(mAdapter);
        device_list.setOnItemClickListener(this);

    }

    @SuppressLint("WrongConstant")
    private void scan() {
        if (bltAdapter.isEnabled() && !bltAdapter.isDiscovering()) {
            boolean startDiscovery = bltAdapter.startDiscovery();

            if (!startDiscovery) {
                Toast.makeText(this, "开始扫描失败！", 0).show();
                return;
            }
            Toast.makeText(this, "开始扫描", 0).show();
            mArrayAdapter.clear();
            devices.clear();
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(receiver, filter);
        } else {
            String scan_state1 = "正在扫描";

            unregisterReceiver(receiver);
        }
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                devices.add(device);
                mAdapter.notifyDataSetChanged();
            }
        }
    };



    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(BleActivity.this, parameter2.class);
        intent.putExtra("device", devices.get(i));
        iBleAPresenter.cancel();
        startActivity(intent);
    }

    protected void onDestroy() {

        super.onDestroy();
        unregisterReceiver(receiver);
    }


}
