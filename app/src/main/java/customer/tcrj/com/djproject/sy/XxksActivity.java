package customer.tcrj.com.djproject.sy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.MyFragmentPagerAdapter;
import customer.tcrj.com.djproject.adpater.XxksFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kjNum;
import customer.tcrj.com.djproject.net.ApiConstants;

import static customer.tcrj.com.djproject.R.id.num;

public class XxksActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private XxksFragmentPagerAdapter myFragmentPagerAdapter;
    private String kcid;

    private MyOkHttp mMyOkhttp;
    Entity loginInfo;

    @Override
    protected int setLayout() {
        return R.layout.activity_xxks;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");

        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        kcid = getIntent().getStringExtra("kcid");
        getNum(loginInfo.getData().getData().getId(),kcid);

        mViewPager.setOffscreenPageLimit(4);
        myFragmentPagerAdapter = new XxksFragmentPagerAdapter(getSupportFragmentManager(),kcid);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        txtTitle.setText("在线学习");
        btnback.setOnClickListener(this);


    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;
        }
    }

    private int type = 0;

    //联网进行登录
    private void getNum(final String memberId, String courseId) {

        JSONObject jsonObject = new JSONObject();

        Log.e("TAG","username:"+memberId+"---courseId:"+courseId);
        try {
            jsonObject.put("memberId", memberId);
            jsonObject.put("courseId", courseId);

//            jsonObject.put("username", "zs");
//            jsonObject.put("password", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kjnumlistApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<kjNum>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, kjNum response) {
                        Log.e("TAG","课件数量："+response.toString());
//                        int num = response.getData().get(0).getNum();
//                        int num1 = response.getData().get(1).getNum();
//                        int num2 = response.getData().get(2).getNum();
//                        int num3 = response.getData().get(3).getNum();
                        List<kjNum.DataBean> data = response.getData();

                        for(int i = 0;i < data.size();i++){
//                            13301: 视频
//                            13302: 图片
//                            13303: 文档
//                            13305: 音频
                            int num = data.get(i).getNum();
                            String type = data.get(i).getType();

                            if(type.equals("13303") && num>0){
                                if(mViewPager != null){
                                    mViewPager.setCurrentItem(2);
                                }

                                return;
                            }else if(type.equals("13305") && num>0){
                                if(mViewPager != null){
                                    mViewPager.setCurrentItem(3);
                                }

                                return;
                            }else if(type.equals("13301") && num>0){
                                if(mViewPager != null){
                                    mViewPager.setCurrentItem(0);
                                }

                                return;
                            }else if(type.equals("13302") && num>0){
                                if(mViewPager != null){
                                    mViewPager.setCurrentItem(1);
                                }

                                return;
                            }

                        }


                    }
                });
    }
}
