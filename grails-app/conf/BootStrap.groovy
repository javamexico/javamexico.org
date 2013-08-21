import org.javamexico.portal.usuarios.Requestmap
import org.javamexico.portal.usuarios.Rol
import org.javamexico.portal.usuarios.Usuario
import org.javamexico.portal.usuarios.UsuarioRol
import org.joda.time.LocalDate

class BootStrap {

    def init = { servletContext ->

        def springSecurityService

        if(!Rol.count()){
            new Rol(authority: 'ROLE_ADMIN').save(failOnError: true)
            new Rol(authority: 'ROLE_USER').save(failOnError: true)
        }

        if (!Usuario.count()){
            new Usuario(
                    username: 'benek',
                    password: 'benekin',
                    enabled: true,
                    nombre: 'Javier Ramirez',
                    correo: 'xbenek@java.net',
                    fechaNacimiento: new LocalDate(1984, 3, 20),
                    ubicacion: 'Queretaro',
                    sitioWeb: 'www.javamexico.org/blogs/benek',
                    bio: 'Algo aqui...'
            ).save(failOnError: true)
            new UsuarioRol(usuario: Usuario.get(1), rol: Rol.get(1)).save(failOnError: true)
        }

        if (!Requestmap.count()){
            new Requestmap(url: '/admin/dbconsole/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/js/**', configAttribute:'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/css/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/images/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/login/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/logout/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save(failOnError: true)
            new Requestmap(url: '/*', configAttribute: 'IS_AUTHENTICATED_FULLY').save(failOnError: true)
        }

    }
    def destroy = {
    }
}
