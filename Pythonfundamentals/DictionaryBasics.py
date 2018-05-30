me = {'name': 'Charlie', 'age': 28, 'country of birth': 'China', 'favorite language': 'Javascript'}

def printKeyValue(dict, key):
    print 'My ' + key + ' is ' + str(dict[key])

printKeyValue(me, 'name')
printKeyValue(me, 'age')
printKeyValue(me, 'country of birth')
printKeyValue(me, 'favorite language')