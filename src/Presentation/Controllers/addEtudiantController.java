package Presentation.Controllers;

import Entities.Etudiant;
import Entities.Filiere;
import Metier.IMetier;
import Metier.IMetierImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class addEtudiantController {
    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldPrenom;

    @FXML
    private TextField fieldTelephone;

    @FXML
    private Button buttonAnnuler;

    Stage stage = new Stage();
    IMetier metier;
    public void enregistrerEtudiant(){
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String email = fieldEmail.getText();
        String telephone = fieldTelephone.getText();
        Filiere filiere = new Filiere(FiliereController.getFiliere().getIdFiliere(),FiliereController.getFiliere().getNomFiliere());
        Etudiant etudiant = new Etudiant(filiere,nom,prenom,telephone,email);
        metier = new IMetierImpl();
        metier.addEtudiant(etudiant);
        Stage stage = (Stage) buttonAnnuler.getScene().getWindow();
        stage.close();
        ListEtudiantController.listEtudiants.clear();
        ListEtudiantController.listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
    }
    public void annuler(){
        Stage stage = (Stage) buttonAnnuler.getScene().getWindow();
        stage.close();
    }
}
