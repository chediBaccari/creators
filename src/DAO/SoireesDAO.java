/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Musique;
import entities.Soirees;
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
public class SoireesDAO {
    public void insertSoirees(Soirees s){

        String requete = "insert into soirées  values (default,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, s.getTitre());
            ps.setString(2, s.getDate());   
            ps.setString(3, s.getHeur());
            ps.setString(4, s.getInformation());
            ps.setInt(5,s.getIdLieu());
            ps.executeUpdate();
            System.out.println("Ajout de Soirées effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion Soirées "+ex.getMessage());
        }
    }


    public void updateSoirees(Soirees s ,int id){
        String requete = "update soirées set date=?,titre=? , heur=? ,information=?,idLieu=?  where idSoiree=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, s.getDate());
            ps.setString(2, s.getTitre());
            ps.setString(3, s.getHeur());
            ps.setString(4, s.getInformation());
            ps.setInt(5,s.getIdLieu());
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de Soirées effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour Soirées "+ex.getMessage());
        }
    }
   

    public void deleteSoirées(int id){
        String requete = "delete from soirées where idSoiree=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Soiree supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Soirees findSoireesById(int id){
   Soirees soir = new Soirees();
     String requete = "select * from soirées where idSoiree=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
              soir.setDate(resultat.getString(3));
              soir.setTitre(resultat.getString(2));
                soir.setHeur(resultat.getString(4));
                soir.setInformation(resultat.getString(5));
                soir.setIdLieu(resultat.getInt(6));
            }
            return soir ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Soirées "+ex.getMessage());
            return null;
        }
    }

    public Soirees findSoireesByTitre(String titre){
    Soirees soir = new Soirees();
     String requete = "select * from soirées where titre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(1));
                soir.setDate(resultat.getString(3));
              soir.setTitre(resultat.getString(2));
                soir.setHeur(resultat.getString(4));
                soir.setInformation(resultat.getString(5));
                soir.setIdLieu(resultat.getInt(6));
            }
            return soir;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Soirees"+ex.getMessage());
            return null;
        }
    }
    
    public Soirees findSoireesByLieu(int idLieu){
    Soirees soir = new Soirees();
     String requete = "select * from soirées where idLieu=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, idLieu);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(1));
                soir.setDate(resultat.getString(3));
              soir.setTitre(resultat.getString(2));
                soir.setHeur(resultat.getString(4));
                soir.setInformation(resultat.getString(5));
                soir.setIdLieu(resultat.getInt(6));
            }
            return soir;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Soirees"+ex.getMessage());
            return null;
        }
    }

    
    public List<Soirees> DisplayAllSoirees (){
        
 List<Soirees> listeSoirees = new ArrayList<Soirees>();

        String requete = "select * from soirées";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Soirees soir =new Soirees();
                soir.setIdSoiree(resultat.getInt(1));
                soir.setTitre(resultat.getString(2));
                soir.setDate(resultat.getString(3));
                soir.setHeur(resultat.getString(4));
                soir.setInformation(resultat.getString(5));
                soir.setIdLieu(resultat.getInt(6));

                listeSoirees.add(soir);
            }
            return listeSoirees;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement Soirées "+ex.getMessage());
            return null;
        }
    }
    
}
