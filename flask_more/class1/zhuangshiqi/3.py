#coding=utf8

# What we want: test()
# NOT: deco(test)

def deco(f):
    def _wrap():
        print '-- before do sth.'
        f()
        print '-- after do sth.'
    return _wrap


def test():
    print 'teset called'


test = deco(test)

test()
