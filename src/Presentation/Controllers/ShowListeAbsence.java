package Presentation.Controllers;

import Entities.Etudiant;
import Entities.ListeAbsence;
import Metier.IMetier;
import Metier.IMetierImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ShowListeAbsence implements Initializable {

    @FXML
    private TableColumn<ListeAbsence, LocalDate> dateColumn;

    @FXML
    private TableColumn<ListeAbsence, String> heureDebColumn;

    @FXML
    private TableColumn<ListeAbsence, String> heureFinColumn;

    @FXML
    private TableColumn<ListeAbsence, String> moduleColumn;

    @FXML
    private TableView<ListeAbsence> tableView;


    static ObservableList<ListeAbsence> listAbsence = FXCollections.observableArrayList();
    IMetier metier;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateAbs"));
        heureDebColumn.setCellValueFactory(new PropertyValueFactory<>("heureDeb"));
        heureFinColumn.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
        moduleColumn.setCellValueFactory(new PropertyValueFactory<>("module"));
        metier = new IMetierImpl();
        if(FiliereController.getFiliere().getIdFiliere()==1){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }

        if(FiliereController.getFiliere().getIdFiliere()==2){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }

        if(FiliereController.getFiliere().getIdFiliere()==3){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }

        if(FiliereController.getFiliere().getIdFiliere()==4){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }

        if(FiliereController.getFiliere().getIdFiliere()==5){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }

        if(FiliereController.getFiliere().getIdFiliere()==6){
            listAbsence.clear();
            listAbsence.addAll(metier.getAllListAbsenceByEtudiant(ListEtudiantController.getEtudiant()));
            tableView.setItems(listAbsence);
        }
    }
}
