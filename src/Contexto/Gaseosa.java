
package Contexto;

import Flyweight.TipoGaseosa;
import javax.swing.JOptionPane;
public class Gaseosa{

    private int codBarras;
    //Este atributo de TipoGaseosa hace la conexion entre el Flyweight y nuestro contexto unico, en este caso la 
    //gaseosa unica que puede ser de cierto tipo(manzana de 100ml y que cueste 1$) pero que se diferencia por su codBarras
    private TipoGaseosa tipo;

    public Gaseosa(int codBarras, TipoGaseosa tipo){
        this.codBarras = codBarras;
        this.tipo = tipo;
    }
    
    //Particularizamos el metodo mostrarDatos con el codBarras unico
    
    public String mostrarDatos(){
    //Utilizamos el metodo mostrarDatos de la referencia TipoGaseosa para obtener los datos generales     
        String datosP = tipo.mostrarDatos(codBarras); //Datos particulares
        return datosP;
    }
    
    
    
}
