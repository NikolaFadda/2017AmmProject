/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikola
 */
public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance(){
        if (singleton == null){
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private String connectionString;
    
    
    public void setConnectionString(String s){ this.connectionString = s;}
    public String getConnectionString(){return this.connectionString;}
    
    private PostFactory(){}
    
    public Post getPostById(int id){
        UtenteFactory utenteFactory = UtenteFactory.getInstance();
        
        try{
            Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
            
            String query = "select * from post "
                    + "where postid = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            
            ResultSet res= stmt.executeQuery();
            
            if(res.next()){
                Post current = new Post();
                current.setId(res.getInt("postid"));
                current.setMessaggio(res.getString("messaggio"));
                current.setAllegato(res.getString("allegato"));
                
                Utente autore = utenteFactory.getUtenteByUsername(res.getString("autore"));
                
                stmt.close();
                conn.close();
                return current;
            
            }
                stmt.close();
                conn.close();
        }catch (SQLException e){
        e.printStackTrace();}
        return null;
    }
    
        public List getPostList(Utente usr) {
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            
            Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
            
            String query = 
                      "select * from post "                 
                    + "where destinatario = ?"
                    + "order by postid desc";
            
            
            PreparedStatement stmt = conn.prepareStatement(query);          
            stmt.setString(1, usr.getUsername());           
            
            ResultSet res = stmt.executeQuery();

            
            while (res.next()) {
                
                Post current = new Post();
                
                current.setId(res.getInt("postid"));
                current.setMessaggio(res.getString("messaggio"));      
                current.setAllegato(res.getString("allegato"));                
                current.setDestinatario(usr);
                current.setAutore(
                UtenteFactory.getInstance().getUtenteByUsername(res.getString("autore"))
                );
                
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public void addNewPost(Post post){
        try {
            
            Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
            
            String query = 
                      "insert into post (messaggio, allegato, autore, destinatario) "
                    + "values ( ? , ? , ? , ?)";
            
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
           
            stmt.setString(1, post.getMessaggio());

            stmt.setString(2, post.getAllegato());
            
            stmt.setString(3, post.getAutore().getUsername());
            stmt.setString(4, post.getDestinatario().getUsername().toString());
            
            
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
}
