## 内存模型

1. 程序计数器
2. Java虚拟机栈
3. 本地方法栈
4. Java堆
5. 方法区
6. 运行时常量池
7. 直接内存

运行时区域：1、2、3、4、5



## jstack分析

1. https://www.jianshu.com/p/00b0455cd69c



## 参数

> 万物开始

1. -Xms 初始化最小的堆大小
2. -Xmx 初始化最大的堆大小
3. -Xmn 堆的年轻代大小
   1. JVM堆内存 = 年轻代 + 老年代 + 持久代。
      1. 老年代通常大小64m
   2. 年轻代大小会影响老年代。Sun官方推荐为整个堆的 3/8
4. -XX:MetaspaceSize，jdk8中特有数据结构，元数据空间，专门用来存储元数据。
   1. 好文章 - https://club.perfma.com/article/210111
