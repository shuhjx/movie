package com.shuh.mydemo1.api;

import com.shuh.mydemo1.model.Cinema;
import com.shuh.mydemo1.model.Comment;
import com.shuh.mydemo1.model.Movie;
import com.shuh.mydemo1.model.Seat;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * http://www.jianshu.com/p/9855610eb1d4
 * Created by pc-135 on 2017/11/20.
 */

public interface MovieApiService {

    String BASE_URL = "http://m.maoyan.com/";
    /**
     * 查询出首页电影列表
     * http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=10
     * request :
     * type=hot 类型
     * offset : 数据开始位置
     * limit ：偏移量
     */
    @GET("movie/list.json")
    Observable<List<Movie>> movies(@Query("type") String type,
                                   @Query("offset") int offset,
                                   @Query("limit") int limit);

    /**
     * 查出电影详情(包含评论)
     * http://m.maoyan.com/movie/xxxx.json
     * request:
     * 这里直接在将xxxx换成movieid 例子 246363.json
     */
    @GET("{id}.json")
    Observable<Movie> movieDetail(@Path("id") int id);

    /**
     * 加载更多评论
     * http://m.maoyan.com/comments.json?movieid=246363&limit=5&offset=5
     * request
     * movieid : 电影id
     * limit ： 同上
     * offset ：同上
     */
    @GET("comments.json")
    Observable<List<Comment>> comments(@Query("movieid") int movieid,
                                    @Query("offset") int offset,
                                    @Query("limit") int limit);


    /**
     * 查出影院
     * http://m.maoyan.com/cinemas.json
     * 猫眼的服务器会根据你的ip段加载出你本地的影院
     */
    @GET("cinemas.json")
    Observable<List<Cinema>> cinemas();

    /**
     * 查询出影院详情
     * http://m.maoyan.com/showtime/wrap.json?cinemaid=11533&movieid=
     * request
     * cinemaid : 影院id
     * movieid : 电影id
     */
    @GET("showtime/wrap.json")
    Observable<Cinema> cinemaDetail(@Query("cinemaid") int cinemaid,
                              @Query("movieid") int movieid);

    /**
     * 选座
     * http://m.maoyan.com/show/seats?showId=76304&showDate=2015-06-05
     */
    @GET("show/seats")
    Observable<List<Seat>> seats(@Query("showId") int showId,
                           @Query("showDate") String showDate);
}
