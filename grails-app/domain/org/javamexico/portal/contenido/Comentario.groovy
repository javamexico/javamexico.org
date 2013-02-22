package org.javamexico.portal.contenido

import org.javamexico.portal.usuarios.Usuario

class Comentario {

    String texto

    static belongsTo = [usuario:Usuario, contenido:Contenido]

    static constraints = {
    }
}
