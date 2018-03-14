package com.mvp.rui.androidmvpdemo.module.networkservice;

import com.mvp.rui.androidmvpdemo.common.network.basemodel.ResultModel;
import com.mvp.rui.androidmvpdemo.module.model.InfoCategory;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeService {

    /**
     * 全部栏目接口
     *
     * @return
     */
    @GET("/v1/info/mycategorys")
    Single<ResultModel<List<InfoCategory>>> getCategorys(
            @Query("token") String token
    );

}
