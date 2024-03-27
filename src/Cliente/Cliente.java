
package Cliente;

import javax.swing.JOptionPane;
import Contexto.Gaseosa;
import FabricaFlyweight.FabricaTipoGaseosa;
import Flyweight.TipoGaseosa;

public class Cliente {


    public static void main(String[] args) {
        
        String gaseosas[] = {"Postobon Uva 100ml", "Colombiana 500ml"};
        
        while (true) {

            String opcionGaseosa = (String) JOptionPane.showInputDialog(null, "Seleccione una gaseosa:", "Seleccion de gaseosa",
                    JOptionPane.QUESTION_MESSAGE, null, gaseosas, gaseosas[0]);

            if (opcionGaseosa == null || opcionGaseosa.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }
            
            int numUnidades = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de gaseosas a producir:"));   
            
            
            int cont = 0; //Contador para los codigos de barras
            switch (opcionGaseosa) {
                case "Postobon Uva 100ml":
                    TipoGaseosa tipoGaseosa = FabricaTipoGaseosa.getGaseosa("Postobon Uva 100ml", 1000); // Supongamos que el precio es 1000
                    
                    StringBuilder datosGaseosasP = new StringBuilder(); //Concatenamos los datos de las gaseosas para imprimirlos
                    for (int i = 0; i < numUnidades; i++) {
                    cont = i;
                    int codBarras = cont; // crea un codigo de barras unico por cada gaseosa
                    Gaseosa gaseosa = new Gaseosa(codBarras, tipoGaseosa);
                    datosGaseosasP.append(gaseosa.mostrarDatos()).append("\n");
                    }
                    //Imprimos los datos de todas las gaseosas en un solo joptionpane
                    JOptionPane.showMessageDialog(null, datosGaseosasP);
                    break;
                case "Colombiana 500ml":
                    tipoGaseosa = FabricaTipoGaseosa.getGaseosa("Colombiana 500ml", 2000); // Supongamos que el precio es 2000

                    StringBuilder datosGaseosasC = new StringBuilder(); //Concatenamos los datos de las gaseosas para imprimirlos
                    for (int i = 0; i < numUnidades; i++) {
                    cont = i;
                    int codBarras = cont; // crea un codigo de barras unico por cada gaseosa
                    Gaseosa gaseosa = new Gaseosa(codBarras, tipoGaseosa);
                    datosGaseosasC.append(gaseosa.mostrarDatos()).append("\n");
                    }
                    //Imprimos los datos de todas las gaseosas en un solo joptionpane
                    JOptionPane.showMessageDialog(null, datosGaseosasC);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de gaseosa no válido.");
                    return;
            }
        }
    }
    
}
