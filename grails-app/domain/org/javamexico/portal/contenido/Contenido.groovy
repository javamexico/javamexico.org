package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

abstract class Contenido {

    String titulo
    String texto

    static belongsTo = [usuario:Usuario]
    static hasMany = [tags:Tag, comentarios:Comentario]

    static constraints = {
    }

    static mapping = {
        tablePerHierarchy false
    }
}
