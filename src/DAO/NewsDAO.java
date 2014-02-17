/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import UTIL.MyConnection;
import entities.Musique;
import entities.News;
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
public class NewsDAO {
     public void insertNews(News n){

        String requete = "insert into news  values (default,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, n.getTitre());
            ps.setInt(2, n.getIdImage());
            ps.setString(3, n.getInformation());
            ps.executeUpdate();
            System.out.println("Ajout de News effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion News "+ex.getMessage());
        }
    }


    public void updateNews(News n ,int id){
        String requete = "update news set titre=? , information=? , idImage=?  where idNews=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, n.getTitre());
            ps.setInt(3, n.getIdImage());
            ps.setString(2, n.getInformation());
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Mise à jour de News effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour News "+ex.getMessage());
        }
    }
   

    public void deleteNews(int id){
        String requete = "delete from news where idNews=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("News supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression News"+ex.getMessage());
        }
    }


    public News findNewsById(int id){
   News news = new News();
     String requete = "select * from news where idNews=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
              news.setTitre(resultat.getString(2));
                news.setIdImage(resultat.getInt(3));
                news.setInformation(resultat.getString(4));
            
            }
            return news ;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche News "+ex.getMessage());
            return null;
        }
    }

    public News findNewsByTitre(String titre){
    News   news = new News();
     String requete = "select * from news where titre = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                
                System.out.println(resultat.getString(1));
//                news.setIdNews(resultat.getInt(2));
               news.setTitre(resultat.getString(2));
                news.setIdImage(resultat.getInt(3));
                news.setInformation(resultat.getString(4));
            }
            return news;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche News"+ex.getMessage());
            return null;
        }
    }

    
    public List<News> DisplayAllNews (){
        
 List<News> listeNews = new ArrayList<News>();

        String requete = "select * from news";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                
                News news =new News();
                news.setIdNews(resultat.getInt(1));
                news.setTitre(resultat.getString(2));
                news.setIdImage(resultat.getInt(3));
                news.setInformation(resultat.getString(4));
                listeNews.add(news);
            }
            return listeNews;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement News "+ex.getMessage());
            return null;
        }
    }
    
}
