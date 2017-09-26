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

public class Post 
{
    private int id;
    private User creatorUser; 
    private User destinationUser;
    private String text;
    private String image;

    public Post() {
        this.id = 0;
        this.creatorUser = null;
        this.destinationUser = null;
        this.text = "";
        this.image = "";
    }

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    
    public User getCreatorUser() {
        return creatorUser;
    }

   
    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }
    
   
    public User getDestinationUser() {
        return destinationUser;
    }

  
    public void setDestinationUser(User destinationUser) {
        this.destinationUser = destinationUser;
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text;
    }

  
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
