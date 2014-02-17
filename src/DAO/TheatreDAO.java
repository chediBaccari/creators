/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Musique;
import entities.Theatre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AhmedAsus
 */
public class TheatreDAO {
     public void insertTheatre(Theatre t){

        String requete = "insert into theatre  values (default,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, t.getNom());
            ps.setString(2,t.getDateDebut());
            ps.setString(3, t.getDateFin());
            ps.setInt(4, t.getDuree());
            ps.setString(5, t.getInformation());
            ps.setInt(6 , t.getIdImage());
            ps.executeUpdate();
            System.out.println("Ajout de Theatre effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion Theatre "+ex.getMessage());
        }
    }


    public void updateTheatre(Theatre t ,int id){
        String requete = "update theatre set nom=? , dateDebut=? , dateFin=? ,  duree=? , information=?  ,  idImage=?  where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                ps.setString(1,t.getNom());
                ps.setString(2, t.getDateDebut());
                ps.setString(3, t.getDateFin());
                ps.setInt(4, t.getDuree());
                ps.setString(5, t.getInformation());
                ps.setInt(6, t.getIdImage());
                ps.setInt(7, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de Theatre effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour Theatre "+ex.getMessage());
        }
    }
   

    public void deleteTheatre(int id){
        String requete = "delete from theatre where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Theatre supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression du Theatre "+ex.getMessage());
        }
    }


    public Theatre findTheatreById(int id){
   Theatre thea = new Theatre();
     String requete = "select * from theatre where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
            thea.setNom(resultat.getString(2));
            thea.setDateDebut(resultat.getString(3));
            thea.setDateFin(resultat.getString(4));
            thea.setDuree(resultat.getInt(5));
            thea.setInformation(resultat.getString(6));
            thea.setIdImage(resultat.getInt(7));
            }
            return thea ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Theatre "+ex.getMessage());
            return null;
        }
    }

    public Theatre findTheatreByName(String name){
    Theatre   thea = new Theatre();
     String requete = "select * from theatre where nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, name);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(2));
            thea.setNom(resultat.getString(2));
            thea.setDateDebut(resultat.getString(3));
            thea.setDateFin(resultat.getString(4));
            thea.setDuree(resultat.getInt(5));
            thea.setInformation(resultat.getString(6));
            thea.setIdImage(resultat.getInt(7));
            }
            return thea;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Theatre"+ex.getMessage());
            return null;
        }
    }

    
    public List<Theatre> DisplayAllTheatre (){
        
 List<Theatre> listeTheatre = new ArrayList<Theatre>();

        String requete = "select * from theatre";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
            Theatre thea =new Theatre();
                    thea.setNom(resultat.getString(2));
                    thea.setDateDebut(resultat.getString(3));
                    thea.setDateFin(resultat.getString(4));
                    thea.setDuree(resultat.getInt(5));
                    thea.setInformation(resultat.getString(6));
                    thea.setIdImage(resultat.getInt(7));

                listeTheatre.add(thea);
            }
            return listeTheatre;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement Theatre "+ex.getMessage());
            return null;
        }
    }
}
