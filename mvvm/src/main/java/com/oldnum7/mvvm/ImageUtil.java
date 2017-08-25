package com.oldnum7.mvvm;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/25/18:10
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class ImageUtil {

    @BindingAdapter({"image"})
    public static void imageLoader(ImageView imageView, String url) {
//        ImageLoader.getInstance().displayImage(url, imageView);
        imageView.setImageResource(R.mipmap.ic_launcher_round);
    }
}
