package com.example.administrator.gjdzzpapp.view.activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.inter.ble_DebugView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class parameter2 extends AppCompatActivity implements ble_DebugView {
    public static final int MESSAGE_STATE_CHANGE = 1; // 状态改变
    public static final int MESSAGE_READ = 2;          // 读取数据
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;         // Toast
    private BluetoothDevice mDevice;
    private BluetoothSocket socket;
    private BluetoothService mBluetoothService;

    private Button bottomScreen2,bottomScreencar;

    private OutputStream outputStream=null;
    public InputStream is=null;
    private boolean isConnected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter2);

        initData();
        initConnect();
    }
    @SuppressLint("WrongConstant")
    private void initData() {
        Intent intent=getIntent();
        BluetoothDevice device=intent.getParcelableExtra("device");
        if(device==null){
            showToast("数据为空！");
            finish();
        }
        mDevice=device;
       showToast("获取到数据");
    }
    @SuppressLint("WrongConstant")
    private void initConnect() {
        showToast("蓝牙开始连接");

        if(mBluetoothService==null){
            mBluetoothService=new BluetoothService(parameter2.this,mHandler);

        }if (mBluetoothService!=null){
            if(mDevice!=null){
                mBluetoothService.connect(mDevice);
            }
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT);
    }
    protected  void onDestroy() {

        super.onDestroy();
        if (outputStream!=null){
            try {
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }if (socket!=null){
            if (socket.isConnected()){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            socket=null;
            isConnected=false;
        }
    }
    public synchronized void onResume() {

        super.onResume();
        if (mBluetoothService != null) {
            if (mBluetoothService.getState() == BluetoothService.STATE_NONE) {
                mBluetoothService.start();
            }
        }
    }
    // 创建handler，因为我们接收是采用线程来接收的，在线程中无法操作UI，所以需要handler
      private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_READ:


                    break;
                case MESSAGE_STATE_CHANGE:
                    switch (msg.arg1) {
                        case BluetoothService.STATE_CONNECTED:
                            break;
                        case BluetoothService.STATE_CONNECTING:
                            break;
                        case BluetoothService.STATE_LISTEN:
                            break;
                        case BluetoothService.STATE_NONE:
                            break;
                    }
                    break;
                case MESSAGE_DEVICE_NAME:
                    String s1=msg.getData().toString();
                    Toast.makeText(parameter2.this,s1+"已经成功连接！",Toast.LENGTH_SHORT).show();
                    isConnected=true;
                    break;
                case MESSAGE_TOAST:
                    if (mBluetoothService != null) {
                        mBluetoothService.connect(mDevice);
                    }
                    break;
            }
            return false;
        }
    });

}
