import t3chfest_2016_back.*

class BootStrap {
    
    def barrioService
    def poblacionService
    def actuacionPolicialService
    def algoritmoSeguridadService
    def algoritmoMedioAmbienteService
    def algoritmoEconomiaService

    def init = { servletContext ->
        
        //Creación de los barrios
        barrioService.leerBarrios()
        
        //Creación de Histórico por barrio
        barrioService.generarHistoricoPorAno(2015)
        
        //Carga de datos por histórico
        poblacionService.leerPoblacionPorMes()
        actuacionPolicialService.leerActuacion()

        //Cálculo de agregados
        algoritmoSeguridadService.calculaNotas()
        algoritmoMedioAmbienteService.calculaNotas()
        algoritmoEconomiaService.calculaNotas()
        
    }
    def destroy = {
    }
}
