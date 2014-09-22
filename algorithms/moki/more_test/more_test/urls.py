from django.conf.urls import patterns, include, url
from django.contrib import admin

urlpatterns = patterns('views',
    # Examples:
    # url(r'^$', 'more_test.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),
    url(r'^hello/', include('test_rss.urls')),
)
