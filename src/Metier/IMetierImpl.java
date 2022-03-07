package Metier;

import DAO.SignletonConnexionDB;
import Entities.Etudiant;
import Entities.Filiere;
import Entities.ListeAbsence;
import Entities.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IMetierImpl implements IMetier{
    @Override
    public boolean checkInfoUser(String login, String password) {
        Connection connection = SignletonConnexionDB.getConnection();
        boolean check = false;
        try{
            String sql ="select * from professeur where login=? and pass=?";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                check = true;
            }else{
                check = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(check);
        return check;
    }

    @Override
    public void addEtudiant(Etudiant etudiant) {
        Connection connection = SignletonConnexionDB.getConnection();
        try{
            String sql = "insert into etudiant(idFiliere,nomEtudiant,prenomEtudiant,teleEtudiant,emailEtudiant) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,etudiant.getFiliere().getIdFiliere());
            ps.setString(2,etudiant.getNomEtudiant());
            ps.setString(3,etudiant.getPrenomEtudiant());
            ps.setString(4,etudiant.getTeleEtudiant());
            ps.setString(5,etudiant.getEmailEtudiant());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        try {
            PreparedStatement pst = SignletonConnexionDB.getConnection().prepareStatement("delete from etudiant where idEtudiant = ? ");
            pst.setInt(1,etudiant.getIdEtudiant());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEtudiant(int idEtudiant, Etudiant etudiant) {
        Connection connection = SignletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=connection.prepareStatement("update Etudiant set nomEtudiant=?,prenomEtudiant=?,teleEtudiant=?,emailEtudiant=? where idEtudiant=?");
            pstm.setString(1,etudiant.getNomEtudiant());
            pstm.setString(2,etudiant.getPrenomEtudiant());
            pstm.setString(3,etudiant.getTeleEtudiant());
            pstm.setString(4,etudiant.getEmailEtudiant());
            pstm.setInt(5,idEtudiant);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void createAbsence(ListeAbsence listeAbsence, Professeur professeur, Etudiant etudiant) {

        try {
            PreparedStatement pst = SignletonConnexionDB.getConnection().prepareStatement("insert into listeabsence (dateAbs, heureDeb, heureFin, module)  values (?,?,?,?)");
            Date date=Date.valueOf(listeAbsence.getDateAbs());
            pst.setDate(1,date);
            pst.setString(2,listeAbsence.getHeureDeb());
            pst.setString(3,listeAbsence.getHeureFin());
            pst.setString(4,listeAbsence.getModule());
            pst.execute();
            String sql2 ="SELECT * FROM listeabsence ORDER BY idAbs DESC LIMIT 1";
            PreparedStatement pst1 = SignletonConnexionDB.getConnection().prepareStatement(sql2);
            ResultSet rs = pst1.executeQuery();
            if(rs.next()){
                String sql3 = "insert into absenter(idAbs,idEtudiant) values (?,?)";
                PreparedStatement pst3 = SignletonConnexionDB.getConnection().prepareStatement(sql3);
                pst3.setInt(1,rs.getInt("idAbs"));
                pst3.setInt(2,etudiant.getIdEtudiant());
                pst3.execute();
                PreparedStatement pst2 = SignletonConnexionDB.getConnection().prepareStatement("insert into remplir(idProf,idAbs) values (?,?)");
                pst2.setInt(1,professeur.getIdProf());
                pst2.setInt(2,rs.getInt("idAbs"));
                pst2.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        Connection connection = SignletonConnexionDB.getConnection();
        List<Etudiant> listEtudiants = new ArrayList<>();

        try{
            String sql = "select * from etudiant";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                String sql1 = "select * from filiere where idFiliere = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setInt(1,rs.getInt("idFiliere"));
                ResultSet rs1 = ps1.executeQuery();
                Filiere f = null;
                if(rs1.next()){
                    f=new Filiere(rs1.getInt("idFiliere"),rs1.getString(2));
                }
                    Etudiant etudiant = new Etudiant(rs.getInt("idEtudiant"),f,rs.getString("nomEtudiant"),rs.getString("prenomEtudiant"),rs.getString("teleEtudiant"),rs.getString("emailEtudiant"));
                    listEtudiants.add(etudiant);
            }
            return listEtudiants;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ListeAbsence> getAllListAbsenceByEtudiant(Etudiant etudiant){
        Connection connection = SignletonConnexionDB.getConnection();
        List<ListeAbsence> listeAbsences = new ArrayList<>();

        try{
            String sql = "select * from absenter where idEtudiant = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,etudiant.getIdEtudiant());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String sql2 = "select * from listeabsence where idAbs = ?";
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1,rs.getInt("idAbs"));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    Date date=rs2.getDate("dateAbs");
                    ListeAbsence listeAbsence = new ListeAbsence(rs2.getInt("idAbs"),date.toLocalDate(),rs2.getString("heureDeb"),rs2.getString("heureFin"),rs2.getString("module"));
                    listeAbsences.add(listeAbsence);
                }
            }
            return listeAbsences;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        /*try{
            String sql = "select * from absenter where idEtudiant = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,etudiant.getIdEtudiant());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String sql2 = "select * from listeabsence where idAbs = ?";
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1,rs.getInt("idAbs"));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    Date date=rs2.getDate("dateAbs");
                    ListeAbsence listeAbsence = new ListeAbsence(rs2.getInt("idAbs"),date.toLocalDate(),rs2.getString("heureDeb"),rs2.getString("heureFin"),rs2.getString("module"));
                    listeAbsences.add(listeAbsence);
                }
            }
            return listeAbsences;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

         */
    }

    @Override
    public Professeur getProfByLogin(String login) {
        Connection connection = SignletonConnexionDB.getConnection();
        Professeur professeur = null;
        try{

            String sql = "select * from professeur where login = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                professeur = new Professeur(rs.getInt("idProf"),rs.getString("nom"),rs.getString("login"),rs.getString("pass"));
            }
            return professeur;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkFiliere(int idProf, int idFiliere) {
        Connection connection = SignletonConnexionDB.getConnection();
        Boolean check = false;
        try{
            String sql = "select * from enseigner where idProf = ? and idFiliere = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,idProf);
            ps.setInt(2,idFiliere);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                check = true;
            }
            return check;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Etudiant> getAllEtudiantsByFiliere(Filiere filiere) {
        Connection connection = SignletonConnexionDB.getConnection();
        List<Etudiant> listEtudiants = new ArrayList<>();

        try{
            String sql = "select * from etudiant where idFiliere = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,filiere.getIdFiliere());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Etudiant etudiant = new Etudiant(rs.getInt("idEtudiant"),filiere,rs.getString("nomEtudiant"),rs.getString("prenomEtudiant"),rs.getString("teleEtudiant"),rs.getString("emailEtudiant"));
                listEtudiants.add(etudiant);
            }
            return listEtudiants;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
