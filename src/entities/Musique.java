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
public class Musique {
    
    private int idMusique;
    private String titre; 
    private String lien;

    public int getIdMusique() {
        return idMusique;
    }

    public String getTitre() {
        return titre;
    }

    public String getLien() {
        return lien;
    }

    public void setIdMusique(int idMusique) {
        this.idMusique = idMusique;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Musique{" + "idMusique=" + idMusique + ", titre=" + titre + ", lien=" + lien + '}';
    }
    
    
    
}
