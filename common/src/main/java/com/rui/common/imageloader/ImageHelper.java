package com.rui.common.imageloader;//package com.souyute.sytbook.imageload;
//
//import android.text.TextUtils;
//
//import static android.R.attr.host;
//
///**
// * Created by rui on 18/9/3.
// */
//public class ImageHelper {
//
//
//    public static final String HTTP = "http://";
//    public static final String HTTPS = "https://";
//    public static final String FILE = "file://";
//
//    public static String addImageDomain(String url) {
////        if (TextUtils.isEmpty(url)) {
////            return "";
////        }
////        if (url.startsWith(HTTP) || url.startsWith(HTTPS) || url.startsWith(FILE)) {
////            return url;
////        }
////        if (YunStoreModel.getYunStoreModel() == null) {
////            return url;
////        }
////
////        String host = YunStoreModel.getYunStoreModel().host;
////
//////        LogUtils.i("ImageHelper", "----------------->host="+host);
////        if (TextUtils.isEmpty(host)) {
////            host = "";
////        } else if (!host.startsWith(HTTPS) && !host.startsWith(HTTP)) {
////            host = String.format("http://%s/", host);
////        }
////        YunStoreModel.getYunStoreModel().host = host;
//
//        return host + url;
////        return AppVersionModel.getAppVersionModel().img_server + url;
//    }
//
//    public static String addImageDomain2(String url) {
//        if (TextUtils.isEmpty(url)) {
//            return "";
//        }
//        if (url.startsWith(HTTP)) {
//            return url;
//        }
//
//        return "http://101.200.72.127/imgs/" + url;
//    }
//
//    /**
//     * 本地图片加载时，需要给地址添加file://开头标记
//     *
//     * @param path
//     * @return
//     */
//    public static String addLocalFileFlag(String path) {
//        if (TextUtils.isEmpty(path))
//            return "";
//        if (path.startsWith(FILE) || path.startsWith(HTTP))
//            return path;
//        return FILE + path;
//    }
//
//}
