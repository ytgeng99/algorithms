'''Write a function that takes in a dictionary and returns a list of tuples where the first tuple item is the key and the second is the value. '''


def dict_to_tuple(dict1):
    tuple_list = []
    for name in dict1:
        tuple_list.append((name, dict1[name]))
    return tuple_list

my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}

print dict_to_tuple(my_dict)