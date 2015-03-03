#coding=utf8

from flask import Flask
from flask import request
app = Flask(__name__) # Flask 实例. the name of the application package
                        # __name__ python解释器自动设置的特殊变量，如果这个包被import，代表module的名字

"""
print type(app)
print id(app)
print dir(app)
"""

@app.route("/hello", methods=['POST']) # 装饰器
def hello(): # 方法
    print request.data
    print request.form
    return "Hello World!" # 方法默认返回值 Null

if __name__ == "__main__":
    app.run()


"""
1. __name__ 变量
2. __file__ 变量
3. 方法
4. 装饰器
5. flask统一的入口，flask路由url
"""
