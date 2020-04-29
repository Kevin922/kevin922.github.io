1. 今天做性能调优，发现简单查询的接口速度慢。SQL速度在几十毫秒，但是代码中有几百毫秒的执行时间。代码没有调用RPC或者启动线程。注意到使用getBean()方法。怀疑此处性能有问题。
目前理解，性能优化不是线性学习过程。更多需要对基础知识的感悟理解。
2. 今明两日做实验，先尝试解决问题。若能验证成功，再写定量分析。
3. 此处区分两个概念：依赖注入 与 依赖查找。



> https://stackoverflow.com/questions/54869486/performance-of-spring-autowire-vs-getbeanclassname/54873871#54873871

I do not think 'using spring' is relative to 'you shouldn't really care about the performance'. This question based on using spring, the performance between `getBean` and `@autowired`. I think there are two concept 'dependency lookup' and 'dependency inject'. getBean is dependency lookup. @autowired is dependency inject. This question is good.

