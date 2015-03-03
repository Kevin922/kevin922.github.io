#coding=utf8

# What we want: test(a=1), with argument


def deco(f):
    def _wrap(a):  # change here
        print '-- before do sth.'
        f(a) # change here
        print '-- after do sth.'
    return _wrap


@deco
def test(a=1):
    print("test() called. BY %s" % (a))

# What have we done in NO.15?
# test = deco(test)

#test(2)
test()
