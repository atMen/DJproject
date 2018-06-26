package customer.tcrj.com.djproject.sy.infoactivity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.SpFragmentPagerAdapter;
import customer.tcrj.com.djproject.adpater.XxksFragmentPagerAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;

public class SpstudyActivity extends BaseActivity {




    private SpFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_spstudy;
    }

    @Override
    protected void setView() {

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
