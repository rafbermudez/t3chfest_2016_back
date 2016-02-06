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
        Float maquinaria = 70.0
        Float dia = 55.0
        Float noche = 45.0
        
        Float points = 0.0
        
        if(historico.las01<maquinaria)
        points++
        if(historico.las01<dia)
        points++
        if(historico.las01<noche)
        points++
        
        if(historico.las10<maquinaria)
        points++
        if(historico.las10<dia)
        points++
        if(historico.las10<noche)
        points++
        
        if(historico.las50<maquinaria)
        points++
        if(historico.las50<dia)
        points++
        if(historico.las50<noche)
        points++
        
        if(historico.las90<maquinaria)
        points++
        if(historico.las90<dia)
        points++
        if(historico.las90<noche)
        points++
        
        if(historico.las99<maquinaria)
        points++
        if(historico.las99<dia)
        points++
        if(historico.las99<noche)
        points++
        
        nota = points/1.5
        
        return nota
    }
}
