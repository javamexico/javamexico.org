<%@ page import="org.javamexico.portal.contenido.Pregunta" %>



<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'dateDeleted', 'error')} ">
    <label for="dateDeleted">
        <g:message code="pregunta.dateDeleted.label" default="Date Deleted" />
        
    </label>
    
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'comentarios', 'error')} ">
    <label for="comentarios">
        <g:message code="pregunta.comentarios.label" default="Comentarios" />
        
    </label>
    
<ul class="one-to-many">
<g:each in="${preguntaInstance?.comentarios?}" var="c">
    <li><g:link controller="comentario" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="comentario" action="create" params="['pregunta.id': preguntaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'comentario.label', default: 'Comentario')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'hostname', 'error')} ">
    <label for="hostname">
        <g:message code="pregunta.hostname.label" default="Hostname" />
        
    </label>
    <g:textField name="hostname" value="${preguntaInstance?.hostname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'status', 'error')} required">
    <label for="status">
        <g:message code="pregunta.status.label" default="Status" />
        <span class="required-indicator">*</span>
    </label>
    <g:field name="status" type="number" value="${preguntaInstance.status}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'tags', 'error')} ">
    <label for="tags">
        <g:message code="pregunta.tags.label" default="Tags" />
        
    </label>
    <g:select name="tags" from="${org.javamexico.portal.tags.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${preguntaInstance?.tags*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'texto', 'error')} ">
    <label for="texto">
        <g:message code="pregunta.texto.label" default="Texto" />
        
    </label>
    <g:textField name="texto" value="${preguntaInstance?.texto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'titulo', 'error')} ">
    <label for="titulo">
        <g:message code="pregunta.titulo.label" default="Titulo" />
        
    </label>
    <g:textField name="titulo" value="${preguntaInstance?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'usuario', 'error')} required">
    <label for="usuario">
        <g:message code="pregunta.usuario.label" default="Usuario" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="usuario" name="usuario.id" from="${org.javamexico.portal.usuarios.Usuario.list()}" optionKey="id" required="" value="${preguntaInstance?.usuario?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: preguntaInstance, field: 'votos', 'error')} ">
    <label for="votos">
        <g:message code="pregunta.votos.label" default="Votos" />
        
    </label>
    <g:select name="votos" from="${org.javamexico.portal.contenido.Voto.list()}" multiple="multiple" optionKey="id" size="5" value="${preguntaInstance?.votos*.id}" class="many-to-many"/>
</div>

