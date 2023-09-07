import requests
import json

url = "http://localhost:8080/demo/utilisateurs/"

liste_utilisateur =[
    {'nom': 'Dupond',
    'prenom' : 'Olivier',
    'mail' : 'dupont@mail.com',
    'pwd' : 'xxxxx',
    'solde' : 788875},
     {'nom': 'Tom',
    'prenom' : 'Beranger',
    'mail' : 'Tom@mail.com',
    'pwd' : 'xxxxx',
    'solde' : 58458},
     {'nom': 'antoine',
    'prenom' : 'chauvin',
    'mail' : 'antoine@mail.com',
    'pwd' : 'xxxxx',
    'solde' : 58458}
]


for i, adresse_data in enumerate(liste_utilisateur):

    response = requests.post(url, json=adresse_data)


    if response.status_code == 200 or response.status_code == 201:
        print(f"utilisateurs {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"c'est good : {response.status_code}")
