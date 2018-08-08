package com.example.administrator.gjdzzpapp.view.activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.inter.ble_DebugView;

public class parameter2 extends AppCompatActivity implements ble_DebugView {
    private BluetoothDevice mDevice;
    private BluetoothSocket socket;
    private BluetoothService mBluetoothService;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter2);

        initData();
        initConnect();
    }

    @SuppressLint("WrongConstant")
    private void initConnect() {
        Toast.makeText(this,"蓝牙开始连接",0).show();

        if(mBluetoothService==null){
            Toast.makeText(this,"蓝牙设备出现问题！",0).show();
        }if (mBluetoothService!=null){
            if(mDevice!=null){
                mBluetoothService.connect(mDevice);
            }
        }
    }

    private void initData() {
        Intent intent=getIntent();
        BluetoothDevice device=intent.getParcelableExtra("device");
        if(device==null){
            finish();
        }
           mDevice=device;


    }

    @Override
    public void sendData() {

    }

    @Override
    public void receiveData() {

    }

    @Override
    public <T> void response(T response, int responseFlag, int btnflag) {


    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public void showToast(String msg) {

    }
}
