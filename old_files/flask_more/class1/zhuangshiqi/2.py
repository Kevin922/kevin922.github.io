#coding=utf8

def deco(f):
    print '-- before do sth.'
    f()
    print '-- after do sth.'
    return f


def test():
    print 'teset called'


deco(test)

