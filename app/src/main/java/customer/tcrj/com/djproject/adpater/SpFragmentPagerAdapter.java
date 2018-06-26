package customer.tcrj.com.djproject.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import customer.tcrj.com.djproject.sy.infoactivity.SplistFregment;
import customer.tcrj.com.djproject.sy.infoactivity.SpplFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.SpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.TpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.WdFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.YpFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class SpFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"课程目录", "课程评论"};

    public SpFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SplistFregment();
        }
            return new SpplFregment();


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

