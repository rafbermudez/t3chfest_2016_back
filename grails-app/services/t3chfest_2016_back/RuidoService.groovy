package t3chfest_2016_back

import grails.transaction.Transactional
import org.grails.plugins.csv.CSVMapReader

@Transactional
class RuidoService {

def cargaRuido() {

        File defaultDir = new File("data")
        String fileName = "ruido.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def estacion = Estacion.findByCodigo(csvLineMap.NMT)
   
            estacion.las01 = csvLineMap.las01.replaceAll(',','.').toFloat()
            estacion.las10 = csvLineMap.las10.replaceAll(',','.').toFloat()
            estacion.las50 = csvLineMap.las50.replaceAll(',','.').toFloat()
            estacion.las90 = csvLineMap.las90.replaceAll(',','.').toFloat()
            estacion.las99 = csvLineMap.las99.replaceAll(',','.').toFloat()
                
            if (!estacion.save()) {
                estacion.errors.each {
                    
                    println it
                    
                }
            }
        }
        
    }
}
