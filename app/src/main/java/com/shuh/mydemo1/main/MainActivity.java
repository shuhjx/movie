package com.shuh.mydemo1.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuh.commonlib.BottomBorderItemDecoration;
import com.shuh.commonlib.adapter.CommonRecyclerAdapter;
import com.shuh.mydemo1.R;
import com.shuh.mydemo1.holder.MovieViewHolder;
import com.shuh.mydemo1.model.Movie;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainPresenter mPresenter;
    private RefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ArrayList<Movie> mList;
    private CommonRecyclerAdapter mAdapter;
    private int offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        mPresenter = new MainPresenter(this);
        initViews();
    }

    private void initViews(){
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //刷新
                offset = 0;
                mList.clear();
                mPresenter.getDataFromHttp(offset);
            }
        }).setOnLoadmoreListener(new OnLoadmoreListener() {
            //加载更多
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                offset ++;
                mPresenter.getDataFromHttp(offset);
            }
        });

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new BottomBorderItemDecoration());
        mRecyclerView.setAdapter(mAdapter = new CommonRecyclerAdapter(this, mList) {
            @Override
            public ViewHolder createHolder(ViewGroup parent, int viewType) {
                return new MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false));
            }
        });

    }

    /**********View begin************/
    @Override
    public void setPresenter(@NonNull MainPresenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
    @Override
    public ArrayList<Movie> getMovieList() {
        return mList;
    }
    @Override
    public void refreshData(){
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadmore();

        if(mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }
    /**********View end************/

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }
}
