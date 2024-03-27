
package FabricaFlyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import Flyweight.TipoGaseosa;
import javax.swing.JOptionPane;


public class FabricaTipoGaseosa {
    //Con esta clase buscamos crear unicamente los objetos necesarios
    //Si un objeto de TipoGaseosa no esta, que se cree y se almacene en el HashMap
    //Si resulta que si esta en el HashMap, unicamente que se devuelva la referencia y que no se cree nada mas
    //Asi ahorramos memoria referenciando a un unico objeto y no creando varios
    
    //Guardamos los tipos de gaseosa que tengamos en un HashMap
    public static Map<String, TipoGaseosa> TiposGaseosa = new HashMap();

    public static TipoGaseosa getGaseosa(String nombre, int precio) {
        TipoGaseosa resultado = (TipoGaseosa)TiposGaseosa.get(nombre);
        if (resultado == null) {
            //Si no se encuentra el tipo de gaseosa en el hashmap, que cree uno nuevo
            resultado = new TipoGaseosa(nombre, precio);
            //Esa nueva instancia se agrega al hashmap
            TiposGaseosa.put(nombre, resultado);
            JOptionPane.showMessageDialog(null, "Creando gaseosa: " + nombre);
            //JOptionPane.showMessageDialog(null, "Creando gaseosa: " + nombre);
        }
        //En caso de que si este el tipo de gaseosa en el hashmap, que solo lo devuelva y no cree nuevas instancias
        return resultado;
    }
    
}
