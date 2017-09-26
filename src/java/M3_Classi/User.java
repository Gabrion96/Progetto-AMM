/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3_Classi;

/**
 *
 * @author Gabriele Concas
 */

public class User 
{
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String URLimmagine;
    private String frase;
    private String data;
    private String password;

    public User() {
        this.id = 0;
        this.nome = "";
        this.cognome = "";
        this.username = "";
        this.URLimmagine = "";
        this.frase = "";
        this.data = "";
        this.password = "";
    }

    
    public int getId() {
        return id;
    }

   
  
    public void setId(int id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getCognome() {
        return cognome;
    }

    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

   
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getURLimmagine() {
        return URLimmagine;
    }

    
    public void setURLimmagine(String URLimmagine) {
        this.URLimmagine = URLimmagine;
    }

  
    public String getFrase() {
        return frase;
    }

   
    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }

    
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object otherUser) {
        if (otherUser instanceof User)
            if (this.getId() == ((User) otherUser).getId()) return true;
        return false;
    }
}
