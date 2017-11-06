/* Populate tables */
INSERT INTO role (role_id, role) VALUES(1, 'ADMIN');
INSERT INTO role (role_id, role) VALUES(2, 'USER');


INSERT INTO obra_social (direccion_obra_social, nombre_obra_social) VALUES('Bv. Oronio 1200', 'Esencial');
INSERT INTO obra_social (direccion_obra_social, nombre_obra_social) VALUES('Ituzaingo 1201', 'OSDE');
INSERT INTO obra_social (direccion_obra_social, nombre_obra_social) VALUES('Ninguna', 'Particular');

INSERT INTO plan (descripcion_plan, tipo_plan, id_obra_social) VALUES('plan con pago de coseguro', 'Grupo Oroño', 1);
INSERT INTO plan (descripcion_plan, tipo_plan, id_obra_social) VALUES('cobertura total', 'Plan Plata', 1);
INSERT INTO plan (descripcion_plan, tipo_plan, id_obra_social) VALUES('plan con pago de coseguro minimo', 'Osde Prepago', 2);
INSERT INTO plan (descripcion_plan, tipo_plan, id_obra_social) VALUES('plan todo cubierto', 'Osde Total', 2);
INSERT INTO plan (descripcion_plan, tipo_plan, id_obra_social) VALUES('paciente paga la totalidad', 'Particular', 3);

INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(34557182, 'Federico', 'Borda', '1989-07-21', 'Hombre', 'pasaje palpa 3532', 4323461, 'federicoborda3@hotmail.com', 1);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(34557184, 'Juan', 'Perez', '1980-01-02', 'Hombre', 'cafferata 3532', 4333463, 'juanperez@hotmail.com', 1);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(34557190, 'Pepe', 'Juarez', '1989-07-21', 'Hombre', 'ramon lista 3532', 4323470, 'pepe@hotmail.com', 2);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(35557182, 'Alberto', 'Pioni', '1989-07-21', 'Hombre', 'biedma 3532', 4323422, 'alberto@hotmail.com', 2);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(36557182, 'Ramon', 'Gaturro', '1989-07-21', 'Hombre', 'viamonte 3532', 4323455, 'ramon@hotmail.com', 3);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(37557182, 'Oscar', 'Villanueva', '1989-07-21', 'Hombre', 'ocampo 3532', 4323478, 'oscar@hotmail.com', 3);
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente, id_plan) VALUES(38557182, 'Romina', 'Fabra', '1989-07-21', 'Mujer', 'vera mujica 3532', 4323499, 'romina@hotmail.com', 4);

INSERT INTO medico (nro_matricula, apellido_medico, nombre_medico, direccion_medico, dni_medico, tel_medico, email_medico) VALUES(1234567, 'Moscarielo', 'Juan Alberto', 'Caferata 3030', 30555222, 4302200, 'juanalbeto@yahoo.com');
INSERT INTO medico (nro_matricula, apellido_medico, nombre_medico, direccion_medico, dni_medico, tel_medico, email_medico) VALUES(8910111, 'Roytman', 'Roberto', 'Urquiza 3030', 20555222, 4302233, 'roberto@yahoo.com');





