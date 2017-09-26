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



public class GroupFactory 
{
    private static GroupFactory singleton;
    private String connectionString;

    public static GroupFactory getInstance() 
    {
        if (singleton == null) 
        {
            singleton = new GroupFactory();
        }
        return singleton;
    }

    private ArrayList < Group > groupList = new ArrayList < Group > ();

    private GroupFactory() 
    {
        //Creazione gruppi

        //Lol-italia
        ArrayList < Integer > aux = new ArrayList < Integer > ();
        Group gruppo1 = new Group();
        gruppo1.setId(1001);
        aux.add(2);
        aux.add(3);
        aux.add(4);
        gruppo1.setUserList(aux);
        gruppo1.setNome("Lol-italia");

        //League of legends
        aux = new ArrayList < Integer > ();
        Group gruppo2 = new Group();
        gruppo2.setId(1002);
        aux.add(1);
        aux.add(3);
        aux.add(4);
        gruppo2.setUserList(aux);
        gruppo2.setNome("League of legends");

        groupList.add(gruppo1);
        groupList.add(gruppo2);
    }

    public Group getGroupByID(int id) 
    {
        try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from gruppo "
                    + "where id = ?";
            
        
            PreparedStatement stmt = conn.prepareStatement(query);
            
        
            stmt.setInt(1, id);
            
           
            ResultSet res = stmt.executeQuery();

          
            if (res.next()) {
                Group current = new Group();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
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

    public ArrayList < Group > getGroupList(User user) 
    {

        try 
        {
         
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT gruppo.id, gruppo.nome, gruppo.urlImmagine FROM gruppo "
                + "INNER JOIN followgruppo ON gruppo.id = followgruppo.followed "
                + "WHERE followgruppo.follower = ?";
            
      
            PreparedStatement stmt = conn.prepareStatement(query);
            
      
            stmt.setInt(1, user.getId());
            
           
            ResultSet res = stmt.executeQuery();

            ArrayList <Group> ret = new ArrayList<>();
            
         
            while (res.next()) 
            {
                Group current = new Group();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
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
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    public String getConnectionString()
    {
        return this.connectionString;
    }
}
