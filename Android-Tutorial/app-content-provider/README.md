### 内容提供器

#### 运行时权限
由于很多软件店大欺客，常需要很多不必要的权限。所以 Android 开发团队也意识   
到了这个问题，于是在 6.0 系统中加入了运行时权限功能。就是说：用户不需要在   
安装软件的时候一次性授权所有申请的权限，而是在使用软件的收再对某一项权限申
请进行授权。
---
不是所有的权限都需要在运行时申请。权限分成 2 类：普通权限和危险权限。
* 危险权限
```
# 日历
READ_CALENDAR   WRITE_CALENDAR

# 相机
CAMERA

# 通讯录
READ_CONTACTS   WRITE_CONTACTS  GET_CONTACTS

# 位置
ACCESS_FINE_LOCATION    ACCESS_COARSE_LOCATION

# 麦克风
RCORD_AUDIO

# 电话
READ_PHONE_STATE    CALL_PHONE  READ_CALL_LOG   WRITE_CALL_LOG  ADD_VOICEMAIL   USE_SIP PROCESS_OUTGOING_CALLS

# 传感器
BODY_SENSORS

# 短信
SEND_SMS    RECEIVE_SMS READ_SMS    RECEIVE_WAP_PUSH    RCEIVE_MMS

# 存储
READ_EXTERNAL_STORAGE   WRITE_EXTERNAL_STORAGE
```
* 更多权限，请参考[官方地址](http://developer.android.com/reference/android/Manifest.permission.html)

#### 内容提供者

* URI 写法   
也可以使用通配符
* "*" 表示匹配任意长度的任意字符
* "#" 表示匹配任意长度的数字
```
# package.name 填写实际的包名，tableName 实际的表名，1 tableName 表中 id 为 1 的数据。
1. content://package.name.provider/tableName
2. content://package.name.provider/tableName1
```

* 创建自己的内容提供器
```
1.新建一个类继承 ContentProvider
```