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
    private User creatorUser; /*Se è >0 allora è di un utente, se è <1000 allora è di un gruppo, se è 0 è stato solamente instanziato*/
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the creatorId
     */
    public User getCreatorUser() {
        return creatorUser;
    }

    /**
     * @param creatorID the creatorId to set
     */
    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }
    
        /**
     * @return the creatorId
     */
    public User getDestinationUser() {
        return destinationUser;
    }

    /**
     * @param creatorID the creatorId to set
     */
    public void setDestinationUser(User destinationUser) {
        this.destinationUser = destinationUser;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
