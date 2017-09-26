/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gabriele Concas
 * Created: 25-set-2017
 */

--DB: ammdb; username: amm; password: amm;--

CREATE TABLE utente (
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    username VARCHAR(256) UNIQUE,
    urlImmagine VARCHAR(256),
    frase VARCHAR(256),
    data date,
    password VARCHAR(256) NOT NULL
);

CREATE TABLE post (
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    creatorId INTEGER,
    FOREIGN KEY (creatorId) REFERENCES utente (id) ON DELETE CASCADE,
    destinationId INTEGER,
    FOREIGN KEY (destinationId) REFERENCES utente (id) ON DELETE CASCADE,
    text VARCHAR(1024),
    image VARCHAR(256)
);

CREATE TABLE gruppo (
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256)   
);

CREATE TABLE followutente (
    follower INTEGER,
    FOREIGN KEY (follower) REFERENCES utente (id) ON DELETE CASCADE,
    followed INTEGER,
    FOREIGN KEY (followed) REFERENCES utente (id) ON DELETE CASCADE,
    PRIMARY KEY(follower,followed)
);

CREATE TABLE followgruppo (
    follower INTEGER,
    FOREIGN KEY (follower) REFERENCES utente (id) ON DELETE CASCADE,
    followed INTEGER,
    FOREIGN KEY (followed) REFERENCES gruppo (id) ON DELETE CASCADE,
    PRIMARY KEY (follower, followed)
);

--Inserimento dati--

--Popolamento utente--
INSERT INTO utente (id, nome, cognome, username, urlImmagine, frase, data, password)
VALUES (1,
        'Yasuo',
        'The Unforgiven',
        'Yasuo',
        'img/yasuo.jpg',
        'La morte è come il vento, sempre al mio fianco',
        '1996-12-20',
        'unforgiven');

INSERT INTO utente (id, nome, cognome, username, urlImmagine, frase, data, password)
VALUES (2,
        'Zed',
        'Shadow',
        'Zed',
        'img/zed.jpg',
        'La lama non vista è la più letale',
        '1996-12-13',
        'Shadow');

INSERT INTO utente (id, nome, cognome, username, urlImmagine, frase, data, password)
VALUES (3,
        'Lee',
        'Sin',
        'Godfist',
        'img/lee_sin.jpg',
        'Il tuo volere, i miei pugni',
        '1995-08-16',
        'Pugno');

INSERT INTO utente (id, nome, cognome, username, urlImmagine, frase, data, password)
VALUES (4,
        'Thresh',
        'Carceriere',
        'The chain warden',
        'img/thresh.jpg',
        'Che dolce agonia',
        '1994-07-20',
        'Lantern');

--Popolamento gruppo--
INSERT INTO gruppo (id, nome)
VALUES (default,
        'Lol-italia');
        

--Popolamento gruppo--
INSERT INTO gruppo (id, nome)
VALUES (default,
        'League of legends');

--Popolamento post--
INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        1,
        1,
        'La morte è come il vento, sempre al mio fianco',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        1,
        1,
        'Non c è cura per la follia',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        1,
        1,
        'Alcuni errori non si possono ripetere due volte',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        2,
        2,
        'Hai visto i due nuovi champions ?',
        'img/xaya.jpg');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        2,
        2,
        'Solo i più degni sopravvivono',
        '');
        

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        2,
        2,
        'Sono la tua punizione',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        3,
        3,
        'Non ti sei ancora iscritto a LoL ?',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        3,
        3,
        'La cecità non è un problema quando il nemico ha cattivo odore',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        3,
        3,
        'La cecità non è un problema quando il nemico ha cattivo odore',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        4,
        4,
        '#Vieni a giocare con me',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        4,
        4,
        'È finita quando lo dico io',
        '');

INSERT INTO post (id, creatorId, destinationId, text, image)
VALUES (default,
        4,
        4,
        'Non temere la fine, abbracciala',
        '');

--Popolamento followutente--
INSERT INTO followutente (follower, followed)
VALUES (1,2),
       (1,3),
       (1,4),
       (2,1),
       (2,3),
       (2,4),
       (3,1),
       (3,2),
       (3,4),
       (4,1),
       (4,2),
       (4,3);
       

INSERT INTO followgruppo (follower, followed)
VALUES (1,2),
       (2,1),
       (3,1),
       (3,2),
       (4,1),
       (4,2);