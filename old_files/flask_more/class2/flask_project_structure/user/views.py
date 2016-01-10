#coding=utf8
__author__ = 'yanwenyuan'

from manage import app

@app.route('/user')
def user():
    return 'user'
