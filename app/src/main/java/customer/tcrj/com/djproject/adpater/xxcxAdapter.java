package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class xxcxAdapter extends BaseQuickAdapter<qyListInfo.DataBean, BaseViewHolder>{
    private Context mContext;

    public xxcxAdapter(@Nullable List<qyListInfo.DataBean> data, Context context) {
        super(R.layout.item_dkgl, data);
        this.mContext = context;
    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
////        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
////        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
//    }

    @Override
    protected void convert(final BaseViewHolder helper, qyListInfo.DataBean item) {
//        helper.getView(R.id.rl_message_list).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickListener.OnItemClick(helper.getAdapterPosition());
//            }
//        });
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
        void OnItemClick(int position);
    }


    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
