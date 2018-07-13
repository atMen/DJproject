package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.hdjlInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class hdjlAdapter extends BaseQuickAdapter<hdjlInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public hdjlAdapter(@Nullable List<hdjlInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_xyq, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, hdjlInfo.DataBean.ContentBean item) {
        TextView content = helper.getView(R.id.content);
        TextView name = helper.getView(R.id.name);

        content.setText(item.getMsgContent());
        name.setText("--"+item.getCname());

    }




}
