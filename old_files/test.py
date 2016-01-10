class Dynamic_object(object):
    def generate(cls, method_name, func):
        setattr(cls, method_name, func)

dynamic_object = Dynamic_object()
dynamic_object.generate('plus_one', lambda x: x + 1)
print dir(dynamic_object)
print '\n'
print dynamic_object.plus_one(2)
