/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*****
 *
 * @author Chedi
 */
public class AdminDAO {
    public boolean insertAdmin(Admin a){
        if(verifLogin(a.getLogin()))
        {
        String requete = "insert into admin (login,pwd) values (?,?)";
        try {
          
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getPwd());
            ps.executeUpdate();
            System.out.println("Ajout de l'Admin effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
        return true;
    }
        return false;
    }


    public boolean updateAdmin(Admin a,int id){
         if(verifLogin(a.getLogin()))
        {
        String requete = "update admin set login=? , pwd=?  where idAdmin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getPwd());
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de l'Admin effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
        return true;
    }
         return false;
    }
   

    public void deleteAdmin(int id){
        String requete = "delete from admin where idAdmin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Admin supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Admin findAdminById(int id){
    Admin admin = new Admin();
     String requete = "select * from admin where idAdmin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                admin.setIdAdmin(resultat.getInt(1));
                admin.setLogin(resultat.getString(2));
                admin.setPwd(resultat.getString(3));
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

    public Admin findAdminByLogin(String login){
    Admin   admin = new Admin();
     String requete = "select * from admin where login = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                admin.setIdAdmin(resultat.getInt(1));
                admin.setLogin(resultat.getString(2));
                admin.setPwd(resultat.getString(3));
            }
            return admin;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }
  public boolean verifUthentification(String login,String pwd)
  {
       String requete = "select * from admin where login = ? and pwd = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            if(resultat.next() )
            {
                System.out.println("Admin trouvé");
            return true;
            
            }
            else 
            {
                System.out.println("Admin non trouvé");
                return false ;
            }

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return false;
        }
  }
  public boolean verifLogin (String log)
  {
      if(findAdminByLogin(log)==null)
      {
          return true ;
      }
      return false;
  }
    
    public List<Admin> DisplayAllAdmin (){
        
 List<Admin> listeadmin = new ArrayList<Admin>();

        String requete = "select * from admin";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                Admin admin =new Admin();
                admin.setIdAdmin(resultat.getInt(1));
                admin.setLogin(resultat.getString(2));
                admin.setPwd(resultat.getString(3));

                listeadmin.add(admin);
            }
            return listeadmin;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
}
