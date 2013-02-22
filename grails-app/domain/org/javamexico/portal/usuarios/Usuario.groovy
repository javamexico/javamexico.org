package org.javamexico.portal.usuarios

import org.javamexico.portal.tags.Tag

class Usuario {

    //Informacion del Usuario
    String usuario
    String nombre
    String correo
    String contrasenia
    Date fechaNacimiento
    String ubicacion

    //Propiedades de control
    Integer status = 0
    Integer reputacion = 0
    String token = ""
    Date dateCreated
    Date lastUpdated
    Date dateDeleted

    static hasMany = [habilidades:Habilidad, certificaciones:Certificacion, escuelas:Escuela, tags:Tag]

    static constraints = {
    }
}
