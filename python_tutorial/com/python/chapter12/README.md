### 武装飞船
这是一个游戏！名称：外星人入侵。游戏规则如下：   
1. 玩家控制一艘飞船，该船最初在屏幕底部中央出现。   
2. 左右箭头可以移动飞船，按下空格进行射击。   
3. 游戏开始后，一群外星人在天空中，在屏幕中往下移动。   
4. 玩家的人物是射杀外星人，当所有的外星人都被消灭后，将会出现一群新的外星人，且速度更快。   
5. 外星人撞到飞船或者到达屏幕底部，玩家就损失一艘飞船。损失三艘后，游戏结束。

#### 动手试一试
* 12-1 蓝色天空。见： /blue_sky
* 12-2 游戏角色。见： /game_role

#### 12.2 安装 Pygame
##### Linux + Python 3 或者 OS X系统
* 用 pip 安装 Pygame
* 官网： https://www.pygame.org/wiki/GettingStarted
```
# 这个是教程写的，没法用。
pip install --user hg+http://bitbucket.org/pygame/pygame
# 用 Pygame 官网的方法
python3 -m pip install -U pygame --user
```
* 导入 Pygame
```
python3
import pygame
```
更重要的是，要导入到自己的 IDE 中。
1. 设置 Project INterpreter
2. 点击点击右上角的 +
3. 搜索框中输入 pygame
4. 列表最下面 Install to user's site packages directory(/home/用户名/.local) 打上勾
* pip: 专门下载 Python 包的

**所以先要安装 pip:**

###### 1. 在 Linux 和 OS X 系统中检查是否安装了 pip
```
pip --version
# 如果出现错误，请用下面的：
pip3 --version
```
###### 2. 在 Windows 系统中检查是否安装了 pip
```
python -m pip --version
```
###### 3. 安装 pip
访问 https://bootstrap.pypa.io/get-pip.py。 如果出现对话框就保存文件; 如果 get_pip.py
的代码出现在浏览器中，就复制代码保存为 get-pip.py，然后以管理员身份运行这个文件。   
注意：如果找不到 get-pip.py,请访问：https://pip.pypa.io/

###### 4. 在 Linux 和 OS X 系统安装 pip
```
sudo python get-pip.py
```
###### 5. 在 Windows 系统安装 pip
```
python get-pip.py
```
##### Linux + Python 2.7 
* 用包管理器安装 Pygame

---

#### 12.3 开始游戏项目
见 /alien_invasion/
* 免费素材网站： https://pixabay.com/

##### 步骤
1. 创建 Pygame 窗口以及相应用户输入
2. 设置背景色
3. 创建设置类
4. 添加飞船图像
5. 创建 Ship 类
6. 在屏幕上绘制飞船
7. 重构：模块 game_functions