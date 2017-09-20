# TankWar
> 此项目是马士兵老师j2se讲解中的第二个项目，实现了坦克大战游戏基本功能。
## Release 0.1
- 创建游戏窗口（自定义大小位置，大小不可改变）
- 窗口可关闭

  [快速访问](https://github.com/1298630983/TankWar/tree/820bd50ea73df174b1e2baf7856ce82c6387ec6b)
## Release 0.2
- 重写paint方法，画出坦克雏形
- 设置背景色（绿）和坦克色（红）

  [快速访问](https://github.com/1298630983/TankWar/tree/6ce11fc005e38357b4faffab96d71de261f41323)
## Release 0.3
- 让坦克动起来
- 使用双缓冲解决闪烁现象
  - 原因：屏幕刷新率太快，paint方法还没有完成
  - 解决：将所有东西画在虚拟图片上，一次性显示出来
## Release 0.4
- 代码重构
  - 将今后需要多次修改的量定义为常量（如Frame的宽和高） 
  - 常量使用public static final定义
## Release 0.5
- 让坦克听从指挥
  - 添加KeyMonitor键盘监听器类
  - KeyClient添加键盘监听器
## Release 0.6
- 将坦克单独包装成类
- 添加成员变量x，y；draw方法；按键处理方法
- 最后使得合适的方法出现在合适的类中
## Release 0.7
- 让坦克可以在8个方向行走
  1. 添加纪录按键的布尔量
  2. 添加代表方向的量（枚举）
  3. 根据按键状态确定坦克方向
  4. 根据方向进行下一步的移动（move）
## Release 0.8
- 添加子弹类（与Tank类似）
- 在TankClient中添加一发子弹测试
## Release 0.9
- 创建炮筒，根据炮筒方向打出子弹
  1. 增加ctrl按键发射炮弹
  2. 使用fire方法，返回Missile
  3. 新增prDir属性，每次move后根据tank方向确定炮筒方向，炮筒用直线表示（drawLine）
## Release 1.0
- 打出多发炮弹
  - 使用容器放炮弹
  - 每当抬起ctrl时装弹，逐一画出炮弹
- 解决炮弹不消亡的问题
  - 加入炮弹的生死量live（missile）
  - 当炮弹飞出边界就remove
- 解决坦克出界问题
## Release 1.1
- 画出一个敌方坦克
  - 加入区别敌我的量good并设置敌方为蓝色
  - 更新tank构造函数，加入good
- 击毙敌方坦克
  - Missle类中加入hitTank(Tank)方法，返回boolean
  - 碰撞检测的辅助类Rectangle，为Tank和Missle加入getRect()
  - 当坦克被击毙时，坦克和子弹都消失
## Release 1.2
- 加入爆炸
  - 添加爆炸类
  - 爆炸应该存在集合类中
  - 击毙坦克时产生爆炸
- 添加多辆坦克
- 让敌方坦克更加智能
  - 动起来（随机Random）,随机方向移动随机步骤
  - 让敌方坦克发射炮弹（不要太密集，random）
## Release 1.3
- 添加两堵墙
  - 建立Wall类，建立Wall对象
  - 让子弹打击Wall，注意不能穿过Wall
- 让坦克不能穿过墙
  - 记录上一次的位置oldX,oldY
  - 每次move之前记录上次位置
  - 创建stay方法，当撞到时回到之前位置，当碰到墙时stay
- 坦克之间也不能互相穿越
  - 当tank遇到tank时stay
- 超级炮弹
  - 向八个方向发射炮弹，绑定按键A
## Release 1.4
- 主坦克生命
  - 加入life变量
- 给主坦克添加血条
  - 根据life值显示血量
## Release 1.5
- 添加血块补给
  - 添加blood类
  - 给血块运动轨迹，并在eat后消失
- 敌方坦克死光后重新加入
- 我方坦克死后按f2复活

> End