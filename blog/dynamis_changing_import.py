#coding=utf8

"""
@note: 动态加载 变化的 包
        Dynamicly import changing module
"""

__author__ = 'k9 Lee'


import sys
import importlib


"""
@important: Does not consider thread safty
"""

def dy_import(name, package=None):
    # Fast path: see if the module has already been imported.
    # @doc: imp
    try:
        sys.modules[name]
    except KeyError:
        # if not found, just import 
        importlib.import_module(name, package)
    else:
        # del and reload module
        print '1'
        del sys.modules[name]
        print '2'
        importlib.import_module(name, package)
        print '3'

