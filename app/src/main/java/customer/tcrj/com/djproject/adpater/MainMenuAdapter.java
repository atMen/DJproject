package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.MenuEntity;
import customer.tcrj.com.djproject.bean.bzbdyInfo;
import customer.tcrj.com.djproject.bean.dyInfo;


/**
 * 首页菜单适配器
 * Created by leict on 2017/10/25.
 */

public class MainMenuAdapter extends BaseAdapter {
    private List<bzbdyInfo.DataBean.ContentBean> itemList;
    private final Context context;
    private final LayoutInflater inflater;

    public MainMenuAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setData(bzbdyInfo list) {

        if(list != null){
            itemList = list.getData().getContent();

        }

    }

    @Override
    public int getCount() {
        if (itemList.size() >= 4){
            return 4;
        }

        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int id, View view, ViewGroup parent) {

        if(itemList == null)
        return null;

        bzbdyInfo.DataBean.ContentBean data = itemList.get(id);
        if (data == null)
            return null;
        final ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_listview, null);
            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.sex = (TextView) view.findViewById(R.id.sex);
            viewHolder.sr = (TextView) view.findViewById(R.id.sr);
            viewHolder.zw = (TextView) view.findViewById(R.id.zw);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String sex1 = data.getXb();
        if("1".equals(sex1)){
            viewHolder.sex.setText("性别：男");
        }else {
            viewHolder.sex.setText("性别：女");
        }
        viewHolder.name.setText("姓名："+data.getXm());
        String optime = data.getCsrq();
        String substring = optime.substring(0, 10);
        viewHolder.sr.setText("出生日期："+substring);
        viewHolder.zw.setText("电话："+data.getLxdh());

        return view;
    }

    private class ViewHolder {
        TextView name;
        TextView sex;
        TextView sr;
        TextView zw;
    }
}
