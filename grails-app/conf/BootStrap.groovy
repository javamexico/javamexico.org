import org.javamexico.portal.usuarios.Usuario
import org.joda.time.LocalDate

class BootStrap {

    def init = { servletContext ->

        def springSecurityService

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
        }

    }
    def destroy = {
    }
}
