/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Chedi
 */
public class Lieu {
    
    private int Lieu ;
    private String nom;
    private String information;
    private String lienMap;
    private int idImage;
    private int tel;

    public int getLieu() {
        return Lieu;
    }

    public String getNom() {
        return nom;
    }



    public String getInformation() {
        return information;
    }

    public String getLienMap() {
        return lienMap;
    }

    public int getIdImage() {
        return idImage;
    }

    public int getTel() {
        return tel;
    }

    public void setLieu(int Lieu) {
        this.Lieu = Lieu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

    public void setInformation(String information) {
        this.information = information;
    }

    public void setLienMap(String lienMap) {
        this.lienMap = lienMap;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Lieu{" + "Lieu=" + Lieu + ", nom=" + nom + ", information=" + information + ", lienMap=" + lienMap + ", idImage=" + idImage + ", tel=" + tel + '}';
    }

  
    
    
}
