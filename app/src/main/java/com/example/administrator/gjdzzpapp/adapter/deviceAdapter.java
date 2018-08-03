package com.example.administrator.gjdzzpapp.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.gjdzzpapp.entity.DeviceDataBean;
import com.example.administrator.gjdzzpapp.view.activity.BleActivity;

import java.util.List;

public class deviceAdapter extends BaseAdapter {
   private List<BluetoothDevice> list;
   private Context context;

    public deviceAdapter(Context context, List<BluetoothDevice> deviceList) {
        this.context=context;
        this.list=deviceList;
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
