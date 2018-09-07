package com.mvp.rui.androidmvpdemo.model;


import java.io.Serializable;

/**
 * Created by 0020030 on 18/7/10.
 */
public class UserInfo implements Serializable {

    private static final String TOKEN_KEY = "TOKEN_KEY";
    private static UserInfo mUserInfo;

    //    userId    用户id
//    userName  用户名称
//    userCode  用户编号
//    token     token值（暂未启用）
//    accountId 关联账户id（-1为无关联账户）
    private int userId;
    private String userName;
    private String userCode;
    private String token;
    private int accountId;
    private String mobileNum;

//    public static void saveToken(String token) {
//        SharedPreferencesUtils.saveString(TOKEN_KEY, token);
//    }
//
//    public static String getToken() {
//        return SharedPreferencesUtils.loadString(TOKEN_KEY);
//    }
//
//
//    public static void setUserInfo(UserInfo userInfo) {
//        mUserInfo = userInfo;
//    }
//
//    public static UserInfo getInstence() {
//        return mUserInfo;
//    }


    public static UserInfo getmUserInfo() {
        return mUserInfo;
    }

    public static void setmUserInfo(UserInfo mUserInfo) {
        UserInfo.mUserInfo = mUserInfo;
    }

    public static String getTokenKey() {
        return TOKEN_KEY == null ? "" : TOKEN_KEY;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode == null ? "" : userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getToken() {
        return token == null ? "" : token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getMobileNum() {
        return mobileNum == null ? "" : mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", token='" + token + '\'' +
                ", accountId=" + accountId +
                ", mobileNum='" + mobileNum + '\'' +
                '}';
    }
}
