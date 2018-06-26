package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class xxkcAdapter extends BaseQuickAdapter<kcList.DataBean.ContentBean, BaseViewHolder>{
        private Context mContext;

    public xxkcAdapter(@Nullable List<kcList.DataBean.ContentBean> response, Context context) {
        super(R.layout.item_xxkc, response);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, kcList.DataBean.ContentBean item) {
        helper.setText(R.id.text,item.getTitle());
        String optime = item.getOptime();
        String substring = optime.substring(0, 10);
        helper.setText(R.id.time,substring);
        ImageView icon = helper.getView(R.id.content);
        TextView progress = helper.getView(R.id.progress);
        Glide.with(mContext).load(ApiConstants.ImageURLROOT+item.getImgPath()).into(icon);

        Log.e("TAG","progress:"+item.getProgress());
        String progress1 = item.getProgress();

        if(progress1.equals("0")){
            progress.setText("未学");
            progress.setBackgroundColor(Color.parseColor("#ff0000"));
        }else if (progress1.equals("100")){
            progress.setText("已学完");
            progress.setBackgroundColor(Color.parseColor("#86B659"));
        }else{
            progress.setText("已学");
            progress.setBackgroundColor(Color.parseColor("#FFCE44"));
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
