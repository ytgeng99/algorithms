'''Write a program that takes a list and prints a message for each element in the list, based on that element's data type.

Your program input will always be a list. For each item in the list, test its data type. If the item is a string, concatenate it onto a new string. If it is a number, add it to a running sum. At the end of your program print the string, the number and an analysis of what the array contains. If it contains only one type, print that type, otherwise, print 'mixed'.'''

l = ['magical unicorns',19,'hello',98.98,'world']
'''l = [2,3,1,7,4,12]
l = ['magical','unicorns']
l = []'''
new_str_list = []
sum = 0
str_items = 0
num_items = 0
for item in l:
    if type(item) == str:
        new_str_list.append(item)
        str_items += 1
    elif type(item) == int or type(item) == float:
        sum += item
        num_items += 1

if (str_items == 0 and num_items == 0):
    print 'The array you entered is empty'
elif (str_items > 0 and num_items > 0):
    print 'The array you entered is of mixed type'
elif (str_items != 0 and num_items == 0):
    print 'The array you entered is of string type'
elif (str_items == 0 and num_items != 0):
    print 'The array you entered is of number type'

if (str_items != 0):
    print 'String:', ' '.join(new_str_list)

if (num_items != 0):
    print 'Sum:', sum