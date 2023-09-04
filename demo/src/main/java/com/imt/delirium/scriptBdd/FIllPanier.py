import requests
import json

url = "http://localhost:8080/demo/paniers"



liste_produit = [{"listProduit":[{"titre":"Mousse au chocolat","prix":4,"categories":"dessert","description":"Au cacao de Madagascar","allergenes":"Oeufs"}],"adresse":{"rue":"rue","ville":"ville","cp":1}}]


for i, adresse_data in enumerate(liste_produit):

        response = requests.post(url, json=adresse_data)


        if response.status_code == 200 or response.status_code == 201:
            print(f"paniers {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
        else:
            print(f"Erreur lors de l'ajout du panier {i+1} : {response.status_code}")
