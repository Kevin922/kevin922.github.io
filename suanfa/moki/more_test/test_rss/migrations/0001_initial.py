# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='RssContent',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('artist', models.CharField(default=b'', max_length=50)),
                ('artistLink', models.CharField(default=b'', max_length=200)),
                ('album', models.CharField(default=b'', max_length=50)),
                ('albumLink', models.CharField(default=b'', max_length=200)),
                ('albumPrice', models.CharField(default=b'', max_length=20)),
                ('genre', models.CharField(default=b'', max_length=50)),
                ('coverArt', models.CharField(default=b'', max_length=300)),
                ('releaseDate', models.CharField(default=b'', max_length=50)),
                ('create_time', models.DateTimeField(auto_now_add=True, verbose_name=b'\xe5\x88\x9b\xe5\xbb\xba\xe8\xae\xb0\xe5\xbd\x95\xe6\x97\xb6\xe9\x97\xb4')),
            ],
            options={
            },
            bases=(models.Model,),
        ),
    ]
