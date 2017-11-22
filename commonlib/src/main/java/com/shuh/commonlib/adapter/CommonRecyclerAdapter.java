package com.shuh.commonlib.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shuh.commonlib.loader.ImageLoader;

import java.util.List;

/**
 * Created by pc-135 on 2017/11/22.
 */

public abstract class CommonRecyclerAdapter<H extends CommonRecyclerAdapter.ViewHolder> extends RecyclerView.Adapter<H> {

    protected List<? extends BaseModel> list;
    protected Context context;

    public CommonRecyclerAdapter(Context context, List<? extends BaseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        return createHolder(parent, viewType);
    }

    abstract public H createHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(H holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        try {
            return list.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        protected View parent;
        protected SparseArray<View> views = new SparseArray<>();

        public ViewHolder(View itemView) {
            super(itemView);
            parent = itemView;
        }

        public abstract <M extends BaseModel> void setData(M model);

        public View findView(@IdRes int id){
            View v = views.get(id);
            if(v == null){
                v = parent.findViewById(id);
                views.put(id, v);
            }
            return v;
        }

        public TextView getTextView(@IdRes int id){
            return (TextView) findView(id);
        }
        public ViewHolder setText(@IdRes int id, CharSequence text){
            getTextView(id).setText(text);
            return this;
        }

        public ImageView getImageView(@IdRes int id){
            return (ImageView) findView(id);
        }

        public ViewHolder setImage(@IdRes int id, ImageLoader imageLoader, String url){
            imageLoader.setImageUrl(parent, url, getImageView(id));
            return this;
        }
    }

    public static class BaseModel {
    }
}
