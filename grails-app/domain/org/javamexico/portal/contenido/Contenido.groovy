package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario
import org.joda.time.DateTime

abstract class Contenido {

    String titulo
    String texto
    String hostname
    EstatusContenidoEnum status

    //TODO Usar DateTime
    DateTime dateCreated
    DateTime lastUpdated
    DateTime dateDeleted

    static belongsTo = [usuario:Usuario]
    static hasMany = [tags:Tag, comentarios:Comentario, votos:Voto]

    static constraints = {
        titulo ()
        texto widget: 'textarea', maxSize: 15000
        hostname display: false
        status display: false
        dateCreated display: false
        lastUpdated display: false
        dateDeleted nullable: true, display: false
        usuario nullable: true, display: false
        tags nullable: true
        comentarios nullable: true, display: false
        votos nullable: true, display: false
    }

}
