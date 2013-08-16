package org.javamexico.portal.contenido

import org.javamexico.portal.usuarios.Usuario

class Voto {

    Boolean up

    static belongsTo = [usuario:Usuario, contenido:Contenido]

    Date dateCreated
    Date lastUpdated

    static constraints = {
        usuario unique: ['contenido']
    }
}
