package t3chfest_2016_back

class HistoricoPorBarrio {
    
    Long id
    Integer mes
    Integer year
    Barrio barrio
    Integer poblacion
    
    //Actuaciones policiales
    Integer actuacionesContraPersonas
    Integer actuacionesPatrimonio
    Integer tenenciaArmas
    Integer tenenciaDrogas
    Integer consumoDrogas
    Integer detenidos
    Integer accidentesConHeridos
    Integer accidentesSinHeridos
    Integer ventaPropIntelectual
    Integer ventaAlimentos
    Integer alcoholAdultos
    Integer alcoholMenores
    Integer actuacionesEnLocales
    Integer denunciasSobreLocales
    
    //Notas agregadas
    Float seguridad
    Float medioAmbiente
    Float economia

    static constraints = {
        poblacion nullable:true
        
        actuacionesContraPersonas nullable:true
        actuacionesPatrimonio nullable:true
        tenenciaArmas nullable:true
        tenenciaDrogas nullable:true
        consumoDrogas nullable:true
        detenidos nullable:true
        accidentesConHeridos nullable:true
        accidentesSinHeridos nullable:true
        ventaPropIntelectual nullable:true
        ventaAlimentos nullable:true
        alcoholAdultos nullable:true
        alcoholMenores nullable:true
        actuacionesEnLocales nullable:true
        denunciasSobreLocales nullable:true
        
        seguridad nullable:true
        medioAmbiente nullable:true
        economia nullable:true
    }
}
