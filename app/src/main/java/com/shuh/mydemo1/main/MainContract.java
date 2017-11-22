package com.shuh.mydemo1.main;

import com.shuh.mydemo1.BasePresenter;
import com.shuh.mydemo1.BaseView;
import com.shuh.mydemo1.model.Movie;

import java.util.ArrayList;

/**
 * Created by pc-135 on 2017/11/20.
 */

public interface MainContract {

    interface View extends BaseView<MainPresenter>{

        ArrayList<Movie> getMovieList();
        void refreshData();
    }

    interface Presenter extends BasePresenter{
        void getDataFromHttp(int offset);
    }
}
