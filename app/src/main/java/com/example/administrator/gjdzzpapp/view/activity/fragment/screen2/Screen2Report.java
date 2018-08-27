package com.example.administrator.gjdzzpapp.view.activity.fragment.screen2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.prorocol.CMD;
import com.example.administrator.gjdzzpapp.prorocol.DecodingTool;
import com.example.administrator.gjdzzpapp.prorocol.EncodingTool;
import com.example.administrator.gjdzzpapp.service.BluetoothService;
import com.example.administrator.gjdzzpapp.view.activity.fragment.BaseFragment;

public class Screen2Report extends BaseFragment {
   private EditText s2Address,s2Roadid,s2mode,s2wordsize,s2wde,s2mle;
   private Spinner s2displaymode,s2words,s2worddirect,s2movelevel;
   private ArrayAdapter<String > s2dmAdapter,s2wsAdapter,s2wdAdapter,s2mlAdapter;
   private String[] s2dm_item,s2ws_item,s2wd_item,s2ml_item;
   private String s2dm,s2ws,s2wd,s2ml;
   private Button s2rSetting,s2rSelect,s2rClear;
   private BluetoothService bls;
    @Override
    protected View getSuccessView() {
        View view=View.inflate(getActivity(),R.layout.screen2_fg,null);
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
        s2displaymode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String []item=getResources().getStringArray(R.array.displaymode);
                s2dm=EncodingTool.getwordmode(item[i]);
            }
        });
        s2words.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[]item=getResources().getStringArray(R.array.woresize);
                s2ws=EncodingTool.getwordsize(item[i]);
            }
        });
        s2worddirect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[]item=getResources().getStringArray(R.array.worddirect);
                s2wd=EncodingTool.getmovedirect(item[i]);
            }
        });
        s2movelevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item=getResources().getStringArray(R.array.wmovel);
                s2ml=EncodingTool.getmovevelocity(item[i]);
            }
        });
        s2rSetting.setOnClickListener(this);
        s2rSelect.setOnClickListener(this);
        s2rClear.setOnClickListener(this);
    }

    @Override
    public void send(String s) {
        bls.SendData(s);
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.s2r_setting:
                setting();
                break;
            case R.id.s2r_select:
                select();
                break;
            case R.id.s2r_clear:
                clear();
                break;
        }
    }

    private void clear() {
    }

    private void select() {
        String senddata=DecodingTool.getpackage(null,0,CMD.wrsr);
        send(senddata);
    }

    private void setting() {
        String roadid1=DecodingTool.word2hexstr(s2Roadid.getText().toString());
        String s;
        if(s2dm=="静态"){
              s = s2Address.getText().toString() + roadid1.length() + roadid1+ s2ws + s2dm;
        }else {
             s = s2Address.getText().toString() + roadid1.length() + roadid1+ s2ws + s2dm + s2wd + s2ml;
        }
        String senddata=DecodingTool.getpackage(s,s.length(),CMD.wrs);
        send(senddata);
    }
}
