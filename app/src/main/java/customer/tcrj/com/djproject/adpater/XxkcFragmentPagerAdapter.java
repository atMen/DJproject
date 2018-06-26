package customer.tcrj.com.djproject.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.djproject.sy.xxkaFragment.KCFragment;
import customer.tcrj.com.djproject.sy.xxkaFragment.SpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.TpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.WdFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.YpFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class XxkcFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"专题课程", "形势政策", "微视分享", "典型事迹"};
    private String ismine;

    public XxkcFragmentPagerAdapter(FragmentManager fm,String ismine) {
        super(fm);
        this.ismine = ismine;

    }

    public XxkcFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new KCFragment(position,ismine);
        } else if (position == 1) {
            return new KCFragment(position,ismine);
        }else if (position == 2){
            return new KCFragment(position,ismine);
        }
        return new KCFragment(position,ismine);
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


//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//    }
}

