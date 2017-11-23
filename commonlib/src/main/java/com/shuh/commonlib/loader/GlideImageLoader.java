package com.shuh.commonlib.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.shuh.commonlib.R;
import com.shuh.commonlib.utils.DensityUtils;
import com.shuh.commonlib.utils.ScreenUtils;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * https://muyangmin.github.io/glide-docs-cn/int/okhttp3.html
 * Created by pc-135 on 2017/11/22.
 */

public class GlideImageLoader implements ImageLoader {

    private static final GlideImageLoader mInstance = new GlideImageLoader();
    private GlideImageLoader(){}

    public static GlideImageLoader getInstance(){
        return mInstance;
    }

    @Override
    public void setImageUrl(final Context context, String url, final ImageView imageView) {
        checkNotNull(imageView, "imageView == null");
        checkNotNull(url, "url == null");
        GlideApp.with(context)
                .asBitmap()
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.loading)
//                .error(R.mipmap.error)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        imageView.setImageBitmap(resource);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        layoutParams.height = DensityUtils.dip2px(context,130);
                        layoutParams.width = ScreenUtils.calWidth(context, layoutParams.height);
                        imageView.setLayoutParams(layoutParams);
                    }
                });
    }

    @Override
    public void setImageUrl(final View view, String url, final ImageView imageView) {
        checkNotNull(imageView, "imageView == null");
        checkNotNull(url, "url == null");
        GlideApp.with(view)
                .asBitmap()
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.loading)
//                .error(R.mipmap.error)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        imageView.setImageBitmap(resource);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        layoutParams.height = DensityUtils.dip2px(view.getContext(),130);
                        layoutParams.width = ScreenUtils.calWidth(view.getContext(), layoutParams.height);
                        imageView.setLayoutParams(layoutParams);
                    }
                });
    }
}
