### 题目选择
1. 第一题是转换单位，可以实现`转换类`，`文本处理类`, 或者过程化编程就好. 还是可以考虑。
2. 第二题是`图`的操作，数据结构，暂不考虑。回忆一下严蔚敏数据结构，可以实现的。
3. 第三题，题目描述最少，最像是现实生活的问题，我选择这个。



### 第三题的设计

#### 配置要求
1. python 2.7.x


#### 概述
设计内容是我国庆时候想的，国庆结束第一天实现coding。

迭代3次：

1. 面向对象。实现Hotel类。用户类-包括，比较比较方法。可以处理‘Hotel的比较、选择’。
2. 测试用例，`doctest`添加测试用例上去。
3. 像个产品。bottle是我想看看源码的python框架，答答题顺便用一下。

##### 可以做的改进点，未做
- 4. 我还想实现一个python的单例模式... 我怎么感觉自己想要得越来越多呢... 让我写这样的代码很爽！
- 5. 正则检查用户输入, 输入错误，直接raise error

#### Step 1 面向对象 - OK - User.compare()记录了缺陷
1. 实现2个类.
2. 重载`>`运算符


#### Step 2. 测试用例 - OK - 直接 python Hotel.py, 就可以执行测试
1. 添加 `doctest`


#### Step 3. 用bottle框架 - 
1. 用bottle 实现一个用户的交互, bottle最为简洁，最适合这次场景