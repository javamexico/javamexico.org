package org.javamexico.portal.usuarios

import org.javamexico.portal.contenido.Contenido
import org.javamexico.portal.tags.Tag
import org.joda.time.LocalDate

class Usuario {

    transient springSecurityService

    //SpringSecurity
    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    //Informacion del usuario
    String nombre
    String correo
    LocalDate fechaNacimiento
    String ubicacion
    String sitioWeb
    String bio

    static hasMany = [
            habilidades:Habilidad,
            certificaciones:Certificacion,
            escuelas:Escuela,
            tags:Tag,
            contenidos:Contenido
    ]

    //Propiedades de control
    Integer estatus = 0
    Integer reputacion = 0
    String token = ""
    LocalDate dateCreated
    LocalDate lastUpdated
    LocalDate dateDeleted

    static constraints = {
        username blank: false, unique: true
        password blank: false
        dateDeleted nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Rol> getAuthorities() {
        UsuarioRol.findAllByUsuario(this).collect { it.rol } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
