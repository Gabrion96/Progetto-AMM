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

public class UserFactory 
{
    private static UserFactory singleton;
    private String connectionString;

    public static UserFactory getInstance() 
    {
        if (singleton == null) 
        {
            singleton = new UserFactory();
        }
        return singleton;
    }

    private ArrayList < User > userList = new ArrayList < User > ();

    private UserFactory() 
    {
        //Creazione users

        //Yasuo
        User user1 = new User();
        user1.setId(1);
        user1.setNome("Yasuo");
        user1.setCognome("The Unforgiven");
        user1.setUsername("Yasuo");
        user1.setURLimmagine("img/yasuo.jpg");
        user1.setFrase("La morte è come il vento, sempre al mio fianco");
        user1.setData("20/12/1996");
        user1.setPassword("unforgiven");

        //Zed
        User user2 = new User();
        user2.setId(2);
        user2.setNome("Zed");
        user2.setCognome("Shadow");
        user2.setUsername("Zed");
        user2.setURLimmagine("img/zed.jpg");
        user2.setFrase("L'ombra non vista è la più letale");
        user2.setData("13/12/1996");
        user2.setPassword("Shadow");

        //Lee Sin
        User user3 = new User();
        user3.setId(3);
        user3.setNome("Lee");
        user3.setCognome("Sin");
        user3.setUsername("Godfist");
        user3.setURLimmagine("img/lee_sin.jpg");
        user3.setFrase("Il tuo volere, i miei pugni");
        user3.setData("16/08/1995");
        user3.setPassword("Pugno");

        //Thresh
        User user4 = new User();
        user4.setId(4);
        user4.setNome("Thresh");
        user4.setCognome("Carceriere");
        user4.setUsername("The chain warden");
        user4.setURLimmagine("img/thresh.jpg");
        user4.setFrase("Che dolce agonia");
        user4.setData("20/07/1994");
        user4.setPassword("Lantern");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    }

    public User getUserById(int id) 
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select * from utente "
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdByEmailAndPassword(String username, String password) 
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                      "select id from utente "
                    + "where email = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            System.out.println(stmt);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("id");
                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList < User > getFriendsByUser(User user) 
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT utente.id, utente.nome, utente.cognome, utente.email, utente.password, utente.urlImmagine, utente.frase, utente.data FROM utente "
                + "INNER JOIN followutente ON utente.id = followutente.followed "
                + "WHERE followutente.follower = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <User> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<User> getUserList() 
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "SELECT * FROM utente";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            ArrayList <User> ret = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while (res.next()) {
                User current = new User();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setURLimmagine(res.getString("urlImmagine"));
                current.setFrase(res.getString("frase"));
                current.setData(res.getString("data"));
                ret.add(current);
            }
            
            stmt.close();
            conn.close();
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;   
    }
    
    public void updateUser(int id, String nome, String cognome, String username, String profile_imm, String frase, String data, String password) 
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = 
                "UPDATE utente "
                    + "SET nome = ?, "
                    + "cognome = ?, "
                    + "username = ?, "
                    + "urlImmagine = ?, "
                    + "frase = ?, "
                    + "data = ?, "
                    + "password = ? "
                    + "WHERE id = ? ";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, username);
            stmt.setString(4, profile_imm);
            stmt.setString(5, frase);
            stmt.setString(6, data);
            stmt.setString(7, password);
            stmt.setInt(8, id);
            
            // Esecuzione query
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void deleteUser(int id) {
            try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "amm", "amm");
            
            String query = "DELETE FROM utente WHERE id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1,id);
            
            // Esecuzione query
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
