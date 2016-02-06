package t3chfest_2016_back

import grails.transaction.Transactional

import org.grails.plugins.csv.CSVMapReader

@Transactional
class PoblacionService {

    def leerPoblacionPorMes()
    {
        File defaultDir = new File("data")
        String fileName = "ene15.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def barrio = Barrio.findByNombre(csvLineMap.Distrito)
            

            
            def historico = HistoricoPorBarrio.findByBarrioAndMesAndYear(barrio,csvLineMap.Mes,csvLineMap.Ano)

            historico.poblacion = csvLineMap.Total.toInteger()
            
            if (!historico.save()) {
                historico.errors.each {
                    println it
                }
            }

        }
    }

}
