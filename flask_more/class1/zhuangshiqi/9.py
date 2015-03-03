#coding=utf8

# What we want: deco带参数


def deco(a):
    def _wrap0(f):
        def _wrap(*argv, **kwargv):  # change here
            print '-- before do sth. deco argv: %s' % a
            f(*argv, **kwargv)
            _wrap0(f)
            print '-- after do sth. deco argv: %s' % a
        return _wrap
    return _wrap0


@deco(1)
def test(a=1):
    print("test() called. BY %s" % (a))

# What have we done in NO.15?
# test = deco(1)(test)

test(2)