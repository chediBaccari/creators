/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author Chedi
 */
public class ArtsVisuels {
    
    private int idRubrique;
    private String nom;
    private String dateDebut;
    private String dateFin;
    private float duree;
    private int idLieu;
    private String artiste;
    private String sujet;
    private int idImage;

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

   

    public float getDuree() {
        return duree;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getSujet() {
        return sujet;
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

    

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "ArtsVisuels{" + "idRubrique=" + idRubrique + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", duree=" + duree + ", idLieu=" + idLieu + ", artiste=" + artiste + ", sujet=" + sujet + ", idImage=" + idImage + '}';
    }

    
    
    
    
}
