
<%@ page import="org.javamexico.portal.contenido.Pregunta" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="bootstrap">
        <g:set var="entityName" value="${message(code: 'pregunta.label', default: 'Pregunta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <g:javascript library="jquery"/>
    </head>
    <body>
        <div class="row-fluid">
            
            <div class="span3">
                <div class="well">
                    <ul class="nav nav-list">
                        <li class="nav-header">${entityName}</li>
                        <li class="active">
                            <g:link class="list" action="list">
                                <i class="icon-list icon-white"></i>
                                <g:message code="default.list.label" args="[entityName]" />
                            </g:link>
                        </li>
                        <li>
                            <g:link class="create" action="create">
                                <i class="icon-plus"></i>
                                <g:message code="default.create.label" args="[entityName]" />
                            </g:link>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="span9">
                
                <div class="page-header">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                </div>

                <g:if test="${flash.message}">
                    <bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
                </g:if>

                <g:each in="${preguntaInstanceList}" var="preguntaInstance">
                    <table class="table">
                        <tr>
                            <td rowspan="3">
                                <div id="up">
                                    <g:remoteLink method="POST" controller="voto" action="create" update="votos${preguntaInstance.id}"
                                                  params="${[up:true, contenidoId:preguntaInstance.id]}"
                                                  onFailure="alert('Solamente puedes emitir un voto');">+1</g:remoteLink>
                                </div>
                                <div id="votos${preguntaInstance.id}">${preguntaInstance.votos.size()}</div>
                                -1
                            </td>
                            <td colspan="6"><g:link action="show" id="${preguntaInstance.id}"><h3>${preguntaInstance.titulo}</h3></g:link></td>
                        </tr>
                        <tr>

                            <td>
                                Autor: <g:link action="show" controller="usuario"
                                               id="${preguntaInstance.usuario.id}">
                                ${preguntaInstance.usuario.nombre}</g:link>
                            </td>
                            <td>Publicado: ${preguntaInstance.dateCreated}</td>
                            <td>IP: ${preguntaInstance.hostname}</td>
                            <td>
                                &Uacute;ltima modificaci&oacute;n:
                                ${preguntaInstance.lastUpdated}
                            </td>
                            <td>Estado: ${preguntaInstance.status.etiqueta}</td>
                        </tr>
                        <tr>
                            <td colspan="6">${preguntaInstance.texto}</td>
                        </tr>
                    </table>
                </g:each>
                <div class="pagination">
                    <bootstrap:paginate total="${preguntaInstanceTotal}" />
                </div>
            </div>

        </div>
    </body>
</html>
