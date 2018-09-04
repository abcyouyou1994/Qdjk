package com.example.administrator.gjdzzpapp.view.activity.fgactivity;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.adapter.FragPagerAdapter;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.fragment.FragmentFactory;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.Screen2Fragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.Screen2Param;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.ScreenCarFragment;
import com.example.administrator.gjdzzpapp.view.activity.parameter2;
import com.example.administrator.gjdzzpapp.view.activity.widgets.NoScrollView;
import com.example.administrator.gjdzzpapp.view.utils.ConstantUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class bleActivity extends BaseMvpActivity {
/*
蓝牙调试fragment主activity

 */

private ViewPager mViewPager;
    private BluetoothDevice mDevice;
    private BluetoothSocket socket;
    private BluetoothService mBluetoothService;
    RadioButton bottomScreen2,bottomScreencar;
    RadioGroup radioGroup;
    NoScrollView viewPager;
    ImageView ivScreen2,ivScreencar;
    TextView homeTitle;
    private FragPagerAdapter fpa;
    private OutputStream outputStream=null;
    public InputStream is=null;
    private boolean isConnected=false;
    private List<Fragment> mFragment=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble2);
        initView();
        initFragment();
        initData();
        initConnect();

    }

    private void initFragment() {
        mFragment.add(new Screen2Fragment());
        mFragment.add(new ScreenCarFragment());
        mViewPager.setAdapter(new MypagerAdapter(getSupportFragmentManager()));
    }

    private void initConnect() {
        showToast("蓝牙开始连接");

        if(mBluetoothService==null){
            mBluetoothService=new BluetoothService(bleActivity.this,mHandler);

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
            showToast("数据为空！");
            finish();
        }
        mDevice=device;
        showToast("获取到数据");
    }

    private void initView() {
        homeTitle=(TextView)findViewById(R.id.home_title);
        viewPager=(NoScrollView)findViewById(R.id.view_pager);
        bottomScreen2=(RadioButton)findViewById(R.id.screen2);
        bottomScreencar=(RadioButton)findViewById(R.id.screen_car);
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        fpa=new FragPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fpa);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
        homeTitle.setText("两字屏调试");
        bottomScreen2.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (isConnected) {
                    switch (i) {
                        case R.id.screen2:
                            viewPager.setCurrentItem(0, false);
                            homeTitle.setText("两字屏调试");
                            break;
                        case R.id.screen_car:
                            viewPager.setCurrentItem(1, false);
                            homeTitle.setText("小车屏调试");
                            break;
                    }
                }
                else {
                    showToast("未获取到数据！");
                }
            }
        });
    }
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
                case ConstantUtils.MESSAGE_READ:


                    break;
                case ConstantUtils.MESSAGE_STATE_CHANGE:
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
                case ConstantUtils.MESSAGE_DEVICE_NAME:
                    String s1=msg.getData().toString();
                    Toast.makeText(bleActivity.this,s1+"已经成功连接！",Toast.LENGTH_SHORT).show();
                    isConnected=true;
                    break;
                case ConstantUtils.MESSAGE_TOAST:
                    if (mBluetoothService != null) {
                        mBluetoothService.connect(mDevice);
                    }
                    break;
            }
            return false;
        }
    });

     class MypagerAdapter extends FragmentPagerAdapter{

         public MypagerAdapter(FragmentManager fm) {
             super(fm);
         }

         @Override
         public Fragment getItem(int i) {
             return FragmentFactory.createForMain(i);
         }

         @Override
         public int getCount() {
             return 2;
         }
     }
}
