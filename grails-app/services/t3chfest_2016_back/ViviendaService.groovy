package t3chfest_2016_back

import grails.transaction.Transactional

import org.grails.plugins.csv.CSVMapReader

@Transactional
class ViviendaService {

    def leerDatosVivienda()
    {
        File defaultDir = new File("data")
        String fileName = "vivienda.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def barrio = Barrio.findByNombre(csvLineMap.DISTRITO)

            def historico = HistoricoPorBarrio.findByBarrioAndMesAndYear(barrio,csvLineMap.MES,csvLineMap.YEAR)

            historico.compraM2 = csvLineMap.COMPRA_M2.toFloat()
            historico.alquilerM2 = csvLineMap.ALQUILER_M2.toFloat()
            
            if (!historico.save()) {
                historico.errors.each {
                    println it
                }
            }

        }
    }
}
