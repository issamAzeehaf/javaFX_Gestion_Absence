package Entities;

import java.util.*;

public class Filiere {

   private int idFiliere;
   private String nomFiliere;
   private List<Etudiant> etudiant;
   private List<Professeur> professeur;
   public Filiere() {
      // TODO: implement
   }

   public Filiere(int idFiliere,String nomFiliere){
      this.idFiliere=idFiliere;
      this.nomFiliere=nomFiliere;
   }

   public Filiere(int idFiliere, String nomFiliere, List<Etudiant> etudiant, List<Professeur> professeur) {
      this.idFiliere = idFiliere;
      this.nomFiliere = nomFiliere;
      this.etudiant = etudiant;
      this.professeur = professeur;
   }

   public int getIdFiliere() {
      return idFiliere;
   }

   public void setIdFiliere(int newIdFiliere) {
      idFiliere = newIdFiliere;
   }

   public String getNomFiliere() {
      return nomFiliere;
   }

   public void setNomFiliere(String newNomFiliere) {
      nomFiliere = newNomFiliere;
   }

   public List<Etudiant> getEtudiant() {
      if (etudiant == null)
         etudiant = new ArrayList<Etudiant>();
      return etudiant;
   }

   public Iterator getIteratorEtudiant() {
      if (etudiant == null)
         etudiant = new ArrayList<Etudiant>();
      return etudiant.iterator();
   }

   public void setEtudiant(List<Etudiant> newEtudiant) {
      removeAllEtudiant();
      for (Iterator iter = newEtudiant.iterator(); iter.hasNext();)
         addEtudiant((Etudiant)iter.next());
   }

   public void addEtudiant(Etudiant newEtudiant) {
      if (newEtudiant == null)
         return;
      if (this.etudiant == null)
         this.etudiant = new ArrayList<Etudiant>();
      if (!this.etudiant.contains(newEtudiant))
      {
         this.etudiant.add(newEtudiant);
         newEtudiant.setFiliere(this);      
      }
   }

   public void removeEtudiant(Etudiant oldEtudiant) {
      if (oldEtudiant == null)
         return;
      if (this.etudiant != null)
         if (this.etudiant.contains(oldEtudiant))
         {
            this.etudiant.remove(oldEtudiant);
            oldEtudiant.setFiliere((Filiere)null);
         }
   }

   public void removeAllEtudiant() {
      if (etudiant != null)
      {
         Etudiant oldEtudiant;
         for (Iterator iter = getIteratorEtudiant(); iter.hasNext();)
         {
            oldEtudiant = (Etudiant)iter.next();
            iter.remove();
            oldEtudiant.setFiliere((Filiere)null);
         }
      }
   }

   public List<Professeur> getProfesseur() {
      if (professeur == null)
         professeur = new ArrayList<Professeur>();
      return professeur;
   }

   public Iterator getIteratorProfesseur() {
      if (professeur == null)
         professeur = new ArrayList<Professeur>();
      return professeur.iterator();
   }

   public void setProfesseur(List<Professeur> newProfesseur) {
      removeAllProfesseur();
      for (Iterator iter = newProfesseur.iterator(); iter.hasNext();)
         addProfesseur((Professeur)iter.next());
   }

   public void addProfesseur(Professeur newProfesseur) {
      if (newProfesseur == null)
         return;
      if (this.professeur == null)
         this.professeur = new ArrayList<Professeur>();
      if (!this.professeur.contains(newProfesseur))
      {
         this.professeur.add(newProfesseur);
         newProfesseur.addFiliere(this);      
      }
   }

   public void removeProfesseur(Professeur oldProfesseur) {
      if (oldProfesseur == null)
         return;
      if (this.professeur != null)
         if (this.professeur.contains(oldProfesseur))
         {
            this.professeur.remove(oldProfesseur);
            oldProfesseur.removeFiliere(this);
         }
   }

   public void removeAllProfesseur() {
      if (professeur != null)
      {
         Professeur oldProfesseur;
         for (Iterator iter = getIteratorProfesseur(); iter.hasNext();)
         {
            oldProfesseur = (Professeur)iter.next();
            iter.remove();
            oldProfesseur.removeFiliere(this);
         }
      }
   }

}