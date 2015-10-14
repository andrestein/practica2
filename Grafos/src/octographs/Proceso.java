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
    public int [][] matrizAdyasencia;
    
    
    public Proceso (ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos){
        ArrayList<String> temp = new ArrayList<String>();       
        matrizAdyasencia = new int[elementos.size()+1][elementos.size()+1];       
        for(int j = 1; j <= temp.size();j++){
           for(int k = 1; k <= temp.size();k++){
               matrizAdyasencia[j][k] = CERO;               
           }
        }       
        for(int i = 0; i<relaciones.size();i++){
        Relacion x =  relaciones.get(i);       
       
            int j = 0;
            int f = 0;
            int c = 0;
            for(; j < matrizAdyasencia.length;j++){                
                f = j;
            }
            int m = 0;
            for(; m < matrizAdyasencia.length;m++){               
                c = m;
            }
            matrizAdyasencia[f][c] = UNO;  
        }
       
    } 
}
