# Write code that prints all the odd numbers from 1 to 1000. Use the for loop and don't use a list to do this exercise.

for i in range(1, 1001, 2):
    print i

# Create another program that prints all the multiples of 5 from 5 to 1,000,000.'''

for i in range(5, 1000001, 5):
    print i

# Create a program that prints the sum of all the values in the list: a = [1, 2, 5, 10, 255, 3]. Then print the average of the values.

a = [1, 2, 5, 10, 255, 3]
sum = 0
for i in a:
    sum += i
print sum
print sum/len(a)