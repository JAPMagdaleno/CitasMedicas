CREATE TABLE doctores
(
    id              BIGSERIAL    NOT NULL,
    nombre          VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100) NOT NULL,
    especialidad    VARCHAR(50)  NOT NULL,
    PRIMARY KEY (id)
);
