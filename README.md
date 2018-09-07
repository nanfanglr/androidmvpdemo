# AndroidMvpDemo
这是一个基于mvp架构的Android项目。


##### 计划使用的libraries如下:
* RxJava2
* Dagger2 
* Retrofit2
* Mosby MVP with View State support (v3!)
* Timber
* Glide with a wrapper
* Butterknife 
* Retrolambda
* Stetho
* EasyPermissions 



当Android Studio编译失败，出现以下问题：

Error:Compilation failed; see the compiler error output for details.

可以通过以下的方式获取详细的日志输出，以便分析其中原因：

1、在命令行中进入项目的根目录，或者可以在Android studio的Terminal中直接操作也可以，然后敲入一个命令：

gradlew compileDebug --stacktrace

就可以输出较详细的信息，然后根据命令行给出的提示，还可以在后面加上-info或者-debug的选项得到更详细的信息，于是这个命令可以这样写：

gradlew compileDebug --stacktrace -info

或者：

gradlew compileDebug --stacktrace -debug

2、也可以用这个命令

gradlew compileDebugSources --stacktrace -info
