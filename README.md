# Activité Pratique N°2 : Spring MVC - Spring Data JPA, Hibernate
---

#  Description du Projet

Ce projet consiste à développer une **application web de gestion de stock de produits** en utilisant **Spring Boot et Spring MVC**, avec un accent particulier sur la **sécurisation de l’application via Spring Security**.

L’objectif principal de ce travail pratique est d’illustrer les mécanismes fondamentaux de sécurité dans les applications web modernes, notamment :

- l’authentification des utilisateurs
- la gestion des rôles et autorisations (RBAC)
- la protection contre les attaques courantes
- la sécurisation des routes HTTP

L’interface utilisateur est développée avec **Thymeleaf et Bootstrap**, permettant de créer une application dynamique, responsive et ergonomique.

---

#  Technologies Utilisées

## Backend
- **Java 17+**
- **Spring Boot**
- Spring MVC
- Spring Data JPA
- Spring Security
- Spring Validation

## Frontend
- **Thymeleaf**
- Thymeleaf Layout Dialect
- Thymeleaf Security Extras
- **HTML5**
- **CSS3**
- **Bootstrap 5**
- **Bootstrap Icons**

## Base de données
- **H2 Database (Base en mémoire)**

## Outils de développement
- **Maven**
- **IntelliJ IDEA**
- **Git / GitHub**

---

#  Fonctionnalités Implémentées

##  Sécurité et Contrôle d’Accès (Spring Security)

L'application implémente un système complet de sécurité basé sur **Spring Security**.

### Authentification
- Authentification **In-Memory**
- Encodage des mots de passe avec **BCryptPasswordEncoder**

### Gestion des rôles (RBAC)

Deux rôles principaux sont définis :

#### USER
Peut :
- consulter la liste des produits
- effectuer des recherches

#### ADMIN
Peut :
- consulter les produits
- ajouter un produit
- modifier un produit
- supprimer un produit

### Sécurisation des routes

| Route | Accès |
|------|------|
| `/admin/**` | ADMIN uniquement |
| `/user/**` | USER et ADMIN |

### Protection CSRF
La protection **CSRF** est activée par défaut pour sécuriser les formulaires et les requêtes sensibles.

### Gestion des exceptions
En cas d’accès non autorisé :

- l’utilisateur est redirigé vers une **page personnalisée d’erreur (403)**.

---

#  Gestion des Produits (CRUD)

L'application permet de gérer les produits à travers les opérations CRUD classiques.

## Create – Ajouter un produit
- Formulaire sécurisé
- Validation des données côté serveur avec :
  - `@Valid`
  - `BindingResult`

## Read – Afficher les produits
- Tableau dynamique
- Interface responsive avec Bootstrap

## Update – Modifier un produit
- Formulaire pré-rempli
- Utilisation de champs cachés pour l’identifiant

## Delete – Supprimer un produit
- Confirmation JavaScript pour éviter les suppressions accidentelles

## Recherche de produits
- Recherche par **nom**
- Implémentée avec **Spring Data JPA**




---

#  Interface Utilisateur (UI / UX)

## Système de Layout

L'application utilise **Thymeleaf Layout Dialect** pour structurer l’interface :

- un **layout principal**
- des **vues dynamiques**

Cela permet de réutiliser des composants communs comme :

- la barre de navigation
- le pied de page
- les styles globaux

---

## Barre de Navigation Dynamique

La navbar affiche :

- le nom de l’utilisateur connecté
- les options de navigation
- l’option de déconnexion

Grâce à **Thymeleaf Security Extras**.

---

## Notifications (Flash Messages)

Les actions utilisateur déclenchent des **notifications Bootstrap** :

- ajout réussi
- modification réussie
- suppression réussie

Implémentées via :
 RedirectAttributes


---

## Design

Interface réalisée avec **Bootstrap** :

- Cards
- Badges
- Tables responsives
- Effets `shadow`
- `table-hover`

L’objectif est de produire une interface **claire, moderne et intuitive**.

---

#  Configuration Technique Spécifique

## Accès à la Console H2 en mode développement

Pour faciliter le développement, la console **H2 Database** est accessible tout en conservant un niveau de sécurité adéquat.

La configuration de sécurité inclut :

- désactivation ciblée du **CSRF uniquement pour la console H2**
- autorisation des **frames HTML** nécessaires à l'interface H2

Cette configuration permet d’éviter les blocages liés aux mécanismes de sécurité du navigateur (Clickjacking protection).

---

#  Tests de l’Application

L’application intègre plusieurs profils utilisateurs permettant de tester :

- l’authentification
- les restrictions d’accès
- les fonctionnalités CRUD selon les rôles

---
