## MIT Spring课程

https://pdos.csail.mit.edu/6.824/schedule.html



## SpringMVC流程图

1. **用户请求 --> DispatcherServlet**
2. **DispatcherServlet --> HandlerMapping**，根据url， `HandlerMapping`把请求映射为`HandlerExecutionChain`对象（包含一个`Handler`*页面控制器*对象、多个`HandlerInterceptor`拦截器对象）。通过策略模式，很容易添加新的映射策略。
3. **DispacherServlet --> HandlerAdapter**，`HandlerAdapter`将`Handler`包装为适配器以支持多种类型的处理器。
4. 调用`HttpMessageConverter`将`Request`转为对象。
5. **HandlerAdapter --> Handler**`，调用真正的处理器。返回`ModelAndView`对象（包含模型数据、逻辑视图名）。
6. **ModelAndView的逻辑视图名 --> ViewResolver**，`ViewResolver`将逻辑视图名解析为具体的`View`，通过这种策略模式，方便使用其他视图技术。
7. **View --> 渲染**，`View`会根据传进来的`Model`模型数据进行渲染，`Model`是一个Map
8. 返回控制权给`DispatcherServlet, 返回响应用户。



## Spring事务传播性

7种事务传播性。



## Spring MVC - 封装controller返回值，例如返回json - {code:200, data: "hello", msg: "ok"}

1. [不完整]生命周期 *只看到了springframework部分，未涉及tomcat.servlet*

   1. `DispatcherServlet.doDispatch()`中调用真正处理Request的HanlderAdapter

   2. ```Java
      // Actually invoke the handler.
      mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
      ```

   3. `AbstractHandlerMethodAdapter` 各种模板方法，真正处理当前Request的类需要实现对应方法。

   4. `RequestMappingHandlerAdapter` 实现了`AbstractHandlerMethodAdapter`处理Request的方法。而`RequestMappingHandlerAdapter`支持自定义`setReturnValueHandlers()`返回值。而猜测，这里可以封装返回值。

   5. 成员变量`returnValueHandlers`真正调用，处理当前Request的返回值。证实了NO.4的猜想。

   6. `HandlerMethodReturnValueHandlerComposite`代理了多个实现了接口`HandlerMethodReturnValueHandler`以处理当前请求的返回值的类。这多个实现类，各自有各自方式处理请求返回值。

   7. `GenericeResponseBodyHandler` 而这个类，真正地要处理当前请求的返回值.

   8. `RequestResponseBodyMethodProcessor.handleReturnValue()`类被调用，`ResponseBodyAdvice`也在这时被调用。

   9. `AbstractMessageConverterMethodProcessor`被调用。这个类有能力通过接口 `HttpMessageConverter`  （`GenericHttpMessageConverter`类实现了这个接口）的能力将Request的返回值进行converter。

2. 总结：

   1. 如果你需要将自己的controller返回值，进行converter转换。那么你可以继承`GenericHttpMessageConverter`类。重写其`write`方法来自定义。
   2. 以上的调用中，涉及多种设计模式，其中4种在整个过程中起到了关键作用。而我却不会：
      1. *Decorator*
      2. *Adapter*
      3. *Brigde*
      4. *Composite*
   3. 整体装逼耗时：54 min
   4. 同时，必须要讲，一定不要随便继承或者实现接口`HttpMessageConverter`。然后还打包，通过maven依赖入项目。然后导致当前项目的开发人员一脸懵逼地发现，这返回值结果竟然变了！Spring官方指明的`@ControllerAdvice`来处理，难道不香吗？？？

3. 猜想【若各位大佬知晓确切答案，请评论】：

   1. 你仅仅只是继承了`GenericHttpMessageConverter`类来改写request的返回值。spring怎么知道你定了这些处理方法呢？可能是spring启动时候，会检查所有继承 和 实现过接口`HttpMessageConverter`的类。然后spring会用职责链和代理模式逐个调用这些自定义处理request的类。