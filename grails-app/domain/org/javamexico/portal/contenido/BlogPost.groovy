package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

class BlogPost extends Contenido{

    String titulo
    String texto

    Date dateCreated
    Date lastUpdated
    Date dateDeleted

    static belongsTo = [usuario:Usuario]
    static hasMany = [tags:Tag, comentarios:Comentario, votos:Voto]

    static constraints = {
    }
}
