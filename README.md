# Techforb Challenge 

Este proyecto es una implementación de un sistema bancario backend que permite a los usuarios realizar operaciones bancarias básicas a través de una API RESTful.

## Quick start

### Iniciar el proyecto

Para iniciar el proyecto es necesario el uso de docker.
Con el comando `docker-compose up -d` vamos a estar corriendo nuestra app back-end hecha con java 11, spring boot y persistencia de los datos en postgreSQL.

### Informacion detallada sobre los endpoints y recursos.

https://api.postman.com/collections/29239817-9d739d04-001b-4bc8-a7ae-aeff3b0f3df4?access_key=PMAT-01H8BN92T8G88M82B9MRWRZXXC

Comparto el link a la collecion de postman, donde se encuentra detallado tanto url, methodo http como sus parametros necesarios.


### Resumen del proyecto.



Sistema bancario con inicio de sesion y registro de usuarios, los cuales al registrarse por primera vez se les otorga una cuenta y una tarjeta con datos como cvu o numero de tarjeta generados aleatoriamente.

El usuario puede realizar acciones como:
- Transferencia.
- Solicitud de balance
- Deposito de dinero
- Retiro de dinero

Todo con sus respectivas validaciones y logica de negocio.


