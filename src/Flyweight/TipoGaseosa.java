
package Flyweight;


public class TipoGaseosa {
    
    //Atributos compartidos por los objetos
    public String nombre;
    public int precio;
    
    public TipoGaseosa(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String mostrarDatos(int codBarras){
        //Datos generales
        String datosG ="La gaseosa es " + nombre + " su precio es " + precio + " el tamano es " +
                "el codigo de barras es " + codBarras;
        return datosG;
    }
    
}
