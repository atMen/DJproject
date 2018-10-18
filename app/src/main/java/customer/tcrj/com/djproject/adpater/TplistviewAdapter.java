package customer.tcrj.com.djproject.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.AnimationTools;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kjInfo;
import customer.tcrj.com.djproject.bean.kjdzInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.onlyplActivity;
import customer.tcrj.com.djproject.sy.plActivity;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class TplistviewAdapter extends BaseQuickAdapter<kjInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;
    private String id;
    private MyOkHttp mMyOkhttp;
    private String userid;

    public TplistviewAdapter(@Nullable List<kjInfo.DataBean.ContentBean> data, Context context, String id,MyOkHttp mMyOkhttp,String userid) {
        super(R.layout.item_splistview, data);
        this.mContext = context;
        this.id = id;
        this.mMyOkhttp = mMyOkhttp;
        this.userid = userid;
    }


    @Override
    protected void convert(final BaseViewHolder helper, final kjInfo.DataBean.ContentBean item) {
        helper.getView(R.id.sp_btn).setVisibility(View.GONE);
        final LinearLayout lldz = helper.getView(R.id.ll_dz);
        final ImageView zan_img = helper.getView(R.id.zan_img);

        final TextView progress = helper.getView(R.id.progress);
        final TextView titlename = helper.getView(R.id.titlename);
        final TextView time = helper.getView(R.id.time);
        final ImageView sp_icon = helper.getView(R.id.sp_icon);
        final TextView zannum = helper.getView(R.id.zan_num);
        final LinearLayout llpl = helper.getView(R.id.ll_pl);


        String studyState = item.getStudyState();
        titlename.setText(item.getName());
        time.setText(item.getCreateDate());
        zannum.setText(item.getLikenum()+"");


        if (studyState.equals("100")){
            progress.setText("已学完");
            progress.setBackgroundColor(Color.parseColor("#86B659"));
        }else{
            progress.setText("待学完");
            progress.setBackgroundColor(Color.parseColor("#FFCE44"));
        }
//        progress.setText("已学"+studyState+" %");


        Log.e("TAG","item.isHasLike()："+item.isHasLike());
        if (item.isHasLike()) {
            zan_img.setImageResource(R.drawable.dz);
        } else {
            zan_img.setImageResource(R.drawable.qxdz);
        }



        llpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toClass(mContext,onlyplActivity.class,item.getId(),id);
            }
        });

        lldz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取上次是否已经被点击
                boolean flag = item.isHasLike();
//                // 反向存储记录，实现取消点赞功能
//                item.setZanFocus(!flag);

                if (!flag) {
                    item.setHasLike(true);
                    zan_img.setImageResource(R.drawable.dz);
                    zannum.setText(item.getLikenum() + 1+"");
                    item.setLikenum(item.getLikenum() + 1);
                    AnimationTools.scale(zan_img);
                    zan(item.getId());
                }else{
                    item.setHasLike(false);
//                  Toast.makeText(mContext, "已点过赞", Toast.LENGTH_SHORT).show();
                    zan_img.setImageResource(R.drawable.qxdz);

                    zannum.setText(item.getLikenum() - 1+"");item.setLikenum(item.getLikenum() - 1);
                    zan(item.getId());
                }

            }
        });
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
    //联网进行登录
    private void zan(String kjid) {
        Log.e("TAG","kjid："+kjid+"memberId："+userid+"courseId："+id);
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("memberId", userid);
            jsonObject.put("courseId", id);
            jsonObject.put("coursewareId", kjid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kcdzApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kjdzInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, kjdzInfo response) {
                        Log.e("TAG","成功"+response.getErrorCode());
                        if(response.getErrorCode().equals("0")){
//                            Log.e("TAG","成功");
                        }
                    }
                });
    }
    protected void toClass(Context context, Class clazz, String courseId, String memberId){

        Intent intent = new Intent(context,clazz);
        intent.putExtra("memberId",memberId);
        intent.putExtra("courseId",courseId);
        mContext.startActivity(intent);
    }

}
