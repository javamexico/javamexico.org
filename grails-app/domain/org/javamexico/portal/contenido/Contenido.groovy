package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario
import org.joda.time.LocalDate

abstract class Contenido {

    String titulo
    String texto
    String hostname
    Integer status

    LocalDate dateCreated
    LocalDate lastUpdated
    LocalDate dateDeleted

    static belongsTo = [usuario:Usuario]
    static hasMany = [tags:Tag, comentarios:Comentario, votos:Voto]

    static constraints = {
        dateDeleted nullable: true
    }

}
