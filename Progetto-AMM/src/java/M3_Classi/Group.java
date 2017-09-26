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

    /**
     * @return the id
     */
    public int getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the userList
     */
    public ArrayList < Integer > getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList < Integer > userList) {
        this.userList = userList;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
