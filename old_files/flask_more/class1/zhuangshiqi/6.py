#coding=utf8

# What we want: test(a=1), with argument
# NOT: test()


def deco(f):
    def _wrap():
        print '-- before do sth.'
        f()
        print '-- after do sth.'
    return _wrap


@deco
def test(a=1):
    print("test() called. BY %s" % (a))

# What have we done in NO.15?
# test = deco(test)

test(2)
