#coding=utf8
import os

# url map
import auth
handlers = [(r'/login', auth.views.LoginHandler), # 登录
        (r'/registry', auth.views.RegistryHandleer), # 注册
        ]
