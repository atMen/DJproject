package customer.tcrj.com.djproject.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import customer.tcrj.com.djproject.sy.gnbtn.DwFregment;
import customer.tcrj.com.djproject.sy.gnbtn.DyFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ShykFregment;
import customer.tcrj.com.djproject.sy.gnbtn.ZzshFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.SpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.TpFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.WdFregment;
import customer.tcrj.com.djproject.sy.xxkaFragment.YpFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class XxksFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"视频", "图片", "文档", "音频"};
    private String id;

    public XxksFragmentPagerAdapter(FragmentManager fm,String id) {
        super(fm);
        this.id = id;
    }
    //                            13301: 视频
//                            13302: 图片
//                            13303: 文档
//                            13305: 音频
    @Override
    public Fragment getItem(int position) {
        if (position == 2) {
            return new WdFregment(id);
        } else if (position == 3) {
            return new YpFregment(id);
        }else if (position == 0){
            return new SpFregment(id);
        }
        return new TpFregment(id);
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

