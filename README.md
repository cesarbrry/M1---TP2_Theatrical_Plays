# [ Theatrical Plays ]
## EXPLICATION DU FONCTIONNEMENT DU CODE


Ce code est un ensemble de classes java utilisées afin de générer une facture basée sur des
performances théâtrales (ou des représentations) et des informations sur ces performances. Le code effectue le calcul du
montant total de la facture et des crédits gagnés pour le client. Voici une explication détaillée de ce que fait le code 

-----------------

- Définition des types de pièces de théâtre : Deux constantes sont définies, "TRAGEDY" et "COMEDY", pour représenter
les deux types de pièces de théâtre.
- Initialisation des variables : Plusieurs variables sont initialisées, notamment `totalAmount` pour suivre le montant
total de la facture et `volumeCredits` pour suivre les crédits gagnés par le client.
- Initialisation de la variable "result" : Une variable `result` de type `StringBuffer` est créée pour stocker le texte de la
facture générée.
- Dans notre classe invoice, on a des fonctions nous permettant de calculer la somme totale due par le client et egalement les credits totals que ce dernier a accumulé. On va egalement retrouver une fonction permettant de savoir si le client a assez de points de fidelité pour obtenir une reduction sur le prix final.
- Calcul du montant pour chaque performance : En fonction du type de la pièce de théâtre (comédie ou tragédie), le
code calcule le montant à facturer pour cette performance. Le montant est calculé dans la classe Play.
  - Pour une tragédie, le montant de base est de 400.0 pour une capacité initiale de 30 spectateurs, avec une
majoration de 10.0 par spectateur en plus.
  - Pour une comédie, le montant de base est de 300.0 pour une capacité de base de 20, si on a des spectateur en
plus, on ajoute 100.0 en plus + 5.0 par spectateur en plus. De plus, 3.0 par spectateur est ajouté au montant
quelque soit le nombre de spectateur.
- Calcul des crédits : Les crédits gagnés par le client sont calculés en fonction du nombre de spectateurs qui assistent
à la performance et du type de pièce de théâtre :
  - Pour une piece de theatre random / Tragedy : Le nombre de credits gagnés par le client est egal au nombre
de personnes qui assiste a la piece – 30
  - Pour une comedie : Le nombre de crédit gagné est egal au ( nombre de personne qui assiste - 30 ) + arrondi
inf(nombre de personnes/5)
- Ligne de facture : Une ligne de la facture est ajoutée à la variable `result`, indiquant le nom de la pièce de théâtre, le
montant facturé et le nombre de spectateurs pour cette performance.
- Mise à jour du montant total : Le montant facturé pour cette performance est ajouté au `totalAmount`.

-----------------

En résumé, ce code prend en entrée des informations sur des performances théâtrales, calcule le montant total de la facture
en fonction du type de pièce et du nombre de spectateurs, attribue des crédits en fonction du nombre de spectateurs et du
type de pièce, puis génère une facture sous forme de texte.
