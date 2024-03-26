
package FabricaFlyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import Flyweight.TipoGaseosa;


public class FabricaTipoGaseosa {
    //Con esta clase buscamos crear unicamente los objetos necesarios
    //Si un objeto de TipoGaseosa no esta, que se cree y se almacene en el HashMap
    //Si resulta que si esta en el HashMap, unicamente que se devuelva la referencia y que no se cree nada mas
    //Asi ahorramos memoria referenciando a un unico objeto y no creando varios
    
    //Guardamos los tipos de gaseosa que tengamos en un HashMap
    static Map<String, TipoGaseosa> TiposGaseosa = new HashMap<>();

    public static TipoGaseosa getGaseosa(String nombre, int precio, String tamano) {
        TipoGaseosa resultado = TiposGaseosa.get(nombre);
        if (resultado == null) {
            resultado = new TipoGaseosa(nombre, precio, tamano) {
                @Override
                public String mostrarDatos() {
                    throw new UnsupportedOperationException("Not supported yet."); 
                }
            };
            TiposGaseosa.put(nombre, resultado);
        }
        return resultado;
    }
    
}
