# fluent-http-miniblog

Ce projet permet de donner un exemple d'utilisation du framework REST  [fluent-http](https://github.com/CodeStory/fluent-http) en implémentant 
un mini-blog illustrant les éléments principaux de fluent-http.

# Étudiants

- Faire un fork du projet, le clonner en locale :
    
        mkdir -p /tmp/$USER/workspace
        cd /tmp/$USER/workspace
        export http_proxy=http://cache.univ-lille1.fr
        export https_proxy=http://cache.univ-lille1.fr
        git clone https://github.com/...
    
- Modifier le nom du projet dans le fichier pom.xml

        <name>votre-nom-de-projet</name>

- Ouvrir éclipse en lui indiquant d'utiliser le workspace ```/tmp/$USER/workspace```
- Installer le plugin maven ```m2e``` depuis http://download.eclipse.org/releases/indigo/
- puis "import existing maven project"

# Besoin

- exemple de put/get/post/delete sur article
- inscription des auteurs 
- authentification 
- 1 article == 1 auteur
- 1 page static + JS
- base en ram
- seed de base au boot
- déploiement continu
