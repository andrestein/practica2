/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octographs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author audoban
 */
public class FrameRecorrido extends javax.swing.JFrame {

    /**
     * Creates new form FrameRecorrido
     */
    public FrameRecorrido(Proceso proceso) {
        this.proceso = proceso;
        initComponents();
        initItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        cmbInicial = new javax.swing.JComboBox();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        cmbFinal = new javax.swing.JComboBox();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        spinLongitud = new javax.swing.JSpinner();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCalcular = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSalida = new javax.swing.JTextPane();

        setTitle("Recorridos");
        setMinimumSize(new java.awt.Dimension(480, 480));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        panel.setMaximumSize(new java.awt.Dimension(32767, 40));
        panel.setMinimumSize(new java.awt.Dimension(305, 40));
        panel.setName(""); // NOI18N
        panel.setLayout(new java.awt.GridLayout(2, 4, 7, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nodo inicial:");
        panel.add(jLabel1);

        cmbInicial.setMaximumSize(new java.awt.Dimension(32767, 21));
        cmbInicial.setName(""); // NOI18N
        panel.add(cmbInicial);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nodo final:");
        panel.add(jLabel2);

        cmbFinal.setMaximumSize(new java.awt.Dimension(32767, 21));
        cmbFinal.setName(""); // NOI18N
        panel.add(cmbFinal);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Longitud:");
        panel.add(jLabel3);

        spinLongitud.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
        panel.add(spinLongitud);
        panel.add(filler1);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        panel.add(btnCalcular);

        getContentPane().add(panel);

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 7));
        jSeparator1.setName(""); // NOI18N
        getContentPane().add(jSeparator1);

        textSalida.setEditable(false);
        jScrollPane1.setViewportView(textSalida);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (proceso == null) {
            return;
        }
        Elemento i = (Elemento) cmbInicial.getSelectedItem();
        Elemento f = (Elemento) cmbFinal.getSelectedItem();
        int longitud = (Integer) spinLongitud.getValue();
        String r = proceso.recorridos(i, f, longitud);
        textSalida.setText(r);
    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameRecorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameRecorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameRecorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRecorrido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRecorrido(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox cmbFinal;
    private javax.swing.JComboBox cmbInicial;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JSpinner spinLongitud;
    private javax.swing.JTextPane textSalida;
    // End of variables declaration//GEN-END:variables
    private Proceso proceso;

    private void initItems() {
        ComboBoxModel model1 = new DefaultComboBoxModel(proceso.elementos.toArray());
        ComboBoxModel model2 = new DefaultComboBoxModel(proceso.elementos.toArray());
        cmbInicial.setModel(model1);
        cmbFinal.setModel(model2);
    }

    private void setRecorridos(List<StringBuilder> list) {
        try {
            Document doc = textSalida.getDocument();
            doc.remove(0, doc.getLength());
            if (list == null) {
                doc.insertString(0
                        , "No existen recorridos de longitud: " 
                        + (Integer)spinLongitud.getValue(), null);
                return;
            }
            for (StringBuilder str : list) {
                StringBuilder s = new StringBuilder(str);
                s.insert(0, "* ");
                s.append("\n");
                doc.insertString(0, s.toString(), null);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(FrameRecorrido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
