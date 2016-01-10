#!/usr/bin/env python
# -*- coding: utf-8 -*-

from hotel import Hotel, User
from bottle import route, run, request

@route('/user_ask', method='POST')
def user_compare():
    """ 请用 postman 之类的工具，
    或者 代码: `import requests; requests.post()` 
    
    请求地址: http://localhost:8888/user_ask
    传入数据: Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)
    """

    # 建立现有的酒店列表
    #import pudb; pu.db # 短点工具，可以直接植入断点
    hotel_list = (Hotel(name='Lakewood', rate=3, \
                weekday_fee={'Regular': 110, 'Rewards': 80}, \
                weekend_fee={'Regular': 90, 'Rewards': 80}), \
            Hotel(name='Bridgewood', rate=4, \
                weekday_fee={'Regular': 160, 'Rewards': 110}, \
                weekend_fee={'Regular': 60, 'Rewards': 50}), \
            Hotel(name='Ridgewood', rate=5, \
                weekday_fee={'Regular': 220, 'Rewards': 100}, \
                weekend_fee={'Regular': 150, 'Rewards': 40}), \
            )
    user_ask = request.forms.get('user_ask') # 获取用户请求的旅店
    user = User(user_ask)
    return user.compare(hotel_list)

# bottle 启动监听
run(host='localhost', port=8888)
