package com.mvp.rui.androidmvpdemo.netservice;


import com.mvp.rui.androidmvpdemo.model.InfoCategory;
import com.rui.mvp.network.basemodel.ResultModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rui on 2018/3/9.
 */
public interface HomeService {

    /**
     * 全部栏目接口
     *
     * @return
     */
    @GET("/ssmdemo/category/list")
    Single<ResultModel<List<InfoCategory>>> getCategorys(
            @Query("token") String token
    );

}
