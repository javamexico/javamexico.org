import groovy.sql.Sql

class BootStrap {

    def grailsApplication
    def dataSource

    def init = { servletContext ->

        loadSqlData("catalogos")

    }
    def destroy = {
    }

    def loadSqlData(archivo) {

        try {
            def is = grailsApplication.mainContext.getResource("classpath:sql/${archivo}.sql").inputStream
            println is
            def db = new Sql(dataSource)
            println db
            println "::::::::: Carga ${archivo}... 0% :::::::::"
            is.eachLine { line ->
                // Descomentar  println si no carga al 100% para ver donde truena
                //println line
                db.executeUpdate(line)
            }
            println "::::::::: Carga ${archivo}... 100% :::::::::"
        } catch (ex) {
            println "ocurrio algun error"
            ex.printStackTrace()
        }
    }
}
