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
public class Theatre {
    private int idRubrique;
   private String nom;
   private String dateDebut ;
   private String dateFin ;
   private int duree;
   private String information; 
   private int idImage ; 

    public int getIdRubrique() {
        return idRubrique;
    }

    public String getNom() {
        return nom;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public int getDuree() {
        return duree;
    }

    public String getInformation() {
        return information;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "Theatre{" + "idRubrique=" + idRubrique + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", duree=" + duree + ", information=" + information + ", idImage=" + idImage + '}';
    }
   
   
   
    
}
