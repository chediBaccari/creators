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
public class Album {
    
    private int  idAlbum;
    private String titre;

    public int getIdAlbum() {
        return idAlbum;
    }

    public String getTitre() {
        return titre;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Album{" + "idAlbum=" + idAlbum + ", titre=" + titre + '}';
    }
    
    
}
