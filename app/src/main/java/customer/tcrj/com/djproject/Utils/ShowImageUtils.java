package customer.tcrj.com.djproject.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import customer.tcrj.com.djproject.R;


/**
 * Created by leict on 2018/6/20.
 */

public class ShowImageUtils {

    /**
     * (1)
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param errorimg 错误的资源图片
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showImageView(Context context, String url,
                                     ImageView imgeview,int resourceId) {
        RequestOptions options = new RequestOptions()
                .placeholder(resourceId)
                .error(resourceId)
                .centerCrop()
                ;
        Glide.with(context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(options)
                .into(imgeview);


    }

}
