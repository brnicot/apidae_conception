-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                      Oracle Version 10g
--                        (6/12/2018 11:59:21)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR1
--      Projet : 
--      Auteur : Département Informatique
--      Date de dernière modification : 6/12/2018 11:57:43
-- -----------------------------------------------------------------------------

DROP TABLE CATEGORIES CASCADE CONSTRAINTS;

DROP TABLE PRODUITS CASCADE CONSTRAINTS;

DROP TABLE COMMANDES CASCADE CONSTRAINTS;

DROP TABLE CLIENTS CASCADE CONSTRAINTS;

DROP TABLE COMMANDESPRODUITS CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR1;

-- -----------------------------------------------------------------------------
--       TABLE : CATEGORIES
-- -----------------------------------------------------------------------------

CREATE TABLE CATEGORIES
   (
    IDCAT NUMBER(2)  NOT NULL,
    NOMCAT CHAR(32)  NULL
,   CONSTRAINT PK_CATEGORIES PRIMARY KEY (IDCAT)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : PRODUITS
-- -----------------------------------------------------------------------------

CREATE TABLE PRODUITS
   (
    REFERENCEPRODUIT CHAR(32)  NOT NULL,
    NOM CHAR(32)  NULL,
    PRIXVENTE NUMBER(2)  NULL
,   CONSTRAINT PK_PRODUITS PRIMARY KEY (REFERENCEPRODUIT)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : COMMANDES
-- -----------------------------------------------------------------------------

CREATE TABLE COMMANDES
   (
    IDCOMMANDE NUMBER(2)  NOT NULL,
    NUMCLIENT NUMBER(4)  NOT NULL
,   CONSTRAINT PK_COMMANDES PRIMARY KEY (IDCOMMANDE)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE COMMANDES
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_COMMANDES_CLIENTS
     ON COMMANDES (NUMCLIENT ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : CLIENTS
-- -----------------------------------------------------------------------------

CREATE TABLE CLIENTS
   (
    NUMCLIENT NUMBER(4)  NOT NULL,
    IDCAT NUMBER(2)  NOT NULL,
    NOMCLIENT CHAR(32)  NULL,
    PRENOMCLIENT CHAR(32)  NULL
,   CONSTRAINT PK_CLIENTS PRIMARY KEY (NUMCLIENT)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CLIENTS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CLIENTS_CATEGORIES
     ON CLIENTS (IDCAT ASC)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : COMMANDESPRODUITS
-- -----------------------------------------------------------------------------

CREATE TABLE COMMANDESPRODUITS
   (
    IDCOMMANDE NUMBER(2)  NOT NULL,
    REFERENCEPRODUIT CHAR(32)  NOT NULL,
    QUANTITÉ CHAR(32)  NULL,
    MONTANTPRODUIT NUMBER(2)  NULL
,   CONSTRAINT PK_COMMANDESPRODUITS PRIMARY KEY (IDCOMMANDE, REFERENCEPRODUIT)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE COMMANDESPRODUITS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_COMMANDESPRODUITS_COMMAND
     ON COMMANDESPRODUITS (IDCOMMANDE ASC)
    ;

CREATE  INDEX I_FK_COMMANDESPRODUITS_PRODUIT
     ON COMMANDESPRODUITS (REFERENCEPRODUIT ASC)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE COMMANDES ADD (
     CONSTRAINT FK_COMMANDES_CLIENTS
          FOREIGN KEY (NUMCLIENT)
               REFERENCES CLIENTS (NUMCLIENT))   ;

ALTER TABLE CLIENTS ADD (
     CONSTRAINT FK_CLIENTS_CATEGORIES
          FOREIGN KEY (IDCAT)
               REFERENCES CATEGORIES (IDCAT))   ;

ALTER TABLE COMMANDESPRODUITS ADD (
     CONSTRAINT FK_COMMANDESPRODUITS_COMMANDES
          FOREIGN KEY (IDCOMMANDE)
               REFERENCES COMMANDES (IDCOMMANDE))   ;

ALTER TABLE COMMANDESPRODUITS ADD (
     CONSTRAINT FK_COMMANDESPRODUITS_PRODUITS
          FOREIGN KEY (REFERENCEPRODUIT)
               REFERENCES PRODUITS (REFERENCEPRODUIT))   ;


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------