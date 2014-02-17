/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Musique;
import entities.Noter;
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
public class NoterDAO {
    
    
     public void insertNoter(Noter m){

        String requete = "insert into noter  values (default ,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, m.getIdRubrique());
            ps.setInt(2, m.getIdClient());
            ps.setInt(3,m.getNbrEtoile());
            ps.executeUpdate();
            System.out.println("Ajout de Noter effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion Noter :"+ex.getMessage());
        }
    }


    public void updateNoter(Noter m ,int id){
        String requete = "update noter set idRubrique=? ,idClient=? ,nbrEtoile=?  where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, m.getIdRubrique());
            ps.setInt(2, m.getIdClient());
            ps.setInt(3,m.getNbrEtoile());
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de NOTER effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour Noter "+ex.getMessage());
        }   
    }
   

    public void deleteNoter(int id){
        String requete = "delete from noter where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Noter supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression d'Noter "+ex.getMessage());
        }
    }


    public Noter findNoterById(int id){
   Noter not = new Noter();
     String requete = "select * from noter where idNote=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
             not.setIdRubrique(resultat.getInt(2));
                not.setIdClient(resultat.getInt(3));
            not.setNbrEtoile(resultat.getInt(4));
            }
            return not ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche Noter "+ex.getMessage());
            return null;
        }
    }

//    public Musique findMusiqueByTitre(String titre){
//    Musique   music = new Musique();
//     String requete = "select * from noter where titre = ?";
//        try {
//            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
//            ps.setString(1, titre);
//            ResultSet resultat = ps.executeQuery();
//            while (resultat.next())
//            {
//                
//                System.out.println(resultat.getString(2));
//                music.setTitre(resultat.getString(2));
//                music.setLien(resultat.getString(3));
//            }
//            return music;
//
//        } catch (SQLException ex) {
//           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors de la recherche Musique"+ex.getMessage());
//            return null;
//        }
//    }

    
    public List<Noter> DisplayAllNoter (){
        
 List<Noter> listeNoter = new ArrayList<Noter>();

        String requete = "select * from noter";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Noter not =new Noter();
                not.setIdNote(resultat.getInt(1));
                not.setIdRubrique(resultat.getInt(2));
                not.setIdClient(resultat.getInt(3));
                not.setNbrEtoile(resultat.getInt(4));

                listeNoter.add(not);
            }
            return listeNoter;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement Noter "+ex.getMessage());
            return null;
        }
    }
    
}
