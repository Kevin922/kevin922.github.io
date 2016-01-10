# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('test_rss', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='rsscontent',
            name='releaseDate',
        ),
        migrations.AddField(
            model_name='rsscontent',
            name='releasedate',
            field=models.CharField(default=b'', max_length=50, null=True),
            preserve_default=True,
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='album',
            field=models.CharField(default=b'', max_length=50, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='albumLink',
            field=models.CharField(default=b'', max_length=200, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='albumPrice',
            field=models.CharField(default=b'', max_length=20, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='artist',
            field=models.CharField(default=b'', max_length=50, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='artistLink',
            field=models.CharField(default=b'', max_length=200, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='coverArt',
            field=models.CharField(default=b'', max_length=300, null=True),
        ),
        migrations.AlterField(
            model_name='rsscontent',
            name='genre',
            field=models.CharField(default=b'', max_length=50, null=True),
        ),
    ]
