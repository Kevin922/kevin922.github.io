#coding=utf8

import urllib
import datetime
import time

import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
import tornado.httpclient

from tornado.options import define, options
define('port', default=8000, help='run on happy coding', type=int)

class IndexHandler(tornado.web.RequestHandler):
    @tornado.web.asynchronous
    def get(self):
        query = self.get_argument('q')
        client = tornado.httpclient.HTTPClient()
        responce = client.fetch('http://legacy.python.org/dev/peps/pep-3333/')

        # start receive data
        body = responce.body
        result_count = len(body)
        now = datetime.datetime.utcnow()
        self.write("""
            <div style="text-align: center">
                <div style="font-size: 72px">%s</div>
                <div style="font-size: 144px">%s</div>
            </div>""" % (result_count, now))
        self.finish()


if __name__ == "__main__":
    tornado.options.parse_command_line()
    application = tornado.web.Application(handlers=[(r"/", IndexHandler),])
    http_server = tornado.httpserver.HTTPServer(application)
    http_server.listen(options.port)
    tornado.ioloop.IOLoop.instance().start()
