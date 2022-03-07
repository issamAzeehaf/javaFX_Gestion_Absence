package Metier;

import Entities.Etudiant;
import Entities.Filiere;
import Entities.ListeAbsence;
import Entities.Professeur;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class MainConsole {
    public static void main(String[] args) {
        IMetier metier = new IMetierImpl();
        Filiere filiere = new Filiere(1,"BDCC-1");
        Etudiant etudiant = new Etudiant(1, filiere, "azehaf","issam","0601799139","issam.azf@gmail.com");
        /*Professeur professeur = new Professeur(2    ,"bousselham","abdelmajid","12345");
        ListeAbsence listeAbsence = new ListeAbsence(1, LocalDate.parse("2020-11-12"), "2h", "4h", "Java");
        metier.createAbsence(listeAbsence,professeur,etudiant);*/
        //metier.deleteEtudiant(etudiant);
        /*for(int i=0;i<metier.getAllEtudiants().size();i++){
            System.out.println(metier.getAllEtudiants().get(i).toString());
        }*/
        /*
        for(int i=0;i<metier.getAllListAbsence().size();i++){
            System.out.println(metier.getAllListAbsence().get(i).toString());
        }
        */

        for(int i=0;i<metier.getAllEtudiants().size();i++){
            System.out.println(metier.getAllListAbsenceByEtudiant(etudiant).get(i).toString());
        }
    }
}
