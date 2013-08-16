package org.javamexico.portal.contenido

import grails.test.mixin.Mock
import org.javamexico.portal.tags.Tag
import org.javamexico.portal.usuarios.Usuario
import org.joda.time.LocalDate
import spock.lang.Specification

/**
 * Author: Benek
 * Date: 02/05/13
 * Time: 21:11
 * www.javamexico.org
 */
@Mock([Usuario, BlogPost])
class BlogPostSpec extends Specification {

    Usuario oscar
    Usuario enrique
    Usuario benek

    def setup(){
        //Se inyecta metodo de SpringSecurity a la metaclase
        Usuario.metaClass.encodePassword = { -> }
        oscar = new Usuario(
                username: 'OscarRyz',
                password: 'oscarin',
                enabled: true,
                nombre: 'Oscar Reyes',
                correo: 'oscar@javamexico.org',
                fechaNacimiento: new LocalDate(1980, 10, 11),
                ubicacion: 'Austin, TX.',
                sitioWeb: 'www.javamexico.org/blogs/OscarRyz',
                bio: 'Me gusta programar'
        ).save(failOnError: true)
        enrique = new Usuario(
                username: 'ezamudio',
                password: 'enriquin',
                enabled: true,
                nombre: 'Enrique Zamudio',
                correo: 'chochos@javamexico.org',
                fechaNacimiento: new LocalDate(1977, 2, 10),
                ubicacion: 'Mexico DF',
                sitioWeb: 'www.javamexico.org/blogs/ezamudio',
                bio: 'Chelero, bajista, Ceylon dev.'
        ).save(failOnError: true)
        benek = new Usuario(
                username: 'benek',
                password: 'benekin',
                enabled: true,
                nombre: 'Javier Ramirez',
                correo: 'xbenek@java.net',
                fechaNacimiento: new LocalDate(1984, 3, 20),
                ubicacion: 'Queretaro',
                sitioWeb: 'www.javamexico.org/blogs/benek',
                bio: 'Algo chistoso aqui...'
        ).save(failOnError: true)
    }

    def "Usuario crea un post en su blog"(){
        given: "Dado un usuario y tres tags"
            Tag t1 = new Tag(nombre: 'java')
            Tag t2 = new Tag(nombre: 'groovy')
            Tag t3 = new Tag(nombre: 'grails')
        when: "es creado un post en el blog del usuario"
            new BlogPost(
                    titulo: 'Primer post de prueba en mi blog',
                    texto: 'Esta es una prueba de un post en mi blog... <b>hola</b>',
                    hostname: '8.8.8.8',
                    status: EstatusContenidoEnum.PUBLICADO,
                    usuario: benek,
                    tags: [t1, t2, t3],

            ).save(failOnError: true)
        then: "el post debe encontrarse en la BD con los datos ingresados"
            BlogPost post = BlogPost.findByUsuario(benek);
            with(post){
                post.usuario.username == 'benek'
                post.titulo == 'Primer post de prueba en mi blog'
                post.hostname == '8.8.8.8'
            }
    }

    def "Se solicitan los posts del blog de un usuario"(){
        given: "Dados 10 posts de los cuales 4 son del usuario"
            Usuario[] lista = [benek, oscar, oscar, enrique, benek, enrique, benek, oscar, oscar, oscar]
            cantidadPosts.times {
                new BlogPost(
                        titulo: "Post $it",
                        texto: "Esta es una prueba de un post en mi blog... $it",
                        hostname: "8.8.8.$it",
                        status: EstatusContenidoEnum.PUBLICADO,
                        usuario: lista[it]
                ).save()
            }
        when: "Se solicitan los posts de ese usuario en especifico"
            def postsBenek = BlogPost.findAllByUsuario(benek)
        then: "Se obtienen los posts creados por el usuario"
            postsBenek.size() == 3
        where:
            cantidadPosts = 10
    }

    def "Se solicitan los posts totales"(){
        given: "Dados 10 posts en el blog de tres usuarios diferentes"
            Usuario[] lista = [benek, oscar, oscar, enrique, benek, enrique, benek, oscar, oscar, oscar]
            cantidadPosts.times {
                new BlogPost(
                        titulo: "Post $it",
                        texto: "Esta es una prueba de un post en mi blog... $it",
                        hostname: "8.8.8.$it",
                        status: EstatusContenidoEnum.PUBLICADO,
                        usuario: lista[it]
                ).save()
            }
        when: "Se solicitan los posts totales"
            def postsTotales = BlogPost.count()
        then: "Deben obtenerse #cantidadPosts posts en total"
            postsTotales == cantidadPosts
        where:
            cantidadPosts = 10
    }

}
