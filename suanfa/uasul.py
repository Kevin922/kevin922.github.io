#coding=utf-8

def getdata():
    import random

    a = []
    for i in range(0, 10):
        a.append(random.randint(0, 100))

    print 'Not sorted: %s' % a
    return a


def bubble_sort(data):
    """
    @note: 每次相邻，两两比较，较大右移
    第一次把最大浮出，第二次第二大
    """
    print '* Bubble sorted is not used in real world'
    length = len(data)
    for i in range(0, length):    # 排序趟数
        for j in range(0, length-i-1):    # 每次排出 最大值
            if data[j] > data[j+1]:
                data[j], data[j+1] = data[j+1], data[j]
    
    print 'Sorted: %s' % data
    return data


def selection_sort(data):
    """
    @note: 每次找出最大，放到最后
    """

    print '* selection sort is too.'
    length = len(data)
    for i in range(0, length): # 排序次数
        exchange_index = length - i - 1
        max_v = max(data[0: length-i]) # 省略了，另外一个 for循环，这个for 循环是为了 找出最大的.
        max_index = data.index(max_v)  # 为了好看，省略了for 的代价，我需要找到下标

        data[exchange_index], data[max_index] = data[max_index], data[exchange_index]

    print 'Sorted: %s' % data
    return data


def quick_sort(data):
    """
    @note: quick sort
    """
    if len(data) < 2: 
        return data
    
    pivot_element = data[1]

    small = [i for i in data if i<pivot_element]
    equal = [i for i in data if i==pivot_element]
    big = [i for i in data if i>pivot_element]

    return quick_sort(small) + equal + quick_sort(big)

if __name__ == '__main__':
    data = getdata()
    bubble_sort(data)
    data = getdata()
    selection_sort(data)
    data = getdata()
    print 'Quick sorted: %s' % quick_sort(data)
