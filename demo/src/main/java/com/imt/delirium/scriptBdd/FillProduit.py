import requests
import json

url = "http://localhost:8080/demo/produits"

liste_produit = [{
                "titre": "Poulet frite",
                "prix": 15,
                "categories": "carnassier",
                "description": "Un repas delicieux",
                "allergenes": "Gluten",
                "urlImage": "https://www.lepoint.fr/images/2020/07/28/20580909lpw-20580940-article-jpg_7259436_1250x625.jpg"
            },
            {
                "titre": "Mousse au chocolat",
                "prix": 4,
                "categories": "gras",
                "description": "Au cacao de Madagascar",
                "allergenes": "Oeufs"
            },
            {
                "titre": "Maroille",
                "prix": 8,
                "categories": "gras",
                "description": "Un fromage incontournable",
                "allergenes": "lactose"
            },
            {
               "titre": "Poulet Frites",
               "prix": 4,
               "categories": "Repas reconfortant",
               "description": "Un repas delicieux",
               "allergenes": "Gluten"
            },
            {
               "titre": "Steack haricot vert",
               "prix": 10,
               "categories": "healthy",
                "description": "Pour les plus sportifs d'entre nous",
                "allergenes": ""
            }

        ]


for i, adresse_data in enumerate(liste_produit):

    response = requests.post(url, json=adresse_data)

    if response.status_code == 200 or response.status_code == 201:
        print(f"produits {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"produits lors de l'ajout de l'adresse {i+1} : {response.status_code}")
