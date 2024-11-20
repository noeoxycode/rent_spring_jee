![Static Badge](https://img.shields.io/badge/RentCarsAPI_coverage-89%25-valid)
![Static Badge](https://img.shields.io/badge/RentFrontAPI_coverage-97%25-valid)
![Static Badge](https://img.shields.io/badge/RentPropertiesAPI_coverage-91%25-valid)

## Spécificités
1. Protection des API Spring : les API Spring ne sont pas appelables depuis un autre client que Front. Un token d'authentification a été mis en place. Les API Spring contrôlent ce token en le comparant avec celui présent dans le [fichier d'environnement](.env) à la racine. Le front récupère quant à lui le token dans son [fichier de properties](RentFrontAPI/src/main/resources/config.properties). Attention, les deux tokens doivent être identiques sous peine de ne pas pouvoir requêter les API Spring.
2. Au premier lancement de l'application, exécuter la commande `docker compose -f docker-compose.yml` pour initier la base de donnée. Suite à cette opération, lancer les scrips SQL disponibles dans les dossiers SQL de [RentCarsApi](RentCarsAPI/src/main/resources/sql/rental_car.sql) et [RentPropertiesApi](RentPropertiesAPI/src/main/resources/sql).

## Fonctionnalités clés
1. Un interceptor présent dans l'api Spring [RentPropertiesApi](RentPropertiesAPI/src/main/java/fr/rent/application/interceptor) ainsi que dans l'api [RentCarsProperties](RentCarsAPI/src/main/java/fr/esgi/rent/interceptor/AuthInterceptor.java)
2. Un [reverse proxy](RentFrontAPI/src/main/java/fr/esgi/api) en tant que front