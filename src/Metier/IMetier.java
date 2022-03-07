package Metier;

import Entities.Etudiant;
import Entities.Filiere;
import Entities.ListeAbsence;
import Entities.Professeur;

import java.util.List;

public interface IMetier {
    boolean checkInfoUser(String login,String password);
    void addEtudiant(Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void updateEtudiant(int id,Etudiant etudiant);
    void createAbsence(ListeAbsence listeAbsence,Professeur prof,Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    List<ListeAbsence> getAllListAbsenceByEtudiant(Etudiant etudiant);
    Professeur getProfByLogin(String login);
    boolean checkFiliere(int idProf,int idFiliere);
    List<Etudiant> getAllEtudiantsByFiliere(Filiere filiere);
}
