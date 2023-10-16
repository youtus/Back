import requests
import json

url = "http://localhost:8080/demo/utilisateurs/"

liste_utilisateur =[
    {'nom': 'a',
    'prenom' : 'a',
    'email' : 'a',
    'password' : 'a',
    }
]


for i, adresse_data in enumerate(liste_utilisateur):

    response = requests.post(url, json=adresse_data)


    if response.status_code == 200 or response.status_code == 201:
        print(f"utilisateurs {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"code : {response.status_code}")
