# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#反射的类不能被混淆
#AndroidMainfrest中的类不能混淆，即四大组件和application的子类和framework层下所有的类默认不会进行混淆，自定义的View不会被混淆，这些在AS中不需要加入；

#与服务端交互，GSON的解析对象不能混淆，否则无法解析出数据；

#使用第三方的库或SDK时，通常需要加入混淆规则，避免进行混淆；

#用到Webview的JS调用时，也需要保证写的接口方法不混淆

#表示proguard对代码进行迭代优化的次数，Android一般为5
-optimizationpasses 7
#忽略警告
-ignorewarning
#摩天轮打包时使用的proguard，摩天轮打包会覆盖demo中的proguard.cfg
#关闭优化
#-dontoptimize
#不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度
#-dontpreverify

#混淆时是否记录日志
# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
-verbose
# 混淆时所采用的算法
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#-allowaccessmodification
#-printmapping map.txt
# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers
# 避免混淆泛型
#-keepattributes Signature
# 抛出异常时保留代码行号
#-keepattributes SourceFile,LineNumberTable

-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,EnclosingMethod

# Keep names - Native method names. Keep all native class/method names.
-keepclasseswithmembers,allowshrinking class * {
    native <methods>;
}
#不混淆拥有原生成员方法的类，但是有可能会被优化时删除
-keepclasseswithmembernames class * {
    native <methods>;
}

#不混淆拥有以下改构造方法的类，不会被删除
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#不混淆拥有以下改构造方法的类，不会被删除
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#不混淆继承该类的子类的以下方法
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

#不混淆该类的以下成员方法，
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#Parcelable的子类和Creator静态成员变量不混淆，否则会产生Android.os.BadParcelableException异常；
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保护注解
-keepattributes  *Annotation*

-keep public class * extends android.app.*{*;}
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.preference.Preference
-keep public class * extends android.os.IInterface
-keep public class * extends android.os.ResultReceiver
-keep public class * extends android.appwidget.AppWidgetProvider
-keep public class * extends android.webkit.*{*;}
-keep public class * extends android.widget.*{*;}

-keep  class android.**{*;}
-keep  class android.app.*$*{*;}
-keep  class * extends android.support.v4.app.Fragment{*;}
-keep  class * extends android.widget.**{*;}
-keep  class * extends android.view.View{*;}
-keep  class * implements android.os.Handler.Callback{*;}
-keep  class * implements android.os.IBinder{*;}
-keep  class * implements Handler.Callback{*;}
-keep  interface * extends android.os.IInterface{*;}
-keep  interface **{*;}
-keep class android.support.** { *; }
-keep class * extends android.support.**{*;}
-keep public class * extends android.app.Fragment

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**


-dontwarn android.support.v4.**
-keep class com.blueware.** { *; }
-keep class com.google.android.** { *; }

## AndroidEventBus
#-keep class org.simple.** { *; }
#-keep interface org.simple.** { *; }
#-keepclassmembers class * {
#    @org.simple.eventbus.Subscriber <methods>;
#}

# ButterKnife
-keep class **$$ViewInjector { *; }
-keep class *$$ViewInjector { *; }
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

## EventBus
##-keepattributes *Annotation*
#-keepclassmembers class ** {
#    @org.greenrobot.eventbus.Subscribe <methods>;
#}
#-keep enum org.greenrobot.eventbus.ThreadMode { *; }

### greenDAO 3（官网配置）
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
    public static java.lang.String TABLENAME;
}
-keep class **$Properties

# Gson
-keepattributes Signature-keepattributes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
# 将下面替换成自己的实体类
#-keep class com.example.bean.** { *; }

# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-keep class okhttp3.** { *; }
-keep class okhttp3.internal.http.CacheStrategy { *; }
-keep class okio.** { *; }

# Okio
-dontwarn com.squareup.**
-dontwarn okio.**
-keep public class org.codehaus.* { *; }
-keep public class java.nio.* { *; }

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Retrolambda
-dontwarn java.lang.invoke.*

# RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#不混淆指定包名下的类，及其子类和类里面的内容（方法和变量）
-keep class org.greenrobot.eventbus.util.ThrowableFailureEvent { *; }
-keep class com.google.gson.** { *; }
-keep class retrofit2.** { *; }
-keep class rx.** { *; }

#反射的类不能混淆
-keep class org.eclipse.paho.client.mqttv3.internal.MIDPCatalog { *; }
-keep class com.ibm.mqttdirect.modules.local.bindings.localListener { *; }
-keep class sun.security.ssl.SSLContextImpl { *; }

#不混淆Serializable接口的子类中指定的某些成员变量和方法
-keep class * implements java.io.Serializable {*;}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#不混淆EventBus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode {
      *;
}

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

#基础数据模板，避免混淆后无法解析
#-keep class com.soyute.inventory.data.model.**{ *; }


#自定义类库
#-keep class com.soyute.inventory.widget.** { *; }
#-keep class com.soyute.inventory.util.** { *; }

#不混淆一个类里面的内部类
#-keep class com.soyute.inventory.ui.check.adapter.CheckDetailsAdapter$ViewHolder { *; }


#BRVAH适配器的混淆配置
-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(...);
}

