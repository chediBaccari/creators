/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Client;
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
public class ClientDAO {

     public void insertClient(Client c){

        String requete = "insert into client(nom,prenom,dateNaissance,email,pwd,adresse,tel) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getDateNaissance());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPwd());
            ps.setString(6, c.getAdresse());
            ps.setInt(7, c.getTel());
          
            ps.executeUpdate();
            System.out.println("Ajout du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateClient(Client c,int id){
        String requete = "update client set nom=? , prenom=?, dateNaissance=?,email=?,pwd=?,adresse=?"
                + ",tel=?,valide=? where idClient=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setString(3, c.getDateNaissance());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPwd());
            ps.setString(6, c.getAdresse());
            ps.setInt(7, c.getTel());
            ps.setInt(8,c.getValide());
            ps.setInt(9, id);
            ps.executeUpdate();
            System.out.println("Mise à jour du client effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
    public void confirmerClient(int id)
    {
       
            String requete = "update client set valide=1 where idClient=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,id);
           
            ps.executeUpdate();
            System.out.println("client accepté avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
        
    }

   

    public void deleteAdmin(int id){
        String requete = "delete from client where idClient=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Client supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public Client findClientById(int id){
    Client client = new Client();
     String requete = "select * from client where idClient=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                client.setIdClient(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setDateNaissance(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setPwd(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setTel(resultat.getInt(8));
                client.setValide(resultat.getInt(9));
                
            }
            return client;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public Client findClientByprenom(String prenom){
    Client   client = new Client();
     String requete = "select * from client where prenom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, prenom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                 client.setIdClient(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setDateNaissance(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setPwd(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setTel(resultat.getInt(8));
                client.setValide(resultat.getInt(9));
            }
            return client;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    
    public List<Client> DisplayAllClientValide (){
        
 List<Client> listeclient = new ArrayList<Client>();

        String requete = "select * from client where valide=1";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Client client =new Client();
                    client.setIdClient(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setDateNaissance(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setPwd(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setTel(resultat.getInt(8));
                client.setValide(resultat.getInt(9));

                listeclient.add(client);
            }
            return listeclient;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
  public List<Client> DisplayAllClientNonValide (){
        
 List<Client> listeclient = new ArrayList<Client>();

        String requete = "select * from client where valide=0";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Client client =new Client();
                    client.setIdClient(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setDateNaissance(resultat.getString(4));
                client.setEmail(resultat.getString(5));
                client.setPwd(resultat.getString(6));
                client.setAdresse(resultat.getString(7));
                client.setTel(resultat.getInt(8));
                client.setValide(resultat.getInt(9));

                listeclient.add(client);
            }
            return listeclient;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
 
}
