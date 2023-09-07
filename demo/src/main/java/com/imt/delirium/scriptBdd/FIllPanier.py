import requests
import json

url = "http://localhost:8080/demo/paniers"



liste_produit = [{"listProduit":[{"titre":"Mousse au chocolat","prix":4,"categories":"dessert","description":"Au cacao de Madagascar","allergenes":"Oeufs"}],"adresse":{"rue":"rue","ville":"ville","cp":1}}]


for i, adresse_data in enumerate(liste_produit):

        response = requests.post(url, json=adresse_data)


       
