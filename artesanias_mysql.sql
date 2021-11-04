create table paises (
    id int auto_increment not null,
    clave varchar(10) not null,
    pais varchar(50) not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id)
) ENGINE=INNODB;

create table artesanos (
    id int auto_increment not null,
    clave varchar(50) not null,
    nombres varchar(50) not null,
    apellidopaterno varchar(50) not null,
    apellidomaterno varchar(50) null,
    idpais int not null,
    correoelectronico varchar(100) not null,
    clavetelefonica varchar(10) not null,
    numerocelular varchar(50) not null,
    empresa varchar(50) null,
    referenciaentrega longtext,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id),
    foreign key (idpais) references paises(id),
    unique key (correoelectronico),
    unique key (clave),
    index (correoelectronico),
    index (clave)
) ENGINE=INNODB;

create table compradores (
    id int auto_increment not null,
    nombres varchar(50) not null,
    apellidopaterno varchar(50) not null,
    apellidomaterno varchar(50) null,
    idpais int not null,
    correoelectronico varchar(100) not null,
    clavetelefonica varchar(10) not null,
    numerocelular varchar(50) not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id),
    foreign key (idpais) references paises(id),
    unique key (correoelectronico),
    index  (correoelectronico)
)ENGINE=INNODB;

create table tipoartesanias (
    id int auto_increment not null,
    tipoartesania varchar(50) not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id)
)ENGINE=INNODB;

create table tipomonedas (
    id int auto_increment not null,
    clave varchar(10) not null,
    moneda varchar(20) not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id)
)ENGINE=INNODB;

create table artesanias (
    id int auto_increment not null,
    nombre varchar(50) not null,
    descripcion longtext not null,
    idtipoartesania int not null,
    idtipomoneda int not null,
    idartesano int not null,
    precio double(12, 2) not null,
    rutaimagen longtext not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    aprobado tinyint default(0) not null,
    primary key (id),
    foreign key (idtipoartesania) references tipoartesanias(id),
    foreign key (idtipomoneda) references tipomonedas(id),
    foreign key (idartesano) references artesanos(id)
)ENGINE=INNODB;

create table calificaciones (
    id int auto_increment not null,
    idartesano int not null,
    idcomprador int not null,
    idartesania int not null,
    calificacion int not null,
    comentario longtext null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    primary key (id),
    foreign key (idartesano) references artesanos(id),
    foreign key (idcomprador) references compradores(id),
    foreign key (idartesania) references artesanias(id),
    unique key (idartesano, idcomprador, idartesania)
)ENGINE=INNODB;

create table clavestelefonicas (
    id int auto_increment not null,
    clave varchar(10) not null,
    idpais int not null,
    fechacreacion varchar(50) not null,
    fechaactualizacion varchar(50) null,
    estado tinyint default(1) not null,
    primary key (id),
    foreign key (idpais) references paises(id)
)ENGINE=INNODB;

insert into tipoartesanias (tipoartesania, fechacreacion) values ('Cerámica', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Madera', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Fibras Vegetales', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Mármol, Piedra y Vidrio', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Metal', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Piel y Cuero', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Textil', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Joyería', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Instrumentos Musicales', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipoartesanias (tipoartesania, fechacreacion) values ('Varios', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));

insert into paises (clave, pais, fechacreacion) values ('MEX', 'México', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('BEL', 'Belice', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('CRI', 'Costa Rica', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('SLV', 'El Salvador', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('GTM', 'Guatemala', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('HND', 'Honduras', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('NIC', 'Nicaragua', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('PAN', 'Panamá', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('CUB', 'Cuba', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('PRI', 'Puerto Rico', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('DOM', 'República Dominicana', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('ARG', 'Argentina', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('BOL', 'Bolivia', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('CHL', 'Chile', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('COL', 'Colombia', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('ECU', 'Ecuador', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('PRY', 'Paraguay', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('PER', 'Perú', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('URY', 'Uruguay', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('VEN', 'Venezuela', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('BRA', 'Brasil', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into paises (clave, pais, fechacreacion) values ('USA', 'Estado Unidos', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));

insert into tipomonedas(clave, moneda, fechacreacion) values ('ARS', 'Peso Argentino', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('PAB', 'Balboa', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('VES', 'Bolívar', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('BOB', 'Boliviano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('USD', 'Dólar Americano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('CRC', 'Colón', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('NIO', 'Córdoba', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('BRL', 'Real', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('CLP', 'Peso Chileno', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('COP', 'Peso Colombiano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('CUP', 'Peso Cubano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('MXN', 'Peso Mexicano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('DOP', 'Peso Dominicano', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('UYU', 'Peso Uruguayo', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('GTQ', 'Quetzal', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('HNL', 'Lempira', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('PYG', 'Guaraní', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into tipomonedas(clave, moneda, fechacreacion) values ('PEN', 'Sol', DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));

insert into clavestelefonicas (clave, idpais, fechacreacion) values ('52', 1, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('501', 2, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('506', 3, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('503', 4, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('502', 5, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('504', 6, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('505', 7, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('507', 8, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('53', 9, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('1+787', 10, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('1+809', 11, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('54', 12, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('591', 13, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('56', 14, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('57', 15, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('593', 16, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('595', 17, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('51', 18, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('598', 19, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('58', 20, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('55', 21, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));
insert into clavestelefonicas (clave, idpais, fechacreacion) values ('1', 22, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));

insert into artesanos(clave, nombres, apellidopaterno, apellidomaterno, idpais, correoelectronico, clavetelefonica, numerocelular, empresa, referenciaentrega, fechacreacion)
values ('MEX-1','artesano','dummy','dummy',1,'artesano@dummy.com','52','5551237891', null, null, DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));

insert into compradores(nombres, apellidopaterno, apellidomaterno, idpais, correoelectronico, clavetelefonica, numerocelular, fechacreacion)
values('comprador','dummy','dummy', 1, 'comprador@dummy.com','52','2229871234',DATE_FORMAT(UTC_TIMESTAMP(6), '%Y-%m-%dT%k:%i:%s.%fZ'));