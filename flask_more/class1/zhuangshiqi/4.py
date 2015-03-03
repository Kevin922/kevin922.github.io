#coding=utf8

# What we want: test()
# NOT: test = deco(test)


def deco(f):
    def _wrap():
        print '-- before do sth.'
        f()
        print '-- after do sth.'
    return _wrap


@deco
def test():
    print 'teset called'

test()



