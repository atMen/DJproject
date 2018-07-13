package customer.tcrj.com.djproject.sy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.MyFragmentPagerAdapter;
import customer.tcrj.com.djproject.adpater.hdjlFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;

public class hdjlnewActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.btnback)
    ImageView btnback;




    private hdjlFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_newhdjl;
    }

    @Override
    protected void setView() {

        mViewPager.setOffscreenPageLimit(2);
        myFragmentPagerAdapter = new hdjlFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);
        num.setVisibility(View.GONE);
        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        txtTitle.setText("互动交流");
        btnback.setOnClickListener(this);
        num.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

            case  R.id.num:
                toClass(this,writexyActivity.class);
                break;
        }
    }
}
