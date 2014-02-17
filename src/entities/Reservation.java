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
public class Reservation {
    private int idReservation ;
    private int idClient ;
    
    

    public int getIdReservation() {
        return idReservation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    
}
