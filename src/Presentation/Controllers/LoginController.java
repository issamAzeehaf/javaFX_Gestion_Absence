package Presentation.Controllers;

import Entities.Professeur;
import Metier.IMetier;
import Metier.IMetierImpl;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private JFXTextField login_field;

    @FXML
    private JFXPasswordField password_field;

    private static Professeur professeur;
    public IMetier metier;

    public static Professeur getProfesseur() {
        return professeur;
    }

    public void connection(ActionEvent event) {
        String log = login_field.getText();
        String password = password_field.getText();
        IMetier metier = new IMetierImpl();
        metier.checkInfoUser(log,password);
        try{
            if(metier.checkInfoUser(log,password)){
                metier = new IMetierImpl();
                professeur = metier.getProfByLogin(log);
                Parent root = FXMLLoader.load(getClass().getResource("../Vue/listeFiliere.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                String css = this.getClass().getResource("../Vue/listeFiliere.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("vote login ou Mot de passe sont incorrecte");
                alert.showAndWait();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
