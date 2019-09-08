### 自定义数据类型

**typedef**

C 语言提供了一个叫做 typedef 的功能来声明一个已有的数据类型的新名字。比如：

```c
typedef int Length;
// Length 就可以代表 int 了。
```

更复杂的：

```c
typedef long int64_t;
typedef struct ADate {
	int year;
	int month;
	int day;
} Date;

//使用
int64_t num = 12345678912334;
Date today = {2019, 7, 20};
```

