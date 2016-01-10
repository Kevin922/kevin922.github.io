#coding=utf8

import atexit

@atexit.register
def goodbye():
    print "You are now leaving the Python sector."

if __name__ == '__main__':
    pass
