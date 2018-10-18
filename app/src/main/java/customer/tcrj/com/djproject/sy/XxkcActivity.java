package customer.tcrj.com.djproject.sy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.XxkcFragmentPagerAdapter;
import customer.tcrj.com.djproject.adpater.XxksFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.zxdtInfo;
import customer.tcrj.com.djproject.mine.ExamListActivity;
import customer.tcrj.com.djproject.net.ApiConstants;

public class XxkcActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.iv_kstx)
    ImageView iv_kstx;

    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.ll_ks)
    LinearLayout ll_ks;


    private XxkcFragmentPagerAdapter myFragmentPagerAdapter;
    private String mine = null;
    private MyOkHttp mMyOkhttp;
    Entity loginInfo = null;

    @Override
    protected int setLayout() {
        return R.layout.activity_dwgl;
    }

    @Override
    protected void setView() {

        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();

         mine = getIntent().getStringExtra("mine");

        if(mine != null){
            ll_ks.setVisibility(View.GONE);
//            num.setVisibility(View.GONE);
        }else {
//            num.setVisibility(View.VISIBLE);
            ll_ks.setVisibility(View.VISIBLE);
        }

        num.setText("开始考试");
        num.setOnClickListener(this);

        mViewPager.setOffscreenPageLimit(4);
        myFragmentPagerAdapter = new XxkcFragmentPagerAdapter(getSupportFragmentManager(),mine);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        txtTitle.setText("学习考试");
        btnback.setOnClickListener(this);
    }

    @Override
    protected void setData() {}

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    //获取网络数据
    private void getData() {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("page", "1");
            jsonObject.put("size", "1");
            jsonObject.put("memberId", loginInfo.getData().getData().getId());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url( ApiConstants.examwklistApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<zxdtInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }

                    @Override
                    public void onSuccess(int statusCode, zxdtInfo response) {

                        if("0".equals(response.getErrorCode())){

                            int size = response.getData().getContent().size();
                            if(size > 0){
                                iv_kstx.setVisibility(View.VISIBLE);
                            }else {
                                iv_kstx.setVisibility(View.GONE);
                            }

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;
            case R.id.num:
                Bundle bundle3 = new Bundle();
                bundle3.putString("type","1");
                toClass(this,ExamListActivity.class,bundle3);
                break;
        }
    }
}
