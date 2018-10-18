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
import android.widget.TextView;

import com.airbnb.lottie.L;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.AnimationTools;
import customer.tcrj.com.djproject.bean.kjInfo;
import customer.tcrj.com.djproject.bean.kjdzInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.PdfActivity;
import customer.tcrj.com.djproject.sy.infoactivity.TpActivity;
import customer.tcrj.com.djproject.sy.onlyplActivity;
import customer.tcrj.com.djproject.sy.plActivity;
import customer.tcrj.com.djproject.video.VideoPlayerbigActivity;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class WdlistviewAdapter extends BaseQuickAdapter<kjInfo.DataBean.ContentBean, BaseViewHolder>{
    private Context mContext;
    private MyOkHttp mMyOkhttp;
    private String userid;
    private String id;
    public WdlistviewAdapter(@Nullable List<kjInfo.DataBean.ContentBean> data, Context context, String id,MyOkHttp mMyOkhttp,String userid) {
        super(R.layout.item_wdlistview, data);
        this.mContext = context;
        this.id = id;
        this.mMyOkhttp = mMyOkhttp;
        this.userid = userid;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final kjInfo.DataBean.ContentBean item) {
        final LinearLayout lldz = helper.getView(R.id.ll_dz);
        final ImageView zan_img = helper.getView(R.id.zan_img);
        final TextView textView = helper.getView(R.id.zan_num);
        final TextView pl = helper.getView(R.id.pl_num);
        final TextView content = helper.getView(R.id.content);
        final TextView progress = helper.getView(R.id.progress);
        final TextView titlename = helper.getView(R.id.titlename);
        final TextView time = helper.getView(R.id.time);
        final TextView zannum = helper.getView(R.id.zan_num);
        final LinearLayout llpl = helper.getView(R.id.pl);

        final String type = item.getType();
        final String file = item.getFile();
        final String kjid = item.getId();
        final String fileName = item.getFileName();
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

        Log.e("TAG","item.isHasLike()："+item.isHasLike());
        if (item.isHasLike()) {
            zan_img.setImageResource(R.drawable.dz);
        } else {
            zan_img.setImageResource(R.drawable.qxdz);
        }

        llpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if("13301".equals(type)){
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("file",file);
                    bundle2.putString("fileName",fileName);
                    bundle2.putString("kcid",id);
                    bundle2.putString("kjid",kjid);
                    bundle2.putString("studyState",item.getStudyState());
                    bundle2.putString("playtime",item.getPlayTime());
                    bundle2.putString("minduction",item.getMinDuration());
                    toClass(mContext,plActivity.class,bundle2);
                }else if("13302".equals(type)){
                    toClass(mContext,onlyplActivity.class,item.getId(),id);
                }else if("13305".equals(type)){
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("file",file);
                    bundle1.putString("fileName",fileName);
                    bundle1.putString("kjid",kjid);
                    bundle1.putString("kcid",id);
                    bundle1.putString("studyState",item.getStudyState());
                    bundle1.putString("playtime",item.getPlayTime());
                    bundle1.putString("minduction",item.getMinDuration());
                    toClass(mContext,VideoPlayerbigActivity.class,bundle1);
                }else if("13303".equals(type)){
                    toClass(mContext,onlyplActivity.class,item.getId(),id);
                }
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
//                    Toast.makeText(mContext, "已点过赞", Toast.LENGTH_SHORT).show();
                    zan_img.setImageResource(R.drawable.qxdz);
                    zannum.setText(item.getLikenum() - 1+"");
                    item.setLikenum(item.getLikenum() - 1);
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
        Log.e("TAG","点赞id："+kjid);
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

    /**
     * Intent带值跳转
     * @param context
     * @param clazz
     * @param bundle
     */
    protected void toClass(Context context, Class clazz, Bundle bundle){

        Intent intent = new Intent(context,clazz);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        mContext.startActivity(intent);
    }

}
