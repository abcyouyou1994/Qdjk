package com.example.administrator.gjdzzpapp.view.activity.fragment.screen2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.view.activity.MainActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleDebug;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;
import com.example.administrator.gjdzzpapp.view.activity.fragment.S2Fragment;


public class S2Report extends BaseFragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private EditText s2Address,s2Roadid,s2mode,s2wordsize,s2wde,s2mle;
    private Spinner s2displaymode,s2words,s2worddirect,s2movelevel;
    private ArrayAdapter<String > s2dmAdapter,s2wsAdapter,s2wdAdapter,s2mlAdapter;
    private String[] s2dm_item,s2ws_item,s2wd_item,s2ml_item;
    private String s2dm,s2ws,s2wd,s2ml;
    private Button s2rSetting,s2rSelect,s2rClear,s2rFinish;

    @Override
    public View initView() {
        mActivity=(MainActivity)getActivity();
        View view=View.inflate(mActivity, R.layout.s2report_fragment,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        s2Address=(EditText)view.findViewById(R.id.screen2_sadress);
        s2Roadid=(EditText)view.findViewById(R.id.screen2_roadid);
        s2mode=(EditText)view.findViewById(R.id.s2md);
        s2wordsize=(EditText)view.findViewById(R.id.words2_size);
        s2wde=(EditText)view.findViewById(R.id.s2direct);
        s2mle=(EditText)view.findViewById(R.id.s2ml);
        s2displaymode=(Spinner)view.findViewById(R.id.s2mode_display);
        s2dm_item=getResources().getStringArray(R.array.displaymode);
        s2dmAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,s2dm_item);
        s2dmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2displaymode.setAdapter(s2dmAdapter);
        s2words=(Spinner)view.findViewById(R.id.s2word_size);
        s2ws_item=getResources().getStringArray(R.array.woresize);
        s2wsAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,s2dm_item);
        s2wsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2words.setAdapter(s2wsAdapter);
        s2worddirect=(Spinner)view.findViewById(R.id.s2word_direct);
        s2wd_item=getResources().getStringArray(R.array.worddirect);
        s2wdAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,s2wd_item);
        s2wdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2worddirect.setAdapter(s2dmAdapter);
        s2movelevel=(Spinner)view.findViewById(R.id.s2word_velocity);
        s2ml_item=getResources().getStringArray(R.array.wmovel);
        s2mlAdapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,s2ml_item);
        s2mlAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2movelevel.setAdapter(s2mlAdapter);
        s2rSetting=(Button)view.findViewById(R.id.s2r_setting);
        s2rSelect=(Button)view.findViewById(R.id.s2r_select);
        s2rClear=(Button)view.findViewById(R.id.s2r_clear);
        s2rFinish=(Button)view.findViewById(R.id.s2_reportfinish) ;
        s2displaymode.setOnItemSelectedListener(this);
        s2words.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        s2worddirect.setOnItemSelectedListener(this);
        s2movelevel.setOnItemSelectedListener(this);
        s2rSetting.setOnClickListener(this);
        s2rSelect.setOnClickListener(this);
        s2rClear.setOnClickListener(this);
        s2rFinish.setOnClickListener(this);
    }

    @Override
    public View initData() {
        return null;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.s2r_select:
                selects2r();
                break;
            case R.id.s2r_setting:
                settings2r();
                break;
            case R.id.s2r_clear:
                clears2r();
                break;
            case R.id.s2_reportfinish:
                finishs2r();
        }
    }

    private void finishs2r() {
        mActivity=(bleDebug)getActivity();
        ((bleDebug) mActivity).initFragment(new S2Fragment());
    }

    private void clears2r() {
    }

    private void settings2r() {
    }

    private void selects2r() {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
