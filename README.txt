+-----------------------------------------------------------------------------------------------------------------------------------+
|                                                                                                                                   |
|  ██████╗ ██████╗  ██████╗      ██╗███████╗████████╗    ██████╗  ██████╗  ██████╗               ██████╗  ██████╗ ██████╗ ██╗  ██╗  |
|  ██╔══██╗██╔══██╗██╔═══██╗     ██║██╔════╝╚══██╔══╝    ██╔══██╗██╔═══██╗██╔═══██╗              ██╔══██╗██╔═══██╗██╔══██╗██║  ██║  |
|  ██████╔╝██████╔╝██║   ██║     ██║█████╗     ██║       ██████╔╝██║   ██║██║   ██║    █████╗    ██████╔╝██║   ██║██████╔╝███████║  |
|  ██╔═══╝ ██╔══██╗██║   ██║██   ██║██╔══╝     ██║       ██╔═══╝ ██║   ██║██║   ██║    ╚════╝    ██╔══██╗██║   ██║██╔══██╗╚════██║  |
|  ██║     ██║  ██║╚██████╔╝╚█████╔╝███████╗   ██║       ██║     ╚██████╔╝╚██████╔╝              ██║  ██║╚██████╔╝██████╔╝     ██║  |
|  ╚═╝     ╚═╝  ╚═╝ ╚═════╝  ╚════╝ ╚══════╝   ╚═╝       ╚═╝      ╚═════╝  ╚═════╝               ╚═╝  ╚═╝ ╚═════╝ ╚═════╝      ╚═╝  |
|                                                                                                                                   |
+-----------------------------------------------------------------------------------------------------------------------------------+

+------------------------------------------------>          Avril 2018            <-------------------------------------------------+

Projet de simulateur de robot mobile code en JAVA sur Eclipse

Développé par Maeva ARLANDIS et Amelie EUGENE (ROB4 - Polytech Sorbonne)

+-----------------------------------------------------------------------------------------------------------------------------------+

	Le projet a pour objectif d'applique la methode de programmation orientee object pour simuler le fonctionnement d'un robot 
mobile avec comme exemple le robot Roomba fabriqué par IRobot.

Contenu du dossier :
- Un UML du projet
- L'ensemble du code source et des tests
- Une Javadoc
- Un README 


---> I - Notice d'utilisation: <---

Pour lancer le programme de simulation, il faut lancer le fichier Simulation.java du package main. Au demarage, tapez 1 pour une in-
terface texte et 2 pour une interface graphique. La simulation se lance alors automatiquement avec comme parametres un comportement 
aleatoire des deplacements du robot Roomba et un environnement predefini.

Pour creer un environnement personnalisé il suffit de ne pas utiliser la methode init dans le main à la suite de la construction 
de l'environnement et d'ajouter soit même les éléments qu'on aura construits avec la methode addElement appliquee a l'environnement.
On peut egalement creer des environnements en appelant le constructeur d'Environnement(int,int) avec comme premier argument la lar-
geur voulue et en deuxieme la longueur.

---> II - Personnalisation: <---

/ 1 - Robot:

Pour creer un nouveau type de robot il convient de créer une nouvelle classe qui herite de la classe abstraite Robot. 
Il ne faut pas oublier d'implémenter les methodes move, calculerPosition et paint.

/ 2 - Capteurs:

Pour creer un nouveau type de capteur il convient de créer une nouvelle classe qui herite de la classe abstraite Capteur.
Il ne faut pas oublier d'implementer les methodes type, detecter et paint.

/ 3 - Formes:

Pour creer une nouvelle forme il convient de créer une nouvelle classe qui herite de la classe abstraite Forme.
Il ne faut pas oublier d'implementer les methodes toString et paint.

/ 4 - Element:

Pour creer un nouvel element il convient de créer une nouvelle classe qui herite de la classe abstraite Element.
Il ne faut pas oublier d'implementer les methodes isColliding, collide et getHomogeneousSize, toString et paint.

/ 5 - Comportement:

Pour creer un nouveau comportement pour un robot il convient de créer une nouvelle classe qui herite de la classe abstraite 
Comportement. Il ne faut pas oublier d'implementer les methodes chemin et toString.

/ 6 - Graphique:

Pour creer une nouvelle interface graphique il convient de créer une nouvelle classe qui herite de la classe Graphique. 
Il ne faut pas oublier d'implementer les methodes draw pour chaque element que l'in souhaite dessiner sur l'interface ainsi creee.

---> III - Notes: <---

Il n'y a pas de classe Point mais la classe Cercle utilisee avec un diametre fonctionne de la meme maniere. La collision va verifier
si le point qui définit les coordonnées de la forme - et uniquement ce point - est au contact de l'autre élément.  
Les capteurs de proximite (bumper) ne sont definie qu'en un seul point du robot. De ce fait, et afin d'eviter que ce dernier ne soit
bloque entre deux capteurs nous avons ajoute une fonctionnalite qui detecte si le robot n'a pas bouge (posture precedente egale a l'
actuelle) et qui deplace le robot en consequence sans qu'aucun capteur n'ait ete active.

---> IV - Resume de ce qui a ete fait: <---

L'UML du projet realise sur UMLet est complet et fait apparaitre les liens d'heritage et d'appartenance. Les classes sont regroupes 
sous des packages qu'on peut identifier et les classes abstraites sont representees sur fond blanc. On y retrouve trois classes de 
comportements, de capteurs et de formes.

Les classes sont commentees et une JavaDoc est disponible pour obtenir des informations sur ces dernieres et leurs methodes.
Des tests unitaires des classes concretes (hors affichage 2D) ont egalement ete realises et sont disponibles dans le package test.  

La simulation fonctionne sous 2 modes: texte et graphique 2D.
Le robot fonctionne avec un comportement aleatoire et possede 3 capteurs de proximite ainsi qu'un capteur de salete en son centre.
Lorsqu'il passe sur une tache il lance une action de nettoyage qui le fait attendre 1 seconde avant supression de l'element.
Les obstacles et murs sont detectes au contact de ses capteurs de proximite et son orientation est modifiee en fonction du capteur
active. 

---> V - Ce qu'il reste a faire: <---

- Completer les tests qui ne couvrent pas encore toutes les possibilites. 
- Implementer les classes Telemetre, Polygone, Suivi_chemin et Suivi_mur.

---> VI - Ameliorations: <---

Les capteurs de proximité sont représentés par un unique point, hors il serait plus correct de les représenter par un arc 
de cercle. On pourait réaliser cela en leur fixant la forme Cercle à un certain diamètre et à la position du centre du robot lors 
de la construction et en ajoutant un attribut "taille_angle" qui définirait la taille de l'arc du cercle. L'attribut angulaire de 
la Posture permettrait de définir l'orientation du capteur. A noter que cette solution ne fonctionnerait que pour les robots circu-
laires comme le Roomba.

On pourrait egalement faire evoluer la simulation en etudiant le comportement de plusieurs robot. Il faudrait alors utiliser une
ArrayList de Roobot dans la classe Simulation et modifier la methode animate afin qu'elle traite chacun des robots contenus.

Les tests de collision avec une forme rectangulaire ne fonctionnent que lorsque le rectangle n'est pas incline dans l'espace (angle
multiple de pi/4). Il faudrait revoir cela afin de vous creer des elements rectangulaires inclines.

+-----------------------------------------------------------------------------------------------------------------------------------+
