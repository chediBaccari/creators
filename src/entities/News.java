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
public class News {
    private int idNews;
    private String titre;
    private String information; 
    private int idImage;

    public int getIdNews() {
        return idNews;
    }

    public String getTitre() {
        return titre;
    }

    public String getInformation() {
        return information;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "News{" + "idNews=" + idNews + ", titre=" + titre + ", information=" + information + ", idImage=" + idImage + '}';
    }
    
    
    
}
