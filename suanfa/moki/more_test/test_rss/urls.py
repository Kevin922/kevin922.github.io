from django.conf.urls import patterns, url

from test_rss import views

urlpatterns = patterns('',
            url(r'^index$', views.index, name='index'),
            url(r'^get$', views.get, name='get_xml'),
            )
