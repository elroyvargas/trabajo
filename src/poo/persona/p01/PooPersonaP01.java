package poo.persona.p01;

import entidad.Persona;
import implementacion.*;
import java.util.*;

public class PooPersonaP01 {
    
    public void ejemplo(){
    String dia1="Lunes";    
    String dia2="Martes";    
    String dia3="Miercoles";    
    String dia4="J";    
    String dia5="V";    
    String dia6="S";    
    String dia7="D";    
    System.out.print(dia1);
    System.out.print(dia2);
    System.out.print(dia3);
    System.out.print(dia4);
    System.out.print(dia5);
    System.out.print(dia6);
    System.out.print(dia7);
    
    String saludo;
    int numero;
    List<String> listaDias= new ArrayList<>();
    listaDias.add(dia7);
    listaDias.add("Lunes");
    listaDias.add("Martes");
    listaDias.add("Miercoles");
    listaDias.add("Jueves");
    listaDias.add("Viernes");
    listaDias.add("Sabado");
    
    System.out.println("arrayyyyyyyyy");
    for(String deeee : listaDias){
            System.out.print(deeee);
    }
    
    

    }

    public static void main(String[] args) throws Exception {
        
        ImplPersona ip = new ImplPersona();
        Persona p1= new Persona();
        int opt=0;
        Scanner input = new Scanner(System.in);
        do{   
            System.out.println("***** CRUD PERSONA *****");
            System.out.println("1 Listar ");
            System.out.println("2 Nuevo ");
            System.out.println("3 Eliminar ");
            System.out.println("0 Salir ");
            System.out.println("Seleccionar: ");
            opt = input.nextInt();
            System.out.println("Tu seleccionaste: " + opt);
            input.nextLine(); // Limpiar el buffer  
            switch (opt) {
                case 1:
                    System.out.println("****** 1 Listar *****");
                    List<Persona> lis = ip.list();
                    System.out.println("ID \t Nombre \t Sexo");
                    for (Persona d : lis) {
                        System.out.println(d.getId() + "\t" + d.getNombres()+ "\t" + d.getSexo());
                    }
                break;
                
                case 2:
                    System.out.println("**** 2 Nuevo ****");
                    Persona d = new Persona();
                    System.out.print("Ingrese Nombre: ");
                    d.setNombres(input.nextLine());
                    System.out.print("Ingrese Sexo: ");
                    d.setSexo(input.nextLine());
                    ip.create(d);
                    
                break;   
                                        
                    
            }
        }while(opt!=0);
        
      /*  
        p1.setNombres("Eder");
        p1.setAp_paterno("Gutierrez");
        p1.setAp_materno("Quispe");
        p1.setSexo("M");        
        Persona p2= new Persona();
        p2.setNombres("Juan");
        p2.setAp_paterno("Perez");
        p2.setAp_materno("Quiroz");
        p2.setSexo("M");
                   
        System.out.println("antes de eliminar");
        ip.create(p1);
        ip.create(p2);        
        
        for(Persona p :ip.list()){
            System.out.println(p.getId()+"  "+p.getNombres());            
        }
        
        ip.delete(2);
        System.out.println("despues  de eliminar");
        for(Persona p :ip.list()){
            System.out.println(p.getId());
            System.out.println(p.getNombres());
            System.out.println(p.getAp_paterno());
            System.out.println(p.getAp_materno());
            System.out.println(p.getSexo());
        }
     */   
    }    
    
}
