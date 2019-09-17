## MVP

Activity 简化,只负责 view 视图. 不直接和 Model(数据层) 交互,而是通过 Presenter 层中转. 如图:

![MVP模型](pics/mvp.jpg)

### suggestions
- 接口规范化
- 使用第三方插件自动生成 mvp 代码,
- 简单的界面,可以不用 mvp
- 部分模块,可以不用接口