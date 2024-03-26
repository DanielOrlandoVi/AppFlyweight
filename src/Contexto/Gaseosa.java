
package Contexto;

import Flyweight.TipoGaseosa;
public class Gaseosa extends TipoGaseosa{
    //Heredamos del flyweight para sobreescribir el metodo general mostrarDatos, es decir lo particularizamos al 
    //objeto de la clase gaseosa
    private String codBarras;
    //Este atributo de TipoGaseosa hace la conexion entre el Flyweight y nuestro contexto unico, en este caso la 
    //gaseosa unica que puede ser de cierto tipo(manzana de 100ml y que cueste 1$) pero que se diferencia por su codBarras
    private TipoGaseosa tipo;

    public Gaseosa(String nombre, int precio, String tamano, String codBarras, TipoGaseosa tipo){
        super(nombre, precio, tamano);
        this.codBarras = codBarras;
        this.tipo = tipo;
    }
    
    @Override
    public String mostrarDatos(){
        String datos = "La gaseosa es " + nombre + " su precio es " + precio + " el tamano es " + tamano +
                "el codigo de barras es " + codBarras;
        return datos;
    }
    
    
    
}
