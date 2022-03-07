package Entities;

import java.util.*;



public class Etudiant {

   private int idEtudiant;
   private String nomEtudiant;
   private String prenomEtudiant;
   private String teleEtudiant;
   private String emailEtudiant;
   private Filiere filiere;
   private List<ListeAbsence> listeAbsence ;

   public Etudiant() {
      // TODO: implement
   }

   public Etudiant(int idEtudiant,Filiere filiere, String nomEtudiant, String prenomEtudiant, String teleEtudiant, String emailEtudiant) {
       this.idEtudiant=idEtudiant;
       this.filiere=filiere;
       this.nomEtudiant=nomEtudiant;
       this.prenomEtudiant=prenomEtudiant;
       this.teleEtudiant=teleEtudiant;
       this.emailEtudiant=emailEtudiant;
   }
   public Etudiant(Filiere filiere, String nomEtudiant, String prenomEtudiant, String teleEtudiant, String emailEtudiant){
      this.filiere=filiere;
      this.nomEtudiant=nomEtudiant;
      this.prenomEtudiant=prenomEtudiant;
      this.teleEtudiant=teleEtudiant;
      this.emailEtudiant=emailEtudiant;
   }

   public int getIdEtudiant() {
      return idEtudiant;
   }

   public void setIdEtudiant(int newIdEtudiant) {
      idEtudiant = newIdEtudiant;
   }

   public String getNomEtudiant() {
      return nomEtudiant;
   }

   public void setNomEtudiant(String newNomEtudiant) {
      nomEtudiant = newNomEtudiant;
   }

   public String getPrenomEtudiant() {
      return prenomEtudiant;
   }

   public void setPrenomEtudiant(String newPrenomEtudiant) {
      prenomEtudiant = newPrenomEtudiant;
   }

   public String getTeleEtudiant() {
      return teleEtudiant;
   }

   public void setTeleEtudiant(String newTeleEtudiant) {
      teleEtudiant = newTeleEtudiant;
   }

   public String getEmailEtudiant() {
      return emailEtudiant;
   }

   public void setEmailEtudiant(String newEmailEtudiant) {
      emailEtudiant = newEmailEtudiant;
   }

   public Filiere getFiliere() {
      return filiere;
   }

   public void setFiliere(Filiere newFiliere) {
      if (this.filiere == null || !this.filiere.equals(newFiliere))
      {
         if (this.filiere != null)
         {
            Filiere oldFiliere = this.filiere;
            this.filiere = null;
            oldFiliere.removeEtudiant(this);
         }
         if (newFiliere != null)
         {
            this.filiere = newFiliere;
            this.filiere.addEtudiant(this);
         }
      }
   }

   @Override
   public String toString() {
      return "Etudiant{" +
              "idEtudiant=" + idEtudiant +
              ", nomEtudiant='" + nomEtudiant + '\'' +
              ", prenomEtudiant='" + prenomEtudiant + '\'' +
              ", teleEtudiant='" + teleEtudiant + '\'' +
              ", emailEtudiant='" + emailEtudiant + '\'' +
              '}';
   }

   public List<ListeAbsence> getListeAbsence() {
      if (listeAbsence == null)
         listeAbsence = new ArrayList<>();
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
         newListeAbsence.addEtudiant(this);      
      }
   }
   public void removeListeAbsence(ListeAbsence oldListeAbsence) {
      if (oldListeAbsence == null)
         return;
      if (this.listeAbsence != null)
         if (this.listeAbsence.contains(oldListeAbsence))
         {
            this.listeAbsence.remove(oldListeAbsence);
            oldListeAbsence.removeEtudiant(this);
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
            oldListeAbsence.removeEtudiant(this);
         }
      }
   }

}