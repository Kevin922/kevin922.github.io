#coding=utf8

# What we want: Do not care what&how_many arguments which test() need


def deco(f):
    def _wrap(*argv, **kwargv):  # change here
        print '-- before do sth.'
        print type(argv)
        print type(kwargv)
        f(*argv, **kwargv)
        print '-- after do sth.'
    return _wrap


@deco
def test(a=1, b=2):
    print("test() called. BY %s" % (a))

# What have we done in NO.15?
# test = deco(test)

test(2)

