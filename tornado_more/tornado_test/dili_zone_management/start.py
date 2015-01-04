#coding=utf8

import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web

from tornado.options import define, options
define("port", default=8000, help="run on the given port", type=int)


# set url; set setting
import settings
import url
app = tornado.web.Application(template_path=settings.template_path,
        cookie_secret=settings.cookie_secret,
        xsrf_cookies=settings.xsrf_cookies,
        handlers=url.handlers,
        )

if __name__ == "__main__":
    print 'k9 Lee do it, begin. Listen on localhost:8000'
    tornado.options.parse_command_line()
    http_server = tornado.httpserver.HTTPServer(app)
    http_server.listen(options.port)
    tornado.ioloop.IOLoop.instance().start()
