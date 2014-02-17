/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jetsetactu;

import DAO.AdminDAO;
import DAO.AlbumDAO;
import DAO.ArtsVisuelsDAO;
import DAO.ClientDAO;
import DAO.CommentaireDAO;
import DAO.LieuDAO;
import entities.Admin;
import entities.Album;
import entities.ArtsVisuels;
import entities.Client;
import entities.Commentaire;
import entities.Lieu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Chedi
 */
public class Jetsetactu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        /*a.setDateDebut("2014.12.1");*/
           
        Admin a=new Admin();
    
       AdminDAO da=new AdminDAO();
       
       boolean test =da.verifUthentification("chedi", "chiheb");
       
      
     
     
    }
    
}
