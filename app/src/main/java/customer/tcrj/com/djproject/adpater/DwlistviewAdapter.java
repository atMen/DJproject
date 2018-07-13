package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class DwlistviewAdapter extends BaseQuickAdapter<qyListInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public DwlistviewAdapter(@Nullable List<qyListInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_dwlistview, data);
        this.mContext = context;
    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
////        View view1 = baseQuickAdapter.getViewByPosition(i,R.id.iv_logo);
////        ReadActivity.launch(mContext, (FreshNewsBean.PostsBean) baseQuickAdapter.getItem(i),view1);
//    }

    @Override
    protected void convert(final BaseViewHolder helper, qyListInfo.DataBean.ContentBean item) {
        TextView name = helper.getView(R.id.name);
        TextView time = helper.getView(R.id.time);
        TextView sex = helper.getView(R.id.sex);
        TextView duty = helper.getView(R.id.duty);
        TextView  isGson = helper.getView(R.id.isGson);
        TextView  isdf = helper.getView(R.id.isdf);


        String paidCast = item.getPaidCast();
        Log.e("TAG","paidCast:"+paidCast);
        if(paidCast != null && paidCast.equals("1")){
            isGson.setVisibility(View.VISIBLE);
            isdf.setVisibility(View.GONE);
        }else{
            isdf.setVisibility(View.VISIBLE);
            isGson.setVisibility(View.GONE);
        }
        name.setText("姓名："+item.getCname());
        String optime = item.getCreateDate();
        if(optime != null && optime.length() >= 10){
            String substring = optime.substring(0, 10);
            time.setText("出生日期："+substring);
        }else {

            time.setText("出生日期：");
        }
        String sex1 = item.getSex();
        if(sex1 != null && sex1.equals("1")){
            sex.setText("性别：男");
        }else if(sex1 != null && sex1.equals("0")){
            sex.setText("性别：女");
        }else {
            sex.setText("性别：");
        }

        duty.setText("职务："+item.getPrzyjszwmc());
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
        void OnItemClick(int position);
    }


    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
