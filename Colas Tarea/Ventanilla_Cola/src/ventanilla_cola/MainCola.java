/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanilla_cola;

/**
 *
 * @author ADMI
 */
public class MainCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                Cola c = new Cola();
        c.setAllItems(new String[]{"[1]", "[2]", "[3]", "[4]", "[5]", "[6]",
            "[7]", "[8]", "[9]", "[10]", "[11]", "[12]"});

        System.out.println("La cola comienza así:");
        c.muestraCola();
        c.runProccess();
        System.out.println("La cola termina así:");
        c.muestraCola();

    }
    
}
