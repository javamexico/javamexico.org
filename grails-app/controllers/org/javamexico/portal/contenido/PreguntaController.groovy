package org.javamexico.portal.contenido

import org.javamexico.portal.usuarios.Usuario
import org.springframework.dao.DataIntegrityViolationException

class PreguntaController {

    def springSecurityService

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [preguntaInstanceList: Pregunta.list(params), preguntaInstanceTotal: Pregunta.count()]
    }

    def create() {
        log.debug("Nueva pregunta con titulo: " + params['titulo'])
        switch (request.method) {
        case 'GET':
            [preguntaInstance: new Pregunta(params)]
            break
        case 'POST':
            def preguntaInstance = new Pregunta(params)
                preguntaInstance.hostname = request.getRemoteAddr()
                preguntaInstance.status = EstatusContenidoEnum.PUBLICADO
                preguntaInstance.usuario = Usuario.get(1)
            if (!preguntaInstance.save(flush: true)) {
                render view: 'create', model: [preguntaInstance: preguntaInstance]
                return
            }

            flash.message = message(code: 'default.created.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), preguntaInstance.id])
            redirect action: 'show', id: preguntaInstance.id
            break
        }
    }

    def show() {
        def preguntaInstance = Pregunta.get(params.id)
        if (!preguntaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
            redirect action: 'list'
            return
        }

        [preguntaInstance: preguntaInstance]
    }

    def edit() {
        switch (request.method) {
        case 'GET':
            def preguntaInstance = Pregunta.get(params.id)
            if (!preguntaInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
                redirect action: 'list'
                return
            }

            [preguntaInstance: preguntaInstance]
            break
        case 'POST':
            def preguntaInstance = Pregunta.get(params.id)
            if (!preguntaInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
                redirect action: 'list'
                return
            }

            if (params.version) {
                def version = params.version.toLong()
                if (preguntaInstance.version > version) {
                    preguntaInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
                              [message(code: 'pregunta.label', default: 'Pregunta')] as Object[],
                              "Another user has updated this Pregunta while you were editing")
                    render view: 'edit', model: [preguntaInstance: preguntaInstance]
                    return
                }
            }

            preguntaInstance.properties = params

            if (!preguntaInstance.save(flush: true)) {
                render view: 'edit', model: [preguntaInstance: preguntaInstance]
                return
            }

            flash.message = message(code: 'default.updated.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), preguntaInstance.id])
            redirect action: 'show', id: preguntaInstance.id
            break
        }
    }

    def delete() {
        def preguntaInstance = Pregunta.get(params.id)
        if (!preguntaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
            redirect action: 'list'
            return
        }

        try {
            preguntaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pregunta.label', default: 'Pregunta'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
