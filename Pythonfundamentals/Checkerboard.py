# Write a program that prints a 'checkerboard' pattern to the console.
for i in range(1,9):
    row = ''
    if i%2 == 0:
        pattern = ' *'
    else:
        pattern = '* '
    for _ in range(1,5):
        row += pattern
    print row