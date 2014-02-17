/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.ArtsVisuels;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Chedi
 */
public class ArtsVisuelsDAO {
    
     public void insertArt(ArtsVisuels a){

        String requete = "insert into artsvisuels (nom,dateFin,dateDebut,duree,idLieu,artiste,sujet,idImage)"
                + " values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getNom());
            ps.setString(2, a.getDateFin());
            ps.setString(3,  a.getDateDebut());
            ps.setFloat(4, a.getDuree());
            ps.setInt(5, a.getIdLieu());
            ps.setString(6, a.getArtiste());
            ps.setString(7, a.getSujet());
            ps.setInt(8, a.getIdImage());
            ps.executeUpdate();
            System.out.println("Ajout de l'art effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    public void updateArt(ArtsVisuels a,int id){
        String requete = "update artsvisuels set nom=? , dateFin=?,dateDebut=?, duree=?,idLieu=?,artiste=?,sujet=? "
                + ",idImage=?   where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getNom());
            ps.setString(2,  a.getDateFin());
            ps.setString(3 , a.getDateDebut());
            ps.setFloat(4, a.getDuree());
            ps.setInt(5, a.getIdLieu());
            ps.setString(6, a.getArtiste());
            ps.setString(7, a.getSujet());
            ps.setInt(8, a.getIdImage());
            ps.setInt(9, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de l'art effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   

    public void deleteArt(int id){
        String requete = "delete from artsvisuels where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("art supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public ArtsVisuels findArtById(int id){
    ArtsVisuels art = new ArtsVisuels();
     String requete = "select * from artsvisuels where idRubrique=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               art.setIdRubrique(resultat.getInt(1));
                art.setNom(resultat.getString(2));
                art.setDateFin(resultat.getString(3));
                art.setDateDebut(resultat.getString(4));
                art.setDuree(resultat.getFloat(5));
                art.setIdLieu(resultat.getInt(6));
                art.setArtiste(resultat.getString(7));
                art.setSujet(resultat.getString(8));
                art.setIdImage(resultat.getInt(9));
            }
            return art;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public ArtsVisuels findArtByNom(String nom){
    ArtsVisuels   art = new ArtsVisuels();
     String requete = "select * artsvisuels  where nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
            art.setIdRubrique(resultat.getInt(1));
                art.setNom(resultat.getString(2));
                art.setDateFin(resultat.getString(3));
                art.setDateDebut(resultat.getString(4));
                art.setDuree(resultat.getFloat(5));
                art.setIdLieu(resultat.getInt(6));
                art.setArtiste(resultat.getString(7));
                art.setSujet(resultat.getString(8));
                art.setIdImage(resultat.getInt(9));
            }
            return art;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    
    public List<ArtsVisuels> DisplayAllArt (){
        
 List<ArtsVisuels> listeadmin = new ArrayList<ArtsVisuels>();

        String requete = "select * from artsvisuels";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                ArtsVisuels art =new ArtsVisuels();
               art.setIdRubrique(resultat.getInt(1));
                art.setNom(resultat.getString(2));
                art.setDateFin(resultat.getString(3));
                art.setDateDebut(resultat.getString(4));
                art.setDuree(resultat.getFloat(5));
                art.setIdLieu(resultat.getInt(6));
                art.setArtiste(resultat.getString(7));
                art.setSujet(resultat.getString(8));
                art.setIdImage(resultat.getInt(9));

                listeadmin.add(art);
            }
            return listeadmin;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
}
