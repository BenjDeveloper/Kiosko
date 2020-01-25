/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libs;


/**
 *
 * @author TPV
 */
public class tblFamilia {
    
    private String descripcioncorta;
    private  javax.swing.ImageIcon imagen;
    public tblProducto[] producto;
    
    public tblFamilia(String descripcioncorta, javax.swing.ImageIcon imagen, tblProducto[] producto) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = imagen;
        this.producto = producto;
    }

    public tblFamilia(String descripcioncorta, javax.swing.ImageIcon imagen) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = imagen;
        this.producto = null;
    }

    public tblFamilia(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = null;
        this.producto = null;
        
    }
    
    public String getDescripcionCorta() {
        return descripcioncorta;
    }

    public void setDescripcionCorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }
    
    public javax.swing.ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(javax.swing.ImageIcon imagen) {
        this.imagen = imagen;
    }
    
}
