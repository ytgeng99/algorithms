'''Write a program that compares two lists and prints a message depending on if the inputs are identical or not.

Your program should be able to accept and compare two lists: list_one and list_two. If both lists are identical print "The lists are the same". If they are not identical print "The lists are not the same." '''

list_one = [1,2,5,6,2]
list_two = [1,2,5,6,2]

list_one = [1,2,5,6,5]
list_two = [1,2,5,6,5,3]

list_one = [1,2,5,6,5,16]
list_two = [1,2,5,6,5]

list_one = ['celery','carrots','bread','milk']
list_two = ['celery','carrots','bread','cream']

same = True
if len(list_one) != len(list_two):
    print 'The lists are not the same.'
else:
    for i, item in enumerate(list_one):
        if item != list_two[i]:
            same = False
            print 'The lists are not the same.'
            break
    if same:
        print 'The lists are the same.'
