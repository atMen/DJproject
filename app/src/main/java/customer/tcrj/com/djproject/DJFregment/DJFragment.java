package customer.tcrj.com.djproject.DJFregment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.MainMenuAdapter;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.bzbdyInfo;
import customer.tcrj.com.djproject.bean.dyInfo;
import customer.tcrj.com.djproject.bean.userInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.DwglActivity;
import customer.tcrj.com.djproject.widget.MyGridView;


/**
 * Created by leict on 2018/3/22.
 */

public class DJFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.listview)
    public MyGridView listView;
    @BindView(R.id.noData)
    TextView noData;
    @BindView(R.id.more)
    TextView more;
    MainMenuAdapter adapter1;

    @BindView(R.id.tv_cn)
    TextView cn;
    @BindView(R.id.tv_zbpm)
    TextView tv_zbpm;
    @BindView(R.id.tv_qspm)
    TextView tv_qspm;
    @BindView(R.id.tv_ndjf)
    TextView tv_ndjf;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_jgzb)
    TextView tv_jgzb;
    @BindView(R.id.tv_zw)
    TextView tv_zw;
    @BindView(R.id.iv_photo)
    ImageView iv_photo;
    @BindView(R.id.start)
    SimpleRatingBar start;

    @BindView(R.id.ll_shyk)
    LinearLayout ll_shyk;

    private MyOkHttp mMyOkhttp;
    private Entity loginInfo = null;

    @Override
    protected int setLayout() {
        return R.layout.dj_fragment;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        more.setOnClickListener(this);
        ll_shyk.setOnClickListener(this);
    }


    @Override
    protected void setData() {

        loginInfo = (Entity) ACache.get(mContext).getAsObject("loginInfo");
        setUserInfo(loginInfo);
        getDataFromNet();

//        adapter1 = new MainMenuAdapter(mContext);
//        adapter1.setData(null);
//        listView.setAdapter(adapter1);
    }

//    private void setUserInfo(Entity response) {
//
//        if(response != null){
//
//            Entity.DataBean personInfo = response.getData();
//            Log.e("TAG","StarNum"+personInfo.getStarNum());
//            tv_zbpm.setText("支部排名：第"+personInfo.getDeptRank()+"名");
//            tv_qspm.setText("全市排名：第"+personInfo.getCityRank()+"名");
//            tv_ndjf.setText("年度积分："+personInfo.getScore()+"分");
//            tv_type.setText(personInfo.getType()+" |");
//            tv_username.setText(personInfo.getUsername());
//            tv_jgzb.setText(personInfo.getDept());
////          cn.setText(personInfo.get());//承若
//            tv_zw.setText(personInfo.getDuty());
//            String photo = personInfo.getPhoto();
//            if(photo != null){
//                if(!photo.equals("")){
//                    Log.e("TAG","setting-photo"+photo);
//                    Glide.with(this).load(ApiConstants.TXImageURLROOT+photo).into(iv_photo);
//                }
//            }
//
//            int i = Integer.parseInt(personInfo.getStarNum());
//            if(i > 0){
//                start.setVisibility(View.VISIBLE);
//                start.setNumberOfStars(i);
//                start.setRating(i);
//
//            }else{
//                start.setVisibility(View.GONE);
//            }
//
//        }
//
//
//    }

    private void setUserInfo(Entity response) {

        if(response != null){

//            llcn.setVisibility(View.VISIBLE);
            Entity.DataBeanX.DataBean personInfo = response.getData().getData();

            String photo = personInfo.getPhoto();
            Log.e("TAG","photo"+photo);
            if(photo != null){

                if(!photo.equals("")){
                    Log.e("TAG","setting-photo"+photo);
                    Glide.with(this).load(ApiConstants.TXImageURLROOT+photo).into(iv_photo);
                }
//                    Uri uri=Uri.parse(photo);
//                    iv_photo.setImageURI(uri);

            }


            String deptRank = personInfo.getDeptRank();
            if(deptRank != null && !deptRank.equals("")){
                tv_zbpm.setText("支部排名：第"+personInfo.getDeptRank()+"名");
            }else {
                tv_zbpm.setText("支部排名：无");
            }

            String cityRank = personInfo.getCityRank();
            if(cityRank != null && !cityRank.equals("")){
                tv_qspm.setText("全市排名：第"+personInfo.getCityRank()+"名");
            }else {
                tv_qspm.setText("全市排名：无");
            }
            String score = personInfo.getScore();
            if(score != null && !score.equals("")){
                tv_ndjf.setText("年度积分："+personInfo.getScore()+"分");
            }else {
                tv_ndjf.setText("年度积分：无");
            }


            tv_type.setText(personInfo.getType()+" | ");
            tv_username.setText(personInfo.getUsername());
//            tv_jgzb.setText(personInfo.getUnit()+personInfo.getDept());
            tv_jgzb.setText(personInfo.getDept());
            cn.setText(personInfo.getMyPromise());//承若

            tv_zw.setText(personInfo.getDjztName());

            String starNum = personInfo.getStarNum();
            if(starNum != null){
                int i = Integer.parseInt(starNum);
                if(i > 0){
                    start.setNumberOfStars(5);
                    start.setRating(i);
                }
            }


//            if(personInfo.getStarNum() > 0){
//                start.setVisibility(View.VISIBLE);
//                start.setNumberOfStars(personInfo.getStarNum());
//                start.setRating(personInfo.getStarNum());
//
//            }else{
//                start.setVisibility(View.GONE);
//            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.more:
                toClass(mContext,dyDataActivity.class);
                break;
            case R.id.ll_shyk:
                Bundle bundle = new Bundle();
                bundle.putInt("type",2);
                toClass(mContext, DwglActivity.class,bundle);
                break;

            default:
                break;

        }
    }


    public void getDataFromNet() {
        if(loginInfo == null){
            return;
        }

        showLoadingDialog("正在加载数据..");
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("page", "1");
            jsonObject.put("size", "4");
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.dyinfoApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<bzbdyInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        hideLoadingDialog();
//                      Toast.makeText(mContext, "服务器连接错误", Toast.LENGTH_SHORT).show();
                        listView.setVisibility(View.GONE);
                        noData.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(int statusCode, bzbdyInfo response) {
                        Log.e("TAG","info:"+response.toString());
                        hideLoadingDialog();
                        List<bzbdyInfo.DataBean.ContentBean> content = response.getData().getContent();
                        if(content != null && content.size() > 0){
                            listView.setVisibility(View.VISIBLE);
                            noData.setVisibility(View.GONE);
                            adapter1 = new MainMenuAdapter(mContext);
                            adapter1.setData(response);
                            listView.setAdapter(adapter1);
                        }else{
                            listView.setVisibility(View.GONE);
                            noData.setVisibility(View.VISIBLE);
                        }


                    }
                });
    }
}
