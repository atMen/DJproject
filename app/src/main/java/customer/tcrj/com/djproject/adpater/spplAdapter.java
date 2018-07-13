package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.AnimationTools;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class spplAdapter extends BaseQuickAdapter<plInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public spplAdapter(@Nullable List<plInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_appl, data);
        this.mContext = context;
    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
////        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
////        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
//    }

    @Override
    protected void convert(final BaseViewHolder helper, final plInfo.DataBean.ContentBean item) {
        ImageView view = helper.getView(R.id.image_icon);
        TextView content_pl = helper.getView(R.id.content_pl);
        TextView time_pl = helper.getView(R.id.time_pl);
        TextView name = helper.getView(R.id.name);

        content_pl.setText(item.getContent());
        time_pl.setText(item.getCreateDate());
        plInfo.DataBean.ContentBean.CreateUserBean createUser = item.getCreateUser();
        if(createUser != null){
            name.setText(item.getCreateUser().getCname());
        }


//        content_pl.setText(item.getContent());
//        time_pl.setText(item.getCreatedataDate());


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
