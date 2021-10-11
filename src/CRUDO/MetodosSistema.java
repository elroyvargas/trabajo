/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDO;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author USUARIO
 */
public class MetodosSistema {
    public Vector lista= new Vector();
    
    
    public void RegistrarPersona(Object x){
    lista.add(x);
    
}
    public ArrayList<DatosPersona> listarPersona(){
        
         ArrayList<DatosPersona> datos= new ArrayList<>();
          Vector nuevoVector = lista;
             for(int i =0; i<nuevoVector.size();i++){
                      DatosPersona v = (DatosPersona)lista.get(i);
                      datos.add(v);
                      
         }
             return datos;
    }
}
