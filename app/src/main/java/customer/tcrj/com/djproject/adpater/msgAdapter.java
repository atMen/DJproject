package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.msgInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class msgAdapter extends BaseQuickAdapter<msgInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public msgAdapter(@Nullable List<msgInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_msg, data);
        this.mContext = context;
    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
////        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
////        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
//    }

    @Override
    protected void convert(final BaseViewHolder helper, final msgInfo.DataBean.ContentBean item) {
                TextView name = helper.getView(R.id.titlename);
        TextView content = helper.getView(R.id.content);
        TextView time = helper.getView(R.id.time);
        name.setText(item.getTitle());
        content.setText(item.getContent());
        time.setText(item.getUpdateDateper());


    }

//    private OnItemClickListener onItemClickListener;
//
//    public interface OnItemClickListener {//定义接口，实现Recyclerview点击事件
//        void OnItemClick(int position);
//    }
//
//
//    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
//        this.onItemClickListener = onItemClickListener;
//    }



}
