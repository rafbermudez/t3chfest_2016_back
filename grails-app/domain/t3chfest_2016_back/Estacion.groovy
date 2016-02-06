package t3chfest_2016_back

class Estacion {

    Integer codigo
    String nombre
    Barrio barrio
    
        
    //ruido
    Float las01	
    Float las10	
    Float las50	
    Float las90	
    Float las99
    
    static constraints = {
        
        las01 nullable:true
        las10 nullable:true
        las50	 nullable:true
        las90	 nullable:true
        las99 nullable:true
    }
}
