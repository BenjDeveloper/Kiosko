/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PrometeoNew666
 */
public class ByosBotonProductos extends JPanel {
    
    public static String TIPO_BOTON_NORMAL = "NORMAL";
    public static String TIPO_BOTON_VIP    = "VIP";
    
    public JLabel JLabelProductoBalanza00      = new JLabel();
    public JLabel JLabelProductoBalanza01      = new JLabel();
    public JLabel JLabelProductoBalanza02      = new JLabel();
    public JLabel JLabelProductoBalanzaCirculo = new JLabel(); 
    public JLabel JLabelProductos              = new JLabel();    
    
    public ByosBotonProductos(String TipoBoton){
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        if(TipoBoton.equals(ByosBotonProductos.TIPO_BOTON_VIP)){
           this.setSize(new Dimension(101,87)); 
        }else{
           this.setSize(new java.awt.Dimension(0,0));
        }
        InicializarBoton();               
    }
    
    public void setEstado(String Estado){        
        switch(Estado){
            case "BUENO":
                JLabelProductoBalanzaCirculo.setBackground(Color.GREEN);
                JLabelProductoBalanzaCirculo.setOpaque(true);                
                break;
            case "REGULAR":
                JLabelProductoBalanzaCirculo.setBackground(Color.YELLOW);
                JLabelProductoBalanzaCirculo.setOpaque(true);                  
                break;
            case "MALO":
                JLabelProductoBalanzaCirculo.setBackground(Color.RED);
                JLabelProductoBalanzaCirculo.setOpaque(true);                 
                break;
            default:
                JLabelProductoBalanzaCirculo.setBackground(Color.GREEN);
                JLabelProductoBalanzaCirculo.setOpaque(false);                  
                break;
        }
    }
    
    private void InicializarBoton() {
        JLabelProductoBalanza00 = new JLabel();
        Border border = JLabelProductoBalanza00.getBorder();
        Border margin = new EmptyBorder(2, 2, 2, 2);
        
        
        JLabelProductoBalanza00.setBorder(new CompoundBorder(border, margin));
        JLabelProductoBalanza00.setForeground(Color.red);
        JLabelProductoBalanza00.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza00.setFont(new java.awt.Font("Consolas", 0, 12));
        JLabelProductoBalanza00.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabelProductoBalanza00.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JLabelProductoBalanza00.setOpaque(false);

        this.add(JLabelProductoBalanza00, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 87, 87));

        JLabelProductoBalanza01 = new JLabel();
        JLabelProductoBalanza01.setBackground(Color.red);
        JLabelProductoBalanza01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza01.setFont(new java.awt.Font("Consolas", 0, 10));
        JLabelProductoBalanza01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza01.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza01.setOpaque(false);

        this.add(JLabelProductoBalanza01, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 20, 20));

        JLabelProductoBalanza02 = new JLabel();
        JLabelProductoBalanza02.setBackground(Color.red);
        JLabelProductoBalanza02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza02.setFont(new java.awt.Font("Consolas", 0, 10));
        JLabelProductoBalanza02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza02.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanza02.setOpaque(false);

        this.add(JLabelProductoBalanza02, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 5, 20, 20));

        JLabelProductoBalanzaCirculo = new JLabel();
        JLabelProductoBalanzaCirculo.setBackground(Color.GREEN);
        JLabelProductoBalanzaCirculo.setOpaque(false);
        JLabelProductoBalanzaCirculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanzaCirculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelProductoBalanzaCirculo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        this.add(JLabelProductoBalanzaCirculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 15, 15));
        
        
        JLabelProductos = new JLabel();
        JLabelProductos.setOpaque(true);
        JLabelProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.add(JLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 87, 87));

    }
    
}
