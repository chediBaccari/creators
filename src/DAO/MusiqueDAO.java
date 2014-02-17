/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Admin;
import entities.Musique;
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
public class MusiqueDAO {
    public void insertMusique(Musique m){

        String requete = "insert into musique  values (default,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, m.getTitre());
            ps.setString(2, m.getLien());
            ps.executeUpdate();
            System.out.println("Ajout de Musique effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion Musique "+ex.getMessage());
        }
    }


    public void updateMusique(Musique m ,int id){
        String requete = "update musique set titre=? , lien=?  where idMusique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, m.getTitre());
            ps.setString(2, m.getLien());
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de Musique effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour Musique "+ex.getMessage());
        }
    }
   

    public void deleteMusique(int id){
        String requete = "delete from musique where idMusique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Musique supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Musique findMusiqueById(int id){
   Musique music = new Musique();
     String requete = "select * from musique where idMusique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
              music.setTitre(resultat.getString(2));
                music.setLien(resultat.getString(3));
            
            }
            return music ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Musique "+ex.getMessage());
            return null;
        }
    }

    public Musique findMusiqueByTitre(String titre){
    Musique   music = new Musique();
     String requete = "select * from musique where titre = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(2));
                music.setTitre(resultat.getString(2));
                music.setLien(resultat.getString(3));
            }
            return music;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Musique"+ex.getMessage());
            return null;
        }
    }

    
    public List<Musique> DisplayAllMusique (){
        
 List<Musique> listeMusique = new ArrayList<Musique>();

        String requete = "select * from musique";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Musique music =new Musique();
                music.setIdMusique(resultat.getInt(1));
                music.setTitre(resultat.getString(2));
                music.setLien(resultat.getString(3));

                listeMusique.add(music);
            }
            return listeMusique;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement Musique "+ex.getMessage());
            return null;
        }
    }
    
}
