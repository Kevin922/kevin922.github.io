#coding=utf8

import settings
AUTH_TEMPLATE_PATH = settings.template_path + '/auth'

import base

class LoginHandler(tornado.web.RequestHandler):
    def get(self):
        self.render('%s/%s' % (AUTH_TEMPLATE_PATH, 'login.html'))

    def post(self):
        pass


class RegistryHandleer(tornado.web.RequestHandler):
    def get(self):
        self.render('%s/%s' % (AUTH_TEMPLATE_PATH, 'registry.html'))

    def post(self):
        username = self.get_argument('username')
        pw1 = self.get_argument('pw1')
        pw2 = self.get_argument('pw2')

        if not username or not pw1 or not pw2:
            self.write('Please fill all information.')
        elif pw1 != pw2:
            self.write('Please enter the same password.')
        else:
            # TODO 入库 - md5加密密码，密钥使用 用户密码
            self.write('''Username: %s <br/> pw: %s <br/> pw %s''' % (username, pw1, pw2))

