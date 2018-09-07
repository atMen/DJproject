package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import android.widget.CheckedTextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.cqryInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class cqryAdapter extends BaseQuickAdapter<cqryInfo.DataBean, BaseViewHolder>{

    private Context mContext;


    public cqryAdapter(@Nullable List<cqryInfo.DataBean> data, Context context) {
        super(R.layout.item_single_select, data);
        this.mContext = context;

    }

    @Override
    protected void convert(final BaseViewHolder helper, final cqryInfo.DataBean item) {
        Log.e("TAG","item:"+item);

        CheckedTextView view = helper.getView(R.id.ctv_single_choice);
        view.setText(item.getCname());
        view.setChecked(item.isselect());
    }

}
