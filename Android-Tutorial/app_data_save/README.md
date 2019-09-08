### 数据持久化
* 文件存储、SharedPreference存储、数据库存储

#### 文件存储

#### SharedPreference存储

#### 数据库存储

##### 用 sqlite3 命令操作数据库
```
    #打开数据库,数据库名含扩展名
    sqlite3 databaseName
    #查看所有表格
    .table
    #查看建表语句
    .schema
    #可以直接使用 SQL 语句查询数据库表。如：
    select * frome tableName
```

##### CRUD 增删改查操作

* 修改某一条记录，直接点击就可以了。默认都是把名字改成 new_name
* 删除一条记录，就是长按某一个。
* 也可以直接用 SQL 语句操作

