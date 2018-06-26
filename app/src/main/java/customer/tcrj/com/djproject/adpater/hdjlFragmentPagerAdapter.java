package customer.tcrj.com.djproject.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import customer.tcrj.com.djproject.sy.gnbtn.DwFregment;
import customer.tcrj.com.djproject.sy.gnbtn.DyFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ShykFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ZzshFregment;
import customer.tcrj.com.djproject.sy.wsdcFregment;
import customer.tcrj.com.djproject.sy.xyqFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class hdjlFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"心愿墙", "网上调查"};

    public hdjlFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new xyqFregment();
        }
        return new wsdcFregment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}

