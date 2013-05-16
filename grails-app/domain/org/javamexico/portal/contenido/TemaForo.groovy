package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

class TemaForo extends Contenido{

    static belongsTo = [foro:Foro]

    static constraints = {
    }
}
