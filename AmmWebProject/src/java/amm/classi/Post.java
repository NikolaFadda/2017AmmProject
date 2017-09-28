/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.classi;

/**
 *
 * @author nikola
 */
public class Post {
    
    protected int postId;
    protected Utente autore;
    private String messaggio;
    private String allegato;
    protected Utente destinatario;
    
    public Post(){
        postId=0;
        autore = null;
        messaggio ="";
        allegato ="";
        destinatario = null;
    }
    
    public int getId(){return postId;}
    public Utente getAutore(){return autore;}
    public String getMessaggio(){return messaggio;}
    public String getAllegato(){return allegato;}
    public Utente getDestinatario(){return destinatario;}
    
    public void setId(int id){this.postId=id;}
    public void setAutore(Utente user){this.autore=user;}
    public void setMessaggio(String mess){this.messaggio=mess;}
    public void setAllegato(String attach){this.allegato=attach;}
    public void setDestinatario(Utente user){this.destinatario=user;}
}
