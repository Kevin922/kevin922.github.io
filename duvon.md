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
