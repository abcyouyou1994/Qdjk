package com.example.administrator.gjdzzpapp.view.activity.fgactivity;




import com.example.administrator.gjdzzpapp.prorocol.EncodingTool;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.utils.ConstantUtils;
import com.jzxiang.pickerview.TimePickerDialog;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.fragment.S2Fragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.ScFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.SdmFragment;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class bleDebug extends AppCompatActivity implements OnDateSetListener {

    private OutputStream outputStream=null;
    public final UUID Myuuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private boolean isConnected=false;
    public InputStream is=null;
    private BluetoothDevice mDevice;
    private BluetoothSocket socket;// 获取到客户端的接口
    private BluetoothService mBluetoothService;
    private RadioGroup radioGroup;
    public RadioButton sc_rb,s2_rb,sdm_rb;
    private Button timeS_btn,timesetting_btn,timeselect_btn;
    private TextView timeSetting,timeTerminal;
    private com.jzxiang.pickerview.TimePickerDialog timePickerDialog;
    Long tenYears=10L*365*1000*60*60*24L;
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Fragment mcont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_debug);
        initview();
        timePickerDialog= new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("时间设置")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))//未选中的文本颜色
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))//当前文本颜色
                .setWheelItemTextSize(12)
                .build();

        initData();
        initConnection();
    }

    private void initConnection() {
        Toast.makeText(this,"蓝牙开始连接",Toast.LENGTH_SHORT).show();

        if(mBluetoothService==null){
            mBluetoothService=new BluetoothService(bleDebug.this,mHandler);
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
            Toast.makeText(this,"没有获取到数据",Toast.LENGTH_SHORT).show();
            finish();
        }
        this.mDevice=device;
        Toast.makeText(this,"获取到数据",Toast.LENGTH_SHORT).show();
    }

    private void initview() {
        timeS_btn=(Button)findViewById(R.id.timesetting);
        timeselect_btn=(Button)findViewById(R.id.selecttime);
        timesetting_btn=(Button)findViewById(R.id.settingtime);
        sc_rb=(RadioButton)findViewById(R.id.screen_car);
        s2_rb=(RadioButton)findViewById(R.id.screen2);
        sdm_rb=(RadioButton)findViewById(R.id.screen_dm);
        radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        timeSetting=(TextView)findViewById(R.id.time_s);
        timeTerminal=(TextView)findViewById(R.id.time_terminal);
        mcont=new S2Fragment();
        s2_rb.setChecked(true);
        initFragment(new S2Fragment());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.screen2:
                        initFragment(new S2Fragment());
                        break;
                    case R.id.screen_car:
                        initFragment(new ScFragment());
                        break;
                    case R.id.screen_dm:
                        initFragment(new SdmFragment());
                        break;
                }
            }
        });
        timeS_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show(getSupportFragmentManager(), "time");
            }
        });


    }

    public void initFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(mcont!=fragment){
            if(!fragment.isAdded()){
                transaction.hide(mcont).add(R.id.fragment_main,fragment).commitAllowingStateLoss();
            }else {
                transaction.hide(mcont).show(fragment).commitAllowingStateLoss();
            }
            mcont=fragment;
        }

    }

    @Override
    public void onDateSet(com.jzxiang.pickerview.TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        timeSetting.setText(text);
    }

    private String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    // 创建handler，因为我们接收是采用线程来接收的，在线程中无法操作UI，所以需要handler
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case ConstantUtils.MESSAGE_READ:

                    try {

                        Bundle data=msg.getData();
                        byte[] temdata=data.getByteArray("dtz");


                        String s=EncodingTool.bytesToHexString(temdata);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case ConstantUtils. MESSAGE_STATE_CHANGE:
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
                    Toast.makeText(bleDebug.this,s1+"已经成功连接！",Toast.LENGTH_SHORT).show();
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
}
