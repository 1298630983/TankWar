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