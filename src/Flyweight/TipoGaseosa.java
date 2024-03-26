
package Flyweight;


public abstract class TipoGaseosa {
    
    //Atributos compartidos por los objetos
    public String nombre;
    public int precio;
    public String tamano;
    
    public TipoGaseosa(String nombre, int precio, String tamano){
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;        
    }
    
    public abstract String mostrarDatos();
    
}
