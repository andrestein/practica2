/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagrafos;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian Anderson
 */
public class UI extends javax.swing.JPanel {

    DefaultTableModel modelo;
    public UI() {
        initComponents();
        String cabezera [] = {"propiedades","si","no-","anti-"};
        String datos [][] = {};
        modelo = new DefaultTableModel(datos, cabezera);
        jTable5.setModel(modelo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lienzo1 = new octographs.Lienzo();
        PnlBotones = new javax.swing.JPanel();
        btnMatriz = new javax.swing.JButton();
        btnMatrizInverza = new javax.swing.JButton();
        btnTablaDeOrden = new javax.swing.JButton();
        btnConexo = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setLayout(new java.awt.GridLayout(3, 1));
        add(lienzo1);

        PnlBotones.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        PnlBotones.setLayout(new javax.swing.BoxLayout(PnlBotones, javax.swing.BoxLayout.LINE_AXIS));

        btnMatriz.setText("Matríz");
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });
        PnlBotones.add(btnMatriz);

        btnMatrizInverza.setText("Matríz Inversa");
        btnMatrizInverza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizInverzaActionPerformed(evt);
            }
        });
        PnlBotones.add(btnMatrizInverza);

        btnTablaDeOrden.setText("Tabla de orden");
        btnTablaDeOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaDeOrdenActionPerformed(evt);
            }
        });
        PnlBotones.add(btnTablaDeOrden);

        btnConexo.setText("Conexo");
        btnConexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConexoActionPerformed(evt);
            }
        });
        PnlBotones.add(btnConexo);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        PnlBotones.add(btnLimpiar);

        add(PnlBotones);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane5);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane7.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane7);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable5);

        jPanel1.add(jScrollPane6);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

   
     
     
    private void btnMatrizInverzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizInverzaActionPerformed
   
     
        //UI UI = new UI();
       Proceso pro = new Proceso(lienzo1.relaciones,lienzo1.elementos);//pcc
              
        jTextArea2.setText("");
        jTextArea2.setRows(lienzo1.elementos.size() + 1);
        jTextArea2.setColumns(lienzo1.elementos.size() + 1);

        for(int i = 0; i< pro.traspuesta.length;i++){
            String x = "";
            for(int j = 0; j < pro.traspuesta.length;j++){                                
             System.out.print(pro.traspuesta[i][j]+ " ");
             x += " " + pro.traspuesta[i][j];
            }
            jTextArea2.append(x + "\n");
            
        }
        System.out.println("Botón matríz_inversa");

                                            
    }//GEN-LAST:event_btnMatrizInverzaActionPerformed

    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizActionPerformed
     //UI UI = new UI();
        Proceso pro = new Proceso(lienzo1.relaciones,lienzo1.elementos);//pcc
        jTextArea1.setText("");
        jTextArea1.setRows(lienzo1.elementos.size() + 1);
        jTextArea1.setColumns(lienzo1.elementos.size() + 1);

        for(int i = 0; i< pro.matrizAdyasencia.length;i++){
            String x = "";
            for(int j = 0; j < pro.matrizAdyasencia.length;j++){                                
             System.out.print(pro.matrizAdyasencia[i][j]+ " ");
             x += " " + pro.matrizAdyasencia[i][j];
            }
            jTextArea1.append(x + "\n");
        }
        System.out.println("Botón matríz");               //pcc
    }//GEN-LAST:event_btnMatrizActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        jTextArea1.setText("");
        jTextArea2.setText("");
        
        
        for(int i = 0; i < modelo.getRowCount();i++){
            modelo.removeRow(0);
            modelo.removeRow(0);
            }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnTablaDeOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaDeOrdenActionPerformed
        Proceso pro = new Proceso(lienzo1.relaciones,lienzo1.elementos);
        Proceso.Reflexiva reflexiva = pro.reflexividad();
        Proceso.Simetrica simetrica = pro.simetria();
        Proceso.Orden orden = pro.orden();
        boolean equivalencia = pro.equivalencia();
        boolean transitividad = pro.transitiva();
        
        if (reflexiva == reflexiva.REFLEXIVA){
            String reflexivaT[] = {"REFLEXIVA","x",null,null};
           modelo.addRow(reflexivaT);
        }
       
        else if (reflexiva == reflexiva.NO_REFLEXIVA){
           String reflexivaT[] = {"REFLEXIVA",null,"x",null};
           modelo.addRow(reflexivaT);
        }
        
        else  if (reflexiva == reflexiva.ANTI_REFLEXIVA){
         String reflexivaT[] = {"REFLEXIVA",null,null,"x"};
         modelo.addRow(reflexivaT);
        }
        
        if (simetrica == simetrica.SIMETRICA){
            String simetricaT[] = {"SIMETRICA","x",null,null};
           modelo.addRow(simetricaT);
        
        }
        
        else if (simetrica == simetrica.NO_SIMETRICA){
          String simetricaT[] = {"SIMETRICA",null,"x",null};
           modelo.addRow(simetricaT);
        }
        
        else if (simetrica == simetrica.ANTI_SIMETRICA){
        String simetricaT[] = {"SIMETRICA",null,null,"x"};
           modelo.addRow(simetricaT);
        }
        if (transitividad == true ){
            String transitivaT[] = {"TRANSITIVA","x",null,"/////////////"};
           modelo.addRow( transitivaT);
        }
        else {
            String transitivaT [] = {"TRANSITIVA ",null,"X","/////////////"};
           modelo.addRow( transitivaT);
        
        }
        if (equivalencia == true ){
        String equivalenciaT[] = {"EQUIVALENCIA","x",null,"/////////////"};
           modelo.addRow( equivalenciaT);
        }
        else {
            String equivalenciaT [] = {"EQUIVALENCIA",null,"X","/////////////"};
           modelo.addRow( equivalenciaT);
        }
        
        
        if (orden == orden.ORDEN_EXTRICO){
        String ordenT[] = {"ORDEN_EXTRICO","x",null,"/////////////"};
           modelo.addRow( ordenT);
        }
        
        if (orden == orden.ORDEN_PARCIAL){
        String ordenT[] = {"ORDEN_PARCIAL","x",null,"/////////////"};
           modelo.addRow( ordenT);
        }
        
       else if (orden == orden.ORDEN_TOTAL){
        String ordenT[] = {"ORDEN_TOTAL","x",null,"/////////////"};
           modelo.addRow( ordenT);
        }
        
                // TODO add your handling code here:
    }//GEN-LAST:event_btnTablaDeOrdenActionPerformed

    private void btnConexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConexoActionPerformed
          Proceso pro = new Proceso(lienzo1.relaciones,lienzo1.elementos);
          Proceso.Conexo conexo = pro.conexo();
          
          if (conexo == conexo.CONEXO)      
          jTextArea1.setText("conexo");
          else 
             jTextArea1.setText("no conexo"); 
          
          
    }//GEN-LAST:event_btnConexoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlBotones;
    private javax.swing.JButton btnConexo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnMatrizInverza;
    private javax.swing.JButton btnTablaDeOrden;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private octographs.Lienzo lienzo1;
    // End of variables declaration//GEN-END:variables

    
}
