package com.shuh.commonlib.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by pc-135 on 2017/11/22.
 */

public class ScreenUtils {
    private static int screenWidth = -1;
    private static int screenHeight = -1;
    public static int getScreenWidth(Context context){
        if(screenWidth == -1){
            Resources resources = context.getResources();
            DisplayMetrics dm = resources.getDisplayMetrics();
//            float density = dm.density;
            screenWidth = dm.widthPixels;
        }
        return screenWidth;
    }

    public static int getScreenHeight(Context context){
        if(screenHeight == -1){
            Resources resources = context.getResources();
            DisplayMetrics dm = resources.getDisplayMetrics();
//            float density = dm.density;
            screenHeight = dm.heightPixels;
        }
        return screenHeight;
    }

    public static int calHeight(Context context, int width, int height){
        return (int) ((double) getScreenWidth(context) * height) / width;
    }

    public static int calWidth(Context context, int height){
        return (int) ((double)getScreenWidth(context)*height)/getScreenHeight(context);
    }
}
