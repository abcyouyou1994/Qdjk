package com.example.administrator.gjdzzpapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.view.inter.IBluetoothView;

public class BleActivity extends BaseMvpActivity implements IBluetoothView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble);
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag, int btn_flag) {
        switch (btn_flag){

        }
    }


}
