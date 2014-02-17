/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Commentaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chedi
 */
public class CommentaireDAO {
    
    
     public void insertCommentaire(Commentaire c){

        String requete = "insert into commentaire(idClient,idRubrique,commentaire) values (?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          
            ps.setInt(1, c.getIdClient());
            ps.setInt(2, c.getIdRubrique());
            ps.setString(3, c.getCommentaire());
          
            ps.executeUpdate();
            System.out.println("Ajout du commentaire effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateCommentaire(String c,int idCommentaire ){
        String requete = "update commentaire set commentaire=? where idCommentaire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c);
            ps.setInt(2, idCommentaire);
            ps.executeUpdate();
            System.out.println("Mise à jour du commentaire effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   

   

    public void deleteCommentaire(int id){
        String requete = "delete from commentaire where idCommentaire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commentaire supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public Commentaire findCommentairetById(int id){
    Commentaire Commentaire = new Commentaire();
     String requete = "select * from commentaire where idCommentaire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
             Commentaire.setIdCommentaire(resultat.getInt(1));
             Commentaire.setIdClient(resultat.getInt(2));
             Commentaire.setIdRubrique(resultat.getInt(3));
             Commentaire.setCommentaire(resultat.getString(4));
                
            }
            return Commentaire;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public Commentaire findClientByIdClient(int id){
    Commentaire   Commentaire = new Commentaire();
     String requete = "select * from commentaire where idClient = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                 
             Commentaire.setIdCommentaire(resultat.getInt(1));
             Commentaire.setIdClient(resultat.getInt(2));
             Commentaire.setIdRubrique(resultat.getInt(3));
             Commentaire.setCommentaire(resultat.getString(4));
            }
            return Commentaire;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public Commentaire findClientByIdRubrique(int id){
    Commentaire   Commentaire = new Commentaire();
     String requete = "select * from commentaire where idRubrique = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                 
             Commentaire.setIdCommentaire(resultat.getInt(1));
             Commentaire.setIdClient(resultat.getInt(2));
             Commentaire.setIdRubrique(resultat.getInt(3));
             Commentaire.setCommentaire(resultat.getString(4));
            }
            return Commentaire;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }   
    public List<Commentaire> DisplayAllCommentaireByClient (int idClient){
        
 List<Commentaire> listecom = new ArrayList<Commentaire>();

        String requete = "select * from commentaire where idClient=?";
        try {
            
           PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setInt(1, idClient);
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Commentaire Commentaire =new Commentaire();
                   
             Commentaire.setIdCommentaire(resultat.getInt(1));
             Commentaire.setIdClient(resultat.getInt(2));
             Commentaire.setIdRubrique(resultat.getInt(3));
             Commentaire.setCommentaire(resultat.getString(4));

                listecom.add(Commentaire);
            }
            return listecom;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    public List<Commentaire> DisplayAllCommentaireByRubrique (int idRubrique){
        
 List<Commentaire> listecom = new ArrayList<Commentaire>();

        String requete = "select * from commentaire where idRubrique=?";
        try {
             PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setInt(1, idRubrique);
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Commentaire Commentaire =new Commentaire();
                   
             Commentaire.setIdCommentaire(resultat.getInt(1));
             Commentaire.setIdClient(resultat.getInt(2));
             Commentaire.setIdRubrique(resultat.getInt(3));
             Commentaire.setCommentaire(resultat.getString(4));

                listecom.add(Commentaire);
            }
            return listecom;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }  
}
