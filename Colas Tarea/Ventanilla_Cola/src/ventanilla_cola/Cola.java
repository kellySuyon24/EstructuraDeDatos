/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanilla_cola;

public class Cola {
    
 private java.util.ArrayList<String> cola = null;
    private java.util.Random alea = new java.util.Random();
    private boolean isDebug = true;

    public Cola() {
        cola = new java.util.ArrayList();
        this.runProccess();
    }

    private boolean isAccepted() {
        return ((int) alea.nextInt(2)) == 0;
    }

    public void muestraCola() {
        if (isDebug) {
            System.out.println("--------------------------------------------------");
        }
        System.out.print("[");
        String sep = "";
        for (String c : cola) {
            System.out.print(sep + c);
            sep = ", ";
        }
        System.out.print("]\n");
        if (isDebug) {
            System.out.println("---------------------------------------------------");
        }
    }

    public void runProccess() {
        int pos = 0;
        int final_size = cola.size();
        while (pos < final_size) {
            if (isDebug) {
                System.out.println(String.format("Atendiendo posición %d[%s]", pos, cola.get(pos)));
            }
            if (this.isAccepted()) {
                cola.remove(pos);
                if (isDebug) {
                    System.out.println("Aceptado, se le atiende y se saca de la cola");
                }
            } else {
                if (isDebug) {
                    System.out.println("No se puede atender en estos momentos");
                }
                if (cola.size() > 10) {
                    for (int nJ = pos; nJ < final_size; nJ++) {
                        if (cola.size() > (10 + nJ)) {
                            if (isDebug) {
                                System.out.println(String.format("Se mueve a %s de la posición %d a la posición %d en la que está %s", cola.get(pos), pos, (10 + nJ), cola.get(10 + nJ)));
                            }
                            java.util.Collections.swap(cola, pos, 10 + nJ);
                        } else {
                            cola.add(cola.get(pos));
                            cola.remove(pos);
                            break;
                        }
                        if (isDebug) {
                            System.out.println("La cola queda así:");
                        }
                        if (isDebug) {
                            muestraCola();
                        }
                    }

                } else {
                    java.util.Collections.swap(cola, pos, cola.size() - 1);
                    if (isDebug) {
                        System.out.println("Se mueve al final");
                    }
                }
            }
            final_size = cola.size();
            if (isDebug) {
                System.out.println("La cola queda así:");
            }
            muestraCola();
        }
    }

    public void setAllItems(String[] items) {
        this.cola = new java.util.ArrayList<String>(java.util.Arrays.asList(items));
    }

    public void addItem(String nuevo) {
        this.cola.add(nuevo);
    }

    public java.util.ArrayList<String> getCola() {
        return this.cola;
    }    
}
