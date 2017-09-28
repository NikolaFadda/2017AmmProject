/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikola
 * 
 */
package amm.classi;
public class Utente {
    
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;
    protected String quote;
    protected String propic;
    
    public Utente(){
    username = "";
    nome="";
    cognome="";
    quote="";
    propic="";
    
    }
    
//Getter methods
    public String getUsername(){ return username;}
    public String getPassword(){ return password;}
    public String getNome(){ return nome;}
    public String getCognome(){ return cognome;}
    public String getQuote(){return quote;}
    public String getPropic(){return propic;}
    
//Setter methods
    public void setUsername(String username){this.username=username;}
    public void setPassword(String password){this.password=password;}
    public void setNome(String nome){this.nome=nome;}
    public void setCognome(String cognome){this.cognome=cognome;}
    public void setQuote(String quote){this.quote=quote;}
    public void setPropic(String propic){this.propic=propic;}
    
    
}
