package com.shuh.mydemo1;

import android.app.Application;

import com.shuh.commonlib.loader.GlideImageLoader;
import com.shuh.commonlib.loader.ImageLoader;

/**
 * Created by pc-135 on 2017/11/22.
 */

public class MyApplication extends Application {

    private GlideImageLoader mImageLoader;
    private static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
        application = this;
    }

    public static MyApplication getApplication(){
        return application;
    }

    private void initImageLoader(){
        mImageLoader = new GlideImageLoader();
    }

    public ImageLoader getImageLoader(){
        return mImageLoader;
    }
}
