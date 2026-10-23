-- =====================================================================
--  Base de datos: preguntastest  (versión corregida)
--  Compatible con MySQL 5.7 / 8.x y MariaDB 10.x
-- ---------------------------------------------------------------------
--  Usuarios de prueba (contraseña = MD5 del texto indicado):
--     luis1 / luis1      alex1 / alex1
-- =====================================================================

CREATE DATABASE IF NOT EXISTS preguntastest
  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE preguntastest;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS preguntas_formuladas;
DROP TABLE IF EXISTS test_usuarios;
DROP TABLE IF EXISTS respuestas;
DROP TABLE IF EXISTS preguntas;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS categorias;

-- ---------------------------------------------------------------------
--  categorias
-- ---------------------------------------------------------------------
CREATE TABLE categorias (
  cod_cat    CHAR(3)     NOT NULL,
  nombre_cat VARCHAR(15) NOT NULL,
  PRIMARY KEY (cod_cat),
  UNIQUE KEY uk_nombre (nombre_cat)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO categorias VALUES
  ('CIE','Ciencias'),
  ('DEP','Deportes'),
  ('GEO','Geografía'),
  ('HIS','Historia'),
  ('MUS','Música'),
  ('SER','Series TV');

-- ---------------------------------------------------------------------
--  usuarios
-- ---------------------------------------------------------------------
CREATE TABLE usuarios (
  id_usuario       INT         NOT NULL AUTO_INCREMENT,
  usuario          VARCHAR(15) NOT NULL,
  password	   VARCHAR(32) NOT NULL,          -- MD5 en hexadecimal
  nombre           VARCHAR(15) NOT NULL,
  apellidos        VARCHAR(30) NOT NULL,
  fechanac         DATE        DEFAULT NULL,
  num_accesos      INT         DEFAULT 0,
  test_realizados  INT         DEFAULT 0,
  puntuacion_media FLOAT       DEFAULT 0,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY uk_usuario (usuario)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO usuarios VALUES
  (3,'luis1','43d25532e4e1759773233764f9c1bc18','Luis','Herrero','2000-01-01',0,0,0),
  (4,'alex1','946d20c91f154795805cebdefe919ef7','Alex','Posada Campos','2000-11-11',0,0,0);

-- ---------------------------------------------------------------------
--  preguntas
--   tipo: 1 varias válidas | 2 una válida | 3 foto + varias válidas
--         4 foto + una válida | 5 audio + una válida
--   fecha_canc: si no es NULL, la pregunta está cancelada y no se formula
-- ---------------------------------------------------------------------
CREATE TABLE preguntas (
  num_preg        INT          NOT NULL AUTO_INCREMENT,
  enunciado       TEXT         NOT NULL,
  categoria       CHAR(3)      DEFAULT NULL,
  nivel           TINYINT      DEFAULT 1,
  tipo            TINYINT      DEFAULT NULL,
  ruta_foto       VARCHAR(200) DEFAULT NULL,
  ruta_audio      VARCHAR(200) DEFAULT NULL,
  veces_formulada INT          DEFAULT 0,
  veces_acertada  INT          DEFAULT 0,
  fecha_canc      DATE         DEFAULT NULL,
  PRIMARY KEY (num_preg),
  KEY fk_pregunta_categoria (categoria),
  CONSTRAINT ck_pregunta_nivel CHECK (nivel BETWEEN 1 AND 3),
  CONSTRAINT ck_pregunta_tipo  CHECK (tipo BETWEEN 1 AND 5),
  CONSTRAINT fk_pregunta_categoria FOREIGN KEY (categoria)
    REFERENCES categorias (cod_cat) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO preguntas VALUES
  (1,'Señala cuáles de las siguientes ciudades están entre las 10 aglomeraciones urbanas más pobladas del mundo (ONU, 2018)','GEO',2,1,NULL,NULL,0,0,NULL),
  (2,'Marca, entre los siguientes, los que son nombres de estrechos','GEO',3,1,NULL,NULL,0,0,NULL),
  (3,'Marca los países que pertenecen a Asia','GEO',1,1,NULL,NULL,0,0,NULL),
  (4,'Marca los ríos que pasan por la Comunidad Autónoma de Cantabria','GEO',2,1,NULL,NULL,0,0,NULL),
  (5,'La siguiente imagen corresponde al estrecho de ...','GEO',2,4,'estrecho.png',NULL,0,0,NULL),
  (6,'La siguiente bandera es la de ...','GEO',2,4,'lituania.png',NULL,0,0,NULL),
  (7,'Marca los que son personajes de la serie Friends','SER',2,1,NULL,NULL,0,0,NULL),
  (8,'Marca las localidades que son de Cantabria','GEO',3,1,NULL,NULL,0,0,NULL),
  (9,'Marca las localidades que son de la provincia de Sevilla','GEO',3,1,NULL,NULL,0,0,NULL),
  (10,'La capital de Islandia es ...','GEO',2,2,NULL,NULL,0,0,NULL),
  (11,'Señala las provincias o distritos por los que pasa el río Duero','GEO',2,1,NULL,NULL,0,0,NULL),
  (12,'Señala las series de TV que son estadounidenses','SER',2,1,NULL,NULL,0,0,NULL),
  (13,'La Traviata es una ópera de Verdi','MUS',1,2,'pregunta13.png',NULL,0,0,NULL),
  (14,'Señala las óperas que son de Verdi','MUS',3,1,NULL,NULL,0,0,NULL),
  (15,'La campeona olímpica del concurso completo de gimnasia artística en los Juegos Olímpicos de Río 2016 fue ...','DEP',1,2,'pregunta15.png',NULL,0,0,NULL),
  (16,'¿En qué Juegos Olímpicos consiguió Fermín Cacho la medalla de oro en los 1500 m?','DEP',1,2,'pregunta16.png',NULL,0,0,NULL),
  (17,'La nacionalidad del jugador de baloncesto Luka Dončić es ...','DEP',1,2,'pregunta17.png',NULL,0,0,NULL),
  (18,'¿Cuál es la franquicia de la NBA de la ciudad de Dallas?','DEP',2,2,'pregunta18.png',NULL,0,0,NULL),
  (19,'¿Qué grupo de los 80 compuso e interpretó la canción «La chica de ayer»?','MUS',2,2,'pregunta19.png',NULL,0,0,NULL),
  (20,'¿A qué grupo musical pertenece el cantante Marc Ros?','MUS',3,2,'pregunta20.png',NULL,0,0,NULL),
  (21,'¿De qué serie de TV es este personaje?','SER',2,4,'cersei.png',NULL,0,0,NULL),
  (22,'¿De qué grupo es el tema que está sonando?','MUS',3,5,'pregunta22.png','izal.mp3',0,0,NULL),
  (23,'¿A qué juegas en un recinto cerrado si consigues un strike?','DEP',2,2,'pregunta23.png',NULL,0,0,NULL),
  (24,'¿Qué selección europea jugó contra Francia la final del Mundial de fútbol de Rusia 2018?','DEP',1,2,'pregunta24.png',NULL,0,0,NULL),
  (25,'¿En qué equipo debutó Michael Jordan en la NBA?','DEP',1,2,'pregunta25.png',NULL,0,0,NULL),
  (26,'¿Cuántos años consecutivos ganó Miguel Induráin el Tour de Francia?','DEP',1,2,'pregunta26.png',NULL,0,0,NULL),
  (27,'Kimi Räikkönen ha sido campeón del mundo de Fórmula 1','DEP',1,2,'pregunta27.png',NULL,0,0,NULL),
  (28,'¿De qué álbum es la canción «Learning to Fly» de Pink Floyd?','MUS',3,2,'pregunta28.png',NULL,0,0,NULL),
  (29,'¿En qué año dejó John Frusciante los Red Hot Chili Peppers por segunda vez?','MUS',3,2,'pregunta29.png',NULL,0,0,NULL),
  (30,'¿Qué grupo tocó en la azotea del edificio en el que tenía su estudio de grabación?','MUS',2,2,'pregunta30.png',NULL,0,0,NULL),
  (31,'A quién le importa - Alaska | “Yo sé que me critican, me consta que me odian, la envidia les corroe…','MUS',1,2,'pregunta31.png',NULL,0,0,'2026-09-01');

-- ---------------------------------------------------------------------
--  respuestas
-- ---------------------------------------------------------------------
CREATE TABLE respuestas (
  num_preg         INT          NOT NULL,
  num_resp         INT          NOT NULL,
  texto_resp       TEXT         NOT NULL,
  correcta         TINYINT(1)   DEFAULT 0,
  ruta_foto        VARCHAR(200) DEFAULT NULL,
  veces_respondida INT          DEFAULT 0,
  PRIMARY KEY (num_preg, num_resp),
  CONSTRAINT fk_respuesta_pregunta FOREIGN KEY (num_preg)
    REFERENCES preguntas (num_preg) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO respuestas VALUES
  (1,1,'París',0,NULL,0),
  (1,2,'Ciudad de México',1,NULL,0),
  (1,3,'Nueva York',0,NULL,0),
  (1,4,'Buenos Aires',0,NULL,0),
  (1,5,'Osaka',1,NULL,0),
  (1,6,'Bombay',1,NULL,0),
  (2,1,'Creus',0,NULL,0),
  (2,2,'Gibraltar',1,NULL,0),
  (2,3,'Mesina',1,NULL,0),
  (2,4,'Ardenas',0,NULL,0),
  (2,5,'Apeninos',0,NULL,0),
  (2,6,'Bering',1,NULL,0),
  (3,1,'Japón',1,NULL,0),
  (3,2,'Madagascar',0,NULL,0),
  (3,3,'Comoras',0,NULL,0),
  (3,4,'Seychelles',0,NULL,0),
  (3,5,'Kiribati',0,NULL,0),
  (3,6,'Azerbaiyán',1,NULL,0),
  (4,1,'Nalón',0,NULL,0),
  (4,2,'Saja',1,NULL,0),
  (4,3,'Pisuerga',1,NULL,0),
  (4,4,'Eo',0,NULL,0),
  (4,5,'Cadagua',0,NULL,0),
  (4,6,'Miera',1,NULL,0),
  (5,1,'Bering',0,NULL,0),
  (5,2,'Gibraltar',1,NULL,0),
  (5,3,'Bósforo',0,NULL,0),
  (5,4,'Mesina',0,NULL,0),
  (6,1,'Vanuatu',0,NULL,0),
  (6,2,'Irlanda',0,NULL,0),
  (6,3,'Lituania',1,NULL,0),
  (6,4,'Macedonia del Norte',0,NULL,0),
  (7,1,'Rachel Green',1,NULL,0),
  (7,2,'Carlton Banks',0,NULL,0),
  (7,3,'Melinda Gordon',0,NULL,0),
  (7,4,'Joy Turnes',0,NULL,0),
  (7,5,'Ross Geller',1,NULL,0),
  (7,6,'Chandler Bing',1,NULL,0),
  (8,1,'Aguilar de Campoo',0,NULL,0),
  (8,2,'Trespaderne',0,NULL,0),
  (8,3,'Laredo',1,NULL,0),
  (8,4,'Liérganes',1,NULL,0),
  (8,5,'Llanes',0,NULL,0),
  (8,6,'Bejes',1,NULL,0),
  (9,1,'Bormujos',1,NULL,0),
  (9,2,'Gelves',1,NULL,0),
  (9,3,'Iznájar',0,NULL,0),
  (9,4,'Pozoblanco',0,NULL,0),
  (9,5,'Moriles',0,NULL,0),
  (9,6,'Osuna',1,NULL,0),
  (10,1,'Reikiavik',1,NULL,0),
  (10,2,'Astaná',0,NULL,0),
  (10,3,'Vilna',0,NULL,0),
  (10,4,'Tallin',0,NULL,0),
  (11,1,'Soria',1,NULL,0),
  (11,2,'Palencia',0,NULL,0),
  (11,3,'Valladolid',1,NULL,0),
  (11,4,'Salamanca',1,NULL,0),
  (11,5,'Braganza',1,NULL,0),
  (11,6,'León',0,NULL,0),
  (12,1,'Breaking Bad',1,NULL,0),
  (12,2,'Vikingos',0,NULL,0),
  (12,3,'Juego de Tronos',1,NULL,0),
  (12,4,'Sherlock',0,NULL,0),
  (12,5,'La que se avecina',0,NULL,0),
  (12,6,'The Big Bang Theory',1,NULL,0),
  (13,1,'Verdadero',1,NULL,0),
  (13,2,'Falso',0,NULL,0),
  (14,1,'Madama Butterfly',0,NULL,0),
  (14,2,'Rigoletto',1,NULL,0),
  (14,3,'Tosca',0,NULL,0),
  (14,4,'La Traviata',1,NULL,0),
  (14,5,'Il Corsaro',1,NULL,0),
  (14,6,'Otello',1,NULL,0),
  (15,1,'Wang Yan',0,NULL,0),
  (15,2,'Aliya Mustafina',0,NULL,0),
  (15,3,'Simone Biles',1,NULL,0),
  (16,1,'Seúl',0,NULL,0),
  (16,2,'Barcelona',1,NULL,0),
  (16,3,'Atlanta',0,NULL,0),
  (16,4,'Sídney',0,NULL,0),
  (17,1,'Español',0,NULL,0),
  (17,2,'Serbio',0,NULL,0),
  (17,3,'Croata',0,NULL,0),
  (17,4,'Ruso',0,NULL,0),
  (17,5,'Esloveno',1,NULL,0),
  (18,1,'Cavs',0,NULL,0),
  (18,2,'Nets',0,NULL,0),
  (18,3,'Nuggets',0,NULL,0),
  (18,4,'Mavericks',1,NULL,0),
  (19,1,'Nacha Pop',1,NULL,0),
  (19,2,'Los Secretos',0,NULL,0),
  (19,3,'La Guardia',0,NULL,0),
  (19,4,'Gabinete Caligari',0,NULL,0),
  (20,1,'Delorean',0,NULL,0),
  (20,2,'Izal',0,NULL,0),
  (20,3,'Sidonie',1,NULL,0),
  (21,1,'Los Tudor',0,NULL,0),
  (21,2,'Juego de Tronos',1,NULL,0),
  (21,3,'Vikingos',0,NULL,0),
  (21,4,'Camelot',0,NULL,0),
  (22,1,'Izal',1,NULL,0),
  (22,2,'Lori Meyers',0,NULL,0),
  (22,3,'Sidonie',0,NULL,0),
  (23,1,'Curling',0,NULL,0),
  (23,2,'Bolos',1,NULL,0),
  (23,3,'Snooker',0,NULL,0),
  (24,1,'Alemania',0,NULL,0),
  (24,2,'Croacia',1,NULL,0),
  (24,3,'Inglaterra',0,NULL,0),
  (24,4,'Bélgica',0,NULL,0),
  (25,1,'Phoenix Suns',0,NULL,0),
  (25,2,'New Jersey Nets',0,NULL,0),
  (25,3,'Chicago Bulls',1,NULL,0),
  (26,1,'2 años',0,NULL,0),
  (26,2,'3 años',0,NULL,0),
  (26,3,'4 años',0,NULL,0),
  (26,4,'5 años',1,NULL,0),
  (27,1,'Verdadero',1,NULL,0),
  (27,2,'Falso',0,NULL,0),
  (28,1,'The Wall',0,NULL,0),
  (28,2,'Animals',0,NULL,0),
  (28,3,'A Momentary Lapse of Reason',1,NULL,0),
  (28,4,'The Dark Side of the Moon',0,NULL,0),
  (29,1,'2003',0,NULL,0),
  (29,2,'2005',0,NULL,0),
  (29,3,'2007',0,NULL,0),
  (29,4,'2009',1,NULL,0),
  (29,5,'2011',0,NULL,0),
  (30,1,'The Beatles',1,NULL,0),
  (30,2,'The Doors',0,NULL,0),
  (30,3,'The Rolling Stones',0,NULL,0),
  (30,4,'The Who',0,NULL,0),
  (31,1,'.. mi moño les trastoca',0,NULL,0),
  (31,2,'--- mi vida les descoloca',0,NULL,0),
  (31,3,'... mi vida les agobia',1,NULL,0),
  (31,4,'... mi vida les deshonra',0,NULL,0);

-- ---------------------------------------------------------------------
--  test_usuarios
-- ---------------------------------------------------------------------
CREATE TABLE test_usuarios (
  num_test         INT         NOT NULL AUTO_INCREMENT,
  usuario          VARCHAR(15) DEFAULT NULL,
  fecha            DATE        NOT NULL,
  hora_inicio      TIME        DEFAULT NULL,
  hora_fin         TIME        DEFAULT NULL,
  general          TINYINT(1)  DEFAULT 1,     -- 1: todas las categorías
  numero_preguntas INT         DEFAULT NULL,
  categoria        CHAR(3)     DEFAULT NULL,  -- solo si general = 0
  puntos           FLOAT       DEFAULT NULL,
  PRIMARY KEY (num_test),
  KEY fk_test_usuario (usuario),
  KEY fk_test_categoria (categoria),
  CONSTRAINT fk_test_categoria FOREIGN KEY (categoria)
    REFERENCES categorias (cod_cat) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_test_usuario FOREIGN KEY (usuario)
    REFERENCES usuarios (usuario) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ---------------------------------------------------------------------
--  preguntas_formuladas
-- ---------------------------------------------------------------------
CREATE TABLE preguntas_formuladas (
  numero_test      INT        NOT NULL,
  num_preg_en_test INT        NOT NULL,
  pregunta         INT        NOT NULL,
  acertada         TINYINT(1) DEFAULT NULL,
  puntos           FLOAT      DEFAULT NULL,
  PRIMARY KEY (numero_test, num_preg_en_test),
  KEY fk_pregform_pregunta (pregunta),
  CONSTRAINT fk_pregform_pregunta FOREIGN KEY (pregunta)
    REFERENCES preguntas (num_preg) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_pregform_test FOREIGN KEY (numero_test)
    REFERENCES test_usuarios (num_test) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
