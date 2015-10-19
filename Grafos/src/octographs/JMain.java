/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octographs;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author audoban
 */
public class JMain extends JFrame
{

    JMain()
    {
        super();
        initialize();
    }

    protected final void initialize()
    {
        UI ui = new UI();
        this.setSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.add(ui);
        this.setTitle("Practica Grafos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        JMain contenedor = new JMain();
        contenedor.setVisible(true);
    }
}
