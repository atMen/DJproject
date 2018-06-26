package customer.tcrj.com.djproject.widget;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import customer.tcrj.com.djproject.bean.picInfo;
import customer.tcrj.com.djproject.net.ApiConstants;


public class GlideImageLoader extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        picInfo.DataBean info = (picInfo.DataBean) path;

        Log.e("TAG","ThumbUrl:"+info.getThumbUrl());
        Glide.with(context.getApplicationContext())
                .load(info.getThumbUrl())
                .into(imageView);

    }

//    @Override
//    public ImageView createImageView(Context context) {
//        //圆角
//        return new RoundAngleImageView(context);
//    }
}
