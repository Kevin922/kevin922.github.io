#coding=utf8

"""
1. 安装 flask-login 和 flask-openid
2?. 谁知道openid的概念？给讲讲呢
3.
"""
from flask import Flask
#? app到底是个什么？
app = Flask(__name__)


"""
" login
"""
from flask.ext.login import LoginManager, login_required, login_user

login_manager = LoginManager()
login_manager.session_protection = 'strong'
login_manager.login_view = 'auth.login'

from models import User
@login_manager.user_loader
def load_user(userid):
    if userid == '922':
        return User()
    else:
        return None


@app.route("/login")
def login():
    login_user(User())
    return "login"

@app.route("/test")
@login_required
def settings():
    return 'ok, login'

if __name__ == "__main__":
    app.debug = True
    app.run()
