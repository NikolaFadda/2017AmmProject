/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikola
 * 
 * 
 */
package amm.classi;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;



public class UtenteFactory {
    
    private static UtenteFactory singleton;
    
    public static UtenteFactory getInstance(){
        if(singleton == null){
            singleton = new UtenteFactory();
        }
        return singleton;
    }
    
    //Database
    private String connectionString;
    //private String db = "jdbc:derby://localhost:1527/ammdb";
    
    public void setConnectionString(String s){ this.connectionString = s;}
    public String getConnectionString(){return this.connectionString;}
    
    private UtenteFactory(){
    }
    
    public Utente getUtenteByUsername(String user) {
    try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
       
   
    
    
    if (conn != null){
        System.out.println("Connesso al DB per GetUtenteByUsername");
    }
        
        String query = "select * from utenti " + 
                        "where userid = ?";
        
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user);
        ResultSet res = stmt.executeQuery();
        
        if (res.next()){
            Utente current = new Utente();
            current.setUsername(res.getString("userid"));
            current.setNome(res.getString("nome"));
            current.setCognome(res.getString("cognome"));
            current.setQuote(res.getString("quote"));
            current.setPropic(res.getString("propic"));
            
            stmt.close();
            conn.close();
            return current;
        }
    
        stmt.close();
        conn.close();
    } catch (SQLException e){
        e.printStackTrace();
    }
        return null;
    }
    
     public boolean getUtenteByUsernameAndPassword(String user, String pass) {
    
         boolean st=true;
         
         try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
       
   
    
    
    if (conn != null){
        System.out.println("Connesso al DB per GetUtenteByUsernameAndPassword");
    }
        
        String query = "select * from utenti " + 
                        "where userid = ? and password= ?";
        
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user);
        stmt.setString(2, pass);
        ResultSet res = stmt.executeQuery();
        
        st = res.next();
        conn.close();
        
    } catch (SQLException e){
        e.printStackTrace();
    }
        out.print(st);
     return st;
    }
    
     public boolean checkFreeUserName(String username){
     
             
         boolean st=true;
         
         try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
       
    if (conn != null){
        System.out.println("Connesso al DB per checkFreeUsername");
    }
    PreparedStatement ps = conn.prepareStatement("select * from utenti where userid=?");
    
    ps.setString(1, username);
    ResultSet rs = ps.executeQuery();
    st = rs.next();
    
    conn.close();
    
    //Connetto al db
    
    } catch(Exception ex){
    
            ex.printStackTrace();
    }
        st = !(st);
     return st;
    
     
     }
     
     
    public void addUtente(String username, String password, String nome,
            String cognome, String quote, String propic){
        
        try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
        
    if (conn != null){
        System.out.println("Connesso al DB per aggiungere un utente");
    }
    
    String query = 
                      "insert into utenti (userid, password, nome, cognome, quote, propic) "
                    + "values ( ? , ? , ? , ? , ? , ? )";
    
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, username);
    stmt.setString(2, password);
    stmt.setString(3, nome);
    stmt.setString(4, cognome);
    stmt.setString(5, quote);
    stmt.setString(6, propic);
    
    stmt.executeUpdate();
    
    
    }catch(SQLException e){
            e.printStackTrace();
        }
        
        return;
    }
    
    public void alterPassword (String user, String newPassword){
            
                try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
        
        
    if (conn != null){
        System.out.println("Connesso al DB per cambiare la password");
    }
    
    String query = 
                      "update utenti "+
                      "set password = ? "
                    + "where userid = ? ";
    
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, newPassword);
    stmt.setString(2, user);
    
    
    stmt.executeUpdate();
    
    
    }catch(SQLException e){
            e.printStackTrace();
        }
    
    
    }   
    
    public List getUtentiList (){
        List<Utente> listaUtenti = new ArrayList<Utente>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
            

            String query = 
                      "select * from utenti";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Utente current = new Utente();
                current.setUsername(res.getString("userid"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setQuote(res.getString("quote"));
                current.setPropic(res.getString("propic"));
                
                listaUtenti.add(current);
                
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    
    
    }
    
    public void setFriendship (String user1, String user2){
    
                        try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
        
    if (conn != null){
        System.out.println("Connesso al DB per stringere un'amicizia");
    }
    
    String query = 
                      "insert into friendship (friend1, friend2) "+
                      "values ( ? , ? )";
    
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, user1);
    stmt.setString(2, user2);
    
    
    stmt.executeUpdate();
    
    
    }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public boolean areFriends (String friend1, String friend2){
        
         boolean st=true;
         
         try{
        
        
        Connection conn = DriverManager.getConnection(connectionString,"amm","amm");
       
    if (conn != null){
        System.out.println("Connesso al DB per areFriends");
    }
        if(friend1 == null ? friend2 == null : friend1.equals(friend2)){return true;}
    
    
    PreparedStatement ps = conn.prepareStatement("select * from friendship where"+
                                                    " friend1= ?  AND friend2= ? ");
    
    ps.setString(1, friend1);
    ps.setString(2, friend2);
    ResultSet rs = ps.executeQuery();
    st = rs.next();
    
    if(st== false){
    
    ps.setString(1, friend2);
    ps.setString(2, friend1);
    rs= ps.executeQuery();
    st = rs.next();
    }
    
    conn.close();
    
    //Connetto al db
    
    } catch(Exception ex){
    
            ex.printStackTrace();
    }
     
     
    return st;
    
    
    }
}
