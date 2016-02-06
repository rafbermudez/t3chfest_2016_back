package t3chfest_2016_back

import grails.transaction.Transactional

@Transactional
class AlgoritmoSeguridadService {
    
    void calculaNotas(){
        
        def historicoList = HistoricoPorBarrio.findAll()
        
        historicoList.each{
            it.seguridad = calculo(it)
            if (!it.save()) {
                it.errors.each {
                    println it
                }
            }
        }
    }
    

    Float calculo(HistoricoPorBarrio h) {
        
        Float nota = 0.0
        
        Integer suma= 0
        
        //MUY GRAVES
        suma += h.tenenciaArmas
        suma += 100 * h.tenenciaDrogas
        suma += 100 * h.accidentesConHeridos
        suma += 100 * h.actuacionesEnLocales
        
        //GRAVES
        suma += 10 * h.actuacionesContraPersonas
        suma += 10 * h.consumoDrogas
        suma += 10 * h.detenidos
        suma += 10* h.accidentesSinHeridos
        suma += 10 * h.alcoholAdultos
        suma += 10 * h.alcoholMenores
        suma += 10 * h.denunciasSobreLocales
        
        //MENORES
        suma += h.actuacionesPatrimonio
        suma += h.ventaPropIntelectual
        suma += h.ventaAlimentos

        if (suma){
            Float sumaPonderada = suma.toFloat()/h.poblacion
            nota = (1 - sumaPonderada) * (1 - sumaPonderada) * (1 - sumaPonderada) * 10  
        }    
        
        
        return nota
    }
}
