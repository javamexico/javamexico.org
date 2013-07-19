<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap"/>
        <title><g:message code="app.name"/>></title>
	</head>
	<body>
        <div class="row-fluid">
            <aside id="application-status" class="span3">
                <div class="well sidebar-nav">
                    <h5>javaMéxico 2.0</h5>
                    <ul>
                        <li>App version: <g:meta name="app.version"/></li>
                        <li>Grails version: <g:meta name="app.grails.version"/></li>
                        <li>Groovy version: ${GroovySystem.getVersion()}</li>
                        <li>JVM version: ${System.getProperty('java.version')}</li>
                        <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                        <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                        <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                        <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
                    </ul>
                    <h5>Installed Plugins</h5>
                    <ul>
                        <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                            <li>${plugin.name} - ${plugin.version}</li>
                        </g:each>
                    </ul>
                </div>
            </aside>

            <section id="main" class="span9">

                <div class="hero-unit">
                    <h1>javaMéxico 2.0</h1>

                    <p></p>
                    <p>Bienvenido a javaMéxico 2.0, el nuevo portal de La Comunidad Java de México.</p>
                </div>

                <div>
                    <!--TODO Contenido...--> Contenido aquí...
                </div>

            </section>
        </div>
	</body>
</html>
