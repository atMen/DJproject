package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class FreshNewsAdapter extends BaseQuickAdapter<qyListInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public FreshNewsAdapter(@Nullable List<qyListInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_message, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, qyListInfo.DataBean.ContentBean item) {
        TextView name = helper.getView(R.id.name);
        TextView time = helper.getView(R.id.time);
        TextView sex = helper.getView(R.id.sex);
        TextView duty = helper.getView(R.id.duty);
        ImageView im_icon = helper.getView(R.id.im_icon);
        SimpleRatingBar start = helper.getView(R.id.starts);
//        Glide.with(mContext).load(ApiConstants.ImageURLROOT+item.geturl()).into(im_icon);

        Log.e("TAG","xj:"+item.getActualDue());
        if( !item.getActualDue().equals("")){
            start.setVisibility(View.VISIBLE);
            String actualDue = item.getActualDue();
            int i = Integer.parseInt(actualDue);

            if(i > 90){
                start.setNumberOfStars(5);
                start.setRating(5);
            }else if(i > 80){
                start.setNumberOfStars(4);
                start.setRating(4);
            }else {
                start.setNumberOfStars(3);
                start.setRating(3);
            }





        }else{
            start.setVisibility(View.GONE);
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
        if(sex1.equals("1")){
            sex.setText("性别：男");
        }else {
            sex.setText("性别：女");
        }
        duty.setText("职务："+item.getPrzyjszwmc());
    }

//    private OnItemClickListener onItemClickListener;
//
//    public interface OnItemClickListener {  //定义接口，实现Recyclerview点击事件
//        void OnItemClick(int position);
//    }
//
//
//    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
//        this.onItemClickListener = onItemClickListener;
//    }



}
