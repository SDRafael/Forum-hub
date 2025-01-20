create table usuarios(

    id bigserial not null primary key,
    password varchar(100) not null,
    login varchar(100) not null
);