#coding=utf8

class User(object):
    id = '922'
    nickname = 'k9'

    def is_authenticated(self):
        """ 是否通过认证 """
        return True

    def is_active(self):
        """ 是否激活，是否被禁止 """
        return True

    def is_anonymous(self):
        """ 是否是匿名用户 """
        return False

    def get_id(self):
        """ 返回数据库的唯一id """
        return u'922'

    def __repr__(self):
        return '<User %r>' % (self.name)
