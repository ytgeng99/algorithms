'''Write a program that prints all the prime numbers and all the perfect squares for all numbers between 100 and 100000.

For all numbers between 100 and 100000 test that number for whether it is prime or a perfect square. If it is a prime number print "Foo". If it is a perfect square print "Bar". If it is neither print "FooBar". Do not use the python math library for this exercise. For example, if the number you are evaluating is 25, you will have to figure out if it is a perfect square. It is, so print "Bar".'''

for i in range(100, 100001):
    if i == 1:
        prime = False
        perfect_square = True
    else:
        prime = True
        perfect_square = False
        for j in range(2, i):
            if i%j == 0:
                prime = False
            if j**2 == i:
                perfect_square = True
            if j*2 > i or j**2 > i:
                break
    if not prime and not perfect_square:
        print i, 'FooBar'
    elif prime:
        print i, 'Foo'
    elif perfect_square:
        print i, 'Bar'
