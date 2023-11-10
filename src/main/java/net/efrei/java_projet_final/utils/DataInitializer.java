package net.efrei.java_projet_final.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.efrei.java_projet_final.entities.*;

import java.time.LocalDate;
import java.util.List;

//@Singleton
//@Startup
public class DataInitializer {

    protected EntityManagerFactory emf;
    protected EntityManager em;

//    @PostConstruct
    private void init() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();

        insertDefaultData();
    }

    private void insertDefaultData() {

        // Insérer les utilisateurs
        insertUsers();

        // Insérer d'autres données en respectant les dépendances
        insertCompetences();
        insertNiveaux();
        insertTitres();
        insertDisponibilites();
        insertEcoles();
        insertEnseignants();
        insertOffres();

        em.close();
        emf.close();
    }

    private void insertUsers() {
        List<String> usernames = List.of(
                "Barnabé Baudry", "Marius Lefebvre", "Chloé Dupont", "Emma Martin", "Lucas Durand",
                "Alice Bernard", "Hugo Blanc", "Inès Petit", "Léo Brun", "Manon Roux",
                "Jules Leroy", "Camille Vincent", "Arthur Moreau", "Lola David", "Mathis Simon",
                "Louise Chevalier", "Ethan Boyer", "Zoé Bonnet", "Raphaël Francois", "Charlotte Leroux");

        String defaultPassword = BCrypt.withDefaults().hashToString(12, "password".toCharArray());
        boolean isAdmin, isValid;

        for (int i = 0; i < usernames.size(); i++) {
            isAdmin = i % 2 == 0;
            isValid = i % 4 == 0;

            addUser(usernames.get(i), defaultPassword, isAdmin, isValid);
        }
    }

    private void addUser(String username, String password, boolean isAdmin, boolean isValid) {
        Utilisateur user = new Utilisateur();
        user.setUsername(username);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);
        user.setIsValid(isValid);

        TransactionalOperation.execute(em, () -> em.persist(user));
    }

    private void insertEnseignants() {
        Object[][] utilisateurs = {
                {"Barnabé Baudry", 1},
                {"Marius Lefebvre", 2},
                {"Chloé Dupont", 3},
                {"Emma Martin", 4},
                {"Lucas Durand", 5},
        };

        for (Object[] utilisateur : utilisateurs) {
            String nomUtilisateur = (String) utilisateur[0];
            int idUtilisateur = (Integer) utilisateur[1];

            addEnseignant(nomUtilisateur, idUtilisateur);
        }
    }

    private void addEnseignant(String nomUtilisateur, int idUtilisateur) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nomUtilisateur);

        Utilisateur user = em.find(Utilisateur.class, idUtilisateur);
        enseignant.setIdUtilisateur(user);

        TransactionalOperation.execute(em, () -> em.persist(enseignant));
    }


    private void insertEcoles() {
        Object[][] ecoles = {
                {"Ecole Polytechnique", 6},
                {"Université Paris-Sud", 7},
                {"Université Pierre et Marie Curie", 8},
                {"Ecole Normale Supérieure", 9},
                {"Université Paris-Dauphine", 10}
        };

        for (Object[] ecole : ecoles) {
            addEcole((String) ecole[0], (Integer) ecole[1]);
        }
    }

    private void addEcole(String raisonSociale, int idUtilisateur) {
        Ecole ecole = new Ecole();
        ecole.setRaisonSociale(raisonSociale);
        Utilisateur user = em.find(Utilisateur.class, idUtilisateur);
        ecole.setIdUtilisateur(user);

        TransactionalOperation.execute(em, () -> em.persist(ecole));
    }


    private void insertCompetences() {
        List<String> competences = List.of("Programmation Java", "Gestion de projet", "Analyse de données",
                "Intelligence Artificielle", "Développement Web", "Cybersécurité",
                "Réseaux informatiques", "Conception graphique", "Marketing digital",
                "Comptabilité", "Gestion des ressources humaines", "Enseignement",
                "Traduction", "Rédaction technique", "Photographie", "Vidéographie",
                "Coaching", "Animation 3D", "Développement de jeux", "Robotique");

        for (String competence : competences) {
            addCompetence(competence);
        }
    }

    private void addCompetence(String competence) {
        Competence comp = new Competence();
        comp.setCompetence(competence);

        TransactionalOperation.execute(em, () -> em.persist(comp));
    }


    private void insertTitres() {
        List<String> titres = List.of("Professeur", "Docteur", "Ingénieur", "Technicien", "Chercheur",
                "Consultant", "Manager", "Directeur", "Analyste", "Architecte",
                "Designer", "Développeur", "Spécialiste IT", "Commercial", "Marketeur",
                "Journaliste", "Éditeur", "Auteur", "Photographe", "Vidéaste");

        for (String titre : titres) {
            addTitre(titre);
        }
    }

    private void addTitre(String nomTitre) {
        Titre titre = new Titre();
        titre.setNomTitre(nomTitre);

        TransactionalOperation.execute(em, () -> em.persist(titre));
    }

    private void insertNiveaux() {
        List<String> niveaux = List.of("Débutant", "Intermédiaire", "Avancé", "Expert", "Professionnel",
                "Junior", "Senior", "Master", "Docteur", "Technicien",
                "Spécialiste", "Consultant", "Directeur", "Manager", "Coordinateur",
                "Analyste", "Architecte", "Ingénieur", "Chercheur", "Assistant");

        for (String niveau : niveaux) {
            addNiveau(niveau);
        }
    }

    private void addNiveau(String niveau) {
        Niveau niv = new Niveau();
        niv.setNiveau(niveau);

        TransactionalOperation.execute(em, () -> em.persist(niv));
    }

    private void insertDisponibilites() {
        LocalDate[][] dates = {
                {LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)},
                {LocalDate.of(2023, 2, 5), LocalDate.of(2023, 2, 15)},
                {LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 10)},
                {LocalDate.of(2023, 4, 15), LocalDate.of(2023, 4, 25)},
                {LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 20)},
                {LocalDate.of(2023, 6, 5), LocalDate.of(2023, 6, 15)},
                {LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 10)},
                {LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 25)},
                {LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 20)},
                {LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 15)},
                {LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 10)},
                {LocalDate.of(2023, 12, 15), LocalDate.of(2023, 12, 25)}
        };

        for (LocalDate[] dateRange : dates) {
            addDisponibilite(dateRange[0], dateRange[1]);
        }
    }

    private void addDisponibilite(LocalDate dateDebut, LocalDate dateFin) {
        Disponibilite dispo = new Disponibilite();
        dispo.setDateDebut(dateDebut);
        dispo.setDateFin(dateFin);

        TransactionalOperation.execute(em, () -> em.persist(dispo));
    }

    private void insertOffres() {
        Object[][] offres = {
                {"Enseignant en Mathématiques", "Master en Mathématiques", "Urgent", 1, 1},
                {"Professeur de Physique", "Doctorat en Physique", "Expérience requise", 2, 2},
                {"Développeur Web Full Stack", "Connaissance en React et Node.js", "Projet de 6 mois", 3, 3},
                {"Analyste de données", "Expérience en Python et SQL", "Travail à distance", 4, 4},
                {"Consultant en Cybersécurité", "Certifications en sécurité", "Disponible immédiatement", 5, 5},
                {"Enseignant en Informatique", "Expérience en programmation", "À temps partiel", 6, 1},
                {"Professeur d'Anglais", "Maîtrise en Langues", "Expérience à l'étranger valorisée", 7, 2},
                {"Designer Graphique", "Compétences en Adobe Suite", "Freelance", 8, 3},
                {"Expert en Intelligence Artificielle", "Doctorat en IA", "Projet de recherche", 9, 4},
                {"Chercheur en Biologie", "Publications scientifiques requises", "Poste à long terme", 10, 5},
                {"Formateur en Gestion de Projet", "Certification PMP", "Cours en ligne", 11, 1},
                {"Consultant en Marketing Digital", "Expérience en SEO/SEM", "Contrat flexible", 12, 2}
        };

        for (Object[] offreData : offres) {
            addOffre((String) offreData[0], (String) offreData[1], (String) offreData[2],
                    (Integer) offreData[3], (Integer) offreData[4]);
        }
    }

    private void addOffre(String intitule, String exigences, String remarques, int idDispo, int idEcole) {
        Offre offre = new Offre();
        offre.setIntitule(intitule);
        offre.setExigences(exigences);
        offre.setRemarques(remarques);

        Disponibilite dispo = em.find(Disponibilite.class, idDispo);
        Ecole ecole = em.find(Ecole.class, idEcole);

        offre.setIdDispo(dispo);
        offre.setIdEcole(ecole);

        TransactionalOperation.execute(em, () -> em.persist(offre));
    }


}
