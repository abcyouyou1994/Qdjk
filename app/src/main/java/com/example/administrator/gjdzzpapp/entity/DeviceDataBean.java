package com.example.administrator.gjdzzpapp.entity;

import android.bluetooth.BluetoothDevice;

import java.util.List;

public class DeviceDataBean {
    public DeviceDataBean(){

    }
    private String deviceName;
    String deviceAddress;
    private List<BluetoothDevice> deviceList;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public List<BluetoothDevice> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<BluetoothDevice> deviceList) {
        this.deviceList = deviceList;
    }
}
