package customer.tcrj.com.djproject.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.setting.mymsgActivity;
import customer.tcrj.com.djproject.sy.DwglActivity;
import customer.tcrj.com.djproject.sy.XxkcActivity;

import static customer.tcrj.com.djproject.R.id.rl_hd;


/**
 * Created by leict on 2018/3/22.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.msg)
    RelativeLayout msg;
    @BindView(R.id.rl_zx)
    RelativeLayout rl_zx;
    @BindView(R.id.rl_hd)
    RelativeLayout rl_hd;

    @BindView(R.id.rl_zxgx)
    RelativeLayout rl_zxgx;
    @BindView(R.id.rl_about)
    RelativeLayout rl_about;

    @BindView(R.id.rl_cn)
    RelativeLayout rl_cn;

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
    private Entity loginInfo = null;


    @Override
    protected int setLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void setView() {
        msg.setOnClickListener(this);
        rl_zxgx.setOnClickListener(this);
        rl_zx.setOnClickListener(this);
        rl_hd.setOnClickListener(this);
        rl_about.setOnClickListener(this);
        rl_cn.setOnClickListener(this);
    }

    @Override
    protected void setData() {
        loginInfo = (Entity) ACache.get(mContext).getAsObject("loginInfo");
        setUserInfo(loginInfo);
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
//            int i = Integer.parseInt(personInfo.getStarNum());
//            if(i > 0){
//                start.setVisibility(View.VISIBLE);
//                start.setNumberOfStars(i);
//                start.setRating(i);
//
//            }else{
//                start.setVisibility(View.GONE);
//            }
//        }
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

        tv_zw.setText(personInfo.getDuty());

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

            case R.id.msg:
                toClass(mContext,mymsgActivity.class);
                break;

            case R.id.rl_about://任务
                Toast.makeText(mContext, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_cn://承诺
                Entity.DataBeanX.DataBean data = loginInfo.getData().getData();
                String myPromise = data.getMyPromise();
                if(myPromise == null && "".equals(myPromise)){
                    Toast.makeText(mContext, "没有承诺信息", Toast.LENGTH_SHORT).show();
                }else {
                    Log.e("TAG","cn:"+data.getMyPromise());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("cn",data);
                    toClass(mContext,DialogCRActivity.class,bundle);
                }


                break;

            case R.id.rl_zxgx:
//                toClass(mContext,NetJSCallJavaActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putString("type","0");
                toClass(mContext,ExamListActivity.class,bundle3);
                break;
            case R.id.rl_hd:
//                Bundle bundle1 = new Bundle();
//                bundle1.putInt("type",3);
//                toClass(mContext, DwglActivity.class,bundle1);

                Toast.makeText(mContext, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_zx:
                Bundle bundle2 = new Bundle();
                bundle2.putString("mine","mine");
                toClass(mContext,XxkcActivity.class,bundle2);
                break;
            default:
                break;

        }
    }


}
