package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.msgInfo;
import customer.tcrj.com.djproject.bean.plInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class dialogactivityAdapter extends BaseQuickAdapter<plInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;

    public dialogactivityAdapter(@Nullable List<plInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_dialogactivity, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, final plInfo.DataBean.ContentBean item) {
        LinearLayout lldialogactivity = helper.getView(R.id.ll_dialogactivity);
        TextView contentpl = helper.getView(R.id.content_pl);
        TextView tvicon = helper.getView(R.id.tv_icon);
//        boolean selected = item.isSelected();
//        Log.e("TAG","selected)"+selected);
//        if(selected){
//            contentpl.setTextColor(mContext.getResources().getColor(R.color.red));
//            tvicon.setEnabled(false);
//        }

        lldialogactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("TAG","isplay"+isplay);
                if(isplay){

                    if(onItemClickListener != null){
                        onItemClickListener.OnItemClick(item);
                    }

//                    item.setSelected(true);
                    notifyDataSetChanged();
                    Log.e("TAG","item.isSelected()");

                    isplay = false;
                }

            }
        });

    }

    private boolean isplay = true;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {//定义接口，实现Recyclerview点击事件
        void OnItemClick(plInfo.DataBean.ContentBean item);
    }


    public void setOnItemRlClickListener(OnItemClickListener onItemClickListener) {   //实现点击
        this.onItemClickListener = onItemClickListener;
    }



}
