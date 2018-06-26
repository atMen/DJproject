package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.bean.examlistInfo;
import customer.tcrj.com.djproject.bean.wjdcInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class wjdclistAdapter extends BaseQuickAdapter<wjdcInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public wjdclistAdapter(@Nullable List<wjdcInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_examlist, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, wjdcInfo.DataBean.ContentBean item) {
        TextView name = helper.getView(R.id.titlename);
        TextView time = helper.getView(R.id.time);
        TextView time2 = helper.getView(R.id.time2);

        TextView stat = helper.getView(R.id.stat);

        name.setText(item.getTitle());
        time.setText("开始时间："+item.getTimes());
        time2.setText("结束时间："+item.getTimee());


    }


}
