
<%@ page import="org.javamexico.portal.contenido.Pregunta" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="bootstrap">
        <g:set var="entityName" value="${message(code: 'pregunta.label', default: 'Pregunta')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
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

                <div class="page-header">
                    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
                </div>

                <g:if test="${flash.message}">
                <bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
                </g:if>

                <dl>
                
                    <g:if test="${preguntaInstance?.dateDeleted}">
                        <dt><g:message code="pregunta.dateDeleted.label" default="Date Deleted" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="dateDeleted"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.comentarios}">
                        <dt><g:message code="pregunta.comentarios.label" default="Comentarios" /></dt>
                        
                            <g:each in="${preguntaInstance.comentarios}" var="c">
                            <dd><g:link controller="comentario" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></dd>
                            </g:each>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.dateCreated}">
                        <dt><g:message code="pregunta.dateCreated.label" default="Date Created" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="dateCreated"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.hostname}">
                        <dt><g:message code="pregunta.hostname.label" default="Hostname" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="hostname"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.lastUpdated}">
                        <dt><g:message code="pregunta.lastUpdated.label" default="Last Updated" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="lastUpdated"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.status}">
                        <dt><g:message code="pregunta.status.label" default="Status" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="status"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.tags}">
                        <dt><g:message code="pregunta.tags.label" default="Tags" /></dt>
                        
                            <g:each in="${preguntaInstance.tags}" var="t">
                            <dd><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></dd>
                            </g:each>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.texto}">
                        <dt><g:message code="pregunta.texto.label" default="Texto" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="texto"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.titulo}">
                        <dt><g:message code="pregunta.titulo.label" default="Titulo" /></dt>
                        
                            <dd><g:fieldValue bean="${preguntaInstance}" field="titulo"/></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.usuario}">
                        <dt><g:message code="pregunta.usuario.label" default="Usuario" /></dt>
                        
                            <dd><g:link controller="usuario" action="show" id="${preguntaInstance?.usuario?.id}">${preguntaInstance?.usuario?.encodeAsHTML()}</g:link></dd>
                        
                    </g:if>
                
                    <g:if test="${preguntaInstance?.votos}">
                        <dt><g:message code="pregunta.votos.label" default="Votos" /></dt>
                        
                            <g:each in="${preguntaInstance.votos}" var="v">
                            <dd><g:link controller="voto" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></dd>
                            </g:each>
                        
                    </g:if>
                
                </dl>

                <g:form>
                    <g:hiddenField name="id" value="${preguntaInstance?.id}" />
                    <div class="form-actions">
                        <g:link class="btn" action="edit" id="${preguntaInstance?.id}">
                            <i class="icon-pencil"></i>
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
    </body>
</html>
