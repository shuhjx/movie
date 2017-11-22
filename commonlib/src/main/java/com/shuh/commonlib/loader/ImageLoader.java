package com.shuh.commonlib.loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by pc-135 on 2017/11/22.
 */

public interface ImageLoader {

    void setImageUrl(Context context, String url, ImageView imageView);
    //    <F extends Fragment> void setImageUrl(F f, String url, ImageView imageView);
    void setImageUrl(View view, String url, ImageView imageView);
}
