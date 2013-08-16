package org.javamexico.portal.contenido

enum EstatusContenidoEnum {

    PUBLICADO(1,"Publicado"),
    NO_PUBLICADO(2,"Inactivo"),
    SPAM(3, "SPAM")

    final int id
    final String etiqueta

    EstatusContenidoEnum(int id, String etiqueta){
        this.id = id
        this.etiqueta = etiqueta
    }

    static constraints = {
    }
}
