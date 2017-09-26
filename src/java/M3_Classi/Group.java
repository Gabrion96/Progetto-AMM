/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3_Classi;

import java.util.ArrayList;

/**
 *
 * @author Gabriele Concas
 */

public class Group 
{
    private int id;
    private ArrayList < Integer > userList;
    private String nome;

    public Group() {
        this.id = 0;
        this.userList = null;
        this.nome = "";
    }

    
    public int getID() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

 
    public ArrayList < Integer > getUserList() {
        return userList;
    }

   
    public void setUserList(ArrayList < Integer > userList) {
        this.userList = userList;
    }

 
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }
}
