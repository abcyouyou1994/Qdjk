package com.example.administrator.gjdzzpapp.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Message;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.prorocol.EncodingTool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private AcceptThread mAcceptThread;
    private ConnectThread mConnectThread;
    private static ConnectedThread mConnectedThread;
    private CallBack callBack;
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


    public void connect(BluetoothDevice mDevice) {

        mConnectThread=new ConnectThread(mDevice);
        mConnectThread.start();

    }
    private  synchronized  void connected(BluetoothSocket socket,BluetoothDevice device){
        if (mConnectThread!=null){
            mConnectThread.cancel();
            mConnectThread=null;
        }
        if (mAcceptThread!=null){
            mAcceptThread.cancel();
            mAcceptThread=null;
        }
        mConnectedThread=new ConnectedThread(socket);
        mConnectedThread.start();
        Message msg=new Message();

    }

    private static class ConnectedThread extends Thread{
        private BluetoothSocket mmsocket;
        private InputStream minputstream;
        private OutputStream moutputStream;


        public ConnectedThread(BluetoothSocket socket) {
            this.mmsocket=socket;
            InputStream temin=null;
            OutputStream temou=null;
            try {
                temin=socket.getInputStream();
                temou=socket.getOutputStream();
            }catch (IOException e){
                e.printStackTrace();
            }
            minputstream=temin;
            moutputStream=temou;
        }

        @Override
        public void run() {
            byte[]temInputBuffer=new byte[1024];
            byte[]bytes;
            int acceptlen=0;
            int len=0;
            String readMessage;
            while (true){
                try {
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    acceptlen=minputstream.available();
                    if(acceptlen>0){
                        acceptlen=minputstream.read(temInputBuffer);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        public  void  write(String s){
            byte[]data=EncodingTool.hexStringToByte(s);
            try {
                moutputStream.write(data);
                moutputStream.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        public void cancel(){
            try {
                mmsocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private class AcceptThread extends Thread {

        public void cancel() {
        }
    }

    private class ConnectThread extends Thread{
        private final BluetoothSocket mmsocket;
        private final BluetoothDevice mmDevice;
        public ConnectThread(BluetoothDevice mDevice) {
            mmDevice=mDevice;
            BluetoothSocket tmp=null;
            try {
                tmp=mDevice.createRfcommSocketToServiceRecord(My_UUID);
            }catch (IOException e){
                e.printStackTrace();
            }
            mmsocket=tmp;
        }

        @Override
        public void run() {
            try {
                mmsocket.connect();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void cancel() {

        }
    }
}
