package com.shuh.mydemo1.main;

import android.support.annotation.NonNull;

import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.google.gson.GsonBuilder;
import com.shuh.mydemo1.api.MovieApiService;
import com.shuh.mydemo1.api.factory.MovieGsonConverterFactory;
import com.shuh.mydemo1.model.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by pc-135 on 2017/11/20.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private Retrofit retrofit;
    private MovieApiService service;
    public MainPresenter(@NonNull MainContract.View mainView){
        mMainView = checkNotNull(mainView, "mainView cannot be null!");
        mMainView.setPresenter(this);
        retrofit = new Retrofit.Builder()
                        .baseUrl(MovieApiService.BASE_URL)
                        .addConverterFactory(MovieGsonConverterFactory.create(new GsonBuilder().create()))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
        service = retrofit.create(MovieApiService.class);

    }

    @Override
    public void subscribe() {
        System.out.println("========subscribe========");
        getDataFromHttp(0);
    }

    @Override
    public void getDataFromHttp(int offset){
        service.movies("hot", offset, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .flatMap(new Function<List<Movie>, Observable<Movie>>() {
                    @Override
                    public Observable<Movie> apply(List<Movie> movies) throws Exception {
                        return Observable.fromIterable(movies);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("========onSubscribe========");
                    }

                    @Override
                    public void onNext(Movie movie) {
                        mMainView.getMovieList().add(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        System.out.println("========onError========");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("========onComplete========");
                        mMainView.refreshData();
                    }
                });

    }


    @Override
    public void unsubscribe() {
        System.out.println("========unsubscribe========");
    }
}
