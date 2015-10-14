/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octographs;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Anderson
 */
public class Proceso {

    public static final int CERO = 0;
    public static final int UNO = 1;

    // fila, columna 0: nombres de elementos 
    public int[][] matrizAdyacencia;

    public Proceso(ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos) {

        matrizAdyacencia = new int[elementos.size()][elementos.size()];
        for (int i = 0; i < elementos.size(); i++) {
            for (int j = 0; j < elementos.size(); j++) {
                matrizAdyacencia[i][j] = CERO;
            }
        }

        for (int i = 0; i < relaciones.size(); i++) {
            Relacion x = relaciones.get(i);
            int a = elementos.indexOf(x.getElemento1());
            int b = elementos.indexOf(x.getElemento2());
            matrizAdyacencia[a][b] = UNO;
        }
    }
}
