package t3chfest_2016_back

class HistoricoPorBarrio {
    
    Long id
    Integer mes
    Integer year
    Barrio barrio
    Integer poblacion

    static constraints = {
        poblacion nullable:true
    }
}
