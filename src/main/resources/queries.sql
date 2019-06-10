/*Roles*/
insert into persons_data.role (role_id, role) values (1, 'ADMIN');
insert into persons_data.role (role_id, role) values (2, 'USER');

/*users*/
insert into persons_data.user (id, active, name, password)
values(1, 1,'ADMIN', '$2a$10$J6jThdl.Rad5G5phc/FEBulfZbXEEjF8FX/UZ8vOTiKfe/jAP7Yqq');

insert into persons_data.user (id, active, name, password)
values(2, 1, 'USER', '$2a$10$0y0fcMXVmmzFLT6a09OoguTR5SvhnjhvzpcSiEIz9JwLPYD1j124K');

/*Add Role To User*/
insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 2);