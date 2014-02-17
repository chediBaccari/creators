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
public class Admin {
    
    private int idAdmin;
    private String login ;
    private String pwd ;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" + "idAdmin=" + idAdmin + ", login=" + login + ", pwd=" + pwd + '}';
    }

    
    
    
}
