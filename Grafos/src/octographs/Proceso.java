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
public class Proceso
{

    public static final int CERO = 0;
    public static final int UNO = 1;

    // aRb 
    private Lienzo lienzo;
    private long[][] matrizAdyacencia = null;
    public String[] nodos = null;
    public final int ORDEN;
    public final ArrayList<Elemento> elementos;
    public final ArrayList<Relacion> relaciones;

    public Proceso(ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos)
    {
        this.elementos = elementos;
        this.relaciones = relaciones;
        ORDEN = elementos.size();
        if (ORDEN == 0)
            return;
        matrizAdyacencia = new long[ORDEN][ORDEN];
        for (int i = 0; i < ORDEN; i++)
            for (int j = 0; j < ORDEN; j++)
                matrizAdyacencia[i][j] = CERO;

        for (Relacion x : relaciones) {
            int aR = elementos.indexOf(x.getElemento1());
            int b = elementos.indexOf(x.getElemento2());
            matrizAdyacencia[aR][b] = UNO;
        }

        nodos = new String[ORDEN];
        int i = 0;
        for (Elemento e : elementos)
            nodos[i++] = e.getNombre();
    }

    public final String[] getNodos()
    {
        return nodos;
    }

    public final long[][] getMatrizAdyacencia()
    {
        return matrizAdyacencia;
    }

    public long[][] adyPotencia(int n)
    {
        if (n <= 0)
            return null;
        else if (n == 1)
            return matrizAdyacencia.clone();

        long ans[][] = matrizAdyacencia.clone();
        long mn[][] = null;

        for (int m = 1; m < n; m++) {
            mn = new long[ORDEN][ORDEN];
            for (int x = 0; x < ORDEN; x++)
                for (int i = 0; i < ORDEN; i++) // fila
                    for (int j = 0; j < ORDEN; j++) // columna
                        mn[x][i] += ans[x][j] * matrizAdyacencia[j][i];
            ans = mn;
        }
        return mn;
    }
    
    // Un StringBuilder es como un String pero mas eficiente en las asignaciones
    // y las concatenaciones. En esta funcion se deberan hacer muchas de ellas.
    // Formatee cada recorrido de esta manera a-b-c-d donde a,b,c,d son nodos
    // No es necesario añadir saltos de linea, ya se hace automaticamente.
    // Retorne null para cuando no hayan caminos.
    public LinkedList<StringBuilder> recorridos(Elemento nInicial, Elemento nFinal, int longitud){
        LinkedList<StringBuilder> r = new LinkedList<>();       
        // Debe retornar la lista con los recorridos o null
        // el mensaje correspondiente a recorrido no disponible sera 
        // mostrado
        // test
        long [][] maElevada;
        int indiceI = 0, indiceF=0;
        long numeroCaminos;
        for (Elemento ele : lienzo.elementos) {
            if(nInicial.equals(ele)== true){
                indiceI=lienzo.elementos.indexOf(ele);
            }
            if(nFinal.equals(ele) == true){
                indiceF=lienzo.elementos.indexOf(ele);
            }
        }
        maElevada = adyPotencia(longitud).clone();
        numeroCaminos = maElevada[indiceI][indiceF];
        int i=0;
        int indice = 0;
        
        if(matrizAdyacencia[indiceI][indiceF] == 1){
            
        }
        while(i == numeroCaminos){
            
            /*for(int j=0;j<matrizAdyacencia.length;j++){
                if(matrizAdyacencia[indiceI][j]==1){                 
                  indice =j;
                  if(matrizAdyacencia[j][indiceF]== 1){
                      
                  }
                }
                
            }
            for(int k=0;k< matrizAdyacencia.length;k++){
                if(matrizAdyacencia[indice][k]==1){
                  
                    if(matrizAdyacencia[k][indiceF]== 1){
                      
                    }  
                }
            }           
            /*
            
            */
            for(int j = 0;j<matrizAdyacencia.length;j++){
                if(matrizAdyacencia[indiceI][j]==1){
                    
                    for(int k=0;k<matrizAdyacencia.length;k++){
                        if(matrizAdyacencia[j][indiceF]==1){
                            
                        }                     
                    }
                }
            }
            i++;
        }
        if(r.isEmpty() == true){    
        return null;     
        }
        else{
            return r;
        }              
    }
}
