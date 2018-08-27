package com.example.administrator.gjdzzpapp.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.administrator.gjdzzpapp.view.utils.ConstantUtils;

public class BaseActivity extends AppCompatActivity {
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        registerBroadcast();
    }
    public  boolean  onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    MyReceiver receiver;
    private void registerBroadcast() {
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConstantUtils.RETURN_BLT);
        context.registerReceiver(receiver,filter);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ConstantUtils.RETURN_BLT)){
                Intent intent1=new Intent(BaseActivity.this,TwoActivity.class);
                startActivity(intent1);
            }
        }
    }
    protected void onDestroy() {

        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
