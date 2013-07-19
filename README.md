javaMexico.org 2.0
==================

Acerca
------

javaMéxico 2.0 es un esfuerzo de la [Comunidad Java México](http://www.javamexico.org/ "www.javamexico.org") por desarrollar un portal CMS que suplante el actual mejorando y agregando funcionalidad.

Este proyecto será desarrollado utilizando la plataforma Java mediante Groovy y Grails.

Instalación
-----------
Para echar a andar el proyecto no es necesario más que tener Grails instalado, clonar el proyecto y correrlo mediante el script: grails run-app.

Con este comando el proyecto se levanta en ambiente de desarrollo, así que por default se carga un servidor de base de datos en memoria ([H2](http://www.h2database.com/ "H2"))), lo cuál hace que se pueda desarrollar sin necesidad de instalar algún RDBMS en el equipo. La idea es que en producción el proyecto utilice PostgreSQL 9.

Colaborar
---------
Colaborar es muy sencillo gracias a Git y Github.

[Haz un fork del proyecto](https://help.github.com/articles/fork-a-repo) y analiza el código, pruébalo y haz cambios si lo deseas, si quieres sugerir una mejora puedes programarla en tu fork y enviarla al repositorio upstream mediante [Pull Request](https://help.github.com/articles/using-pull-requests). Nosotros la evaluaremos y seguramente la integraremos. Con el tiempo y continuidad de tus contribuciones te puedes integrar como commiter de Java México para que puedas contribuir directamente.

También puedes revisar la lista de funcionalidades por desarrollar [en la página de Issues del proyecto](https://github.com/javamexico/javamexico.org/issues "Issues javaMéxico 2.0") y levantar la mano para desarrollar una.

Branches
--------
El uso de branches en el repositorio central está limitado inicialmente a "master", en local puedes utilizar los branches que desees aunque al integrar algún cambio al upstream se deberá hacer en "master".

Modelo de Dominio
-----------------
He aquí un diagrama del modelo de dominio (generado con Intellij IDEA):
![Modelo de Dominio](https://raw.github.com/javamexico/javamexico.org/master/diagram.png)

Integración Continua
-------------------

**Estatus en Drone.io**

[![Build Status](https://drone.io/github.com/javamexico/javamexico.org/status.png)](https://drone.io/github.com/javamexico/javamexico.org/latest)

**Deployment en Heroku (tarda en cargar por la capacidad del plan):**

[http://javamexico.herokuapp.com/](http://javamexico.herokuapp.com/)


------
2013, javaMexico.org