package t3chfest_2016_back

import grails.transaction.Transactional
import org.grails.plugins.csv.CSVMapReader

@Transactional
class EstacionService {

    def cargaEstaciones() {

        File defaultDir = new File("data")
        String fileName = "estaciones_ruido.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def barrio = Barrio.findByNombre(csvLineMap.Barrio)

            def estacion = [
                codigo: csvLineMap.Numero,
                nombre:csvLineMap.Nombre,
                barrio:barrio
            ] as Estacion
                
            if (!estacion.save()) {
                estacion.errors.each {
                    println it
                }
            }
        }
        
    }
}
