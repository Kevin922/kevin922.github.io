class Singleton(object):
    _instance = None
    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Singleton, cls).__new__(
                                cls, *args, **kwargs)
        return cls._instance


if __name__ == '__main__':
    s1=Singleton()
    s2=Singleton()
    if(id(s1)==id(s2)):
        print "Same"
    else:
        print "Different"

"""
时间到了这个时候，我还是会时常想起妈妈。
看到任何文章，看到任何母亲，我都会想起我的妈妈。
一直都在帮助我。
一直一直都在帮助我。
即使我任性妄为的时候。

我想我只能写在这里。
工作时候并不总是合适。
业余时间，或许做些什么嘛？
"""