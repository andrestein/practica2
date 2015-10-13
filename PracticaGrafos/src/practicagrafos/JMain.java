/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicagrafos;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author audoban
 */
public class JMain extends JFrame {

    private Lienzo lienzo = null;
    private UI ui = null;

    JMain() {
        super();
        initialize();
    }

    protected final void initialize() {
        ui = new UI();
        this.setSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setContentPane(ui);
        this.setTitle("We can do it: Sarpn y Lordu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //lienzo = new Lienzo();
        //this.setContentPane(lienzo);
        //lienzo.setMinimumSize(new Dimension(800, 600));
        //lienzo.setVisible(true);
    }

    public static void main(String args[]) {    
        
       JMain contenedor = new JMain();
       contenedor.setVisible(true);     
    }
    
    
    public void recorido ()
    {        
        Lienzo lienzo  = new Lienzo();
    for(int i =0 ;i <lienzo.relaciones.size();i++ )
    {
     System.out.println(lienzo.relaciones.get(i));
     
    }
    }
    
    
    public void matrizRelacion(){
        
    } 
  }


