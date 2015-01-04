from django.http import HttpResponse

def hello(request):
    #select mysql
    a = 'hello'
    return render_to_response('test.html', a)
    return HttpResponse("Hello world ! ")
