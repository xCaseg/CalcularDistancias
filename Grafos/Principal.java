
package Grafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        
        ArrayList<GraphNode> origen = new ArrayList<>();

        // EMPEZAMOS POR CREAR LOS DIFERENTES VÉRTICES/NODOS QUE SE UTILIZARÁN

        GraphNode nodoch = new GraphNode();
        nodoch.setName("CHIHUAHA");
        
        GraphNode nodocdmx = new GraphNode();
        nodocdmx.setName("CIUDAD DE MEXICO");
        
        GraphNode nodomty = new GraphNode();
        nodomty.setName("MONTERREY");
        
        GraphNode nodogdl = new GraphNode();
        nodogdl.setName("GUADALAJARA");
        
        GraphNode nodoac = new GraphNode();
        nodoac.setName("ACAPULCO");
                
        GraphNode nodotl = new GraphNode();
        nodotl.setName("TULUM");
        
        GraphNode nodotj = new GraphNode();
        nodotj.setName("TIJUANA");
        
        GraphNode nodogj = new GraphNode();
        nodogj.setName("GUANAJUATO");
        
        GraphNode nodoxa = new GraphNode();
        nodoxa.setName("XALAPA");
        
        GraphNode nodomex = new GraphNode();
        nodomex.setName("MEXICALI");
        
        // AHORA CREAMOS LAS DIFERENTES ARISTAS CON SUS COSTOS CORRESPONDIENTES
        
        //--------------------------CHIHUAHUA--------------------------------//
        // ch-mty
        Edge edgechmty = new Edge();
        edgechmty.setTarget(nodomty);
        edgechmty.setCost(12);

        // ch-cdmx
        Edge edgechcdmx = new Edge();
        edgechcdmx.setTarget(nodocdmx);
        edgechcdmx.setCost(20);
        
        // ch-ac
        Edge edgechac = new Edge();
        edgechac.setTarget(nodoac);
        edgechac.setCost(30);        

        // ch-tl
        Edge edgechtl = new Edge();
        edgechtl.setTarget(nodotl);
        edgechtl.setCost(40);
        
        //--------------------------CDMX--------------------------------//        
                     
        // cdmx-mty
        Edge edgecdmxmty = new Edge();
        edgecdmxmty.setTarget(nodomty);
        edgecdmxmty.setCost(10);

        // cdmx-tl
        Edge edgecdmxtl = new Edge();
        edgecdmxtl.setTarget(nodotl);
        edgecdmxtl.setCost(15);
        
        // cdmx-tj
        Edge edgecdmxtj = new Edge();
        edgecdmxtj.setTarget(nodotj);
        edgecdmxtj.setCost(35);        

        // cdmx-gj
        Edge edgecdmxgj = new Edge();
        edgecdmxgj.setTarget(nodogj);
        edgecdmxgj.setCost(3);
        
        //--------------------------MTY--------------------------------//        
                     
        // mty-tl
        Edge edgemtytl = new Edge();
        edgemtytl.setTarget(nodotl);
        edgemtytl.setCost(30);

        // mty-ac
        Edge edgemtyac = new Edge();
        edgemtyac.setTarget(nodoac);
        edgemtyac.setCost(25);
        
        //--------------------------GDL--------------------------------//        
                     
        // gdl-ch
        Edge edgegdlch = new Edge();
        edgegdlch.setTarget(nodoch);
        edgegdlch.setCost(21);

        // gdl-mty
        Edge edgegdlmty = new Edge();
        edgegdlmty.setTarget(nodomty);
        edgegdlmty.setCost(18);
        
        // gdl-xa
        Edge edgegdlxa = new Edge();
        edgegdlxa.setTarget(nodoxa);
        edgegdlxa.setCost(15);
        
        //--------------------------AC----------------------------------//        
                     
        // ac-mex
        Edge edgeacmex = new Edge();
        edgeacmex.setTarget(nodomex);
        edgeacmex.setCost(40);


        // ----------------------------------------------------//

        // ASIGNAMOS LAS ARISTAS (Edges) A SUS DIFERENTES NODOS DE ORIGEN
        
        origen.add(nodoch);
        nodoch.getEdges().add(edgechmty);
        nodoch.getEdges().add(edgechcdmx);
        nodoch.getEdges().add(edgechac);
        nodoch.getEdges().add(edgechtl);
        
        origen.add(nodocdmx);
        nodocdmx.getEdges().add(edgecdmxmty);
        nodocdmx.getEdges().add(edgecdmxtl);
        nodocdmx.getEdges().add(edgecdmxtj);
        nodocdmx.getEdges().add(edgecdmxgj);

        origen.add(nodomty);
        nodomty.getEdges().add(edgemtytl);
        nodomty.getEdges().add(edgemtyac);
        
        origen.add(nodogdl);
        nodogdl.getEdges().add(edgegdlch);
        nodogdl.getEdges().add(edgegdlmty);
        nodogdl.getEdges().add(edgegdlxa);
        
        origen.add(nodoac);
        nodoac.getEdges().add(edgeacmex);
        
        // Salida
        
        //1. El programa deberá iniciar con un menú, mostrando una lista enumerada de las 5 ciudades de origen posibles 
        //a consultar, y se le pedirá al usuario que ingrese el número correspondiente a la ciudad de origen que desea consultar.
        
        System.out.println("Bienvenido al programa para calcular distancias por medio de Grafos\n");
        System.out.println("Por favor seleccione la ciudad Origen que desea consultar\n");        

        for (int i = 0; i < origen.size(); i++) {
            GraphNode node = origen.get(i);
            System.out.println((i + 1) + ". " + node.getName());
        }     

        int noCiudad = 0;
        boolean eleccion = false;
        do {            
            boolean valido = false;        
            while (!valido) {
                try {
                    String input = JOptionPane.showInputDialog("Ciudad Origen a Consultar: ");
                    noCiudad = Integer.parseInt(input);
                    if (noCiudad > 0 && noCiudad <= origen.size()) {
                        valido = true;
                    } else {
                        //5. En caso de que el usuario elija una ciudad (numero) que no se encuentra en la lista, 
                        // que se indique que la opción seleccionada NO se encuentra en la base de datos.
                        JOptionPane.showMessageDialog(null, "La ciudad seleccionada NO se encuentra en la base de datos. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero.");
                }
            }
            GraphNode ciudadOrigen = origen.get(noCiudad - 1);
            System.out.println("\nHa elegido la ciudad: " + ciudadOrigen.getName() + "...\n");
            
            //2. El programa deberá mostrar las ciudades de destino disponibles 
            //para viajar desde la ciudad de origen seleccionada, junto con la duración de viaje en horas correspondiente.

            System.out.println("Desde " + ciudadOrigen.getName() + " se puede llegar por carretera a: ");
            for (Edge arista : ciudadOrigen.getEdges()) {
                System.out.println("---> " + arista.getTarget().getName() + " en un viaje con una duracion de: " + arista.getCost() + " horas.");
            }
            
            //3. Después, se le deberá preguntar al usuario si desea realizar otra consulta, 
            //si el usuario indica que SI quiere realizar otra consulta, el programa deberá reiniciarse.

            boolean inputValido = false;
            while (!inputValido) {
                String input = JOptionPane.showInputDialog("¿Desea ejecutar otra consulta? (S/N): ");
                if (input != null) {
                    input = input.trim().toUpperCase();
                    switch (input) {
                        case "S" -> {
                            eleccion = true;
                            inputValido = true;
                        }
                        case "N" -> {
                            eleccion = false;
                            inputValido = true;
                        }
                        default -> JOptionPane.showMessageDialog(null, "Por favor ingrese 'S' para sí o 'N' para no.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una respuesta válida.");
                }
            }
        } while (eleccion);
        
        //Si el usuario indica que NO quiere realizar otra consulta, el programa deberá finalizar su ejecución 
        //y mostrar un mensaje de despedida.
        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestros servicios. Hasta la próxima...");
        System.out.println("\nGracias por utilizar nuestros servicios. Hasta la proxima...\n");

    } // main

} // Principal
