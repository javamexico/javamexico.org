
<%@ page import="org.javamexico.portal.contenido.Pregunta" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="bootstrap">
        <g:set var="entityName" value="${message(code: 'pregunta.label', default: 'Pregunta')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <g:javascript library="jquery"/>
    </head>
    <body>
        <div class="row-fluid">

            <div class="span3">
                <div class="well">
                    <ul class="nav nav-list">
                        <li class="nav-header">${entityName}</li>
                        <li>
                            <g:link class="list" action="list">
                                <i class="icon-list"></i>
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

                <g:if test="${flash.message}">
                    <bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
                </g:if>
                <div>
                    <g:if test="${preguntaInstance?.titulo}">
                        <h3><g:fieldValue bean="${preguntaInstance}" field="titulo"/></h3>
                    </g:if>
                </div>

                <div class="container-fluid well well-large">
                    <div class="row-fluid">
                        <div class="span1">
                            <p></p>
                            <div id="up">
                                <g:remoteLink method="POST" controller="voto" action="create" update="votos${preguntaInstance.id}"
                                              params="${[up:true, contenidoId:preguntaInstance.id]}"
                                              onFailure="alert('Solamente puedes emitir un voto');">+1</g:remoteLink>
                            </div>
                            <div id="votos${preguntaInstance.id}">${preguntaInstance.votos.size()}</div>
                            -1
                        </div>
                        <div class="span3">
                            <g:if test="${preguntaInstance?.usuario}">
                                <strong><g:message code="pregunta.usuario.label" default="Autor: " /></strong>
                                <g:link controller="usuario" action="show" id="${preguntaInstance.usuario.id}"><g:fieldValue bean="${preguntaInstance}" field="usuario.nombre"/></g:link>
                            </g:if>
                        </div>
                        <div class="span8">
                            <g:if test="${preguntaInstance?.status}">
                                <strong><g:message code="pregunta.status.label" default="Estado: " /></strong>
                                <g:fieldValue bean="${preguntaInstance}" field="status.etiqueta"/>
                            </g:if>
                        </div>
                        <div class="span3">
                            <g:if test="${preguntaInstance?.dateCreated}">
                                <strong><g:message code="pregunta.dateCreated.label" default="Creado: " /></strong>
                                <g:fieldValue bean="${preguntaInstance}" field="dateCreated"/>
                            </g:if>
                        </div>
                        <div class="span3">
                            <g:if test="${preguntaInstance?.lastUpdated}">
                                <strong><g:message code="pregunta.lastUpdated.label" default="Modificado: " /></strong>
                                <g:fieldValue bean="${preguntaInstance}" field="lastUpdated"/>
                            </g:if>
                        </div>
                        <div class="span5">
                            <g:if test="${preguntaInstance?.hostname}">
                                <strong><g:message code="pregunta.hostname.label" default="IP: " /></strong>
                                <g:fieldValue bean="${preguntaInstance}" field="hostname"/>
                            </g:if>
                        </div>
                        <div class="span11">
                            <g:if test="${preguntaInstance?.texto}">
                                <strong><g:message code="pregunta.texto.label" default="Pregunta: " /></strong>
                                <p>
                                    <g:fieldValue bean="${preguntaInstance}" field="texto"/>
                                </p>
                            </g:if>
                        </div>
                        <div class="">
                            <g:form>
                                <g:hiddenField name="id" value="${preguntaInstance?.id}" />
                                <div>
                                    <g:link class="btn btn-primary" action="edit" id="${preguntaInstance?.id}">
                                        <i class="icon-pencil icon-white"></i>
                                        <g:message code="default.button.edit.label" default="Edit" />
                                    </g:link>
                                    <button class="btn btn-danger" type="submit" name="_action_delete">
                                        <i class="icon-trash icon-white"></i>
                                        <g:message code="default.button.delete.label" default="Delete" />
                                    </button>
                                </div>
                            </g:form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
