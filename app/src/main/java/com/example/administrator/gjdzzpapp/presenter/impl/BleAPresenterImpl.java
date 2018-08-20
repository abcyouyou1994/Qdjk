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


    @Override
    public void scan() {

    }

    @Override
    public void cancel() {
        mBluetoothAdapter.cancelDiscovery();
    }

}
