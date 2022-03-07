package Entities;

import java.util.*;
public class Professeur {

   private int idProf;
   private String nom;
   private String login;
   private String pass;
   private List<Filiere> filiere;
   private List<ListeAbsence> listeAbsence;

   public Professeur() {

   }

   public Professeur(int idProf, String nom, String login, String pass) {
      this.idProf = idProf;
      this.nom = nom;
      this.login = login;
      this.pass = pass;
   }

   public Professeur(int idProf, String nom, String login, String pass, List<Filiere> filiere, List<ListeAbsence> listeAbsence) {
        this.idProf = idProf;
        this.nom = nom;
        this.login = login;
        this.pass = pass;
        this.filiere = filiere;
        this.listeAbsence = listeAbsence;
    }
   public int getIdProf() {
      return idProf;
   }

   public void setIdProf(int newIdProf) {
      idProf = newIdProf;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String newNom) {
      nom = newNom;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String newLogin) {
      login = newLogin;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String newPass) {
      pass = newPass;
   }

   public List<Filiere> getFiliere() {
      if (filiere == null)
         filiere = new ArrayList<Filiere>();
      return filiere;
   }

   public Iterator getIteratorFiliere() {
      if (filiere == null)
         filiere = new ArrayList<Filiere>();
      return filiere.iterator();
   }

   public void setFiliere(List<Filiere> newFiliere) {
      removeAllFiliere();
      for (Iterator iter = newFiliere.iterator(); iter.hasNext();)
         addFiliere((Filiere)iter.next());
   }

   public void addFiliere(Filiere newFiliere) {
      if (newFiliere == null)
         return;
      if (this.filiere == null)
         this.filiere = new ArrayList<Filiere>();
      if (!this.filiere.contains(newFiliere))
      {
         this.filiere.add(newFiliere);
         newFiliere.addProfesseur(this);      
      }
   }

   public void removeFiliere(Filiere oldFiliere) {
      if (oldFiliere == null)
         return;
      if (this.filiere != null)
         if (this.filiere.contains(oldFiliere))
         {
            this.filiere.remove(oldFiliere);
            oldFiliere.removeProfesseur(this);
         }
   }

   public void removeAllFiliere() {
      if (filiere != null)
      {
         Filiere oldFiliere;
         for (Iterator iter = getIteratorFiliere(); iter.hasNext();)
         {
            oldFiliere = (Filiere)iter.next();
            iter.remove();
            oldFiliere.removeProfesseur(this);
         }
      }
   }

   public List<ListeAbsence> getListeAbsence() {
      if (listeAbsence == null)
         listeAbsence = new ArrayList<ListeAbsence>();
      return listeAbsence;
   }

   public Iterator getIteratorListeAbsence() {
      if (listeAbsence == null)
         listeAbsence = new ArrayList<ListeAbsence>();
      return listeAbsence.iterator();
   }

   public void setListeAbsence(List<ListeAbsence> newListeAbsence) {
      removeAllListeAbsence();
      for (Iterator iter = newListeAbsence.iterator(); iter.hasNext();)
         addListeAbsence((ListeAbsence)iter.next());
   }

   public void addListeAbsence(ListeAbsence newListeAbsence) {
      if (newListeAbsence == null)
         return;
      if (this.listeAbsence == null)
         this.listeAbsence = new ArrayList<ListeAbsence>();
      if (!this.listeAbsence.contains(newListeAbsence))
      {
         this.listeAbsence.add(newListeAbsence);
         newListeAbsence.addProfesseur(this);      
      }
   }

   public void removeListeAbsence(ListeAbsence oldListeAbsence) {
      if (oldListeAbsence == null)
         return;
      if (this.listeAbsence != null)
         if (this.listeAbsence.contains(oldListeAbsence))
         {
            this.listeAbsence.remove(oldListeAbsence);
            oldListeAbsence.removeProfesseur(this);
         }
   }

   public void removeAllListeAbsence() {
      if (listeAbsence != null)
      {
         ListeAbsence oldListeAbsence;
         for (Iterator iter = getIteratorListeAbsence(); iter.hasNext();)
         {
            oldListeAbsence = (ListeAbsence)iter.next();
            iter.remove();
            oldListeAbsence.removeProfesseur(this);
         }
      }
   }

}