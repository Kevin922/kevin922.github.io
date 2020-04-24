> 摘自：https://www.cnblogs.com/huanongying/p/7021555.html

### 事务4种隔离级别

#### 事务并发的问题

1. 脏读：事务A读到了事务B修改的数据，事务B回滚，事务A读到的是脏数据。
2. 不可重复度：事务A多次读id=1的数据，事务B多次修改并提交了id=1的数据。事务A多次读到id=1的数据结果都不一样。
3. 幻读：管理员A将学生成绩从数字改为ABCDE五个等级。这期间，管理员B插入一条具体分数的数据。管理员A修改结束后发现还有一条记录依然是具体分数，好像产生了幻觉。

> 不可重复读侧重于修改；幻读侧重于增加或删除

#### MySQL事务隔离级别

``` 
事务隔离级别								脏读		不可重复度		幻读
读未提交read-uncommitted		true		true			true
读已提交read-commmitted			false		true			true
可重复读repeatable-read			false		false			true
串行化serializable					false			false			false
```



## utf8和utf8mb4编码

**utf8mb4**的编码，mb4就是**most bytes 4**。

mysql支持的 utf8 编码最大字符长度为 3 字节，如果遇到 4 字节的宽字符就会插入异常了。

> 三个字节的 UTF-8 最大能编码的 Unicode 字符是 0xffff，也就是 Unicode 中的基本多文种平面（BMP）。也就是说，任何不在基本多文本平面的 Unicode字符，都无法使用 Mysql 的 utf8 字符集存储。包括 Emoji 表情（Emoji 是一种特殊的 Unicode 编码，常见于 ios 和 android 手机上），和很多不常用的汉字，以及任何新增的 Unicode 字符等等。

## 编码排序规则

那么偶尔看到**utf8_general_ci**等等，这些就是排序规则。

> utf8_unicode_ci比较准确，utf8_general_ci速度比较快。通常情况下 utf8_general_ci的准确性就够我们用的了，在我看过很多程序源码后，发现它们大多数也用的是utf8_general_ci，所以新建数据 库时一般选用utf8_general_ci就可以了
>     如果是utf8mb4那么对应的就是 utf8mb4_general_ci,  utf8mb4_unicode_ci