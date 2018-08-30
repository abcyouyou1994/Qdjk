package com.example.administrator.gjdzzpapp.view.activity.fgactivity;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.adapter.FragPagerAdapter;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.widgets.NoScrollView;

public class bleActivity extends BaseMvpActivity {
/*
蓝牙调试fragment主activity

 */

    RadioButton bottomScreen2,bottomScreencar;
    RadioGroup radioGroup;
    NoScrollView viewPager;
    ImageView ivScreen2,ivScreencar;
    TextView homeTitle;
    private BluetoothSocket socket;
    private BluetoothService mBluetoothService;
    private Handler mHandler;
    private FragPagerAdapter fpa;
    private BluetoothDevice mDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble2);
        initView();
        initData();
        initConnect();
    }

    private void initConnect() {
        Toast.makeText(this,"蓝牙开始连接",Toast.LENGTH_SHORT).show();

        if(mBluetoothService==null){
            Toast.makeText(this,"蓝牙设备出现问题！",Toast.LENGTH_SHORT).show();
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

    private void initView() {
        homeTitle=(TextView)findViewById(R.id.home_title);
        viewPager=(NoScrollView)findViewById(R.id.view_pager);
        bottomScreen2=(RadioButton)findViewById(R.id.screen2);
        bottomScreencar=(RadioButton)findViewById(R.id.screen_car);
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        fpa=new FragPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fpa);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setCurrentItem(0);
        homeTitle.setText("两字屏调试");
        bottomScreen2.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.screen2:
                        viewPager.setCurrentItem(0,false);
                        homeTitle.setText("两字屏调试");
                        break;
                    case R.id.screen_car:
                        viewPager.setCurrentItem(1,false);
                        homeTitle.setText("小车屏调试");
                        break;
                }
            }
        });
    }
}
