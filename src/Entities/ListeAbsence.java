package Entities; /***********************************************************************
 * Module:  ListeAbsence.java
 * Author:  Amina
 * Purpose: Defines the Class ListeAbsence
 ***********************************************************************/

import java.time.LocalDate;
import java.util.*;

/** @pdOid 063d9924-d088-4a71-9b11-8982778f5acf */
public class ListeAbsence {
   /** @pdOid dbc0cd3f-fb51-411b-91bc-4ffb67c6102d */
   private int idAbs;
   /** @pdOid e4354745-7f4a-49bd-a414-5d0d96783eda */
   private LocalDate dateAbs;
   /** @pdOid 6d23302c-c32a-4988-9c9c-f3fb1d2cefdd */
   private String heureDeb;
   /** @pdOid 5e311611-33ed-44fd-895e-a5953970663b */
   private String heureFin;
   /** @pdOid 635acfad-d4e5-4ab0-944d-c580e229d467 */
   private String module;

   /** @pdRoleInfo migr=no name=Etudiant assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public List<Etudiant> etudiant;
   /** @pdRoleInfo migr=no name=Professeur assc=association2 coll=java.util.List impl=java.util.ArrayList mult=1..* side=A */
   public List<Professeur> professeur;

   /** @pdOid e202593a-eb54-4889-a461-b5cb4b0a5058
    * @param idAbs
    * @param i
    * @param heureDeb
    * @param heureFin
    * @param jamoukh*/
   public ListeAbsence(int idAbs, int i, String heureDeb, String heureFin, String jamoukh) {
      // TODO: implement
   }


   public ListeAbsence(int idAbs, LocalDate dateAbs, String heureDeb, String heureFin, String module) {
      this.idAbs = idAbs;
      this.dateAbs = dateAbs;
      this.heureDeb = heureDeb;
      this.heureFin = heureFin;
      this.module = module;
   }
   public ListeAbsence(LocalDate dateAbs, String heureDeb, String heureFin, String module) {
      this.idAbs = idAbs;
      this.dateAbs = dateAbs;
      this.heureDeb = heureDeb;
      this.heureFin = heureFin;
      this.module = module;
   }

   @Override
   public String toString() {
      return "ListeAbsence{" +
              "idAbs=" + idAbs +
              ", dateAbs=" + dateAbs +
              ", heureDeb='" + heureDeb + '\'' +
              ", heureFin='" + heureFin + '\'' +
              ", module='" + module + '\'' +
              '}';
   }

   /** @pdOid c5ff5498-243e-4a4a-925c-e1ea41017aee */
   public int getIdAbs() {
      return idAbs;
   }

   /** @param newIdAbs
    * @pdOid a2b09bed-134b-41c9-b786-ea4b1a6e6eaa */
   public void setIdAbs(int newIdAbs) {
      idAbs = newIdAbs;
   }

   /** @pdOid 489d54f5-b019-41a3-87f0-61545a9f5dc4
    * @return*/
   public LocalDate getDateAbs() {
      return dateAbs;
   }

   /** @param newDateAbs
    * @pdOid fd69e2d5-d9b5-47a0-8ffe-30f2df42a087 */
   public void setDateAbs(LocalDate newDateAbs) {
      dateAbs = newDateAbs;
   }

   /** @pdOid 58e2f6bd-8ed9-4a59-b7ad-7ea27708ae5e */
   public String getHeureDeb() {
      return heureDeb;
   }

   /** @param newHeureDeb
    * @pdOid e6ed52f8-0b08-460b-ada6-76ed515d6fd8 */
   public void setHeureDeb(String newHeureDeb) {
      heureDeb = newHeureDeb;
   }

   /** @pdOid 4833b78b-10fa-4676-b7fd-08733f7a9215 */
   public String getHeureFin() {
      return heureFin;
   }

   /** @param newHeureFin
    * @pdOid f9fc061b-5a18-46b6-a53d-f3d99e05c0b0 */
   public void setHeureFin(String newHeureFin) {
      heureFin = newHeureFin;
   }

   /** @pdOid 7fc20c18-7776-4892-9650-e2b33f8d20ba */
   public String getModule() {
      return module;
   }

   /** @param newModule
    * @pdOid 297f611f-5557-41e8-b8b4-3761f4bf154e */
   public void setModule(String newModule) {
      module = newModule;
   }


   /** @pdGenerated default getter */
   public List<Etudiant> getEtudiant() {
      if (etudiant == null)
         etudiant = new ArrayList<Etudiant>();
      return etudiant;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorEtudiant() {
      if (etudiant == null)
         etudiant = new ArrayList<Etudiant>();
      return etudiant.iterator();
   }

   /** @pdGenerated default setter
    * @param newEtudiant */
   public void setEtudiant(List<Etudiant> newEtudiant) {
      removeAllEtudiant();
      for (Iterator iter = newEtudiant.iterator(); iter.hasNext();)
         addEtudiant((Etudiant)iter.next());
   }

   /** @pdGenerated default add
    * @param newEtudiant */
   public void addEtudiant(Etudiant newEtudiant) {
      if (newEtudiant == null)
         return;
      if (this.etudiant == null)
         this.etudiant = new ArrayList<Etudiant>();
      if (!this.etudiant.contains(newEtudiant))
      {
         this.etudiant.add(newEtudiant);
         newEtudiant.addListeAbsence(this);
      }
   }

   /** @pdGenerated default remove
    * @param oldEtudiant */
   public void removeEtudiant(Etudiant oldEtudiant) {
      if (oldEtudiant == null)
         return;
      if (this.etudiant != null)
         if (this.etudiant.contains(oldEtudiant))
         {
            this.etudiant.remove(oldEtudiant);
            oldEtudiant.removeListeAbsence(this);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllEtudiant() {
      if (etudiant != null)
      {
         Etudiant oldEtudiant;
         for (Iterator iter = getIteratorEtudiant(); iter.hasNext();)
         {
            oldEtudiant = (Etudiant)iter.next();
            iter.remove();
            oldEtudiant.removeListeAbsence(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public List<Professeur> getProfesseur() {
      if (professeur == null)
         professeur = new ArrayList<Professeur>();
      return professeur;
   }

   /** @pdGenerated default iterator getter */
   public Iterator getIteratorProfesseur() {
      if (professeur == null)
         professeur = new ArrayList<Professeur>();
      return professeur.iterator();
   }

   /** @pdGenerated default setter
    * @param newProfesseur */
   public void setProfesseur(List<Professeur> newProfesseur) {
      removeAllProfesseur();
      for (Iterator iter = newProfesseur.iterator(); iter.hasNext();)
         addProfesseur((Professeur)iter.next());
   }

   /** @pdGenerated default add
    * @param newProfesseur */
   public void addProfesseur(Professeur newProfesseur) {
      if (newProfesseur == null)
         return;
      if (this.professeur == null)
         this.professeur = new ArrayList<Professeur>();
      if (!this.professeur.contains(newProfesseur))
      {
         this.professeur.add(newProfesseur);
         newProfesseur.addListeAbsence(this);
      }
   }

   /** @pdGenerated default remove
    * @param oldProfesseur */
   public void removeProfesseur(Professeur oldProfesseur) {
      if (oldProfesseur == null)
         return;
      if (this.professeur != null)
         if (this.professeur.contains(oldProfesseur))
         {
            this.professeur.remove(oldProfesseur);
            oldProfesseur.removeListeAbsence(this);
         }
   }

   /** @pdGenerated default removeAll */
   public void removeAllProfesseur() {
      if (professeur != null)
      {
         Professeur oldProfesseur;
         for (Iterator iter = getIteratorProfesseur(); iter.hasNext();)
         {
            oldProfesseur = (Professeur)iter.next();
            iter.remove();
            oldProfesseur.removeListeAbsence(this);
         }
      }
   }

}