import t3chfest_2016_back.*

class BootStrap {
    
    def barrioService
    def poblacionService

    def init = { servletContext ->
        
        //Creación de los barrios
        
//        def b = new Barrio(nombre:"CENTRO")
//        b.save()
        
        barrioService.leerBarrios()
        barrioService.generarHistoricoPorAno(2015)

        //Creación de Histórico por barrio
        
        //Carga de datos
        
    }
    def destroy = {
    }
}
