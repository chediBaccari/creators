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
public class Commentaire {
    
    private int idCommentaire;
    private int idClient;
    private int idRubrique;
    private String commentaire;

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", idClient=" + idClient + ", idRubrique=" + idRubrique + ", commentaire=" + commentaire + '}';
    }
    
    
    
}
