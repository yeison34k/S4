INSERT INTO users (username, password, enabled, intentos, nombre, apellido, email) VALUES ('andres','$2a$10$ykhXmCAam5FUEF9GN.4Z8OwwWJidvMii6VFYe77cmS2X6oF6p4W86',true, 0, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO users (username, password, enabled, intentos, nombre, apellido, email) VALUES ('admin','$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK',true, 0, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO role (nombre) VALUES ('ROLE_USER');
INSERT INTO role (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user, role) VALUES (1, 1);
INSERT INTO user_role (user, role) VALUES (2, 2);
INSERT INTO user_role (user, role) VALUES (2, 1);
