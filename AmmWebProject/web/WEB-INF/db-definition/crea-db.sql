/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nikola
 * Created: 28-set-2017
 */

create table friendship (
    friend1 VARCHAR(128),
    friend2 VARCHAR(128)

);

create table post (
    postid INTEGER GENERATED BY DEFAULT As IDENTITY PRIMARY KEY,
    messaggio VARCHAR(512),
    allegato VARCHAR(256),
    autore VARCHAR(128),
    destinatario VARCHAR(128)
    
);

create table utenti (
    
    userid VARCHAR(128) PRIMARY KEY,
    password VARCHAR(128),
    nome VARCHAR(128),
    cognome VARCHAR(128),
    quote VARCHAR(512),
    propic VARCHAR(256)

);


insert into utenti (userid, password, nome, cognome, quote, propic)
values ('nikfadda','1234','Nicola','Fadda','Sopra la panca la capra campa','propic.jpg');
insert into utenti (userid, password, nome, cognome, quote, propic)
values ('lucarossi','1111','Luca','Rossi','Sotto la panca la capra crepa','foto.jpg');
insert into utenti (userid, password, nome, cognome, quote, propic)
values ('anonimo','222','Utente','Anonimo','Io sono nessuno','nessuno.jpg');
insert into utenti (userid, password, nome, cognome, quote, propic)
values ('jsnow','kinginthenorth','Jon','Snow','L`inverno e` arrivato','ritratto.jpg');
insert into utenti (userid, password, nome, cognome, quote, propic)
values ('mithrandir','anorflame','Gandalf','il Bianco','Tu non puoi passare!','Gandalf.jpg');

insert into friendship (friend1,friend2)
values ('nikfadda','lucarossi');
insert into friendship (friend1,friend2)
values ('nikfadda','anonimo');
insert into friendship (friend1,friend2)
values ('anonimo','jsnow');
insert into friendship (friend1,friend2)
values ('jsnow','mithrandir');
insert into friendship (friend1,friend2)
values ('nikfadda','mithrandir');

insert into post (messaggio, allegato, autore, destinatario)
values('Primo post di Nicola Fadda','','nikfadda','nikfadda');
insert into post (messaggio, allegato, autore, destinatario)
values('Ciao Luca! Come stai?','','nikfadda','lucarossi');
insert into post (messaggio, allegato, autore, destinatario)
values('Gandalf! Ma che bella barca!','','nikfadda','mithrandir');
insert into post (messaggio, allegato, autore, destinatario)
values('Questa diavoleria come funziona?','','mithrandir','mithrandir');
insert into post (messaggio, allegato, autore, destinatario)
values('Greetings! I am Jon Snow, King of the north and Former commander of the Night`s Watch','','jsnow','jsnow');
insert into post (messaggio, allegato, autore, destinatario)
values('Fanno senso, i colibrì','','anonimo','anonimo');
insert into post (messaggio, allegato, autore, destinatario)
values('Secondo post di Nicola Fadda','','nikfadda','nikfadda');


