# L'invasion des fautes d'orthographe

L'invasion des fautes d'orthographe est un projet réalisé par 4 étudiants :
  - Nicolas Lamblin
  - Guillaume Launay
  - Valentin Nourdin
  - Alexandre Pereira

Idée originale : Stephane Goria

Il s'agit d'un jeu sérieux dont le but est de corriger des fautes d'orthographe dans un texte qui défile verticalement.

## Description du sujet

  Notre projet est un jeu sérieux, c'est-à-dire qu’il est réalisé dans un but éducatif.
Il est basé sur le principe du jeu «Space Invaders» mais les vaisseaux ennemis sont remplacés par un texte à fautes et au lieu de tirer dessus, il faut écrire les mots corrigés.
Lorsque le joueur tape la bonne correction le mot devient vert, mais s'il se trompe ou essaie de corriger un mot bien écrit, le défilement du texte accélère...

  À quelques lignes de la fin de l’écran, les mots se colorent en vert s'ils sont bien orthographiés et en rouge s'ils le sont mal.
Chaque mot bien corrigé rapporte 100 points par lettre et dès qu’un mot erroné touche le bas de l'écran, le joueur perd une vie.
Lorsqu'il n'en a plus, la partie est terminée..

  Le but du jeu est donc d'obtenir le meilleur score possible, et également d'améliorer son niveau de Français.

## Technologies utilisées

  Le jeu est développé en Java et utilise Swing ainsi que LanguageTool pour détecter le type des mots et générer des fautes appropriées.
