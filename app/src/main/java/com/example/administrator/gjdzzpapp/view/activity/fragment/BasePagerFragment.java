package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.widgets.SYViewPager;
import com.example.administrator.gjdzzpapp.view.utils.ConstantUtils;
import com.viewpagerindicator.TabPageIndicator;

public abstract class BasePagerFragment extends Fragment implements View.OnClickListener{
    public TabPageIndicator indicator;
    public SYViewPager viewPager;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=View.inflate(getActivity(),R.layout.viewpager_indicator,null);
        initview(view);
        setActionBar();
        return view;
    }

    protected abstract void receiveData(String s);

    private void initview(View view) {
        indicator=(TabPageIndicator)view.findViewById(R.id.indicator);
        viewPager=(SYViewPager)view.findViewById(R.id.view_pager);

    }

    protected abstract void setActionBar();

    private Handler myHandler=new Handler(new Handler.Callback(){

        @Override
        public boolean handleMessage(Message message) {
          switch (message.what){
              case ConstantUtils
                      .MESSAGE_COMPLETE:
                  Bundle bundle=message.getData();
                    String s=bundle.getString("dtz");
                  receiveData(s);
                  break;
              case ConstantUtils.MESSAGE_FAILED:
                  Bundle bundle1=message.getData();
                  String s1=bundle1.getString("error");
                  showToast(s1);
                  break;
          }
            return false;
        }
    });
    protected abstract void showToast(String msg);
    public abstract void send(String s);
}
