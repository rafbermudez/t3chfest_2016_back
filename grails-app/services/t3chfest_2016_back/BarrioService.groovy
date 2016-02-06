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
        [1,2,3,4,5,6,7,8,9,10,11,12].each{
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
    
    def obtenerDatosDeEstaciones(){
        Barrio.list().each{
            barrio ->
            
            def estaciones = Estacion.findAllByBarrio(barrio)
            
            if(estaciones)
            {
                def las01 = (estaciones.collect{it -> it.las01}.sum() / estaciones.size())
                def las10 = (estaciones.collect{it -> it.las10}.sum() / estaciones.size())
                def las50 = (estaciones.collect{it -> it.las50}.sum() / estaciones.size())
                def las90 = (estaciones.collect{it -> it.las90}.sum() / estaciones.size())
                def las99 = (estaciones.collect{it -> it.las99}.sum() / estaciones.size())
                
                def historicos = HistoricoPorBarrio.findAllByBarrio(barrio)
                
                historicos.each{
                    historico->
                    historico.las01 = las01
                    historico.las10 = las10
                    historico.las50 = las50
                    historico.las90 = las90
                    historico.las99 = las99
                    
                    if (!historico.save()) {
                        historico.errors.each {
                            println it
                        }
                    }
                
                }
            }
            else
            {
                def historicos = HistoricoPorBarrio.findAllByBarrio(barrio)
                
                historicos.each{
                    historico->
                    historico.las01 = 0
                    historico.las10 = 0
                    historico.las50 = 0
                    historico.las90 = 0
                    historico.las99 = 0
                    
                    if (!historico.save()) {
                        historico.errors.each {
                            println it
                        }
                    }
                
                }
            }
            
        }
    }
}
