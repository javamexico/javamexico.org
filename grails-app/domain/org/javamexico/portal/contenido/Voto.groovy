package org.javamexico.portal.contenido

import org.javamexico.portal.usuarios.Usuario

class Voto {

    Boolean up

    static belongsTo = [usuario:Usuario]

    Date dateCreated
    Date lastUpdated
    Date dateDeleted

    static constraints = {
    }
}
