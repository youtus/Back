import requests
import json

url = "http://localhost:8080/demo/utilisateurs/"

liste_utilisateur =[
    {'nom': 'Dupond',
    'prenom' : 'Olivier',
    'email' : 'z',
    'password' : 'z',
    'solde' : 788875,
    'panier':{
        'id:45'
    },
    }
]


for i, adresse_data in enumerate(liste_utilisateur):

    response = requests.post(url, json=adresse_data)


    if response.status_code == 200 or response.status_code == 201:
        print(f"utilisateurs {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"c'est good : {response.status_code}")
