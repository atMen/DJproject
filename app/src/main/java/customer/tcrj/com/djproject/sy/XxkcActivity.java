package customer.tcrj.com.djproject.sy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.XxkcFragmentPagerAdapter;
import customer.tcrj.com.djproject.adpater.XxksFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.mine.ExamListActivity;

public class XxkcActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.num)
    TextView num;

    private XxkcFragmentPagerAdapter myFragmentPagerAdapter;
    private String mine = null;

    @Override
    protected int setLayout() {
        return R.layout.activity_dwgl;
    }

    @Override
    protected void setView() {

         mine = getIntent().getStringExtra("mine");

        if(mine != null){
            num.setVisibility(View.GONE);
        }else {
            num.setVisibility(View.VISIBLE);
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
    protected void setData() {

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
