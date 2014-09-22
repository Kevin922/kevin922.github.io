#coding=utf8

import requests
from xml.etree import ElementTree

from django.http import HttpResponse

from test_rss.models import RssContent


def get(request):
    """ get xml content views """

    def _get_data(get_list=None):
        """ 获取xml中数据 """

        assert(get_list is not None)

        url = 'http://ax.phobos.apple.com.edgesuite.net/WebObjects/MZStore.woa/wpa/MRSS/newreleases/limit=300/rss.xml'
        a = requests.get(url)
        tree = ElementTree.fromstring(a.content)
        for elem in tree.iter('item'):
            temp = RssContent()
            for i in elem:
                # 根据自己的需求，处理一下xml数据
                for j in get_list:
                    #! coverArt 需要单独处理，先实现功能，细节稍等处理

                    if i.tag.endswith(j):
                        if j == 'category':
                            #! 这个地方设计得不好，稍微调整表结构就能搞定
                            setattr(temp, 'genre', i.text)
                        else:
                            setattr(temp, j, i.text)

            temp.save()

    get_list = ('artist', 'artistLink', 'album', 'albumLink',
            'albumPrice', 'category', 'coverArt', 'releasedate')
    _get_data(get_list)
    return HttpResponse('Ok, go to index, have a look')


def index(request):
    """ 偷个懒，没写render 和 template 
        我先把功能实现了，再说别的"""
       
    content = '''
    <pre>
    id = %s
    artist = %s
    artistLink = %s
    album = %s
    albumLink = %s
    albumPrice = %s
    genre = mod = %s
    coverArt = %s
    releaseDate = %s
    </pre>
    <br/>
    '''

    all_item = RssContent.objects.all()
    out_html = []
    for l in all_item:
        ret = content % (l.id, l.artist, l.artistLink, l.album, l.albumLink,
                l.albumPrice, l.genre, l.coverArt, l.releasedate)
        out_html.append(ret)

    result = ''.join(out_html)

    return HttpResponse(result)
