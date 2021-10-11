package implementacion;
import java.util.*;

import entidad.Persona;

public class ImplPersona {
    
    //List<String> listaDias= new ArrayList<>();
    List<Persona> lis= new ArrayList<>();
    int id=0;    
    
    public void create(Persona p){
        id=id+1;
        p.setId(id);
        lis.add(p);
    }
    
    public List<Persona> list(){  //read
        return lis;
    }
    
    public void delete(int id) throws Exception{
        /*
        for(Persona ps : lis){
            if(id==ps.getId()){
               System.out.print("Eliminando"+ps.getNombres());
               lis.remove(ps);
               
            }
        }
        */            
        
        Iterator<Persona> itr = lis.iterator();            
        while(itr.hasNext()){
            Persona pers = itr.next();
            if(pers.getId()==(id)){
                System.out.println("Eliminando a: "+pers.getNombres());
                itr.remove();                    
            }
        }
            
            
    }
    
    
    
 /*   public String saludo(){
        return "Hola";
    }
    
    public int numero(){
        return 5;
    }
    
    public void despedida(){
        
    }
 */ 
}
