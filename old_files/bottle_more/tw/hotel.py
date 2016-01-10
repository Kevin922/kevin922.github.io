#!/usr/bin/env python
# -*- coding: utf-8 -*-


### Error define - START
class HotelException(Exception):
    """ Hotel 所有异常的父类 """
    pass



class UserInputDateError(HotelException):
    """ 用户输入 日期错误异常 """
    pass

### Error define - END


### Hotel - START
class Hotel(object):
    """ Hotel的操作 """

    def __init__(self, location='', name='', rate=3,
            weekday_fee={'Regular': 220, 'Rewards': 150},
            weekend_fee={'Regular': 150, 'Rewards': 100},
            user_input=None):

        """
        >>> user1 = User('Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)')
        >>> hotel1 = Hotel(name='Lakewood', rate=3, weekday_fee={'Regular': 110, 'Rewards': 80}, weekend_fee={'Regular': 90, 'Rewards': 80})
        >>> hotel2 = Hotel(name='Bridgewood', rate=4, weekday_fee={'Regular': 160, 'Rewards': 110}, weekend_fee={'Regular': 60, 'Rewards': 50})

        >>> hotel1.user_ask(user1.user_input)
        (330, {'weekday_count': 3, 'user_type': 'Regular', 'weekend_count': 0})
        >>> hotel2.user_ask(user1.user_input)
        (480, {'weekday_count': 3, 'user_type': 'Regular', 'weekend_count': 0})
        >>> hotel1 < hotel2
        True
        >>> hotel1 > hotel2
        False

        >>> print min([hotel1, hotel2])
        Lakewood
        """
        self.location = location # 酒店地址
        self.name = name # 酒店名字
        self.rate = rate # 酒店星级
        self.weekday_fee = weekday_fee # 工作日, 对不同顾客价格
        self.weekend_fee = weekend_fee # 节假日，对不同顾客价格
        self.user_input = user_input


    def __str__(self):
        return self.name


    def _calulate(self):
        """ 根据User时间，计算价格 """
        assert self.user_input is not None, 'User `user_ask` to set user_input'
        rls = self.user_input['weekday_count'] * self.weekday_fee[self.user_input['user_type']] \
                + self.user_input['weekend_count'] * self.weekend_fee[self.user_input['user_type']]
        return rls


    def user_ask(self, user_input=None):
        """ 用户询问价格 且 设置用户输入user_input
        user_input: {'user_type': 'Regular', 'weekday_count': 9, 'weekend_count': 2}
        """
        if user_input is not None:
            self.user_input = user_input
        return self._calulate(), self.user_input


    def __lt__(self, other):
        """ 酒店价格比较，重载了 `<` 小于操作符
        !! 如果酒店星级相同，会有bug
        """
        i_fee, user_input = self.user_ask()
        other_fee, user_input = other.user_ask()
        if i_fee < other_fee: # 价格更小
            return True
        elif i_fee == other_fee: # 价格相同，星级更大
            if self.rate > other.rate:
                return True
            elif self.rate == other.rate:
                return True
            else:
                return False
        else:
            return False


    def check_in(self, user_input):
        """ 入住酒店 """
        pass


    def check_out(self):
        """ 离开酒店 """
        pass

### Hotel - END


### User - START
class User(object):
    """ 用户类 - 提供用户希望的操作 - 工具类"""

    def __init__(self, user_input):
        """
        >>> user1 = User('Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)')
        >>> user1.user_input
        {'weekday_count': 3, 'user_type': 'Regular', 'weekend_count': 0}

        >>> user2 = User('Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)')
        >>> user2.user_input
        {'weekday_count': 1, 'user_type': 'Regular', 'weekend_count': 2}

        >>> user3 = User('Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)')
        >>> user3.user_input
        {'weekday_count': 2, 'user_type': 'Rewards', 'weekend_count': 1}

        # 建立酒店
        >>> hotel_list = (Hotel(name='Lakewood', rate=3, \
                        weekday_fee={'Regular': 110, 'Rewards': 80}, \
                        weekend_fee={'Regular': 90, 'Rewards': 80}), \
                    Hotel(name='Bridgewood', rate=4, \
                        weekday_fee={'Regular': 160, 'Rewards': 110}, \
                        weekend_fee={'Regular': 60, 'Rewards': 50}), \
                    Hotel(name='Ridgewood', rate=5, \
                        weekday_fee={'Regular': 220, 'Rewards': 100}, \
                        weekend_fee={'Regular': 150, 'Rewards': 40}), \
                    )

        >>> user1 = User('Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)')
        >>> user2 = User('Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)')
        >>> user3 = User('Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)')

        >>> print user1.compare(hotel_list)
        Lakewood
        >>> print user2.compare(hotel_list)
        Bridgewood
        >>> print user3.compare(hotel_list)
        Ridgewood
        """
        self.user_input = self._handle_user_input(user_input)


    def __str__(self):
        return self.user_input


    def _handle_user_input(self, user_input):
        """ 处理 用户输入, 一段连续的日期
        In: Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)
        Out: {'user_type': 'Regular', 'weekday_count': 9, 'weekend_count': 2}
        """

        def __check_input(user_input):
            """ 用正则表达式检查一下用户的输入，是否符合规范
            if error: raise UserInputDateError """
            pass

        def __count(user_input):
            """ 1. 用户类型
            2. 计算 总共的工作日，总共的周末 """
            import re
            from collections import Counter
            # 1. 获取用户类型
            user_input = user_input.split(':')
            user_type = user_input[0]
            # 2. 计算总共的计数
            pattern = re.compile(r'\((?P<week>\w*)\)')
            match = pattern.findall(user_input[1]) # 正则捕获: ['mon', 'tues', 'wed']
            week_count = Counter(match)
            # 2.1 计算 工作日 总数
            weekday_count = 0
            for weekday in ('mon', 'tues', 'wed', 'thur', 'fri'):
                weekday_count += week_count[weekday]
            # 2.2 计算 周末 总数
            weekend_count = 0
            for weekend in ('sat', 'sun'):
                weekend_count += week_count[weekend]

            return {'user_type': user_type, 'weekday_count': weekday_count, 'weekend_count': weekend_count}

        __check_input(user_input)
        return __count(user_input)


    def compare(self, hotel_list):
        """ 用户行为， 比较价格

        你可能会奇怪我为什么要`user_ask`, 设置酒店的用户输入
        原因:
        1. 我想用 重载操作符
        2. 我想用 min()，

        缺点:
        我也觉得这样的实现方式非常的不优雅，只是暂时没有想到好办法，因为__lt__只能传入两个参数

        优点:
        但是这大大简化了 主函数中的代码, 在User.__init__()中的实例代码
        """
        # 初始化所有hotel实例
        for hotel in hotel_list:
            hotel.user_ask(self.user_input)
        best_for_user = min(hotel_list)
        return best_for_user.name  # 找出最划算的酒店

### User - END


if __name__ == '__main__':
    # 单元测试
    # 所有：>>> 开头的注释代码，都是单元测试

    import doctest
    doctest.testmod()

