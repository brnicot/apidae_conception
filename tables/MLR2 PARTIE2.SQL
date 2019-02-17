-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                      Oracle Version 10g
--                        (6/12/2018 12:14:20)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR2
--      Projet : 
--      Auteur : Département Informatique
--      Date de dernière modification : 6/12/2018 12:12:54
-- -----------------------------------------------------------------------------

DROP TABLE DATE CASCADE CONSTRAINTS;

DROP TABLE CATEGORIES CASCADE CONSTRAINTS;

DROP TABLE REPRÉSENTANTS CASCADE CONSTRAINTS;

DROP TABLE CLIENTSFRANÇAIS CASCADE CONSTRAINTS;

DROP TABLE PRODUITS CASCADE CONSTRAINTS;

DROP TABLE COMMANDES CASCADE CONSTRAINTS;

DROP TABLE CLIENTS CASCADE CONSTRAINTS;

DROP TABLE ASSO_4 CASCADE CONSTRAINTS;

DROP TABLE COMMANDESPRODUITS CASCADE CONSTRAINTS;

-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR2;

-- -----------------------------------------------------------------------------
--       TABLE : DATE
-- -----------------------------------------------------------------------------

CREATE TABLE DATE
   (
    DATE DATE  NOT NULL
,   CONSTRAINT PK_DATE PRIMARY KEY (DATE)  
   ) ;

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
--       TABLE : REPRÉSENTANTS
-- -----------------------------------------------------------------------------

CREATE TABLE REPRÉSENTANTS
   (
    IDREPR NUMBER(2)  NOT NULL,
    NOMREPR CHAR(32)  NULL,
    PRENOMREPR CHAR(32)  NULL
,   CONSTRAINT PK_REPRÉSENTANTS PRIMARY KEY (IDREPR)  
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : CLIENTSFRANÇAIS
-- -----------------------------------------------------------------------------

CREATE TABLE CLIENTSFRANÇAIS
   (
    NUMCLIENT NUMBER(4)  NOT NULL,
    TEL CHAR(32)  NULL,
    NOMCLIENT CHAR(32)  NULL,
    PRENOMCLIENT CHAR(32)  NULL
,   CONSTRAINT PK_CLIENTSFRANÇAIS PRIMARY KEY (NUMCLIENT)  
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
--       TABLE : ASSO_4
-- -----------------------------------------------------------------------------

CREATE TABLE ASSO_4
   (
    DATE DATE  NOT NULL,
    NUMCLIENT NUMBER(4)  NOT NULL,
    IDREPR NUMBER(2)  NOT NULL
,   CONSTRAINT PK_ASSO_4 PRIMARY KEY (DATE, NUMCLIENT)  
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE ASSO_4
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_ASSO_4_DATE
     ON ASSO_4 (DATE ASC)
    ;

CREATE  INDEX I_FK_ASSO_4_CLIENTSFRANÇAIS
     ON ASSO_4 (NUMCLIENT ASC)
    ;

CREATE  INDEX I_FK_ASSO_4_REPRÉSENTANTS
     ON ASSO_4 (IDREPR ASC)
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


ALTER TABLE CLIENTSFRANÇAIS ADD (
     CONSTRAINT FK_CLIENTSFRANÇAIS_CLIENTS
          FOREIGN KEY (NUMCLIENT)
               REFERENCES CLIENTS (NUMCLIENT))   ;

ALTER TABLE COMMANDES ADD (
     CONSTRAINT FK_COMMANDES_CLIENTS
          FOREIGN KEY (NUMCLIENT)
               REFERENCES CLIENTS (NUMCLIENT))   ;

ALTER TABLE CLIENTS ADD (
     CONSTRAINT FK_CLIENTS_CATEGORIES
          FOREIGN KEY (IDCAT)
               REFERENCES CATEGORIES (IDCAT))   ;

ALTER TABLE ASSO_4 ADD (
     CONSTRAINT FK_ASSO_4_DATE
          FOREIGN KEY (DATE)
               REFERENCES DATE (DATE))   ;

ALTER TABLE ASSO_4 ADD (
     CONSTRAINT FK_ASSO_4_CLIENTSFRANÇAIS
          FOREIGN KEY (NUMCLIENT)
               REFERENCES CLIENTSFRANÇAIS (NUMCLIENT))   ;

ALTER TABLE ASSO_4 ADD (
     CONSTRAINT FK_ASSO_4_REPRÉSENTANTS
          FOREIGN KEY (IDREPR)
               REFERENCES REPRÉSENTANTS (IDREPR))   ;

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