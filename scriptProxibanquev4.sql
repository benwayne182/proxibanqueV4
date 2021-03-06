create user user7 identified by user7;

grant connect, resource to user7;

connect user7/user7;

ALTER TABLE "USER7"."COMPTECOURANT" DROP CONSTRAINT "FKJ23UKXX5CRAX38077EDBRPDIG";

ALTER TABLE "USER7"."COMPTE" DROP CONSTRAINT "FKRYJSOQ3Q8Q4T1CHCN426FWEOX";

ALTER TABLE "USER7"."COMPTEEPARGNE" DROP CONSTRAINT "FKEBRK0FODD26Y0VJWNBHKFS5SC";

ALTER TABLE "USER7"."COMPTE" DROP CONSTRAINT "SYS_C009134";

ALTER TABLE "USER7"."COMPTECOURANT" DROP CONSTRAINT "SYS_C009137";

ALTER TABLE "USER7"."COMPTEEPARGNE" DROP CONSTRAINT "SYS_C009140";

ALTER TABLE "USER7"."DIRECTEUR" DROP CONSTRAINT "SYS_C009144";

ALTER TABLE "USER7"."CLIENT" DROP CONSTRAINT "SYS_C009130";

ALTER TABLE "USER7"."CONSEILLER" DROP CONSTRAINT "SYS_C009096";

ALTER TABLE "USER7"."USERS" DROP CONSTRAINT "SYS_C009146";

DROP INDEX "USER7"."SYS_C009134";

DROP INDEX "USER7"."SYS_C009142";

DROP INDEX "USER7"."SYS_C009130";

DROP INDEX "USER7"."SYS_C009140";

DROP INDEX "USER7"."SYS_C009146";

DROP INDEX "USER7"."SYS_C009137";

DROP INDEX "USER7"."SYS_C009144";

DROP TABLE HT_CLIENT CASCADE CONSTRAINT;

DROP TABLE HT_CONSEILLER CASCADE CONSTRAINT;

DROP TABLE CONSEILLER CASCADE CONSTRAINT;

DROP TABLE COMPTE CASCADE CONSTRAINT;

DROP TABLE HT_COMPTECOURANT CASCADE CONSTRAINT;

DROP TABLE COMPTEEPARGNE CASCADE CONSTRAINT;

DROP TABLE HT_COMPTEEPARGNE CASCADE CONSTRAINT;

DROP TABLE HT_DIRECTEUR CASCADE CONSTRAINT;

DROP TABLE USERS CASCADE CONSTRAINT;

DROP TABLE DIRECTEUR CASCADE CONSTRAINT;

DROP TABLE COMPTECOURANT CASCADE CONSTRAINT;

DROP TABLE HT_COMPTE CASCADE CONSTRAINT;

DROP TABLE HT_USERS CASCADE CONSTRAINT;

DROP TABLE HT_PERSONNE CASCADE CONSTRAINT;

DROP TABLE CLIENT CASCADE CONSTRAINT;

CREATE TABLE "USER7"."HT_CLIENT" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_CONSEILLER" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."CONSEILLER" (
		"ID" NUMBER(10 , 0) NOT NULL,
		"NOM" VARCHAR2(255),
		"PRENOM" VARCHAR2(255),
		"LOGIN" VARCHAR2(255),
		"PASSWORD" VARCHAR2(255)
	);

CREATE TABLE "USER7"."COMPTE" (
		"TYPE_COMPTE" VARCHAR2(31) NOT NULL,
		"ID" NUMBER(10 , 0) NOT NULL,
		"SOLDE" FLOAT(126) NOT NULL,
		"CLIENT_ID" NUMBER(10 , 0)
	);

CREATE TABLE "USER7"."HT_COMPTECOURANT" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."COMPTEEPARGNE" (
		"TAUXDINTERET" FLOAT(126) NOT NULL,
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_COMPTEEPARGNE" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_DIRECTEUR" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."USERS" (
		"ID" NUMBER(10 , 0) NOT NULL,
		"NOM" VARCHAR2(255),
		"PRENOM" VARCHAR2(255),
		"LOGIN" VARCHAR2(255),
		"PASSWORD" VARCHAR2(255)
	);

CREATE TABLE "USER7"."DIRECTEUR" (
		"ID" NUMBER(10 , 0) NOT NULL,
		"NOM" VARCHAR2(255),
		"PRENOM" VARCHAR2(255),
		"LOGIN" VARCHAR2(255),
		"PASSWORD" VARCHAR2(255)
	);

CREATE TABLE "USER7"."COMPTECOURANT" (
		"DECOUVERTAUTORISE" FLOAT(126) NOT NULL,
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_COMPTE" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_USERS" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."HT_PERSONNE" (
		"ID" NUMBER(10 , 0) NOT NULL
	);

CREATE TABLE "USER7"."CLIENT" (
		"ID" NUMBER(10 , 0) NOT NULL,
		"NOM" VARCHAR2(255),
		"PRENOM" VARCHAR2(255),
		"ADRESSE" VARCHAR2(255),
		"CODEPOSTAL" NUMBER(10 , 0) NOT NULL,
		"EMAIL" VARCHAR2(255),
		"TEL" VARCHAR2(255),
		"VILLE" VARCHAR2(255),
		"CONSEILLER_ID" NUMBER(10 , 0)
	);

CREATE UNIQUE INDEX "USER7"."SYS_C009134" ON "USER7"."COMPTE" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009142" ON "USER7"."CONSEILLER" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009130" ON "USER7"."CLIENT" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009140" ON "USER7"."COMPTEEPARGNE" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009146" ON "USER7"."USERS" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009137" ON "USER7"."COMPTECOURANT" ("ID" ASC);

CREATE UNIQUE INDEX "USER7"."SYS_C009144" ON "USER7"."DIRECTEUR" ("ID" ASC);

ALTER TABLE "USER7"."COMPTE" ADD CONSTRAINT "SYS_C009134" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."COMPTECOURANT" ADD CONSTRAINT "SYS_C009137" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."COMPTEEPARGNE" ADD CONSTRAINT "SYS_C009140" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."DIRECTEUR" ADD CONSTRAINT "SYS_C009144" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."CLIENT" ADD CONSTRAINT "SYS_C009130" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."CONSEILLER" ADD CONSTRAINT "SYS_C009096" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."USERS" ADD CONSTRAINT "SYS_C009146" PRIMARY KEY ("ID");

ALTER TABLE "USER7"."COMPTECOURANT" ADD CONSTRAINT "FKJ23UKXX5CRAX38077EDBRPDIG" FOREIGN KEY ("ID")
	REFERENCES "USER7"."COMPTE" ("ID")
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE "USER7"."COMPTE" ADD CONSTRAINT "FKRYJSOQ3Q8Q4T1CHCN426FWEOX" FOREIGN KEY ("CLIENT_ID")
	REFERENCES "USER7"."CLIENT" ("ID")
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE "USER7"."COMPTEEPARGNE" ADD CONSTRAINT "FKEBRK0FODD26Y0VJWNBHKFS5SC" FOREIGN KEY ("ID")
	REFERENCES "USER7"."COMPTE" ("ID")
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

insert into directeur values (1,'LOPEZ','Michel','michel','michel');

commit;