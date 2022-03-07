package Presentation.Controllers;

import Entities.Etudiant;
import Entities.Filiere;
import Metier.IMetier;
import Metier.IMetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class ListEtudiantController  implements Initializable {
    @FXML
    private TableColumn<Etudiant, String> email;

    @FXML
    private TableColumn<Etudiant, String> nom;

    @FXML
    private TableColumn<Etudiant, String> prenom;

    @FXML
    private TableColumn<Etudiant, String> telephone;

    @FXML
    private TableView<Etudiant> tableView;

    private static String updateNom;
    private static String updatePrenom;
    private static String updateEmail;
    private static String updateTelephone;
    private static int updateId;
    private static Etudiant etudiant;

    public static Etudiant getEtudiant() {
        return etudiant;
    }

    static ObservableList<Etudiant> listEtudiants = FXCollections.observableArrayList();
    IMetier metier;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        nom.setCellValueFactory((new PropertyValueFactory<>("nomEtudiant")));
        prenom.setCellValueFactory((new PropertyValueFactory<>("prenomEtudiant")));
        email.setCellValueFactory((new PropertyValueFactory<>("emailEtudiant")));
        telephone.setCellValueFactory((new PropertyValueFactory<>("teleEtudiant")));
        metier = new IMetierImpl();
        if(FiliereController.getFiliere().getIdFiliere()==1){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }

        if(FiliereController.getFiliere().getIdFiliere()==2){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }

        if(FiliereController.getFiliere().getIdFiliere()==3){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }

        if(FiliereController.getFiliere().getIdFiliere()==4){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }

        if(FiliereController.getFiliere().getIdFiliere()==5){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }

        if(FiliereController.getFiliere().getIdFiliere()==6){
            listEtudiants.clear();
            listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            tableView.setItems(listEtudiants);
        }


    }


    public void addEtudiant(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../Vue/addEtudiant.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ajouter un etudiant");
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("../Vue/addEtudiant.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setAlwaysOnTop(true);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteEtudiant(){
        try{
            int indicePos = tableView.getSelectionModel().getSelectedIndex();
            if(indicePos>=0){
                int idEtudiant = tableView.getSelectionModel().getSelectedItem().getIdEtudiant();
                String nomEtudiant =tableView.getSelectionModel().getSelectedItem().getNomEtudiant();
                String prenomEtudiant = tableView.getSelectionModel().getSelectedItem().getPrenomEtudiant();
                String emailEtudiant = tableView.getSelectionModel().getSelectedItem().getEmailEtudiant();
                String telEtudiant = tableView.getSelectionModel().getSelectedItem().getTeleEtudiant();
                Filiere filiere = new Filiere(FiliereController.getFiliere().getIdFiliere(),FiliereController.getFiliere().getNomFiliere());
                Etudiant etudiant = new Etudiant(idEtudiant,filiere,nomEtudiant,prenomEtudiant,telEtudiant,emailEtudiant);
                tableView.getItems().remove(etudiant);
                metier.deleteEtudiant(etudiant);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supression");
                alert.setContentText("l'etudiant a ete bien supprimer");
                alert.showAndWait();
                ListEtudiantController.listEtudiants.clear();
                ListEtudiantController.listEtudiants.addAll(metier.getAllEtudiantsByFiliere(FiliereController.getFiliere()));
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supression");
                alert.setContentText("Vous devez selectionner un etudiant");
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateEtudiant(){
        try{
            int indicePos = tableView.getSelectionModel().getSelectedIndex();
            if(indicePos>=0){
                updateId = tableView.getSelectionModel().getSelectedItem().getIdEtudiant();
                updateNom = tableView.getSelectionModel().getSelectedItem().getNomEtudiant();
                updatePrenom = tableView.getSelectionModel().getSelectedItem().getPrenomEtudiant();
                updateEmail = tableView.getSelectionModel().getSelectedItem().getEmailEtudiant();
                updateTelephone = tableView.getSelectionModel().getSelectedItem().getTeleEtudiant();
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/updateEtudiant.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Modifier un etudiant");
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/addEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setAlwaysOnTop(true);
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update");
                alert.setContentText("Vous devez selectionner un etudiant");
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createAbsence(){
        try{
            int indicePos = tableView.getSelectionModel().getSelectedIndex();
            if(indicePos>=0) {
                int idEtudiant = tableView.getSelectionModel().getSelectedItem().getIdEtudiant();
                String nomEtudiant = tableView.getSelectionModel().getSelectedItem().getNomEtudiant();
                String prenomEtudiant = tableView.getSelectionModel().getSelectedItem().getPrenomEtudiant();
                String emailEtudiant = tableView.getSelectionModel().getSelectedItem().getEmailEtudiant();
                String telEtudiant = tableView.getSelectionModel().getSelectedItem().getTeleEtudiant();
                etudiant = new Etudiant(idEtudiant,FiliereController.getFiliere(),nomEtudiant,prenomEtudiant,telEtudiant,emailEtudiant);
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/createAbsence.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Creer une absence");
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/createAbsence.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setAlwaysOnTop(true);
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Vous devez selectionner un etudiant");
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showListAbsence(){
        try{
            int indicePos = tableView.getSelectionModel().getSelectedIndex();
            if(indicePos>=0) {
                int idEtudiant = tableView.getSelectionModel().getSelectedItem().getIdEtudiant();
                String nomEtudiant = tableView.getSelectionModel().getSelectedItem().getNomEtudiant();
                String prenomEtudiant = tableView.getSelectionModel().getSelectedItem().getPrenomEtudiant();
                String emailEtudiant = tableView.getSelectionModel().getSelectedItem().getEmailEtudiant();
                String telEtudiant = tableView.getSelectionModel().getSelectedItem().getTeleEtudiant();
                etudiant = new Etudiant(idEtudiant,FiliereController.getFiliere(),nomEtudiant,prenomEtudiant,telEtudiant,emailEtudiant);
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/showListeAbsence.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Liste d'absence");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setAlwaysOnTop(true);
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Vous devez selectionner un etudiant");
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getUpdateNom() {
        return updateNom;
    }

    public static String getUpdatePrenom() {
        return updatePrenom;
    }

    public static String getUpdateEmail() {
        return updateEmail;
    }

    public static String getUpdateTelephone() {
        return updateTelephone;
    }

    public static int getUpdateId() {
        return updateId;
    }

    public static void sendMessage(String subject, String text, String destinataire, String copyDest) {

    }
}
