## MVVM 模型
   
**Model - View - ViewModel**   
在 mvp 的基础上,实现了数据视图绑定(DataBinding)

### DataBinding using
- step1: app module 下 build.gradle 的 android {} 中加上
    ```
    dataBinding {
        enabled = true
    }
    ```
- step2: 布局文件转换为 DataBinding 布局, 选中布局文件的跟布局, Alt + Enter 选择 databinding 即可.
- step3: setContentView(R.layout.activity_main) 修改为 DataBindingUtil.setContentView(activity:this,R.layout.activity_main)