### fragment

#### 动态添加方式
1. 自定义 fragment 类继承 android.support.v4.app.Fragment，且关联相应 的布局
2. 实例化自定义的 fragment
3. 获取 FragmentManager 实例，通过 getSupportFragmentManager()
4. 开启一个事务 FragmentTransaction,通过 beginTransaction()
5. 向容器内添加或替换 fragment，一般使用 replace(),需要容器的 id 和 fragment 实例
6. 提交事务，通过 commit()

**注意：** 碎片的界面很大，添加后如果按了返回键，就直接退出程序了。为了提升体验，可以
加上返回栈的效果：transaction.addToBackStack(null);

#### 生命周期

![fragment生命周期](/app-fragment/imgs/android-fragment-lifecycle.png)

#### 限定符

* large
* sw600dp

#### 简易版新闻，用 fragment

* 支持手机和平板，2种不同 UI 界面
* 逻辑稍微复杂，需要理一理
