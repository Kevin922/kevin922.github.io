#coding=utf8

def deractor(func):
    def _d(*args, **kw):
        print 'WOW START deractor'
        ret = func(*args, **kw)
        print 'END deractor'
        return ret
    return _d

@deractor
def Iam(name):
    print 'I am k9 %s' % name


if __name__ == '__main__':
    Iam('world')
