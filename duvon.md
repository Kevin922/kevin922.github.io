> Do not worry, not one will notice this doc, I will del it later.

### Q1
A: `try... except... else... finally...`

So does `while... else`, `for... else...`

### Q2
A: Yes, python supported multiple inheritance.

```python
class C1(object):
    """ parent 1 """
    
    pass

class C2(object):
    """ parent 2 """
    
    pass
    
class C3(C1, C2):
    """ child """
    
    pass
```

### Q3
A: `xrange(0, 10, 1)`

### Q4
A: No, python doesn't. I just have a lunch, let's continue.

- Rease I guess is about python's Philosophy - simple.

- `if-elif-else` does the same thing.

- and `dict` is good way to solve your problem, too. More than that, `dict` is hash, which is fast way for *find something*.

### Q5
A: I do not know.

I guess maybe python's interpreter can not understand the syntax that *lambda forms in contain statement*.

### Q6
A: python will help you recycle the memory, I guess use *add reference and release*. 

I do not know how python implement this.
But I learn C++ before, that is the same theory:

> If you let `a = 1`, then you let `b = a`, the reference will add 1, then you `del b`, the ref will reduce 1.

> if the reference count is 0, the python's gc will recycle the memory.

> This is a simple and good way, but these is other ways in program langage. Ruby maybe use another way.

> I learn those in <C++ prime> and <the future of code>[http://book.douban.com/subject/24536403/]

### Q7
A: Just talk about 2 points.

1. The most of disadvantage people always metioned is 'Hey, python is really slow, look at my c program~'

> I have to say, python's slow is not the language itself, the reason is the python's interpreter is optimized better.

> At first, java is slow, but today, JVM is really fast. So is V8 for js.

2. process VS thread

> We always use python process to handle user requests, why not use python thread?

> python's interpreter have a *global thread lock*, only one thread hold the lock in the same moment, Which maybe means block.

### Q8
A: 

1. list is mutable, which you just think that is a mutable array.

2. tuple is immutable, a immutable array.

3. dict is a k-v object, but no ordered, if you want you should use *OrderedDict*

4. set is a set in which element is unique, like `a=[1, 1, 2, 3]` is a list, `set(a)` is `[1, 2, 3]`

### Q9
A: `global`

1. advantage. You will have a var to record the same in anywhere.

2. disadvantage. *global var* will let your code more coupling, your module or func depend on the global var. And your code is less readable.

### Q10
A: Yes, python hava private var, but not use keyword, use var's name.

python's interperter will rename the name of variable which's name start with double `__` or single `_`.

```python
class Private_show(object):

    def __init__(self):
        """ Notice, __init__ is system name"""
        
        self.__hello = 'Hi, I am private use __'
```

### Q11
A: 
```python
""" You often use: """

# 1
a = xrange(0, 10)  # 1. save memory, xrange is generator


# 2
with open('a.file', 'rb') as f:
    for l in f:     # f is generator
        print l


# 3        
t = (i for i in range(0, 10))    # guess t is what?
tt = [i for i in range(0, 10)]   # so tt is what??  Have a try ~
type(t)
type(tt)


# 4
def out(a):
    while a < 10:
        yield a
        a = a + 1

for i in out(0):
    print i
```

### Q12
A: A sweet candy. Code show you how and why.

``` python
class A(object):
    """ the same staticmethod """
    
    def static1():
        pass
    
    static1 = staticmethod(static1) # this make static1 a static method, I think it's ok. But...
    
    @staticmethod
    def static2():
        """ Same, just candy: static2 = staticmethod(static2) """
        pass
```

with arguments:
``` python

@d('hello')
def f(): pass

# is same as

f1 = d('hello')  # 1. d reture a func which receive a fucn as argument
f = f1(f)        # 2. do some thing
```

### Q13
A: `class FOO` is the old OOP in python, we suggest you to use `class FOO(object)`, all object have the same base `object`.


### Q14
A: I guess python do not have `++i` or `--i`.

I always use `a = a + 1`, even not use `a += 1`, I think the former is a little bit more explict... Maybe it is just my thinking.


### Q15
A: 

``` python
""" __init__ does the same, if you have to use base's method, use super() """
class father(object):
    def hello(self):
        print 'hello, I am father.'

class child(father):
    def hello(self):
        print 'hello, I am child.'
```


### Q16
A: Good question, let me show you some my old code

``` python

# 1. eval do a expression, 
cmd = '''ADIPrize%s(user_id=data['user_id'], $
                    name=data['name'], $
                    phone=data['phone'],$
                    nick=data['nick'])''' % data['km']$
    ]                                
top_user = eval(cmd)$            
top_user.save()


# exec do a code, like
exec "a = 1"
"""
```


### Q17
A: ok, show you my old code

``` python
#coding=utf8

def mom_data(request, device, sport, func, hope=HOPE_TYPE['LENGTH']):
    """
    @para: for mom,
    1. @request, just get mom data
    2. @device, ((0, u'追踪器'), (1, u'健康秤'), (2, u'咕咚 maybe android'),
                (3, u'咕咚 maybe ios'), (4, u'码表'))
    3. @sport,  ((0, u'走路'), (1, u'跑步'), (2, u'骑行'),
                (3, u'滑雪'), (4, u'滑冰'), (5, u'登山'))
    4. @func, which is a func, add user sports data
    5. hope, which one do u want? `total_length` OR `total_calories`?

    @return: True, 'init' OR False, 'init'
    """
    import json
    import datetime
    from www.product.interface import get_product_type

    assert(isinstance(device, (tuple, list)))
    assert(isinstance(sport, (tuple, list)))
"""
```

### Q18
A: 

``` python 
class A(object):
    a = 1

if __name__ == '__main__':
    """ You can write test code in main """
    
    a = A()
    a_attr = getattr(a, 'a')
    print a_attr
    
    setattr(a, 'a', 2)
    a_attr = getattr(a, 'a')
    print a_attr
```

### Q19
A: Yes, just use one class to get\set the data. I never implement a singleton before.

I guess the simple example is *settings.py*, all process get info from the only one file.

I will finish one later, as one commit, you will see.

```python
pass
```

### Q20
A: 

- `range` will product a list, all element is stored in memory.

- `xrange` will product a iter, just when you want to get, the iter returen one element, less memory used.


### Q21
A: Last year 2013, I read [this](http://www.ibm.com/developerworks/cn/linux/l-cn-python-optim/index.html?ca=dat-).

Those below is what I ofen use, hope is useful for you.

- Chose right data structure. Use `dict` to get what you want, not using find `list` by`for-in` to get.
- Use `join` not `+` to connect string, this alse metioned in <python cookbook>.
- `list comprehension` is faster than `for, append()`.
- built-in func is more faster, cause it is implemented by C module.
- use `xrange()`


### Q22
A: I just read and used `doctest`, that is really simple.
Cause I read some source code of *web.py*, which use `doctest`, the great author.

``` python
# file my_test.py
def test(x): 
    '''''
    >>> test(2)
    4
    >>> test(3)
    9
    ''' 
    return x*x 
     
if __name__ == '__main__': 
    import doctest, my_test 
    doctest.testmod(my_test)
```


### Q23
A: this one I metioned in *private var questtion*.

`__<foo>__` that is python special method, python keep them, like:

- `__file__`, your file name and path
- `__init__`
- `__getattr__`, getattr()
- `__getitem__`, setattr()
- `__add__`, this is really cool, it implement `+`, in C++ is more complex.
- some thing else, all in doc, if I am not sure I will check doc


### Q24
A: wow, I always use 3 way.

- `logging` or print. use `tail -f logging.file | grep "yanwenyuan"`
```python
""" I use this func in my project """
import logging

def print_debug(e, debug_flag):
    if debug_flag:
        logging.error('yanwenyuan %s ', e)
```

- pudb, cause I use vim, pudb is really helpful
``` python
if __main__ == '__main__':
    import pudb; pu.db
    print 'hello'
```

- Just directly read the django or other framework's error page

- sentry, is online report, not debugging tool, but useful.


### Q25
A: 3 ways

- `join`
- `+`
- memoryview


### Q26
A: Maybe you should use `dir()` to get the object's attrs, it read `__dict__`

`__name__` will tell you the object's module name


### Q27
A: Good, No "?:", for now, but have anohter way: `true_out if True else false_out`


### Q28
A: WOW, I do not know. All I know is that add an element in dict `sys.module`, see my [old code](https://github.com/Kevin922/kevin922.github.io/blob/master/blog/dynamis_changing_import.py)

I want to do some werid thing before...
