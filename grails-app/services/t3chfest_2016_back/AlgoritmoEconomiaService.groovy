package t3chfest_2016_back

import grails.transaction.Transactional

@Transactional
class AlgoritmoEconomiaService {

    void calculaNotas(){
        
        def historicoList = HistoricoPorBarrio.findAll()
        
        historicoList.each{
            it.economia = calculo(it)
            if (!it.save()) {
                it.errors.each {
                    println it
                }
            }
        }
    }
    

    Float calculo(HistoricoPorBarrio historico) {
        
        Float nota = 0.0
        
        Float notaCompra = (6500 - historico.compraM2) * 10 / 6500
        
        nota = notaCompra
        
        return nota
    }
}
