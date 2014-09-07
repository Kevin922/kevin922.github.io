#coding=utf8

> Record what I learn about tornado, just base, just some code,

> On ubuntu vps, it can not decode Chinese, I just type in English, just a lazy boy in vim

### What I got first, not really what I want
1. `initialize()` is just like `__init__()`, good method u should use.

2.  `get_argument()` get all parameters.

3. `self.request.files` hanlde file.


### What I want - That is ** asynchronous ** !!
> 异步地几种实现方法，好的总结：
> - Callback argument 回调参数
> - Return a placeholder (Future, Promise, Deferred) 返回占位符
> - Deliver to a queue 传入队列
> - Callback registry (e.g. POSIX signals) 回调注册

1. 非阻塞式异步请求

2. 异步 HTTP 客户端

