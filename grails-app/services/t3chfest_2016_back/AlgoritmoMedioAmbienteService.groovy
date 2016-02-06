package t3chfest_2016_back

import grails.transaction.Transactional

@Transactional
class AlgoritmoMedioAmbienteService {

    void calculaNotas(){
        
        def historicoList = HistoricoPorBarrio.findAll()
        
        historicoList.each{
            it.medioAmbiente = calculo(it)
            if (!it.save()) {
                it.errors.each {
                    println it
                }
            }
        }
    }
    

    Float calculo(HistoricoPorBarrio historico) {
        
        Float nota = 0.0
        
        
        return nota
    }
}
