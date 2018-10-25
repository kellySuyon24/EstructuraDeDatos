/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascensor;

public class ascensorr {
    
        int interna[] = {4, 6, 8, 10, 22};
    int frenteinterna = 0;
    int finalinterna = interna.length - 1;
    int externa[] = {-9, -4, -3, -1};
    int frenteexterna = 0;
    int finalexterna = externa.length - 1;
    int n=20;
    int piso[] = new int[15];
    int p = 0;

    public void Subir() {

     
        while (frenteinterna != -1 && interna[frenteinterna] < n) {
            System.out.println("Subiendo al piso N° " + interna[frenteinterna]);
            for (int i = p; i <= interna[frenteinterna]; i++) {
                System.out.println("Piso N°" + i);
            }
            System.out.println(" ");
            p = interna[frenteinterna];

            if (frenteinterna == finalinterna) {
                frenteinterna = -1;
                finalinterna = -1;
            } else {
                frenteinterna++;
            }
        }
        System.out.println("Usted quizo subir al piso N° " + interna[frenteinterna]);
        System.out.println("Usted ha llegado al último piso (piso N° " + n + ")");
        System.out.println(" ");
    }

    public void bajar() {

        while (frenteexterna != -1 && externa[frenteexterna] < n) {
            System.out.println("Bajando al piso N° " + Math.abs(externa[frenteexterna]));

            for (int k = p; k > Math.abs(externa[frenteexterna]); k--) {
                System.out.println("Piso N° " + k);
            }
            System.out.println(" ");
            p = Math.abs(externa[finalexterna]);

            if (frenteexterna == finalexterna) {
                frenteexterna = -1;
                finalexterna = -1;
            } else {
                frenteexterna++;
            }
        }

    }
}
