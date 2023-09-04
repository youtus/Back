import requests
import json

url = "http://localhost:8080/demo/utilisateurs"

print("dans le script")

liste_adresses =[
    {'nom': 'Dupond',
    'prenom' : 'Olivier',
    'mail' : 'dupont@mail.com',
    'pwd' : 'xxxxx',
    'solde' : 788875}
]


for i, adresse_data in enumerate(liste_adresses):

    response = requests.post(url, json=adresse_data)


    if response.status_code == 200 or response.status_code == 201:
        print(f"utilisateurs {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"Erreur lors de l'ajout de l'utilisateurs {i+1} : {response.status_code}")
