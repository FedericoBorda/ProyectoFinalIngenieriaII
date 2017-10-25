/* Populate tables */
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente) VALUES(34557182, 'Federico', 'Borda', '1989-07-21', 'masc', 'pasaje palpa 3532', 4323461, 'federicoborda3@hotmail.com');
INSERT INTO paciente (dni_paciente, nombre_paciente, apellido_paciente, fecha_nacimiento_pa, sexo_paciente, direccion_paciente, tel_paciente, email_paciente) VALUES(34557184, 'Juan', 'Perez', '1980-01-02', 'masc', 'cafferata 3532', 4333463, 'juanperez@hotmail.com');

INSERT INTO medico (nro_matricula, apellido_medico, nombre_medico, direccion_medico, dni_medico, tel_medico, email_medico) VALUES(1234567, 'Moscarielo', 'Juan Alberto', 'Caferata 3030', 30555222, 4302200, 'juanalbeto@yahoo.com');
INSERT INTO medico (nro_matricula, apellido_medico, nombre_medico, direccion_medico, dni_medico, tel_medico, email_medico) VALUES(8910111, 'Roytman', 'Roberto', 'Urquiza 3030', 20555222, 4302233, 'roberto@yahoo.com');

INSERT INTO obra_social (direccion_obra_social, nombre_obra_social) VALUES('Bv. Oronio 1200', 'Esencial');
INSERT INTO obra_social (direccion_obra_social, nombre_obra_social) VALUES('Ituzaingo 1201', 'OSDE');

INSERT INTO plan (descripcion_plan, tipo_plan) VALUES('plan con pago de coseguro', 'Grupo Oronio');
INSERT INTO plan (descripcion_plan, tipo_plan) VALUES('plan sin pago de coseguro', 'Plan Plata');