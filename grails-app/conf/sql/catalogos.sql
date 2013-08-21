--define los roles del sistema
--poner aquí los roles del sistema

--usuarios de ejemplo
insert into usuario (id, version, username, "password", enabled, account_expired, account_locked, password_expired, nombre, correo, date_created, bio, reputacion, token, ubicacion, fecha_nacimiento, date_deleted, estatus, sitio_web, last_updated)values (1, 0, 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', true, false, false, false, 'Administrador',  'administrador@example.com', current_timestamp, 'mi bio',0, ' ','México', current_timestamp,   null,  0, 'javamexico.org',current_timestamp);
insert into usuario (id, version, username, "password", enabled, account_expired, account_locked, password_expired, nombre, correo, date_created, bio, reputacion, token, ubicacion, fecha_nacimiento, date_deleted, estatus, sitio_web, last_updated)values (2, 0, 'Shadonwk', '5f4dcc3b5aa765d61d8327deb882cf99', true, false, false, false, 'Administrador',  'shadonwk@example.com', current_timestamp, 'mi bio',0, ' ','México', current_timestamp,   null,  0, 'javamexico.org',current_timestamp);


--relacion usuario rol
--poner aqui la relación entre usuario y rol

