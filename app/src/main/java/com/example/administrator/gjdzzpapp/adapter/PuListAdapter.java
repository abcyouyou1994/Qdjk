package com.example.administrator.gjdzzpapp.adapter;

/**
 * Created by dingchao on 2017/12/28.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.example.administrator.gjdzzpapp.R;
import com.example.administrator.gjdzzpapp.entity.JsonDataBean;
import com.example.administrator.gjdzzpapp.app.AppApplication;


/**
 * 此adapter是商铺ListVIew---》listView的适配器
 */

public class PuListAdapter extends BaseAdapter {
    private Context context;
    private List<JsonDataBean.HomeShoplistBean> list;
    private boolean isEdit = false;


    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pu_list, viewGroup, false);
            holder.ll_item_pu_list_all = convertView.findViewById(R.id.ll_item_pu_list_all);
            holder.tv_item_pu_list_title = convertView.findViewById(R.id.tv_item_pu_list_title);//
            holder.tv_item_pu_list_address = convertView.findViewById(R.id.tv_item_pu_list_address);//
            holder.tv_item_pu_list_tag1 = convertView.findViewById(R.id.tv_item_pu_list_tag1);
            holder.tv_item_pu_list_tag2 = convertView.findViewById(R.id.tv_item_pu_list_tag2);
            holder.tv_item_pu_list_tag3 = convertView.findViewById(R.id.tv_item_pu_list_tag3);
            holder.tv_item_pu_list_money = convertView.findViewById(R.id.tv_item_pu_list_money);//
            holder.tv_item_pu_list_money_danwei = convertView.findViewById(R.id.tv_item_pu_list_money_danwei);
            holder.iv_item_pu_list_imgurl = convertView.findViewById(R.id.iv_item_pu_list_imgurl);//*/

            /*新增*/
//            holder.iv_movie_abouttoshow_moviephoto = convertView.findViewById(R.id.iv_movie_abouttoshow_moviephoto);//影片缩略图*/
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        /*绑定数据和点击事件*/
        //影片缩略图，使用第三方加载
        //
        //Piscasso还没有安装所以先屏蔽2018725
      /*  Picasso.with(AppApplication.getmContext())//上下文
                .load(list.get(i).getShopImgUrl())//加载的地址
                .resize(94, 131)//设置显示的图片大小
                .placeholder(R.mipmap.ic_launcher)//图片较大加载慢时显示的图片
                .error(R.mipmap.ic_launcher)//加载错误时的图片
                .into(holder.iv_item_pu_list_imgurl);//指定显示图片的控件
*/

        holder.tv_item_pu_list_title.setText(list.get(i).getShopName());//名称
        holder.tv_item_pu_list_address.setText(list.get(i).getShopAddress());//导演
        holder.tv_item_pu_list_money.setText(list.get(i).getShopMonery());//上映时间
        holder.tv_item_pu_list_money_danwei.setText(list.get(i).getShopMoneryUnit());//上映时间

        /*标签遍历绑定*/
        List<JsonDataBean.HomeShoplistBean.ShopTagsBean> tagList = new ArrayList<>();
        tagList = list.get(i).getShopTags();

        for (int j = 0; j < tagList.size(); j++) {
            if (j == 0) {//第一个标签
                holder.tv_item_pu_list_tag1.setText(tagList.get(j).getTag());//主演
            }
            if (j == 1) {//第2个标签
                holder.tv_item_pu_list_tag2.setText(tagList.get(j).getTag());//主演
            }
            if (j == 2) {//第3个标签
                holder.tv_item_pu_list_tag3.setText(tagList.get(j).getTag());//主演
            }
        }


        /*点击个项目时携带Id跳转详情页面不是编辑状态的时候可以触发*/
        holder.ll_item_pu_list_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "携带Id跳转详情页面---》Id:" + list.get(i).getShopId(), Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    public PuListAdapter(Context context, List<JsonDataBean.HomeShoplistBean> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder {
        private LinearLayout ll_item_pu_list_all;//点击单项时使用
        private TextView tv_item_pu_list_title,//商铺名称
                tv_item_pu_list_address,//位置
                tv_item_pu_list_tag1,//标签1
                tv_item_pu_list_tag2,//标签2
                tv_item_pu_list_tag3,//标签3
                tv_item_pu_list_money,//价格
                tv_item_pu_list_money_danwei;//价格单位
        private ImageView iv_item_pu_list_imgurl;//商铺缩略图


    }
}
