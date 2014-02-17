/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Lieu;
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
public class LieuDAO {
    
     
     public void insertCommentaire(Lieu l){

        String requete = "insert into lieux(nom ,information,lienMap,idImage,tel) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          
           ps.setString(1, l.getNom());
           ps.setString(2, l.getInformation());
           ps.setString(3, l.getLienMap());
           ps.setInt(4, l.getIdImage());
           ps.setInt(5, l.getTel());
          
            ps.executeUpdate();
            System.out.println("Ajout du commentaire effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateLieu(Lieu l,int idLieu ){
        String requete = "update lieux set nom=?,information=?,lienMap=?,idImage=?,tel? where idLieu=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, l.getNom());
            ps.setString(2, l.getInformation());
            ps.setString(3, l.getLienMap());
            ps.setInt(4, l.getIdImage());
            ps.setInt(5, l.getTel());
            ps.setInt(6, idLieu);
            ps.executeUpdate();
            
            System.out.println("Mise à jour du lieu effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
   

   

    public void deleteLieu(int id){
        String requete = "delete from lieux where idLieu=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Lieu supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public Lieu findLieutById(int id){
    Lieu Lieu = new Lieu();
     String requete = "select * from lieux where idLieu=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
             Lieu.setLieu(resultat.getInt(1));
                Lieu.setNom(resultat.getString(2));
             Lieu.setInformation(resultat.getString(3));
             Lieu.setLienMap(resultat.getString(4));
             Lieu.setIdImage(resultat.getInt(5));
             Lieu.setTel(resultat.getInt(6));
             
                
            }
            return Lieu;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

   

    
    public List<Lieu> DisplayAllLieu (){
        
 List<Lieu> listeLieu = new ArrayList<Lieu>();

        String requete = "select * from lieux ";
        try {
            
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Lieu Lieu =new Lieu();
                   
              Lieu.setLieu(resultat.getInt(1));
                Lieu.setNom(resultat.getString(2));
             Lieu.setInformation(resultat.getString(3));
             Lieu.setLienMap(resultat.getString(4));
             Lieu.setIdImage(resultat.getInt(5));
             Lieu.setTel(resultat.getInt(6));

                listeLieu.add(Lieu);
            }
            return listeLieu;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
   public List<Lieu> DisplayAllLieuByNom (String nom){
        
 List<Lieu> listeLieu = new ArrayList<Lieu>();

        String requete = "select * from lieux where nom like ? ";
        try {
            
          PreparedStatement ps =MyConnection.getInstance().prepareStatement(requete);
           
              ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();

            while(resultat.next()){
                
                Lieu Lieu =new Lieu();
                   
              Lieu.setLieu(resultat.getInt(1));
                Lieu.setNom(resultat.getString(2));
             Lieu.setInformation(resultat.getString(3));
             Lieu.setLienMap(resultat.getString(4));
             Lieu.setIdImage(resultat.getInt(5));
             Lieu.setTel(resultat.getInt(6));

                listeLieu.add(Lieu);
            }
            return listeLieu;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
   
}
