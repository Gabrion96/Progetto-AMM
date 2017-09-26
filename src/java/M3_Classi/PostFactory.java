/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3_Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriele Concas
 */

public class PostFactory 
{
    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList < Post > postList = new ArrayList < Post > ();

    private PostFactory() {
        //Creazione Post

        //Yasuo
        Post post1 = new Post();
        post1.setId(1);
        post1.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Yasuo: id=1*/
        post1.setDestinationUser(UserFactory.getInstance().getUserById(1));
        post1.setText("La morte è come il vento, sempre al mio fianco");
        post1.setImage("");

        //Zed
        Post post2 = new Post();
        post2.setId(2);
        post2.setCreatorUser(UserFactory.getInstance().getUserById(2)); /*Zed: id=2*/
        post2.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post2.setText("Hai visto i due nuovi champions ?");
        post2.setImage("img/xaya.jpg");

        //Lee Sin
        Post post3 = new Post();
        post3.setId(3);
        post3.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Lee Sin: id=3*/
        post3.setDestinationUser(UserFactory.getInstance().getUserById(3));
        post3.setText("Non ti sei ancora iscritto a LoL ?");
        post3.setImage("");

        //Thresh
        Post post4 = new Post();
        post4.setId(4);
        post4.setCreatorUser(UserFactory.getInstance().getUserById(4)); /*Thresh: id=4*/
        post4.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post4.setText("#Vieni a giocare con me");
        post4.setImage("");

        //thresh2
        Post post5 = new Post();
        post5.setId(5);
        post5.setCreatorUser(UserFactory.getInstance().getUserById(4)); /*Thresh: id=4*/
        post5.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post5.setText("È finita quando lo dico io");
        post5.setImage("");

        //Lee sin2
        Post post6 = new Post();
        post6.setId(6);
        post6.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Lee sin: id=3*/
        post6.setDestinationUser(UserFactory.getInstance().getUserById(3));
        post6.setText("La cecità non è un problema quando il nemico ha cattivo odore");
        post6.setImage("");

        //Zed2
        Post post7 = new Post();
        post7.setId(7);
        post7.setCreatorUser(UserFactory.getInstance().getUserById(2)); /*Zed: id=2*/
        post7.setDestinationUser(UserFactory.getInstance().getUserById(3));
        post7.setText("Solo i più degni sopravvivono");
        post7.setImage("");

        //Yasuo2
        Post post8 = new Post();
        post8.setId(8);
        post8.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Yasuo: id=1*/
        post8.setDestinationUser(UserFactory.getInstance().getUserById(1));
        post8.setText("Non c'è cura per la follia");
        post8.setImage("");
        
        //Yasuo3
        Post post9 = new Post();
        post9.setId(9);
        post9.setCreatorUser(UserFactory.getInstance().getUserById(1)); /*Yasuo: id=1*/
        post8.setDestinationUser(UserFactory.getInstance().getUserById(1));
        post9.setText("Alcuni errori non si possono ripetere due volte");
        post9.setImage("");
        
        //Zed3
        Post post10 = new Post();
        post10.setId(10);
        post10.setCreatorUser(UserFactory.getInstance().getUserById(2)); /*Zed: id=2*/
        post10.setDestinationUser(UserFactory.getInstance().getUserById(2));
        post10.setText("Sono la tua punizione");
        post10.setImage("");
        
        //Lee Sin3
        Post post11 = new Post();
        post11.setId(11);
        post11.setCreatorUser(UserFactory.getInstance().getUserById(3)); /*Lee Sin: id=3*/
        post11.setDestinationUser(UserFactory.getInstance().getUserById(3));
        post11.setText("La cecità non è un problema quando il nemico ha cattivo odore");
        post11.setImage("");
        
        //Thresh3
        Post post12 = new Post();
        post12.setId(12);
        post12.setCreatorUser(UserFactory.getInstance().getUserById(4)); /*Thresh: id=4*/
        post12.setDestinationUser(UserFactory.getInstance().getUserById(4));
        post12.setText("Non temere la fine, abbracciala");
        post12.setImage("");


        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);
        postList.add(post6);
        postList.add(post7);
        postList.add(post8);
        postList.add(post9);
        postList.add(post10);
        postList.add(post11);
        postList.add(post12);

    }

    public Post getPostByID(int id) 
    {
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from post "
                    + "where id = ?";
            
       
            PreparedStatement stmt = conn.prepareStatement(query);
            
       
            stmt.setInt(1, id);
            
         
            ResultSet res = stmt.executeQuery();

       
            if (res.next()) {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList < Post > getPostList(User user) 
    {
        try 
        {
            
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT post.id, post.creatorId, post.destinationId, post.text, post.image FROM post "
                + "INNER JOIN utente ON post.creatorId = utente.id "
                + "WHERE post.destinationId = ?";
            
       
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setInt(1, user.getId());
            
           
            ResultSet res = stmt.executeQuery();

            ArrayList <Post> ret = new ArrayList<>();
            
            
            while (res.next()) 
            {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    
    public ArrayList < Post > getCreatorPostList(User user) 
    {
        try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT post.id, post.creatorId, post.destinationId, post.text, post.image FROM post "
                + "INNER JOIN utente ON post.creatorId = utente.id "
                + "WHERE post.creatorId = ?";
            
         
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setInt(1, user.getId());
            
         
            ResultSet res = stmt.executeQuery();

            ArrayList <Post> ret = new ArrayList<>();
            
          
            while (res.next()) 
            {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setCreatorUser(UserFactory.getInstance().getUserById(res.getInt("creatorId")));
                current.setDestinationUser(UserFactory.getInstance().getUserById(res.getInt("destinationId")));
                current.setText(res.getString("text"));
                current.setImage(res.getString("image"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public void insertPost (Post post) 
    {
        {
        try 
        {
         
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "INSERT INTO post (id, creatorId, destinationId, text, image) " +
                "VALUES (default,?,?,?,?) ";
            
        
            PreparedStatement stmt = conn.prepareStatement(query);
            
       
            stmt.setInt(1, post.getCreatorUser().getId());
            stmt.setInt(2, post.getDestinationUser().getId());
            stmt.setString(3, post.getText());
            stmt.setString(4, post.getImage());
            
          
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    }
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    public String getConnectionString()
    {
            return this.connectionString;
    }
}
