
package Cliente;

import javax.swing.JOptionPane;
import Contexto.Gaseosa;
import FabricaFlyweight.FabricaTipoGaseosa;
import Flyweight.TipoGaseosa;
import java.util.Random;


public class Cliente {


    public static void main(String[] args) {
        Random random = new Random();
        String gaseosas[] = {"Postobon Uva 100ml", "Colombiana 500ml", "Finalizar pedido"};
        StringBuilder datosGaseosas = new StringBuilder(); //Concatenamos los datos de las gaseosas para imprimirlos en pantalla

        while (true) {

            String opcionGaseosa = (String) JOptionPane.showInputDialog(null, "Seleccione una gaseosa:", "Seleccion de gaseosa",
                    JOptionPane.QUESTION_MESSAGE, null, gaseosas, gaseosas[0]);

            if (opcionGaseosa == null || opcionGaseosa.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }
            
            int numUnidades = 0;   
            if (!opcionGaseosa.equals("Finalizar pedido")){
                boolean alpha = false;
                try{
                    numUnidades = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de gaseosas a producir:"));
                }
                catch (Exception e) {
                    alpha = true;
                }
                while (numUnidades < 1 || alpha){
                    try{
                        numUnidades = Integer.parseInt(JOptionPane.showInputDialog(null,"Porfavor ingrese un número de unidades valido\n\nIngrese el numero de gaseosas a producir:"));
                        alpha = false;
                    }
                    catch (Exception e) {
                        alpha = true;
                    }
                }
            }
        
            
            int cont = 0; //Contador para los codigos de barras
            int codBarras = 0;
          
            switch (opcionGaseosa) {
                case "Postobon Uva 100ml":
                    //Se verifica si la referencia esta en el hashmap, sino, se crea una vez, si esta, la devuelve sin crear nada mas
                    TipoGaseosa tipoGaseosa = FabricaTipoGaseosa.getGaseosa("Postobon Uva 100ml", 1000); // Supongamos que el precio es 1000
                    
                    
                    for (int i = 0; i < numUnidades; i++) {
                    cont = random.nextInt(1000);
                    while (codBarras == cont){
                        cont = random.nextInt(1000);
                    }
                    codBarras = cont; // crea un codigo de barras unico por cada gaseosa
                    //ahorro de memoria ya que tipoGaseosa solo se creo solo una vez
                    //Creamos las gaseosas particulares usando los datos generales a traves de tipoGaseosas(ahorro memoria)
                    Gaseosa gaseosa = new Gaseosa(codBarras, tipoGaseosa);
                    //Contatenamos datos en arreglo para imprimir en pantalla
                    datosGaseosas.append(gaseosa.mostrarDatos()).append("\n");
                    }
                    //Imprimos los datos de todas las gaseosas en un solo joptionpane
                    break;
                case "Colombiana 500ml":
                    tipoGaseosa = FabricaTipoGaseosa.getGaseosa("Colombiana 500ml", 2000); // Supongamos que el precio es 2000

                    for (int i = 0; i < numUnidades; i++) {
                        cont = random.nextInt(1000);
                        while (codBarras == cont){
                            cont = random.nextInt(1000);
                        }
                        codBarras = cont; // crea un codigo de barras unico por cada gaseosa
                        //Creamos las gaseosas particulares usando los datos generales a traves de tipoGaseosas(ahorro memoria)
                    Gaseosa gaseosa = new Gaseosa(codBarras, tipoGaseosa);
                    datosGaseosas.append(gaseosa.mostrarDatos()).append("\n");
                    }
                    break;
                //Imprimos los datos de todas las gaseosas en un solo joptionpane
                case "Finalizar pedido":
                    JOptionPane.showMessageDialog(null, datosGaseosas);
                    datosGaseosas = new StringBuilder();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Tipo de gaseosa no válido.");
                    return;
            }
        }
    }
    
}
