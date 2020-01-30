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
public class tblSector {
    
    private String descripcioncorta;
    private  javax.swing.ImageIcon imagen;
    public tblFamilia[] familia;

    public tblSector(String descripcioncorta, javax.swing.ImageIcon imagen, tblFamilia[] familia) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = imagen;
        this.familia = familia;
    }

    public tblSector(String descripcioncorta, javax.swing.ImageIcon imagen) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = imagen;
        this.familia = null;
    }
    
    public tblSector(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
        this.imagen = null;
        this.familia = null;
        
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
