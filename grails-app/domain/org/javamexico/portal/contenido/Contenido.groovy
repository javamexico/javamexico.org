package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

abstract class Contenido {

    String titulo
    String texto
    String hostname
    Integer status

    Date dateCreated
    Date lastUpdated
    Date dateDeleted

    static belongsTo = [usuario:Usuario]
    static hasMany = [tags:Tag, comentarios:Comentario, votos:Voto]

    static constraints = {
    }

}
