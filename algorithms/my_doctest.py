# file my_test.py
def test(x): 
    '''''
    >>> test(2)
    4
    >>> test(3)
    10
    ''' 
    return x*x 

if __name__ == '__main__': 
    import doctest, my_test 
    doctest.testmod(my_test)
