package org.javamexico.portal.contenido

import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario

abstract class Contenido {

    static constraints = {
    }

    static mapping = {
        tablePerHierarchy false
    }
}
