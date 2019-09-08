### 第 10 章 文件和异常

#### 动手试一试
* 见: demo.py

#### 10.1 从文件中读取数据

##### 10.1.1 读取整个文件
文件： /chapter10/pi_digits.txt   
读取操作见： /chapter10/file_reader.py 模块

##### 10.1.2 文件路径
* 相对路径
* 绝对路径

##### 10.1.3 逐行读取

##### 10.1.4 把文件的每一行存到列表中

##### 10.1.5 使用文件的内容

##### 10.1.6 包含一百万位的大型文件

##### 10.1.7 圆周率中是否包含你的生日

---

#### 10.2 写入文件
##### 10.2.1 写入空文件
* 见文件： write_message.py

---

#### 10.3 异常
* Python 使用异常这种特殊的对象来管理程序执行期间发生的错误

##### 10.3.1 处理 ZeroDivisionError 异常
* 见模块： /except/division.py

##### 10.3.2 使用 try-except 代码块
* 见模块： /except/division.py

##### 10.3.3 使用异常避免崩溃
* 见模块： /except/division.py

##### 10.3.4 else 代码块
* 见模块： /except/division.py

##### 10.3.5 处理 FileNotFoundError 异常
* 见模块： /except/alice.py

##### 10.3.6 分析文本
* 编程项目中如果用到文学文本，这里提供了很多不受版权限制的文学作品：http://www.gutenberg.org/

##### 10.3.7 使用多个文件
* 把计算文件单词的代码抽取成方法，并且放到单独的模块中。然后统计多个文本文件。
* 见模块： /except/word_count.py

##### 10.3.8 失败是一声不吭
* 有时候希望程序发生异常时，什么都不做，那就在 except 代码块中执行： pass

---

#### 10.4 存储数据

##### 10.4.1 使用 json.dump() 和 json.load()
* 见： /data/number_writer.py

##### 10.4.2 保存和读取用户生成的数据
* 见： /data/remember_me.py

##### 10.4.3 重构
