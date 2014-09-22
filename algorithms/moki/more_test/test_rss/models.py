#coding=utf8

from django.db import models

class RssContent(models.Model):
    artist = models.CharField(max_length=50, default='', null=True) # 艺人名字
    artistLink = models.CharField(max_length=200, default='', null=True) # 艺人链接
    album = models.CharField(max_length=50, default='', null=True) # 唱片名字
    albumLink = models.CharField(max_length=200, default='', null=True) # 唱片链接
    albumPrice = models.CharField(max_length=20, default='', null=True) # 唱片价格
    genre = models.CharField(max_length=50, default='', null=True, db_index=True) # 唱片流派
    coverArt = models.CharField(max_length=300, default='', null=True) # 唱片封面图片链接
    releasedate = models.CharField(max_length=50, default='', null=True) # 唱片发行日期

    create_time = models.DateTimeField('创建记录时间', auto_now_add=True) # 上传数据时间

