package Presentation.Controllers;

import Entities.Etudiant;
import Entities.Filiere;
import Metier.IMetier;
import Metier.IMetierImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class updateEtudiantController implements Initializable {
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

    @FXML
    private Button buttonEnregistrer;


    IMetier metier;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldNom.setText(ListEtudiantController.getUpdateNom());
        fieldPrenom.setText(ListEtudiantController.getUpdatePrenom());
        fieldEmail.setText(ListEtudiantController.getUpdateEmail());
        fieldTelephone.setText(ListEtudiantController.getUpdateTelephone());
    }
    public void enregistrerEtudiant(){
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String email = fieldEmail.getText();
        String telephone = fieldTelephone.getText();
        metier = new IMetierImpl();
        Filiere filiere = new Filiere(FiliereController.getFiliere().getIdFiliere(),FiliereController.getFiliere().getNomFiliere());
        Etudiant etudiant = new Etudiant(filiere,nom,prenom,telephone,email);
        metier.updateEtudiant(ListEtudiantController.getUpdateId(),etudiant);
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
