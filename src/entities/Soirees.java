/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author AhmedAsus
 */
public class Soirees {
    private int idSoiree ;
    private String titre;
    private String date ;
    private String heur;
    private String information;
    private int idLieu ;
    

    public int getIdSoiree() {
        return idSoiree;
    }

    public String getDate() {
        return date;
    }

    public String getHeur() {
        return heur;
    }

    public String getInformation() {
        return information;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdSoiree(int idSoiree) {
        this.idSoiree = idSoiree;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeur(String heur) {
        this.heur = heur;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Soirees{" + "idSoiree=" + idSoiree + ", titre=" + titre + ", date=" + date + ", heur=" + heur + ", information=" + information + ", idLieu=" + idLieu + '}';
    }

    
   
    
    
}
