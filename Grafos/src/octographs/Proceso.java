/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octographs;

import java.util.ArrayList;

/**
 *
 * @author audoban
 * @author Andres piedrahita
 */
public class Proceso {

    public static final int CERO = 0;
    public static final int UNO = 1;

    // aRb 
    private int[][] matrizAdyacencia;
    private String[] nodos;
    public final int ORDEN;

    public Proceso(ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos) {
        ORDEN = elementos.size();
        matrizAdyacencia = new int[ORDEN][ORDEN];
        for (int i = 0; i < ORDEN; i++) {
            for (int j = 0; j < ORDEN; j++) {
                matrizAdyacencia[i][j] = CERO;
            }
        }

        for (Relacion x : relaciones) {
            int aR = elementos.indexOf(x.getElemento1());
            int b = elementos.indexOf(x.getElemento2());
            matrizAdyacencia[aR][b] = UNO;
        }

        nodos = new String[ORDEN];
        int i = 0;
        for (Elemento e : elementos) {
            nodos[i++] = e.getNombre();
        }
    }

    public final String[] getNodos() {
        return nodos;
    }

    public final int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public int[][] adyPotencia(int n) {
        if (n < 0) {
            return null;
        } else if (n == 1) {
            return matrizAdyacencia.clone();
        }

        int ans[][] = matrizAdyacencia.clone();
        int mn[][] = new int[ORDEN][ORDEN];

        for (int i = 1; i < n; i++) {
            for (int x = 0; x < ORDEN; x++) {
                for (int y = 0; y < ORDEN; y++) {
                    for (int m = 0; m < ORDEN; m++) {
                        mn[x][y] += ans[x][m] * matrizAdyacencia[m][y];
                    }
                }
            }
            ans = mn.clone();
        }
        return mn;
    }
}
