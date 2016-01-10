#coding=utf8
__author__ = 'yanwenyuan'

from flask import Flask
app = Flask(__name__)

@app.route("/", methods=['GET'])
def hello():
    return "ROOT"

import user

if __name__ == "__main__":
    app.run()
