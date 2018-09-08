package com.rui.common.imageloader;

/**
 * Created by linet on 2017/8/22.
 */

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rui.common.R;


/**
 * Class works as our image loading library wrapper.
 */
public class ImageLoader {

    /**
     * 默认加载图片的方法
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayImage(Context context, String url, ImageView imageView) {
        displayImageBase(context, url, imageView, getDefualtOption());
    }

    /**
     * 默认加载显示RequestOptions
     * 默认的loading、error、null图片
     *
     * @return
     */
    private static RequestOptions getDefualtOption() {
        return getOption(R.drawable.img_defualt, R.drawable.error, R.drawable.img_defualt);
    }

    /**
     * 自定义loading、error、null图片的RequestOptions
     *
     * @param loadingDrawable
     * @return
     */
    private static RequestOptions getOption(
            @DrawableRes int loadingDrawable
            , @DrawableRes int errorDrawable
            , @DrawableRes int nullDrawable) {
//        DiskCacheStrategy.ALL 使用DATA和RESOURCE缓存远程数据，仅使用RESOURCE来缓存本地数据。
//        DiskCacheStrategy.NONE 不使用磁盘缓存
//        DiskCacheStrategy.DATA 在资源解码前就将原始数据写入磁盘缓存
//        DiskCacheStrategy.RESOURCE 在资源解码后将数据写入磁盘缓存，即经过缩放等转换后的图片资源。
//        DiskCacheStrategy.AUTOMATIC 根据原始图片数据和资源编码策略来自动选择磁盘缓存策略。
        RequestOptions options = new RequestOptions()
//                .centerCrop()
                .placeholder(loadingDrawable)//加载中默认图片
                .error(errorDrawable)//  加载错误默认图片
                .fallback(nullDrawable)//请求url/model为空
                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .skipMemoryCache(true)//内存缓存
                ;
        return options;
    }

    private static void displayImageBase(Context context
            , String url
            , ImageView imageView
            , RequestOptions options
    ) {
        try {
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载头像的方法，有默认的头像
     *
     * @param context
     * @param uri
     * @param imageView
     */
    public static void displayHeadImage(Context context, String uri, ImageView imageView) {
        displayImage(context
                , uri
                , imageView
                , R.drawable.icon_default_head
                , R.drawable.icon_default_head
                , R.drawable.icon_default_head
        );
    }

    /**
     * 自定义loading、error、null图片的加载方法
     *
     * @param context
     * @param url
     * @param imageView
     * @param loadingDrawable
     */
    public static void displayImage(Context context, String url, ImageView imageView
            , @DrawableRes int loadingDrawable
            , @DrawableRes int errorDrawable
            , @DrawableRes int nullDrawable) {
        displayImageBase(context, url, imageView, getOption(loadingDrawable, errorDrawable, nullDrawable));
    }

    /**
     * 自定义loading图片的加载方法
     *
     * @param context
     * @param url
     * @param imageView
     * @param loadingDrawable
     */
    public static void displayImage(Context context
            , String url
            , ImageView imageView
            , @DrawableRes int loadingDrawable
    ) {
        displayImageBase(context, url, imageView, getOption(loadingDrawable));

    }

    /**
     * 自定义默认的loading图片RequestOptions
     * 此方法默认error、null图片
     *
     * @param loadingDrawable
     * @return
     */
    private static RequestOptions getOption(@DrawableRes int loadingDrawable) {
        return getOption(loadingDrawable, R.drawable.error, R.drawable.img_defualt);
    }


}
