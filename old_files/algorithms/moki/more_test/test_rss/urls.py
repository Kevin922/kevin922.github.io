from django.conf.urls import patterns, url

from test_rss import views

urlpatterns = patterns('',
            url(r'^index$', views.index),
            url(r'^get$', views.get),
            #url(r'^page/(?P<page_num>\d+)$', views.page),
            )
