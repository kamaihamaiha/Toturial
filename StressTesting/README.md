## 压力测试

### 1. 问题

1. 为什么开展压力测试？
2. 什么时候开展压力测试？

### 为什么开展压力测试

- 提高产品的稳定性
- 提高产品留存率

### 什么时候开展压力测试？

- 首轮功能测试通过后
- 下班后的夜间进行

---

### 2. 第二部分

- 手工测试场景
- 自动化测试场景
  - 模拟事件流
  - Monkey

### Monkey

- 是发送伪随机用户事件的工具

- 存在于手机系统里面，用 ADB 操作。
- MonkeyScript
- MonkeyRunner



### MonkeyScript

- 是一组可以被 Monkey 识别的命令集合
- 可以完成重复固定的操作

### MonkeyRunner

- 提供了一系列的 API
- 可以完成模拟事件及截图操作

### Monkey 和 MonkeyRunner 区别

- Monkey: 在 adb shell 中，生成用户或者系统的伪随机事件
- MonkeyRunner: 通过 API 定义特定命令和事件控制设备。

### MonkeyRunner APIs

- MonkeyRunner: 用来连接设备或者模拟器。
- MonkeyDevice: 提供安装、卸载应用，发送模拟事件
- MonkeyImage: 完成图像保存，及对比的操作。

### MonkeyRunner 的测试类型

- 多设备控制
- 功能测试
- 回归测试

### 压力测试结果

1. Crash
2. ANR

---

### 3. 实践

#### 第一部分



- 准备测试环境
- 一个 App 的压力测试

#### 准备测试环境

1. Android SDK 环境
2. 准备 Python 环境

#### 一个 App 的压力测试

1. 获取 App 包名
2. 给指定 App 包打压力



##### 获取 app 包名：

```shell
adb logcat | grep START
```

结果如图：

![image-20210530230842729](/Users/kk/Codes/MyTutorial/StressTesting/pics/p-1.png)

绿色框是最后一个 ActivityManager 对应的 START，后面 cmp=com.tencent.qqmusicwatch/.ui.LauncherActvity 就是正在运行的 app 的启动 Activity。包名就是：<span color='green'>com.tencent.qqmusicwatch</span>



##### 给指定 App 包打压力

```shell
adb shell monkey -p package 1000
```



#### 第二部分

Monkey 高级参数的应用

##### 1. Throttle 参数

指定事件之间的间隔

语法：

```shell
adb shell monkey --throttle <milliseconds>
```

##### 2. Seed 参数

指定随机生成数的 seed 值

语法：

```shell
adb shell monkey -s <seed> <event-count>
```

