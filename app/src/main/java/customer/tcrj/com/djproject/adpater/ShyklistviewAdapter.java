package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.dhInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class ShyklistviewAdapter extends BaseQuickAdapter<dhInfo.DataBean.ContentBean, BaseViewHolder>{


    private Context mContext;

    public ShyklistviewAdapter(@Nullable List<dhInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_shyklistview, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, dhInfo.DataBean.ContentBean item) {

        TextView name = helper.getView(R.id.name);
        TextView time = helper.getView(R.id.time);
        TextView endtime = helper.getView(R.id.endtime);
        TextView type = helper.getView(R.id.type);
        TextView df = helper.getView(R.id.df);




        name.setText("活动名称："+item.getName());
        time.setText("开始时间："+item.getStartime());
        endtime.setText("结束时间："+item.getEndtime());

        df.setText("活动得分："+item.getCredit()+"分");



        String eventype = item.getEventype();

        if (eventype.equals("14101")) {
            type.setText("活动类型：支部党员大会");
        }else if(eventype.equals("14102")){
            type.setText("活动类型：支部党员会");
        }else if(eventype.equals("14103")){
            type.setText("活动类型：党小组会");
        }else if(eventype.equals("14104")){
            type.setText("活动类型：党课");
        }


    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
        void OnItemClick(int position);
    }


    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
