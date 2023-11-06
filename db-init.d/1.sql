create schema if not exists `projet`;

use `projet`;

create table Competence
(
    competence varchar(255) not null
        primary key
);

create table Disponibilite
(
    id        int  not null auto_increment
        primary key,
    dateDebut date null,
    dateFin   date null
);

create table Niveau
(
    niveau varchar(255) not null
        primary key
);

create table Titre
(
    nomTitre varchar(255) not null
        primary key
);

create table Utilisateur
(
    id       int          not null auto_increment
        primary key,
    username varchar(255) null,
    password varchar(255) null,
    isAdmin    tinyint(1)   null,
    isValid   tinyint(1)   null
);

create table Ecole
(
    id            int          not null auto_increment
        primary key,
    raisonSociale varchar(255) null,
    idUtilisateur int          not null,
    constraint idUtilisateur
        unique (idUtilisateur),
    constraint Ecole_ibfk_1
        foreign key (idUtilisateur) references Utilisateur (id)
);

create table Enseignant
(
    id             int          not null auto_increment
        primary key,
    nom            varchar(255) not null,
    prenom         varchar(255) not null,
    mail           varchar(255) not null,
    telephone      varchar(255) not null,
    centreInterets varchar(255) null,
    sites          varchar(255) null,
    typeContrat    varchar(255) not null,
    extra          varchar(255) null,
    idUtilisateur  int          not null,
    constraint idUtilisateur
        unique (idUtilisateur),
    constraint Enseignant_ibfk_1
        foreign key (idUtilisateur) references Utilisateur (id),
    constraint checkTypeContrat
        check (`typeContrat` = 'Prestation' or `typeContrat` = 'Salarié')
);

create table Offre
(
    id        int          not null auto_increment
        primary key,
    intitule  varchar(255) null,
    exigences varchar(255) null,
    remarques varchar(255) null,
    idDispo   int          not null,
    idEcole   int          not null,
    constraint Offre_ibfk_1
        foreign key (idDispo) references Disponibilite (id),
    constraint Offre_ibfk_2
        foreign key (idEcole) references Ecole (id)
);

create index idDispo
    on Offre (idDispo);

create index idEcole
    on Offre (idEcole);

create table candidate
(
    idEnseignant int          not null,
    idOffre      int          not null,
    contactPar   varchar(255) null,
    contactLe    varchar(255) null,
    decision     varchar(255) null,
    primary key (idEnseignant, idOffre),
    constraint candidate_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint candidate_ibfk_2
        foreign key (idOffre) references Offre (id),
    constraint checkDecision
        check (`decision` is null or `decision` = 'Retenu' or `decision` = 'Non retenu')
);

create index idOffre
    on candidate (idOffre);

create table demande
(
    competence varchar(255) not null,
    idOffre    int          not null,
    primary key (competence, idOffre),
    constraint demande_ibfk_1
        foreign key (competence) references Competence (competence),
    constraint demande_ibfk_2
        foreign key (idOffre) references Offre (id)
);

create index idOffre
    on demande (idOffre);

create table dispo
(
    idEnseignant int not null,
    idDispo      int not null,
    primary key (idEnseignant, idDispo),
    constraint dispo_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint dispo_ibfk_2
        foreign key (idDispo) references Disponibilite (id)
);

create index idDispo
    on dispo (idDispo);

create table evalue
(
    idEnseignant int          not null,
    idEcole      int          not null,
    competence   varchar(255) not null,
    note         int          null,
    commentaire  varchar(255) null,
    primary key (idEnseignant, idEcole, competence),
    constraint evalue_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint evalue_ibfk_2
        foreign key (idEcole) references Ecole (id),
    constraint evalue_ibfk_3
        foreign key (competence) references Competence (competence),
    constraint checkNoteBorne
        check (`note` >= 0 and `note` <= 5)
);

create index competence
    on evalue (competence);

create index idEcole
    on evalue (idEcole);

create table interesse
(
    idEnseignant int not null,
    idEcole      int not null,
    primary key (idEnseignant, idEcole),
    constraint interesse_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint interesse_ibfk_2
        foreign key (idEcole) references Ecole (id)
);

create index idEcole
    on interesse (idEcole);

create table jouit
(
    idEnseignant int          not null,
    nomTitre     varchar(255) not null,
    primary key (idEnseignant, nomTitre),
    constraint jouit_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint jouit_ibfk_2
        foreign key (nomTitre) references Titre (nomTitre)
);

create index nomTitre
    on jouit (nomTitre);

create table possede
(
    idEnseignant int          not null,
    competence   varchar(255) not null,
    primary key (idEnseignant, competence),
    constraint possede_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint possede_ibfk_2
        foreign key (competence) references Competence (competence)
);

create index competence
    on possede (competence);

create table recommandeEnseignant
(
    idEnseignant           int          not null,
    idEnseignantRecommande int          not null,
    competence             varchar(255) not null,
    commentaire            varchar(255) null,
    primary key (idEnseignant, idEnseignantRecommande, competence),
    constraint recommandeEnseignant_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint recommandeEnseignant_ibfk_2
        foreign key (idEnseignantRecommande) references Enseignant (id),
    constraint recommandeEnseignant_ibfk_3
        foreign key (competence) references Competence (competence)
);

create index competence
    on recommandeEnseignant (competence);

create index idEnseignantRecommande
    on recommandeEnseignant (idEnseignantRecommande);

create table souhaite
(
    idEnseignant int          not null,
    niveau       varchar(255) not null,
    primary key (idEnseignant, niveau),
    constraint souhaite_ibfk_1
        foreign key (idEnseignant) references Enseignant (id),
    constraint souhaite_ibfk_2
        foreign key (niveau) references Niveau (niveau)
);

create index niveau
    on souhaite (niveau);

