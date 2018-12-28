package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.bzbdyInfo;
import customer.tcrj.com.djproject.bean.info;

import static android.R.attr.data;


/**
 * 首页菜单适配器
 * Created by leict on 2017/10/25.
 */

public class NewsTypeAdapter extends BaseAdapter {
    private List<info.DataBean> itemList;
    private final Context context;
    private final LayoutInflater inflater;

    public NewsTypeAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setData(info list) {

        if(list != null){
            itemList = list.getData();

        }

    }

    @Override
    public int getCount() {
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

        info.DataBean dataBean = itemList.get(id);
        if (dataBean == null)
            return null;
        final ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_news_type, null);
            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) view.findViewById(R.id.tv_popu_report);


            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.name.setText(dataBean.getName());


        return view;
    }

    private class ViewHolder {
        TextView name;

    }
}
