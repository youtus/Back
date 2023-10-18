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
                "allergenes": "Oeufs",
                "urlImage": "https://recette.supertoinette.com/153761/b/mousse-au-chocolat-noir-maison.jpg"
            },
            {
                "titre": "Maroilles",
                "prix": 8,
                "categories": "gras",
                "description": "Un fromage incontournable",
                "allergenes": "lactose",
                "urlImage": "https://images-ca-1-0-1-eu.s3-eu-west-1.amazonaws.com/photos/original/1549/maroilles-produit-AdobeStock_535846367.jpg"
            },
            {
               "titre": "Poulet Frites",
               "prix": 4,
               "categories": "Repas reconfortant",
               "description": "Un repas delicieux",
               "allergenes": "Gluten",
                "urlImage": "https://www.lepoint.fr/images/2020/07/28/20580909lpw-20580940-article-jpg_7259436_1250x625.jpg"
            },
            {
               "titre": "Steak haricot vert",
               "prix": 10,
               "categories": "healthy",
                "description": "Pour les plus sportifs d'entre nous",
                "allergenes": "",
                "urlImage": "https://i.pinimg.com/736x/23/82/00/238200fb258c06e5c6b946b5fa1f9e7a.jpg"
            },
            {
                "titre": "Salade à l'avocat",
                "prix": 7.5,
                "categories": "healthy",
                "description": "Salade fraîche et pleine de vitamines",
                "allergenes": "Poisson",
                "urlImage": "https://www.kilometre-0.fr/wp-content/uploads/2021/01/20210129Cuisine_mar524.jpg"
            },
            {
                "titre": "Tacos",
                "prix": 7,
                "categories": "gras",
                "description": "Un tacos bien garni",
                "allergenes": "Lactose",
                "urlImage": "https://img.cuisineaz.com/1024x768/2019/04/17/i146583-tacos-poulet-curry.jpeg"
            },
            {
                "titre": "Welsh",
                "prix": 12,
                "categories": "gras",
                "description": "Un délicieux welsh traditionnel",
                "allergenes": "Lactose",
                "urlImage": "https://img.cuisineaz.com/660x660/2015/01/20/i91686-welsh-complet.jpg"
            },
            {
                "titre": "Foie gras",
                "prix": 18,
                "categories": "gras",
                "description": "Un folie gras fermier de la région",
                "allergenes": "",
                "urlImage": "https://cdn.foie-gras-godard.fr/4311/1200x1200/foie-gras-de-canard-entier-du-perigord.jpg"
            },
            {
                "titre": "Kebab",
                "prix": 6,
                "categories": "gras",
                "description": "Le kebab classique",
                "allergenes": "",
                "urlImage": "https://assets.afcdn.com/recipe/20210304/118354_w1024h1024c1cx1060cy707.jpg"
            }
        ]


for i, adresse_data in enumerate(liste_produit):

    response = requests.post(url, json=adresse_data)

    if response.status_code == 200 or response.status_code == 201:
        print(f"produits {i+1} ajoutée avec succès : {json.dumps(response.json(), indent=4)}")
    else:
        print(f"produits lors de l'ajout de l'adresse {i+1} : {response.status_code}")