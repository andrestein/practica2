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
    
    public enum Conexo{CONEXO, NO_CONEXO};
    public enum Reflexiva { REFLEXIVA , ANTI_REFLEXIVA, NO_REFLEXIVA}; 
    public enum Orden {ORDEN_EXTRICO,ORDEN_PARCIAL,ORDEN_TOTAL};
    public enum Simetrica {SIMETRICA, ANTI_SIMETRICA, NO_SIMETRICA}; 
    public static final String CERO = "0";
    public static final String UNO = "1";
    
    // fila, columna 0: nombres de elementos 
    public String [][] matrizAdyasencia;
    public String [][] traspuesta;
    
    public Proceso (ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos){
        ArrayList<String> temp = new ArrayList<String>();
        for(Elemento e: elementos) {
          
            temp.add(e.getNombre());
         
//            if(temp.indexOf(r.getElemento1().getNombre())== -1){
//                temp.add(r.getElemento1().getNombre());
//            }
//            if(temp.indexOf(r.getElemento2().getNombre())== -1){
//                temp.add(r.getElemento2().getNombre());
//            }
        }
           
        temp.sort(String.CASE_INSENSITIVE_ORDER);
        
        matrizAdyasencia = new String[elementos.size()+1][elementos.size()+1];
        traspuesta = new String[elementos.size()+1][elementos.size()+1];
        int a = 0;
        for(int i=1; i <= temp.size();i++){
             matrizAdyasencia[i][0]= temp.get(i-1);
             matrizAdyasencia[0][i]= temp.get(i-1); 
             traspuesta[i][0]= temp.get(i-1);
             traspuesta[0][i]= temp.get(i-1); 
             
        }
                
        
        for(int j = 1; j <= temp.size();j++){
           for(int k = 1; k <= temp.size();k++){
               matrizAdyasencia[j][k] = CERO;
               traspuesta[j][k] = CERO;
           }
        }
        
        for(int i = 0; i<relaciones.size();i++){
        Relacion x =  relaciones.get(i); 
        String ele1 = x.getElemento1().getNombre();
        String ele2 = x.getElemento2().getNombre();        
       
            int j = 0;
            int f = 0;
            int c = 0;
            for(; j < matrizAdyasencia.length;j++){
                if (ele1.equals(matrizAdyasencia[j][0]))
                    f = j;
            }
            int m = 0;
            for(; m < matrizAdyasencia.length;m++){
                if (ele2.equals(matrizAdyasencia[0][m]))
                    c = m;
            }
            matrizAdyasencia[f][c] = UNO;
            traspuesta[c][f] = UNO;
        }
       matrizAdyasencia[0][0] = "/";
       traspuesta[0][0] = "/";
    }
   
    public Conexo conexo(ArrayList<Relacion> relaciones, ArrayList<Elemento> elementos)
    {
       ArrayList<Relacion> temp = new ArrayList<Relacion>();
       Relacion rela;
       Elemento ele;
       
        for (int i = 0; i < relaciones.size();i++){
           rela = relaciones.get(i);
                      
            for(int j = 0; j < relaciones.size(); i++){
                ele = rela.getElemento1();
                if (ele.equals(elementos.get(i)))
                    temp.add(rela);
            }
        }
       return null;
    }
    public Reflexiva reflexividad () 
    {
        int i = 1;
        int j = 1;
        int cont=0;
        for (i = 1; i <= matrizAdyasencia.length-1;i++){
            for (j = 1; j <= matrizAdyasencia.length-1;j++ ){
                if (matrizAdyasencia[i][j].equals(UNO) && i==j){
                 cont = 1 +cont;
                }  
            }
        }
       
        if (cont == matrizAdyasencia.length-1)
           return Reflexiva.REFLEXIVA;
        else if (cont < matrizAdyasencia.length-1 && cont !=0)
           return Reflexiva.NO_REFLEXIVA;
        else 
            return Reflexiva.ANTI_REFLEXIVA;
    }
   
    public Simetrica simetria ()
    {
         int i = 1;
        int j = 1;
        int conts = 0;
        for (i = 1; i <= matrizAdyasencia.length - 1;i++){
            for (j = 1; j <= matrizAdyasencia.length - 1;j++ ){
               if (matrizAdyasencia[i][j] == UNO 
                   && matrizAdyasencia[j][i] == UNO 
                   && i != j&& i>j){
                    conts ++;
                    
                } 
            }
        }
       
        if (conts == (matrizAdyasencia.length-1)*(matrizAdyasencia.length-1)-(matrizAdyasencia.length-1))
            return Simetrica.SIMETRICA;
        else if (conts == 0)
           return Simetrica.ANTI_SIMETRICA;
        else 
              return Simetrica.NO_SIMETRICA;    
    }  
   
    public boolean transitiva ()
    {
        int i = 1;
        int j = 1;
        int k = 1 ;
        
        int a =0;
        int b =0;
        for (; i <= matrizAdyasencia.length-1;i++){
            for (; j <= matrizAdyasencia.length-1;j++ ){
                if (matrizAdyasencia[i][j].equals(UNO)){
                    for (; k <= matrizAdyasencia.length-1;k++ ){
                     if(matrizAdyasencia[j][k].equals(UNO)){
                        b = k;
                      }
                    }
                }
             
            }
            if(matrizAdyasencia[i][b].equals(CERO))
                return false;
        }  
     return true ;
    }
    
    public boolean equivalencia ()
    {
        if (simetria() == Simetrica.SIMETRICA 
            && reflexividad()==Reflexiva.REFLEXIVA
            && transitiva()==true)
        {
            return true;
        }
        return false;
    }
    public Orden orden ()
    {
        int i=1 ,j=1;
      boolean auxiliar = false ;
      for (;i <matrizAdyasencia.length;i++){
         for (;i <matrizAdyasencia.length;i++){
             if (matrizAdyasencia[i][j]==CERO){
             auxiliar = true;
             }     
            }
        }
      
      if (simetria() == Simetrica.ANTI_SIMETRICA
              && transitiva() == true 
              && reflexividad()!=Reflexiva.REFLEXIVA
              && reflexividad()!=Reflexiva.NO_REFLEXIVA
              &&reflexividad()!=Reflexiva.ANTI_REFLEXIVA)
      {
      return Orden.ORDEN_EXTRICO;
      }
      if (simetria() == Simetrica.ANTI_SIMETRICA
              && transitiva() == true 
              && reflexividad()!=Reflexiva.REFLEXIVA
              && reflexividad()!=Reflexiva.NO_REFLEXIVA
              &&reflexividad()!=Reflexiva.ANTI_REFLEXIVA)
      {
      return Orden.ORDEN_EXTRICO;
      }
        
      else if (simetria() == Simetrica.ANTI_SIMETRICA
              && transitiva() == true 
              && reflexividad()==Reflexiva.REFLEXIVA
              && auxiliar == true  )
              
      {
      return Orden.ORDEN_PARCIAL;
      }
      
      else if (simetria() == Simetrica.ANTI_SIMETRICA
              && transitiva() == true 
              && reflexividad()==Reflexiva.REFLEXIVA
               )
              
      {
          return Orden.ORDEN_TOTAL;
    }
           return null;
    }
}
