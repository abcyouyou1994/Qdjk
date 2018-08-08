package com.example.administrator.gjdzzpapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.inter.IOperationView;

public class OperationActivity extends AppCompatActivity implements IOperationView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag, int btn_flag) {

    }
}
