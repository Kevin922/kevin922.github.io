#coding=utf8

def out(ip_in):
    """
    @note: change ip_in to readable str
    """
    # 第一个性能点吧, xrange，迭代器
    # 第二个性能点, 列表生成 速度比 for-in 快
    ip_part = [ip_in[i: i+8] for i in xrange(0, 32, 8)]

    # 完全使用自己的代码，实现转换
    ip_out = []
    for j in ip_part:
        sum = 0
        for index, jj in enumerate(j):
            print 'index ', index
            print 'jj ', jj
            if jj == '1':
                sum = sum + 2**(8-index-1)
        ip_out.append(str(sum))

    # 第三个性能点，使用join()代替+拼接字符串
    ip_out = '.'.join(ip_out)

    return ip_out


if __name__ == '__main__':
    print 'In: 00000001000000010000000100000001'
    print 'Out: ', out('00000001000000010000000100000001')
    print 'In: 11111111111111111111111111111111'
    print 'Out: ', out('11111111111111111111111111111111')
