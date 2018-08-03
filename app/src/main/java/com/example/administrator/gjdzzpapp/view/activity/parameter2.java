package com.example.administrator.gjdzzpapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.inter.ble_DebugView;

public class parameter2 extends AppCompatActivity implements ble_DebugView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter2);
    }

    @Override
    public void sendData() {

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
