package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.dkInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class DkAdapter extends BaseQuickAdapter<dkInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public DkAdapter(@Nullable List<dkInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_message, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, dkInfo.DataBean.ContentBean item) {
        TextView name = helper.getView(R.id.name);
        TextView time = helper.getView(R.id.time);
        TextView sex = helper.getView(R.id.sex);
        TextView duty = helper.getView(R.id.duty);
        ImageView im_icon = helper.getView(R.id.im_icon);
        SimpleRatingBar start = helper.getView(R.id.starts);

        name.setText("姓名："+item.getRealName());


        String optime = item.getCsrq();
        if(optime != null && !"".equals(optime)){
            String substring = optime.substring(0, 10);
            time.setText("出生日期："+substring);
        }

        String sex1 = item.getSex();
        if("1".equals(sex1)){
            sex.setText("性别：男");
        }else if("2".equals(sex1)){
            sex.setText("性别：女");
        }

        String duty1 = item.getLxdh();
        if(duty1 != null){
            duty.setText("电话："+item.getLxdh());
        }else {
            duty.setText("电话：");
        }

    }


}
