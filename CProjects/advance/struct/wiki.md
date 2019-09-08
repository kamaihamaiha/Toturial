### 结构

可以表达出很多数据。举个例子：

1. 声明

```c
struct date {
	int year;
	int month;
	int day;
};
//记住，结构的声明实际上也就是一个语句，要用 ";" 结束。
```

2. 使用

```c
struct date today;
today.year = 2019;
today.month = 07;
today.day = 16;
//输出
printf("Today's date is %i-%i-%i.\n",today.year,today.month,today.day);
```

---

#### 声明的形式

1：

```c
struct point{
	int x;
	int y;
};
```

2:

```c
struct {
	int x;
	int y;
} p1, p2;
```

3:

```c
struct point {
	int x;
	int y;
} p1,p2;
```

---

#### 初始化

以

```c
struct date {
	int year;
	int month;
	int day;
};
```

为例：

```c
struct date today = {2019,07,16};
struct date tomorrow = {.year=2019,.month=07,.day=17};
struct date future = {.year=2099};
```

---

#### 指向结构的指针

当结构在函数中作为参数时，传递的是一个副本，而不是带有地址的结构变量本身。因此推荐的方式是，使用指针。

```c
struct date {
	int year;
	int month;
	int day;
} myday;

struct date *p = &myday;
(*p).month = 12;
//更简单的方式：
p->month = 12;
```

