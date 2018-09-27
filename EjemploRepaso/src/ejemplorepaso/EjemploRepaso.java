package ejemplorepaso;

import javax.swing.JOptionPane;

/**
 *
 * @author Kelly Suyon
 */
public class EjemploRepaso {

    public static void main(String[] args) {

        int total_estudiantes = 0;
        boolean cancelar = false;
        boolean reintentar = true;
        do {
            String numero_estudiante = JOptionPane.showInputDialog("Ingrese Numero de estudiantes");
            if (numero_estudiante != null) {
                if (esEntero(numero_estudiante)) {
                    if (Integer.parseInt(numero_estudiante) > 0) {
                        total_estudiantes = Integer.parseInt(numero_estudiante);
                        reintentar = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a cero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese porfavor un numero entero");
                }
            } else {
                cancelar = true;
            }
        } while (!cancelar && reintentar);

        if (cancelar) {
            JOptionPane.showMessageDialog(null, "A cancelado el registro");
        } else {
            reintentar = true;
            cancelar = false;
            String[] nombres_estudiantes = new String[total_estudiantes];
            int[] lista_edad_estudiantes = new int[total_estudiantes];
            int estudiante_menor = 99999;
            int estudiante_mayor = 0;
            int n_multiplos_7 = 0;
            int[] multiplos_7 = new int[total_estudiantes];
            int suma_edades = 0;
            int k = 0;
            do {
                do {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (k + 1));
                    if (nombre == null) {
                        cancelar = true;

                    } else {
                        if (!esEntero(nombre)) {
                            if (!nombre.equals("")) {
                                nombres_estudiantes[k] = nombre;
                                reintentar = false;
                            } else {
                                reintentar = true;
                                JOptionPane.showMessageDialog(null, "Nombre vacio");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
                        }
                    }
                } while (!cancelar && reintentar);

                if (cancelar) {
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                } else {
                    cancelar = false;
                    reintentar = true;
                    do {
                        String edad = JOptionPane.showInputDialog("Ingrese la edad del estudiante " + (k + 1));
                        if (edad == null) {
                            JOptionPane.showMessageDialog(null, "Saliendo...");
                            cancelar = true;

                        } else {

                            if (esEntero(edad)) {
                                if (Integer.parseInt(edad) > 0) {
                                    lista_edad_estudiantes[k] = Integer.parseInt(edad);
                                    suma_edades += lista_edad_estudiantes[k];
                                    if (lista_edad_estudiantes[k] > estudiante_mayor) {
                                        estudiante_mayor = lista_edad_estudiantes[k];
                                    }
                                    if (lista_edad_estudiantes[k] < estudiante_menor) {
                                        estudiante_menor = lista_edad_estudiantes[k];
                                    }
                                    if (EsMultiplodeSiete(lista_edad_estudiantes[k])) {
                                        multiplos_7[n_multiplos_7] = lista_edad_estudiantes[k];
                                    }
                                    k++;
                                    reintentar = false;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Ingrese un numero entero");
                            }
                        }
                    } while (reintentar && !cancelar);
                }
            } while (k < total_estudiantes && !cancelar);

            if (!cancelar) {
                String lista = "";
                double promedio_edades = (double) suma_edades / total_estudiantes;
                // Impresion de Nombres
                for (int i = 0; i < nombres_estudiantes.length; i++) {
                    lista += (i + 1) + " " + nombres_estudiantes[i] + " - " + lista_edad_estudiantes[i] + " años\n";
                }
                //  Impresion de edades mayor y menor
                lista += " La Edad Mayor es :  " + estudiante_mayor + "\n";
                lista += " La Edad Menor es :  " + estudiante_menor + "\n";
                lista += " El Promedio es :  " + promedio_edades + "\n";
                lista += " La Suma es :  " + suma_edades + "\n";
                lista += "************************\n";

                // Multiplos de 7
                for (int i = 0; i < multiplos_7.length; i++) {
                    if (multiplos_7[i] > 0) {
                        lista += (i + 1) + ". " + multiplos_7[i] + "\n";
                    }
                }

                JOptionPane.showMessageDialog(null, lista);
            }

        }

    }

    public static boolean EsMultiplodeSiete(int pnNumero) {
        boolean bresultado = false;
        if (pnNumero == 0) {
            bresultado = false;
        }
        if (pnNumero % 7 == 0) {
            bresultado = true;
        } else {
            bresultado = false;
        }
        return bresultado;
    }

    public static boolean esEntero(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
