package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.support.v4.app.Fragment;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.Screen2Fragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.Screen2Param;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screen2.Screen2Report;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.CarParam;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.CarReport;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.CarRoad;
import com.example.administrator.gjdzzpapp.view.activity.fragment.screencar.ScreenCarFragment;

import java.util.Currency;

public class FragmentFactory {
    public static Fragment creates2ById(int resId){
        Fragment fragment = null;
        switch (resId) {
            case R.id.car_param://小车屏参数设置
                fragment=new CarParam();
                break;
            case R.id.car_report:
                fragment=new CarReport();
                break;
            case R.id.car_road:
                fragment=new CarRoad();
                break;
        }
        return fragment;
    }

    public static Fragment createForMain(int position){
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new Screen2Fragment();
                break;
            case 1:
                fragment=new ScreenCarFragment();
                break;
        }
        return fragment;
    }
    public  static Fragment crescByid(int resId){
        Fragment fragment=null;
        switch (resId){
            case R.id.s2param:
                fragment=new Screen2Param();
                break;
            case R.id.s2report:
                fragment=new Screen2Report();
                break;
        }return fragment;
    }

}
