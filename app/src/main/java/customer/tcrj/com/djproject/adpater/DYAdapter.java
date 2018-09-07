package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.bzbdyInfo;
import customer.tcrj.com.djproject.bean.dyInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class DYAdapter extends BaseQuickAdapter<bzbdyInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public DYAdapter(@Nullable List<bzbdyInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_listview, data);
        this.mContext = context;
    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
////        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
////        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
//    }

    @Override
    protected void convert(final BaseViewHolder helper, bzbdyInfo.DataBean.ContentBean item) {
//        viewHolder.name.setText("姓名："+data.getCname());
//        viewHolder.sex.setText("性别："+data.getSex());
//        viewHolder.sr.setText("出生日期："+data.getCreateDate());
//        viewHolder.zw.setText("职务："+data.getDepartmentName());
        TextView name = helper.getView(R.id.name);
        TextView sex = helper.getView(R.id.sex);
        TextView sr = helper.getView(R.id.sr);
        TextView zw = helper.getView(R.id.zw);
        name.setText(item.getXm());
        String sex1 = item.getXb();
        if("1".equals(sex1)){
            sex.setText("性别：男");
        }else if("0".equals(sex1)){
            sex.setText("性别：女");
        }
        String optime = item.getCsrq();
        String substring = optime.substring(0, 10);
        sr.setText("出生日期："+substring);
        zw.setText("电话："+item.getLxdh());

    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
        void OnItemClick(int position);
    }


    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
