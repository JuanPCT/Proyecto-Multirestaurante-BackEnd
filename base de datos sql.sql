CREATE TABLE `Rol` (
  `id` int(11),
  `nombre` varchar(50),
  PRIMARY KEY (`id`)
);

CREATE TABLE `USUARIO` (
  `documento` int(11),
  `nombre` varchar(50),
  `apellido` varchar(50),
  `telefono` varchar(30),
  `email` varchar(150),
  `password` varchar(50),
  `estado` boolean,
  `fecha_nacimiento` date,
  `fecha_creacion` date,
  `Rol_id` int(11),
  PRIMARY KEY (`documento`),
  FOREIGN KEY (`Rol_id`) REFERENCES `Rol`(`id`)
);

CREATE TABLE `FACTURA` (
  `id_factura` int(11),
  `documento` int(11),
  `fecha` date,
  PRIMARY KEY (`id_factura`),
  FOREIGN KEY (`documento`) REFERENCES `USUARIO`(`documento`)
);

CREATE TABLE `RESTAURANTE` (
  `id` int(11),
  `nombre` varchar(50),
  `direccion` varchar(50),
  `telefono` varchar(30),
  `email` varchar(150),
  `password` varchar(50),
  `imagen` blob,
  `estado` boolean,
  `url_video` varchar(250),
  PRIMARY KEY (`id`)
);

CREATE TABLE `MENU` (
  `Menu_id` int(11),
  `Tipo` varchar(50),
  `id_restaurante` int(11),
  PRIMARY KEY (`Menu_id`),
  FOREIGN KEY (`id_restaurante`) REFERENCES `RESTAURANTE`(`id`)
);

CREATE TABLE `PRODUCTO` (
  `id` int(11),
  `nombre` varchar(50),
  `precio` double,
  `imagen` blob,
  `Menu_id` int(11),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`Menu_id`) REFERENCES `MENU`(`Menu_id`)
);

CREATE TABLE `DETALLE` (
  `id_detalle` int(11),
  `id_factura` int(11),
  `id_producto` int(11),
  `cantidad` int(11),
  `precio` double,
  PRIMARY KEY (`id_detalle`, `id_factura`),
  FOREIGN KEY (`id_factura`) REFERENCES `FACTURA`(`id_factura`),
  FOREIGN KEY (`id_producto`) REFERENCES `PRODUCTO`(`id`)
);

CREATE TABLE `ADMINR` (
  `documento` int(11),
  `nombre` varchar(50),
  `apellido` varchar(50),
  `telefono` varchar(30),
  `email` varchar(150),
  `password` varchar(50),
  `Rol_id` int(11),
  `id_restaurante` int(11),
  PRIMARY KEY (`documento`),
  FOREIGN KEY (`Rol_id`) REFERENCES `Rol`(`id`),
  FOREIGN KEY (`id_restaurante`) REFERENCES `RESTAURANTE`(`id`)
);

CREATE TABLE `COMENTARIOS` (
  `id` int(11),
  `id_restaurante` int(11),
  `documentoU` int(11),
  `descripcion` varchar(200),
  `calificacion` double,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`documentoU`) REFERENCES `USUARIO`(`documento`),
  FOREIGN KEY (`id_restaurante`) REFERENCES `RESTAURANTE`(`id`)
);

CREATE TABLE `SOLICITUD` (
  `id` int(11),
  `documentoA` int(11),
  `descripcion` varchar(250),
  `imagen` blob,
  `estado` boolean,
  `fecha` date,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`documentoA`) REFERENCES `ADMINR`(`documento`)
);