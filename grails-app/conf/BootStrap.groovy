import t3chfest_2016_back.*

class BootStrap {
    
    def barrioService
    def poblacionService
    def actuacionPolicialService
    def estacionService

    def init = { servletContext ->
        
        //Creación de los barrios
        barrioService.leerBarrios()
        
        //Creación de Histórico por barrio
        barrioService.generarHistoricoPorAno(2015)
        
        //Creación de Estaciones
        estacionService.cargaEstaciones()
        
        //Carga de datos por histórico
        poblacionService.leerPoblacionPorMes()
        actuacionPolicialService.leerActuacion()

        
        
        //Carga de datos
        
    }
    def destroy = {
    }
}
