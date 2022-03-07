package Presentation.Controllers;

import Entities.Etudiant;
import Entities.Filiere;
import Entities.ListeAbsence;
import Entities.Professeur;
import Metier.IMetier;
import Metier.IMetierImpl;
import com.sun.deploy.util.SessionProperties;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

public class CreateAbsence {
    @FXML
    private Button Annuler;

    @FXML
    private Button Enregistrer;

    @FXML
    private TextField Module;

    @FXML
    private DatePicker dateAbs;

    @FXML
    private TextField heureDeb;

    @FXML
    private TextField heureFin;

    IMetier metier;

    public void createAbsence(){
        LocalDate date = dateAbs.getValue();
        String heuredebut = heureDeb.getText();
        String heurefin = heureFin.getText();
        String Module = this.Module.getText();
        Filiere filiere = new Filiere(FiliereController.getFiliere().getIdFiliere(),FiliereController.getFiliere().getNomFiliere());
        metier = new IMetierImpl();
        ListeAbsence listeAbsence = new ListeAbsence(date,heuredebut,heurefin,Module);
        Professeur professeur = new Professeur(LoginController.getProfesseur().getIdProf(),LoginController.getProfesseur().getNom(),LoginController.getProfesseur().getLogin(),LoginController.getProfesseur().getPass());
        metier.createAbsence(listeAbsence,professeur,ListEtudiantController.getEtudiant());

        String from = "issam.azf@gmail.com";
        String msgBody = "Bonjour "+ListEtudiantController.getEtudiant().getPrenomEtudiant()+
                "\n Veuillez justifier votre absence du  : "+
                "\n\t date : "+date+
                "\t\n heure Debut : "+heuredebut+
                "\t\n heure fin : "+heurefin+
                "\t\n Module : "+Module+
                "\t=n Le plutot possible ";
        String to = ListEtudiantController.getEtudiant().getEmailEtudiant();
        String subject = "Justification absence";

        Stage stage = (Stage) Enregistrer.getScene().getWindow();
        stage.close();


    }

    public void Annuler(){
        Stage stage = (Stage) Annuler.getScene().getWindow();
        stage.close();
    }
/*
    public void sendMail(String from,String To,String subject,String bodyMsg){
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(To));
            message.setSubject(subject);
            message.setText(bodyMsg);

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (Exception e) {e.printStackTrace();}
    }

 */

}
/*
    public void sendMail(){
        String to = ListEtudiantController.getEtudiant().getEmailEtudiant();
        String host = "smtp.gmail.com";
        final String username = "issam.azf@gmail.com";
        final String password = "7dbcc24d4e++";
        String from = "issam.azf@gmail.com";

        String subject = "Bonjour "+ListEtudiantController.getEtudiant().getPrenomEtudiant()+
                        "\n Veuillez justifier votre absence du  : "+
                            "\n\t date : "+dateAbs.getValue()+
                            "\t\n heure Debut : "+heureDeb.getText()+
                            "\t\n heure fin : "+heureFin.getText()+
                            "\t\n Module : "+Module.getText()+
                        "\t=n Le plutot possible ";


        Properties props = System.getProperties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port","587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentification(){
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            //creation du mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
            m.setSubject("Jusification Absence");
            m.setText(subject);
            //Envoie du mail
            Transport.send(m,"user","password");
        }catch (Exception e){
            e.printStackTrace();
        }
*/





