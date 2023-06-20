**Système de Sondage - Architecture Client-Serveur**

Ce projet consiste en un système de sondage basé sur une architecture client-serveur utilisant des sockets. Il permet de collecter les réponses des participants à un sondage et de générer des rapports statistiques sur les choix et les préférences.

**Fonctionnalités**

Les participants peuvent choisir parmi différentes options de réponse.
Les réponses des participants sont enregistrées et comptabilisées par le serveur.
Le serveur génère des rapports statistiques sur les choix et les préférences des participants.
Le système prend en charge la communication entre plusieurs clients et le serveur simultanément.

**Architecture**

Le système est basé sur une architecture client-serveur. Les clients se connectent au serveur en utilisant des sockets et envoient leurs réponses. Le serveur reçoit les réponses, les enregistre et effectue des opérations d'analyse pour générer les rapports statistiques.

**Comment utiliser le système de sondage**

Clonez ce dépôt sur votre machine locale.
Exécutez le fichier SondageServer.java pour démarrer le serveur de sondage.
Exécutez le fichier SondageClient.java pour lancer un client de sondage.
Le client affichera les choix possibles pour le sondage. Sélectionnez une option en entrant le numéro correspondant.
La réponse sera envoyée au serveur, qui comptabilisera les réponses et générera les rapports statistiques.
Les rapports statistiques seront affichés sur le client.

**Configuration**

Assurez-vous que vous avez Java JDK installé sur votre machine.
Le serveur utilise le port 8080. Veuillez vous assurer que ce port est disponible avant d'exécuter le serveur.

**Contributeurs**

ADDAZI Noureddine

**Remarque**

Ce projet a été développé dans le cadre d'un projet académique/privé et est mis à disposition sous la licence MIT License. Vous êtes libre de l'utiliser à des fins éducatives et personnelles. Cependant, nous ne pouvons pas garantir la fiabilité et la sécurité du code, et nous n'assumons aucune responsabilité en cas de problème lié à son utilisation.
