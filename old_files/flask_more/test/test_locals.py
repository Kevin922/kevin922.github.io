#coding=utf8

G = 9

def test():
    l = 22
    print 'method 局部变量：', locals()


def test1(a=1, b=2, c=3):
    print a, ' ', b, ' ', c


def test2(*argv, **kwargv):
    print 'argv', argv
    print 'kwargv', kwargv


if __name__ == "__main__":
    print '全局变量', globals()
    test()

    test1(1, 2, 3)

    ll = (1, 2, 3)
    lll = [1, 2, 3]
    test1(ll[0], ll[1], ll[2])

    # get_user(id, name, age, class_num, row)

    test1(*ll)
    test1(*lll)

    # d = {'row': 1, 'age': 2, 'name': 3}
    # get_user(**d)

    d = {'a': 1, 'b': 2, 'c': 3}
    test1(d['a'], d['b'], d['c'])

    test1(c=3, a=1, b=2)
    test1(**d)

    print locals()['ll']

    test2()
    test2(ll)
    test2(*ll)
    test2(d)
    test2(**d)
    test2(*ll, **d)

    test2(1, 2, 3)
    test2(1, 2, 3, a=11, b=22)
