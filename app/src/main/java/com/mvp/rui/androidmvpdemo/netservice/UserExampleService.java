package com.mvp.rui.androidmvpdemo.netservice;


import com.mvp.rui.androidmvpdemo.model.UserInfo;
import com.rui.mvp.network.basemodel.ResultModel;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rui on 2018/3/9.
 */
public interface UserExampleService {
    //如果你在注解中提供的url是完整的url，则url将作为请求的url。
    //如果你在注解中提供的url是不完整的url，且不以 / 开头，则请求的url为baseUrl+注解中提供的值
    //如果你在注解中提供的url是不完整的url，且以 / 开头，则请求的url为baseUrl的主机部分+注解中提供的值

    /**
     * 登陆
     *
     * @param userKey
     * @return
     */
    @GET("/oto-api/inventory/pklogin")
    Flowable<ResultModel<UserInfo>> login(@Query("userKey") String userKey);


}
