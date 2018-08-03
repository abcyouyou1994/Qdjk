package com.example.administrator.gjdzzpapp.presenter.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

import com.example.administrator.gjdzzpapp.entity.DeviceDataBean;
import com.example.administrator.gjdzzpapp.model.inter.IBluetoothModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.presenter.inter.IBleAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IBluetoothView;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;

import java.util.ArrayList;

public class BleAPresenterImpl implements IBleAPresenter {
    private IBluetoothView iBluetoothView;
    private IBluetoothModel iBluetoothModel;
    private BluetoothAdapter mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    private ArrayList<String>mArrayAdapter=new ArrayList<>();
    private ArrayList<BluetoothDevice>devices=new ArrayList<>();
    private ArrayAdapter<String>mAdapter;
    DeviceDataBean deviceDataBean;

    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mArrayAdapter.add(device.getName()+"\n"+device.getAddress());
                devices.add(device);
                mAdapter.notifyDataSetChanged();
            }
        }
    };
    CallBack callBack= new CallBack() {
        @Override
        public void onSuccess(Object response) {
            iBluetoothView.response(response,IMainAView.RESPONSE_ONE,1);
            iBluetoothView.showToast("扫描成功！");
        }

        @Override
        public void onError(String t) {
            iBluetoothView.response(iBluetoothModel,IMainAView.RESPONSE_TWO,1);
                    iBluetoothView.showToast(t);
        }
    };
    private void queryingPaireDevices(){

    }
    @Override
    public void scan() {
        if (!mBluetoothAdapter.isEnabled()){
            iBluetoothView.showToast("请先打开蓝牙！");
        }else if(mBluetoothAdapter.isDiscovering()){
            mBluetoothAdapter.cancelDiscovery();
        }else {
            iBluetoothView.showToast("开始扫描……");
            mBluetoothAdapter.startDiscovery();
            iBluetoothView.editText("正在扫描");
            if(receiver!=null&&mArrayAdapter!=null){
                deviceDataBean.setDeviceList(devices);
                callBack.onSuccess(deviceDataBean);
            }
        }
    }

    @Override
    public void cancel() {
        mBluetoothAdapter.cancelDiscovery();
    }

}
