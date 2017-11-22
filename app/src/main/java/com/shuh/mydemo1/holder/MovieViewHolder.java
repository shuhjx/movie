package com.shuh.mydemo1.holder;

import android.view.View;

import com.shuh.commonlib.adapter.CommonRecyclerAdapter;
import com.shuh.commonlib.loader.ImageLoader;
import com.shuh.mydemo1.MyApplication;
import com.shuh.mydemo1.R;
import com.shuh.mydemo1.model.Movie;

/**
 * Created by pc-135 on 2017/11/22.
 */

public class MovieViewHolder extends CommonRecyclerAdapter.ViewHolder {

    private ImageLoader mImageLoader;
    public MovieViewHolder(View itemView) {
        super(itemView);
        mImageLoader = MyApplication.getApplication().getImageLoader();
    }

    @Override
    public <M extends CommonRecyclerAdapter.BaseModel> void setData(M model) {
        Movie m = (Movie) model;
        setImage(R.id.imageView, mImageLoader, m.getImg())
                .setText(R.id.textView1, m.getNm())
                .setText(R.id.textView2, m.getCat())
                .setText(R.id.textView3, "主演:"+m.getStar())
                .setText(R.id.textView4, m.getRt())
                .setText(R.id.textView5, m.getSc()+"分");

    }
}
