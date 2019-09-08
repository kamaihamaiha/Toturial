### Android.mk 实现方式

1. 在 src/main/ 下创建文件夹： ndkBuild
2. 在 ndkBuild/ 下创建 hello.c 源文件，并编辑。写一个方法: greet。
3. 在 com.kk.app_androidmk 包下创建一个 java 类：Hello。并编写 native 方法。
4. 回到 hello.c,编写 jni 接口方法。
5. 在 ndkBuild/ 下创建 Android.mk 文件，编辑编译脚本。
6. 在该 module 下的 build.gradle 配置 ndk 的编译脚本 Android.mk 的路径和编译动态库的平台。
7. 在工具栏 Build 中选择 Build APK(s),打开 app_androidmk/build/outputs/apk/debug/app_androidmk-debug.apk   
就发现了 lib/armeabi-v7a/下生成了 libhello.so   
8. 回到 Hello.java 中，加载这个动态库文件。
9. 在 MainActivity 中调用 Hello.java 声明的方法。
10. 编译打包运行，ok！