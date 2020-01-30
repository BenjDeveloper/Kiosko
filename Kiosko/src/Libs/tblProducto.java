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
public class tblProducto {
    
    private  String descripcioncorta;
    private  javax.swing.ImageIcon imagen;
    private String costo;

    public tblProducto(String descripcioncorta, javax.swing.ImageIcon imagen, String costo) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = imagen;
        this.costo = costo;
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
    
    
    public String getcosto() {
        return costo;
    }

    public void setcosto(String costo) {
        this.costo = costo;
    } 

}
