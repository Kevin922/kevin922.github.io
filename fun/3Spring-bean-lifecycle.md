## Spring bean 生命周期

> 翻译 - https://dzone.com/articles/spring-bean-lifecycle

Spring IoC容器管理Spring beans。Spring bean只是Spring管理的*Java类的实例*。

Spring IoC容器负责：实例化，初始化，并且让beans之间通信（and wiring beans）。容器也管理bean的生命周期。

Spring提供了几种你能用上bean生命周期的方法。比如，一旦bean被实例化，为了这个bean能达到可用状态，你或许需要执行一些初始化。相似地，你或许需要在容器移除bean之前清理一些资源。

这篇文章中，我们会测试Spring bean的生命周期。这就是Spring Framwork如何创建和销毁Spring beans的。

### 总览Spring Bean生命周期

第一部分：

1. Instantiate 实例化
2. Populate Properties 初始化成员变量
3. Call `setBeanName()` of `BeanNameAware` 
4. Call  `setBeanFactory()` of `BeanFactoryWare`
5. Call `setApplicationContext()` of `ApplicationContextAware`
6. Pre-initialization(BeanPostProcessors) 初始化前
7. `afterPropertiesSet()` of Initializing Beans 初始化bean之后
8. Custom init method 自定义初始化方法
9. Post-initialization(BeanPostProcessors) 发布初始化好的bean
10. Bean ready to use

第二部分：

1. 容器停止
2. Disposable Bean's destroy() 一定性bean销毁
3. Call custom Desotroy Method

第一部分：展示了bean从instantiation实例化到可用的不同阶段。

第二部分：展示了Spring IoC容器停止后bean做了什么。

### Aware Interfaces

- `BeanFactoryAware`: `setBeanFactory()`回调方法支持自己的bean实例化工厂。
- `BeanNameAware`：`setBeanName()`回调支持bean的名字。
- `ApplicationContextAware`: `setApplicationContext()`提供了`ApplicationContext`对象。