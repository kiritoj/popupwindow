# popupwindow
练习了一下底部导航栏的实现
***
练习一下popupWindow的用法
## 效果图
![](https://github.com/kiritoj/popupwindow/blob/master/pic.gif)![](https://github.com/kiritoj/popupwindow/blob/master/yanshi.gif)\
华丽的分割线，记录几个东西
***
* 1 popupwindow的setFocusable(boolean focusable) 方法设置为ture，可以点击弹窗之外的地方关闭弹窗，同时也可以使用手机的返回键达到同样目的；否则弹窗之外的控件可以正常点击，手机返回键会销毁当前活动。一般与setBackgroundDrawable(Drawable background)  一起使用（不过我没用也可以？？）；
* 2 选中后更改颜色，background使用drawable，字体用color
