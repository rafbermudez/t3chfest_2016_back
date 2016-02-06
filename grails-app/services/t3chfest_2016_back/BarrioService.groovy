package t3chfest_2016_back

import grails.transaction.Transactional

import org.grails.plugins.csv.CSVMapReader

@Transactional
class BarrioService {

    def leerBarrios()
    {
        File defaultDir = new File("data")
        String fileName = "barrios.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def barrio = new Barrio(nombre: csvLineMap.BARRIO)
            
            if (!barrio.save()) {
                barrio.errors.each {
                    println it
                }
            }

        }
    }
    
    def generarHistoricoPorAno(def year)
    {
        [12].each{
            mes ->
            Barrio.list().each{
         
                barrio->
                def historico = [
                    mes: mes,
                    year:year,
                    barrio:barrio
                ] as HistoricoPorBarrio
                
                if (!historico.save()) {
                    historico.errors.each {
                        println it
                    }
                }
                
            }
        }        
    }
}
