package org.javamexico.portal.contenido

class Foro {

    String nombre
    String descripcion
    int estatus
    int peso

    static hasMany = [foros:Foro]

    static constraints = {
    }
}
