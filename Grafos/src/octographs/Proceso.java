/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octographs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author audoban
 * @author Andres piedrahita
 */
public class Proceso {

    public static final int CERO = 0;
    public static final int UNO = 1;

    // aRb
    private long[][] matrizAdyacencia = null;
    public String[] nodos = null;
    public final int ORDEN;
    public final ArrayList<Elemento> elementos;
    public final ArrayList<Relacion> relaciones;

    public Proceso(ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos) {
        this.elementos = elementos;
        this.relaciones = relaciones;
        ORDEN = elementos.size();
        if (ORDEN == 0) {
            return;
        }
        matrizAdyacencia = new long[ORDEN][ORDEN];
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

    public final long[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public final long[][] adyPotencia(int n) {
        if (n <= 0) {
            return null;
        } else if (n == 1) {
            return matrizAdyacencia;
        }

        long ans[][] = matrizAdyacencia.clone();
        long mn[][] = null;

        for (int m = 1; m < n; m++) {
            mn = new long[ORDEN][ORDEN];
            for (int x = 0; x < ORDEN; x++) {
                for (int i = 0; i < ORDEN; i++) {
                    for (int j = 0; j < ORDEN; j++) {
                        mn[x][i] += ans[x][j] * matrizAdyacencia[j][i];
                    }
                }
            }
            ans = mn;
        }
        return mn;
    }

    // Un StringBuilder es como un String pero mas eficiente en las asignaciones
    // y las concatenaciones. En esta funcion se deberan hacer muchas de ellas.
    // Formatee cada recorrido de esta manera a-b-c-d donde a,b,c,d son nodos
    // No es necesario añadir saltos de linea, ya se hace automaticamente.
    // Retorne null para cuando no hayan caminos.
    public LinkedList<StringBuilder> recorridos(Elemento nInicial, Elemento nFinal, int longitud) {
        long[][] mn = adyPotencia(longitud);
        int indiceI = elementos.indexOf(nInicial);
        int indiceF = elementos.indexOf(nFinal);
        long nCaminos = mn[indiceI][indiceF];
        long[][] MA = matrizAdyacencia.clone();
        ArrayList<Elemento> listaI = new ArrayList<Elemento>();
        ArrayList<Elemento> listaF = new ArrayList<Elemento>();
        ArrayList<Elemento> recorrido = new ArrayList<Elemento>();
        ArrayList<ArrayList> listasR = new ArrayList<>();
        LinkedList<StringBuilder> r = new LinkedList<>();
        listaI = recorridoL1(nInicial);
        listaF = recorridoL1(nFinal);

        
        listasR.add(recorridoL1(elementos.get(indiceI)));

        if (longitud == 1) {
            if (listaI.indexOf(nFinal) != -1) {
                r.add(new StringBuilder(nInicial.getNombre() + " - " + nFinal.getNombre()));
            }
        }else if (longitud == 2) {
            int nI = indiceI;
            for (int j = 0; j < ORDEN; j++) {
                if (MA[nI][j] == 1) {
                    //MA[nI][j] = 0;
                    recorrido = listasR.get(j);
                    if (recorrido.indexOf(nFinal) != -1) {
                        r.add(new StringBuilder(nInicial.getNombre() + " - "
                                + recorrido.get(j).getNombre() + " - " + nFinal.getNombre()));
                    }
                }
            }
        }

        if (r.isEmpty() == true) {
            return null;
        } else {
            return r;
        }
    }

    // recorridos de longitud 1
    public ArrayList<Elemento> recorridoL1(Elemento elemento) {
        int i = elementos.indexOf(elemento);
        ArrayList<Elemento> lista = new ArrayList<Elemento>();

        for (int j = 0; j < ORDEN; j++) {
            if (matrizAdyacencia[i][j] == 1) {
                lista.add(elementos.get(j));
            }
        }
        return lista;
    }

}
