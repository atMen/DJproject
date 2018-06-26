package customer.tcrj.com.djproject.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import customer.tcrj.com.djproject.sy.gnbtn.DwFregment;
import customer.tcrj.com.djproject.sy.gnbtn.DyFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ShykFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ZzshFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"党员管理", "党费管理", "三会一课", "组织生活"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DyFregment();
        } else if (position == 1) {
            return new DwFregment();
        }else if (position == 2){
            return new ShykFregment();
        }
        return new ZzshFregment();
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

