package com.example.administrator.gjdzzpapp.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.util.UUID;
import java.util.logging.Handler;

public class BluetoothService {
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;
    private BluetoothSocket bluetoothSocket;
    private BluetoothServerSocket bluetoothServerSocket;
    private String Blname="CarTest";
    private UUID My_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private Handler mhandler;

    private int mState;
    public static final int STATE_NONE = 0;         //没有连接
    public static final int STATE_LISTEN = 1;       //等待连接
    public static final int STATE_CONNECTING = 2;  //正在连接
    public static final int STATE_CONNECTED = 3;   //已经连接

    public BluetoothService(BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public BluetoothService(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }


}
