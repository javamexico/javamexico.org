package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

class Comentario {

    String titulo
    String texto
    String hostname
    Integer status

    Date dateCreated
    Date lastUpdated
    Date dateDeleted

    static belongsTo = [usuario:Usuario, contenidos:Contenido]
    static hasMany = [tags:Tag, comentarios:Comentario]

    static constraints = {
    }
}
