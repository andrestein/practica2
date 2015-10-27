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
    public LinkedList<String> recorridos(Elemento nInicial, Elemento nFinal, int longitud) {
        
        LinkedList<String> r = new LinkedList<>();
        if (longitud == 1) {
            for(int i =0; i < relaciones.size();i++){
                for(int j =0; j < relaciones.size();j++){            
                    if( relaciones.get(i).getElemento1().equals(nInicial) && relaciones.get(j).equals(nFinal)){
                        r.add(nInicial.getNombre()+" - "+ nFinal.getNombre());
                    }                
                }            
            }
        }else if (longitud == 2) {
            for(Relacion relacion1: relaciones) {
                if( relacion1.getElemento1().equals(nInicial) ) {
                    for(Relacion relacion2: relaciones ) {
                        if( relacion2.getElemento1().equals(relacion1.getElemento2()) 
                                && relacion2.getElemento2().equals(nFinal) ) 
                        {
                            String str = nInicial + " - " 
                                    + relacion1.getElemento2() + " - "
                                    + relacion2.getElemento2();
                            r.add(str);
                        }
                    }
                }
            }
        }else if(longitud == 3) {
            for(Relacion relacion1: relaciones) {
                if( relacion1.getElemento1().equals(nInicial) ) {
                    for(Relacion relacion2: relaciones ) {
                        if( relacion2.getElemento1().equals(relacion1.getElemento2())){
                            for(Relacion relacion3 : relaciones){
                                if(relacion3.getElemento1().equals(relacion2.getElemento2()) 
                                        && relacion3.getElemento2().equals(nFinal)){
                                   String str = nInicial + " - " 
                                    + relacion1.getElemento2() + " - "
                                    + relacion2.getElemento2() + " - "
                                    + relacion3.getElemento2();
                                    r.add(str); 
                                }
                            }
                        }
                    }
                }
            }
        }else if(longitud == 4) {
            for(Relacion relacion1: relaciones) {
                if( relacion1.getElemento1().equals(nInicial) ) {
                    for(Relacion relacion2: relaciones ) {
                        if( relacion2.getElemento1().equals(relacion1.getElemento2())){
                            for(Relacion relacion3 : relaciones){
                                if(relacion3.getElemento1().equals(relacion2.getElemento2())) {
                                    for(Relacion relacion4: relaciones ) {
                                        if(relacion4.getElemento1().equals(relacion3.getElemento2()) 
                                        && relacion4.getElemento2().equals(nFinal)) {
                                        String str = nInicial + " - " 
                                            + relacion1.getElemento2() + " - "
                                            + relacion2.getElemento2() + " - "
                                            + relacion3.getElemento2() + " - "
                                            + relacion4.getElemento2();
                                            r.add(str); 
                                        }
                                    }
        }else if(longitud == 4){
            
        }else if(longitud == 5){
            for(Relacion relacion1: relaciones) {
                if( relacion1.getElemento1().equals(nInicial) ) {
                    for(Relacion relacion2: relaciones ) {
                        if( relacion2.getElemento1().equals(relacion1.getElemento2())){
                            for(Relacion relacion3 : relaciones){
                                if(relacion3.getElemento1().equals(relacion2.getElemento2())){
                                    for(Relacion relacion4 : relaciones){
                                        if(relacion4.getElemento1().equals(relacion3.getElemento2())){
                                            for(Relacion relacion5 : relaciones){
                                                if(relacion5.getElemento1().equals(relacion3.getElemento2()) 
                                                        && relacion5.equals(nFinal)){
                                                    String str = nInicial + " - " 
                                                    + relacion1.getElemento2() + " - "
                                                    + relacion2.getElemento2() + " - "
                                                    + relacion3.getElemento2() + " - "
                                                    + relacion4.getElemento2() + " - "
                                                    + relacion5.getElemento2() + " - ";
                                                    r.add(str); 
                                                }
                                            }
                                        }
                                    }                                
                                }
                            }
                        }
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
        ArrayList<Elemento> lista = new ArrayList<>();

        for (int j = 0; j < ORDEN; j++) {
            if (matrizAdyacencia[i][j] == 1) {
                lista.add(elementos.get(j));
            }
        }
        return lista;
    }
}
