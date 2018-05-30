'''Create a function that takes in two lists and creates a single dictionary where the first list contains keys and the second values. Assume the lists will be of equal length.

Your first function will take in two lists containing some strings.'''

def lists_to_dict(ls1, ls2):
    return dict(zip(ls1, ls2))

name = ["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"]

print lists_to_dict(name, favorite_animal)


'''Hacker Challenge:
If the lists are of unequal length, the longer list should be used for the keys, the shorter for the values.'''

def lists_to_dict(ls1, ls2):
    if len(ls1) >= len(ls2):
        return dict(zip(ls1, ls2))
    else:
        return dict(zip(ls2, ls1))

name = ["Anna", "Eli", "Pariece", "Brendan", "Amy", "Shane", "Oscar"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks"]

name = ["Anna", "Eli", "Pariece", "Brendan", "Amy"]
favorite_animal = ["horse", "cat", "spider", "giraffe", "ticks", "dolphins", "llamas"]

print lists_to_dict(name, favorite_animal)
print lists_to_dict(favorite_animal, name)