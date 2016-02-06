package t3chfest_2016_back

import grails.transaction.Transactional

import org.grails.plugins.csv.CSVMapReader

@Transactional
class ActuacionPolicialService {

    def leerActuacion()
    {
        File defaultDir = new File("data")
        String fileName = "actuaciones_policiales.csv"
        
        CSVMapReader reader = new CSVMapReader(new File(defaultDir, fileName).newReader())
        
        reader.each{
            csvLineMap ->
            
            def barrio = Barrio.findByNombre(csvLineMap.DISTRITO)
            
            def historico = HistoricoPorBarrio.findByBarrioAndMesAndYear(barrio,csvLineMap.MES,csvLineMap.YEAR)

            historico.actuacionesContraPersonas = csvLineMap.PERSONAS.toInteger()
            historico.actuacionesPatrimonio = csvLineMap.PATRIMONIO.toInteger()
            historico.tenenciaArmas = csvLineMap.ARMAS.toInteger()
            historico.tenenciaDrogas = csvLineMap.TENENCIA_DROGAS.toInteger()
            historico.consumoDrogas = csvLineMap.CONSUMO_DROGAS.toInteger()
            historico.detenidos = csvLineMap.DETENIDOS.toInteger()
            historico.accidentesConHeridos = csvLineMap.ACCIDENTES_CON_HERIDOS.toInteger()
            historico.accidentesSinHeridos = csvLineMap.ACCIDENTES_SIN_HERIDOS.toInteger()
            historico.ventaPropIntelectual = csvLineMap.VENTA_AMBULANTE_PROP_INTELECTUAL.toInteger()
            historico.ventaAlimentos = csvLineMap.VENTA_AMBULANTE_ALIMENTOS.toInteger()
            historico.alcoholAdultos = csvLineMap.VIA_PUBLICA_ALCOHOL_ADULTOS.toInteger()
            historico.alcoholMenores = csvLineMap.VIA_PUBLICA_ALCOHOL_MENORES.toInteger()
            historico.actuacionesEnLocales = csvLineMap.LOCALES_ACTUACIONES.toInteger()
            historico.denunciasSobreLocales = csvLineMap.LOCALES_DENUNCIAS.toInteger()

            if (!historico.save()) {
                historico.errors.each {
                    println it
                }
            }

        }
    }
}
