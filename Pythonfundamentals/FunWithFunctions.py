'''Odd/Even:
Create a function called odd_even that counts from 1 to 2000. As your loop executes have your program print the number of that iteration and specify whether it's an odd or even number.'''

def odd_even(start, end):
    for i in range(start, end+1):
        if i%2 == 0:
            odd_even = 'even'
        else:
            odd_even = 'odd'
        print 'Number is ' + str(i) + '. This is an ' + odd_even + ' number.'

odd_even(1,2000)


'''Multiply:
Create a function called 'multiply' that iterates through each value in a list (e.g. a = [2, 4, 10, 16]) and returns a list where each value has been multiplied by the second argument.'''

def multiply(ls, num):
    for i in range(0, len(ls)):
        ls[i] *= num
    return ls

a = [2,4,10,16]
print multiply(a, 5)


'''Hacker Challenge:
Write a function that takes the multiply function call as an argument. Your new function should return the multiplied list as a two-dimensional list. Each internal list should contain the number of 1's as the number in the multiplied list.'''

def layered_multiples(ls):
    new_ls = []
    for i in range(0, len(ls)):
        new_ls.append([1]*ls[i])
    return new_ls

x = layered_multiples(multiply([2,4,5],3))
print x