/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;

/**
 *
 * @author nayro
 */
public class Admin {
    String Username;
    String Password;
    ArrayList <Librarian>lib=new ArrayList();

    public Admin(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }
    
}