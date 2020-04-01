/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author TPV
 */
public class ByosImagen {

    public static ImageIcon resizeImagen(Image xImage, int newW, int newH) {
        if(xImage==null){
            return null;
        }
        double EscalaH = 100 - Double.valueOf(newH) / Double.valueOf(xImage.getHeight(null)) * 100;
        double EscalaW = 100 - Double.valueOf(newW) / Double.valueOf(xImage.getWidth(null)) * 100;
        double Escala = EscalaH > EscalaW ? EscalaH : EscalaW;
        if (Escala > 0) {
            int xEscalaH = xImage.getHeight(null) - Double.valueOf(Double.valueOf(xImage.getHeight(null)) * Escala / 100).intValue();
            int xEscalaW = xImage.getWidth(null) - Double.valueOf(Double.valueOf(xImage.getWidth(null)) * Escala / 100).intValue();
            Image imgEscalada = xImage.getScaledInstance(xEscalaW, xEscalaH, Image.SCALE_SMOOTH);

            return new ImageIcon(imgEscalada);
        } else {
            return new ImageIcon(xImage);
        }

    }
    
    public static ImageIcon TamanioImagen(Image xImage, int newW, int newH) {
        if(xImage==null){
            return null;
        }
        //double EscalaH = 100 - Double.valueOf(newH) / Double.valueOf(xImage.getHeight(null)) * 100;
        //double EscalaW = 100 - Double.valueOf(newW) / Double.valueOf(xImage.getWidth(null)) * 100;
        //double Escala = EscalaH > EscalaW ? EscalaH : EscalaW;
        //if (Escala > 0) {
        //    int xEscalaH = xImage.getHeight(null) - Double.valueOf(Double.valueOf(xImage.getHeight(null)) * Escala / 100).intValue();
        //    int xEscalaW = xImage.getWidth(null) - Double.valueOf(Double.valueOf(xImage.getWidth(null)) * Escala / 100).intValue();
            Image imgEscalada = xImage.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);

            return new ImageIcon(imgEscalada);
        //} else {
        //    return new ImageIcon(xImage);
        //}

    }    
    
    
    public static Image IconAImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
        
    }
    
    public static Icon JLabelAjustarIcono(JLabel Label, Icon Icono){
        return ByosImagen.TamanioImagen(ByosImagen.IconAImage(Icono),  Label.getWidth(),  Label.getHeight());       
    }
    
}
