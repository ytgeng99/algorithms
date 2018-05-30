import requests

# print the names of the original 151 pokemon
for i in range(1, 152):
    url = 'https://pokeapi.co/api/v2/pokemon-form/' + str(i)
    r = requests.get(url)
    print (r.json()['name'])