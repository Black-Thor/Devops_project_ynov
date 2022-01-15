# Devops_project_ynov

Ceux projet consiste en la réalisation de plusieurs pipeline permettant de dployer une instances axws et de lancer une application au sein de cette instances aws , en utilisant des outils de CI/CD et en respectant un Git flow . Les outils employé sont Docker pour le déploiment de l'application , jenkins pour la création de pipelines automatisé , terraform pour le déploiement de  l'instances aws et ansible pour le déploiement de l'application 

## Installation 

Le projet à été réalisée avec 2 outils :
    - Docker Desktop
    - WSL 

Je recommande l'installation de ces deux outils pour le bon déploiement .

Cloner le projet sur votre instances wsl avec 

```
git clone https://github.com/Black-Thor/Devops_project_ynov.git
```
Vous pouvez ouvrir le code sur VS code avec `code .`

Ajouter les pré-requis suivant : 

Pour le fonctionnement d'ansible ajouter dans `./ansible/inventory/aws_ec2.yaml`

```
aws_access_key_id :  <AWS KEY ID>
aws_secret_access_key : <AWS SECRET ACCESS KEY >
```

Pour le fonctionnement de terraform ajouter dans `./terraform/aws`

Crée le fichier credentials-ynov.txt

avec le contenue suivant 
```
[default]
aws_access_key_id = <AWS KEY ID>
aws_secret_access_key = <AWS SECRET ACCESS KEY >
```
## Deployer le projet 

Ouvrir Docker Desktop sur votre bureau 

saisir la commande dans le terminal WSL

```
docker-commpose up --build 
```

Une fois docker lancer Rendez vous sur  http://localhost/ pour acceder à la page Jenkins .

Dans chaque dossier vous trouverez les fichiers .md expliquant l'utilité de chaque sections


### Autheur 
Stéphane Duboze