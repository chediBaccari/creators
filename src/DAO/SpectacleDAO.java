/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Musique;
import entities.Spectacle;
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
public class SpectacleDAO {
    
    
    public void insertSpectacle(Spectacle s){

        String requete = "insert into spectacle  values (default,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, s.getNom());
            ps.setString(2, s.getDateDebut());
            ps.setString(3,s.getDateFin());
            ps.setInt(4,s.getDuree());
            ps.setString(5, s.getInformation());
            ps.setInt(6,s.getIdImage());
            ps.executeUpdate();
            System.out.println("Ajout de Spectacle effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion Spectacle "+ex.getMessage());
        }
    }


    public void updateSpectacle(Spectacle s ,int id){
        String requete = "update spectacle set nom=? ,dateDebut=?,dateFin=?,duree=?,information=?,idImage=?  where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, s.getNom());
            ps.setString(2, s.getDateDebut());
            ps.setString(3,s.getDateFin());
            ps.setInt(4,s.getDuree());
            ps.setString(5, s.getInformation());
            ps.setInt(6,s.getIdImage());
            ps.setInt(7, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de Spectacle effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour Spectacle "+ex.getMessage());
        }
    }
   

    public void deleteSpectacle(int id){
        String requete = "delete from spectacle where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Spectacle supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression Spectacle "+ex.getMessage());
        }
    }


    public Spectacle findSpectacleById(int id){
   Spectacle sp = new Spectacle();
     String requete = "select * from spectacle where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               sp.setNom(resultat.getString(2));
               sp.setDateDebut(resultat.getString(3));
               sp.setDateFin(resultat.getString(4));
               sp.setDuree(resultat.getInt(5));
               sp.setInformation(resultat.getString(6));
               sp.setIdImage(resultat.getInt(7));
            }
            return sp ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Spectacle "+ex.getMessage());
            return null;
        }
    }

    public Spectacle findSpectacleByNom(String titre){
    Spectacle sp = new Spectacle();
     String requete = "select * from spectacle where nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(1));
               sp.setNom(resultat.getString(2));
               sp.setDateDebut(resultat.getString(3));
               sp.setDateFin(resultat.getString(4));
               sp.setDuree(resultat.getInt(5));
               sp.setInformation(resultat.getString(6));
               sp.setIdImage(resultat.getInt(7));
            }
            return sp ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Spectacle"+ex.getMessage());
            return null;
        }
    }

    
    public List<Spectacle> DisplayAllSpectacle (){
        
 List<Spectacle> listeSpectacle = new ArrayList<Spectacle>();

        String requete = "select * from spectacle";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Spectacle sp =new Spectacle();
                sp.setIdRubrique(resultat.getInt(1));
                sp.setNom(resultat.getString(2));
               sp.setDateDebut(resultat.getString(3));
               sp.setDateFin(resultat.getString(4));
               sp.setDuree(resultat.getInt(5));
               sp.setInformation(resultat.getString(6));
               sp.setIdImage(resultat.getInt(7));

                listeSpectacle.add(sp);
            }
            return listeSpectacle;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement Spectacle "+ex.getMessage());
            return null;
        }
    }
}
