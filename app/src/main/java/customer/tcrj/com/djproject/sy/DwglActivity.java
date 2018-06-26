package customer.tcrj.com.djproject.sy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.MyFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;

public class DwglActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private int type;



    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_dwgl;
    }

    @Override
    protected void setView() {
        type = getIntent().getIntExtra("type",0);
        mViewPager.setOffscreenPageLimit(4);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        txtTitle.setText("党务管理");
        btnback.setOnClickListener(this);
        mViewPager.setCurrentItem(type);

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
}
