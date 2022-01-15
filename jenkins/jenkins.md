# Devops_project_ynov

Cette partie consacré à jenkins , doit permettre de déployer les différents pipeline utile au projet

## Comment l'utiliser 

Pour l'utiliser connecter vous sur le liens  http://localhost/ avec les accès suivant user:`admin` password:`admin`

Rendez-vous dans le dossier associés au action piepline : 

Dans CI on trouve : 
    - sb3t_wrapper

Dans CD on trouve : 
    - infraBuild qui permet de crée ou détruire l'instances aws EC2 via terraform
    - infraOutput qui permet de consulter l'IP de  l'instances aws EC2 via terraform
    - deploiement permet de deployer l'application java et les lv et vg 
    - destroy apermet de detruire les disques lv et vg pour permettre la destruction des instances aws EC2
