package t3chfest_2016_back

import grails.converters.JSON

class BarrioController {

    def BarrioList(){
        def barrios = Barrio.findAll()
        
        render barrios as JSON
    }
    
    def BarrioInfo(Long barrioId, Integer mes, Integer year){
        
        def barrio = Barrio.findById(barrioId)
        
        def c = HistoricoPorBarrio.createCriteria()
        def result = c.get {
            eq("barrio", barrio)
            eq("mes", mes)
            eq("year", year)
        }
        
        render info as JSON
    }
}
