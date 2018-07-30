package com.example.administrator.gjdzzpapp.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.adapter.PuListAdapter;
import com.example.administrator.gjdzzpapp.base.BaseMvpActivity;
import com.example.administrator.gjdzzpapp.entity.JsonDataBean;
import com.example.administrator.gjdzzpapp.presenter.impl.TwoAPresenterImpl;
import com.example.administrator.gjdzzpapp.presenter.inter.ITwoAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;
import com.example.administrator.gjdzzpapp.view.inter.ITwoAView;

/**
 * Created by dingchao on 2018/3/28.
 */

/**
 * 测试获取数据集合，网络请求拿到集合对象
 */
public class TwoActivity extends BaseMvpActivity implements ITwoAView {
    private ITwoAPresenter mITwoAPresenter;
    private Button btn_getdata;//请求数据按钮
    private EditText et_token;//模拟参数

    private ListView lv_data_list;//listView
    private List<JsonDataBean.HomeShoplistBean> jsonpuInfoEntityList;//商铺集合

    private JsonDataBean jsonDataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mITwoAPresenter = new TwoAPresenterImpl(this);
        setContentView(R.layout.activity_two);

        initViewBind();

    }

    private void initViewBind() {
        btn_getdata = (Button) findViewById(R.id.btn_getdata);
        et_token = (EditText) findViewById(R.id.et_token);
        lv_data_list = (ListView) findViewById(R.id.lv_data_list);
        btn_getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mITwoAPresenter.getData();
            }
        });
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag) {
        /*拿到的总的对象*/
        if (responseFlag == IMainAView.RESPONSE_ONE) {
            jsonDataBean = (JsonDataBean) response;
            Log.e("jsonDataBean", "返回的数据信息：" + jsonDataBean.getHome_shopline());
            jsonpuInfoEntityList = jsonDataBean.getHome_shoplist();
            PuListAdapter puListAdapter = new PuListAdapter(TwoActivity.this, jsonpuInfoEntityList);
            lv_data_list.setAdapter(puListAdapter);
        }
    }

    @Override
    public String getToken() {
        return et_token.getText().toString();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
