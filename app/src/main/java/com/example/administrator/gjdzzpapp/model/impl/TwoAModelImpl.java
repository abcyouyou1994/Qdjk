package com.example.administrator.gjdzzpapp.model.impl;

import android.util.Log;



import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.gjdzzpapp.app.AppApplication;
import com.example.administrator.gjdzzpapp.entity.JsonDataBean;
import com.example.administrator.gjdzzpapp.model.inter.ITwoAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public class TwoAModelImpl implements ITwoAModel {

    JsonDataBean jsondatabean;

    @Override
    public void getData(String token, final CallBack callBack) {
        /*进行网络请求，获取数据*/
        // 方式二：使用静态方式创建并显示，这种进度条只能是圆条,设置title和Message提示内容
        if (token.equals("")) {
            
        } else {
            RequestQueue mQueue = Volley.newRequestQueue(AppApplication.getmContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://www.mockhttp.cn/mock/upzl-android-home2", new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    Log.e("login", "-------获取到的idjson--------" + s.toString());
                    Log.e("login", "-------JSON.parseObject(json).data--------" + JSON.parseObject(s.toString()).getString("data"));
                    jsondatabean = JSON.parseObject(JSON.parseObject(s.toString()).getString("data"), JsonDataBean.class);
                    //成功之后，传递出jsondatabean
                    if (jsondatabean != null) {//获取到了数据
                        callBack.onSuccess(jsondatabean);
                    } else {
                        callBack.onError(s);//获取失败信息
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<String, String>();
                    return map;
                }
            };
        /*设置请求一次*/
            stringRequest.setRetryPolicy(
                    new DefaultRetryPolicy(
                            500000,//默认超时时间，应设置一个稍微大点儿的，例如本处的500000
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,//默认最大尝试次数
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    )
            );
            mQueue.add(stringRequest);/*请求数据*/
        }

    }
}
