package customer.tcrj.com.djproject.sy;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.MyApp;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.ShowImageUtils;
import customer.tcrj.com.djproject.adpater.MainMenuAdapter;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.MenuEntity;
import customer.tcrj.com.djproject.bean.MessageEvent;
import customer.tcrj.com.djproject.bean.picInfo;
import customer.tcrj.com.djproject.bean.userInfo;
import customer.tcrj.com.djproject.mine.DialogmsgActivity;
import customer.tcrj.com.djproject.mine.NetJSCallJavaActivity;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.GlideImageLoader;
import customer.tcrj.com.djproject.widget.MyGridView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by leict on 2018/3/22.
 */

public class FirstFragment extends BaseFragment implements View.OnClickListener, OnBannerListener {

    @BindView(R.id.banner)
    Banner banner;

//    @BindView(R.id.banner_db)
//    MZBannerView banner_db;

    @BindView(R.id.iv_bwcx)
    ImageView iv_bwcx;
    @BindView(R.id.iv_yxlz)
    ImageView iv_yxlz;

    @BindView(R.id.ll_xxks)
    LinearLayout llxxks;
    @BindView(R.id.ll_xxcx)
    LinearLayout llxxcx;
    @BindView(R.id.ll_hdjl)
    LinearLayout llhdjl;
    @BindView(R.id.ll_xxfb)
    LinearLayout llxxfb;
    @BindView(R.id.ll_dwgl)
    LinearLayout lldwgl;
    @BindView(R.id.ll_dkgl)
    LinearLayout lldkgl;

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
    CircleImageView iv_photo;
    @BindView(R.id.start)
    SimpleRatingBar start;
    @BindView(R.id.ll_cn)
    LinearLayout llcn;
//    @BindView(R.id.icon_title)
//    TextView icon_title;

    MainMenuAdapter adapter1;
    private MyOkHttp mMyOkhttp;
    Entity loginInfo = null;

    public static final int[] BANNER = new int[]{R.mipmap.banner1, R.mipmap.banner2, R.mipmap.banner3, R.mipmap.banner4, R.mipmap.banner5};


    @Override
    protected int setLayout() {
        return R.layout.first_fragment;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(mContext).getAsObject("loginInfo");
        initview();
        setListener();
    }

    private void initview() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        EventBus.getDefault().register(this);
        titles = new ArrayList<>();
    }

    private void setListener() {
        llxxks.setOnClickListener(this);
        llxxcx.setOnClickListener(this);
        llhdjl.setOnClickListener(this);
        llxxfb.setOnClickListener(this);
        lldwgl.setOnClickListener(this);
        lldkgl.setOnClickListener(this);
        iv_bwcx.setOnClickListener(this);
        iv_yxlz.setOnClickListener(this);

//        mMZBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
//            @Override
//            public void onPageClick(View view, int i) {
//                Log.e("TAG","i:"+i);
//                picInfo.DataBean dataBean = bannerList.get(i);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("picInfo",dataBean);
//                toClass(mContext,NewsDetailActivity.class,bundle);
//            }
//        });
//
//
//        mMZBanner.addPageChangeLisnter(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                icon_title.setText(bannerList.get(position).getTitle());
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    @Override
    protected void setData() {

        setUserInfo(loginInfo);

        geticon();

    }

    private void geticon() {
        showLoadingDialog("正在加载...");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", "");
            jsonObject.put("password", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.picApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<picInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Toast.makeText(mContext, "服务器连接错误", Toast.LENGTH_SHORT).show();
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, picInfo response) {
                        hideLoadingDialog();
                        if(response.getErrorCode().equals("0")){

                            bannerList = response.getData();

                            Log.e("TAG","bannerList"+bannerList.size());
                            if(bannerList.size()>0 ){

                                for(int i = 0;i < response.getData().size(); i++){

                                    if(!("".equals(bannerList.get(i).getThumbUrl()))){
                                        titles.add(bannerList.get(i).getTitle());
                                        Log.e("TAG","titles"+bannerList.get(i).getTitle());
                                    }else {
                                        bannerList.remove(i);
                                    }

//                                    Log.e("TAG","msg"+bannerList.get(i).getThumbUrl());
                                }
                                setBannerData(bannerList);
                            }

                        }
                    }
                });
    }
    List<picInfo.DataBean> bannerList;
    private List<String> titles;

    private void setBannerData(List<picInfo.DataBean> bannerList) {

        Log.e("TAG","bannerList"+bannerList.size());
        banner.setImages(bannerList)
                .setBannerTitles(titles)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start()
                .updateBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);


    }

    private void setUserInfo(Entity response) {

        if(response != null){

            llcn.setVisibility(View.VISIBLE);
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


            tv_type.setText(personInfo.getType()+" |");
            tv_username.setText(personInfo.getUsername());
//            tv_jgzb.setText(personInfo.getUnit()+personInfo.getDept());
            tv_jgzb.setText(personInfo.getDept());
            cn.setText(personInfo.getMyPromise());//承若

            tv_zw.setText(personInfo.getDuty());

            String starNum = personInfo.getStarNum();
            if(starNum != null){
                int i = Integer.parseInt(starNum);
                if(i > 0){
                    start.setVisibility(View.VISIBLE);
                    start.setNumberOfStars(i);
                    start.setRating(i);

                }else{
                    start.setVisibility(View.GONE);
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


//    public static class BannerViewHolder implements MZViewHolder<picInfo.DataBean> {
//        private ImageView mImageView;
//
//        @Override
//        public View createView(Context context) {
//            // 返回页面布局文件
//            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
//            mImageView = (ImageView) view.findViewById(R.id.banner_image);
//            return view;
//        }
//
//        @Override
//        public void onBind(Context context, int position, picInfo.DataBean data) {
//            // 数据绑定
//            String picPath = data.getThumbUrl();
//            Log.e("TAG","image:"+ApiConstants.ImageURLROOT+picPath);
//            Glide.with(context).load(ApiConstants.ImageURLROOT+picPath).into(mImageView);
//
//        }
//    }
//
//    public static class dbBannerViewHolder implements MZViewHolder<picInfo.DataBean> {
//        private ImageView mImageView;
//
//        @Override
//        public View createView(Context context) {
//            // 返回页面布局文件
//            View view = LayoutInflater.from(context).inflate(R.layout.dbbanner_item, null);
//            mImageView = (ImageView) view.findViewById(R.id.banner_image);
//            return view;
//        }
//
//        @Override
//        public void onBind(Context context, int position, picInfo.DataBean data) {
//            //数据绑定
////            mImageView.setImageResource(data);
//            String picPath = data.getThumbUrl();
//            Glide.with(context).load(ApiConstants.ImageURLROOT+picPath).into(mImageView);
//        }
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.ll_xxks:
                toClass(mContext,XxkcActivity.class);//学习考试
                break;
            case R.id.ll_xxcx:
                toClass(mContext,XxcxActivity.class);//信息查询
                break;
            case R.id.ll_hdjl:
                toClass(mContext,hdjlnewActivity.class);//互动交流
                break;
            case R.id.ll_xxfb:
                toClass(mContext,releaseActivity.class);//信息发布
                break;
            case R.id.iv_yxlz:
                Bundle bundle = new Bundle();
                bundle.putString("url","http://lxyz.12371.cn/");
                toClass(mContext,NetJSCallJavaActivity.class,bundle);//专题活动
                break;
            case R.id.iv_bwcx:
                Bundle bundle1 = new Bundle();
                bundle1.putString("url","http://www.12371.cn/special/cx/");
                toClass(mContext,NetJSCallJavaActivity.class,bundle1);//专题活动
                break;
            case R.id.ll_dwgl:
//                toClass(mContext,DwglActivity.class);//党务管理
                toClass(mContext,WebViewActivity.class);

                break;
            case R.id.ll_dkgl:
                toClass(mContext,DkglActivity.class);//党课管理
                break;

            default:
                break;
        }

    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mMZBanner.pause();//暂停轮播
    }

    @Override
    public void OnBannerClick(int position) {
        picInfo.DataBean dataBean = bannerList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("picInfo",dataBean);
                toClass(mContext,NewsDetailActivity.class,bundle);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        Log.e("TAG","evenbus:"+messageEvent.getMessage());
        cn.setText(messageEvent.getMessage());
    }
}
