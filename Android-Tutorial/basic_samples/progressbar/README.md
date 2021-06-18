## ProgressBar 用法

- 水平进度条，自定义样式。

1. XML 中 ProgressBar:

   ```xml
   <ProgressBar
               android:progress="33"
               android:max="100"
               style="?android:attr/progressBarStyleHorizontal" // 这个很重要，要加上
               android:progressDrawable="@drawable/widget_progress_bg"
               android:layout_marginRight="4dp"
               android:layout_marginLeft="4dp"
               android:layout_alignParentBottom="true"
               android:layout_height="1.5dp"/>
   ```

   

2. 自定义样式：widget_progress_bg.xml:

   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <layer-list xmlns:tools="http://schemas.android.com/tools"
       xmlns:android="http://schemas.android.com/apk/res/android"
       tools:ignore="MissingDefaultResource">
   
       <item android:id="@android:id/background">
       <shape>
           <solid android:color="@color/transparent"/> // 自己定义的颜色
       </shape>
   </item>
   
       <item android:id="@android:id/progress">
           <clip>
               <shape>
                   <solid android:color="@color/app_color"/> // 自己定义的颜色
               </shape>
           </clip>
       </item>
   </layer-list>
   ```

   

