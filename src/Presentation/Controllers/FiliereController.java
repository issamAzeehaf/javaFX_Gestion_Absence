package Presentation.Controllers;

import Entities.Filiere;
import Metier.IMetier;
import Metier.IMetierImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FiliereController implements Initializable {
    @FXML
    private Button BDCC1;

    @FXML
    private Button BDCC2;

    @FXML
    private Button BDCC3;

    @FXML
    private Button GLSID1;

    @FXML
    private Button GLSID2;

    @FXML
    private Button GLSID3;

    @FXML
    private Label nomProf;

    private static Filiere filiere;
    IMetier metier;
    private boolean check;

    public static Filiere getFiliere() {
        return filiere;
    }

    public void BDCC1() {
        filiere = new Filiere(1,"BDCC-1");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
        if(check){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez choisir une filiere que vous enseigner");
            alert.showAndWait();
        }

    }


    public void BDCC2() {
        filiere = new Filiere(2,"BDCC-2");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
        if(check) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez choisir une filiere que vous enseigner");
            alert.showAndWait();
        }
    }


    public void BDCC3() {
        filiere = new Filiere(3,"BDCC-3");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
            if(check) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                    scene.getStylesheets().add(css);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Vous devez choisir une filiere que vous enseigner");
                alert.showAndWait();
            }
    }


    public void GLSID1() {
        filiere = new Filiere(4,"GLSID1");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
        if(check) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez choisir une filiere que vous enseigner");
            alert.showAndWait();
        }
    }


    public void GLSID2() {
        filiere = new Filiere(5,"GLSID2");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
        if(check) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez choisir une filiere que vous enseigner");
            alert.showAndWait();
        }
    }


    public void GLSID3() {
        filiere = new Filiere(6,"GLSID3");
        metier = new IMetierImpl();
        check = metier.checkFiliere(LoginController.getProfesseur().getIdProf(),filiere.getIdFiliere());
        if(check) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeEtudiant.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeEtudiant.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez choisir une filiere que vous enseigner");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomProf.setText("Bonjour "+LoginController.getProfesseur().getLogin()+" "+LoginController.getProfesseur().getNom());

    }
}
