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
public class Noter {
    private int idNote;
    private int idRubrique;
    private int idClient;
    private int nbrEtoile;

    public int getIdNote() {
        return idNote;
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNbrEtoile(int nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    @Override
    public String toString() {
        return "Noter{" + "idNote=" + idNote + ", idRubrique=" + idRubrique + ", idClient=" + idClient + ", nbrEtoile=" + nbrEtoile + '}';
    }
    
    
    
    
}
