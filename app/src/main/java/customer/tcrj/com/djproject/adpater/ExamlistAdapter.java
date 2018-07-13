package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.examlistInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.bean.zxdtInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class ExamlistAdapter extends BaseQuickAdapter<zxdtInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public ExamlistAdapter(@Nullable List<zxdtInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_examlist, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, zxdtInfo.DataBean.ContentBean item) {
        TextView name = helper.getView(R.id.titlename);
        TextView time = helper.getView(R.id.time);
        TextView stat = helper.getView(R.id.stat);
        TextView time2 = helper.getView(R.id.time2);


        name.setText(item.getExamName());

        time.setText("开始时间："+item.getEffTime());
        time2.setText("结束时间："+item.getExpTime());

        String examState = item.getApproved();
        Log.e("TAG","状态："+examState);
        if(examState != null){
            if(examState.equals("1")){

                if( item.getStartTime() != null && item.getStartTime().equals("1")){
                    stat.setText("正在阅卷");
                    stat.setBackground(mContext.getResources().getDrawable(R.drawable.bg03));
                }else {
                    stat.setText("开始答题");
                    stat.setBackground(mContext.getResources().getDrawable(R.drawable.bg01));
                }


            }else if(examState.equals("2")){
                stat.setText("已交卷");
                stat.setBackground(mContext.getResources().getDrawable(R.drawable.bg03));
            }else if(examState.equals("3")){
                stat.setText("已阅卷");
                stat.setBackground(mContext.getResources().getDrawable(R.drawable.bg02));
            }
        }else {
            stat.setText("开始答题");
            stat.setBackground(mContext.getResources().getDrawable(R.drawable.bg01));
        }

    }


}
