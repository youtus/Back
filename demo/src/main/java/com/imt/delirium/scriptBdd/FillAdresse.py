import requests
import json

url = "http://localhost:8080/adresse"

liste_adresses = [
    {'rue': '123 Rue de la Paix', 'ville': 'Paris', 'cp': 75000},
    {'rue': '456 Avenue des Champs-Élysées', 'ville': 'Paris', 'cp': 75008},
    {'rue': '789 Boulevard Saint-Michel', 'ville': 'Paris', 'cp': 75005},
    {'rue': '101 Rue Oberkampf', 'ville': 'Paris', 'cp': 75011},
]

# Parcourir la liste pour ajouter chaque adresse
for i, adresse_data in enumerate(liste_adresses):
    # Envoi de la requête POST pour ajouter une nouvelle adresse
    response = requests.post(url, json=adresse_data)

    # Vérification du résultat
    if response.status_code == 200 or response.status_code == 201:
        print(f"Adresse {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"Erreur lors de l'ajout de l'adresse {i+1} : {response.status_code}")
