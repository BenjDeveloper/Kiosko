/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Libs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author TPV
 */
public class Datos {

    public tblSector[] sector;

    public Datos() {
    }

    public void CargaDatos(){

        Map<String,String[]> map = new HashMap();
        map.put("Sector 0", new String[]{"Familia 0A", "Familia 0B", "Familia 0C", "Familia 0D", "Familia 0E", "Familia 0F", "Familia 0G"});
        map.put("Sector 1", new String[]{"Familia 1A","Familia 1B"});
        map.put("Sector 2", new String[]{"Familia 2A", "Familia 2B", "Familia 2C"});
        map.put("Sector 3", new String[]{"Familia 3A"});
        map.put("Sector 4", new String[]{"Familia 4A"});
        map.put("Sector 5", new String[]{"Familia 5A"});
        map.put("Sector 6", new String[]{"Familia 6A"});
        map.put("Sector 7", new String[]{"Familia 7A"});
        
        Map<String,javax.swing.ImageIcon[]> mapImg = new HashMap();
        String path;
        for (Integer i = 0; i< map.size(); i++ ){
            javax.swing.ImageIcon[] imagenes = new javax.swing.ImageIcon[1];
            path = "static/sec"+i.toString()+".png";
            javax.swing.ImageIcon ele = new javax.swing.ImageIcon(path);
            imagenes[0] = ele;
            mapImg.put("Sector "+i.toString(),imagenes);  
        }

        String[] letra = new String[]{"A", "B" , "C", "D", "E", "F", "G"};
        for (Integer i = 0; i<= map.size(); i++ ) {
            String key = "Sector 0";
            if (i==1) key = "Sector 1";
            if (i==2) key = "Sector 2";
            if (i==3) key = "Sector 3";
            if (i==4) key = "Sector 4";
            if (i==5) key = "Sector 5";
            if (i==6) key = "Sector 6";
            if (i==7) key = "Sector 7";
            javax.swing.ImageIcon[] imagenes = new javax.swing.ImageIcon[ map.get(key).length];
            for (int ii = 0; ii<  map.get(key).length; ii++) {
                path = "static/fam"+i.toString()+letra[ii]+".png";
                javax.swing.ImageIcon ele = new javax.swing.ImageIcon(path);
                imagenes[ii] = ele;
            }
            mapImg.put("Familia "+i.toString(),imagenes); 
        }
        
        Map<String,String[]> mapItems = new HashMap();
        mapItems.put("Familia 3A", new String[]{"img0A0", "img0A1", "img0A2"});
        
        mapItems.put("Familia 1A", new String[]{"img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6"});
        mapItems.put("Familia 1B", new String[]{"img1B0"});
        
        mapItems.put("Familia 2A", new String[]{"img2A0","img2A1"});
        mapItems.put("Familia 2B", new String[]{"img2B0","img2B1"});
        mapItems.put("Familia 2C", new String[]{"img2C0","img2C1"});
        
        mapItems.put("Familia 0A", new String[]{"img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5"});
        mapItems.put("Familia 0B", new String[]{"img2C0","img2C1"});
        mapItems.put("Familia 0C", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 0D", new String[]{"img2C0"});
        mapItems.put("Familia 0E", new String[]{"img2C1"});
        mapItems.put("Familia 0F", new String[]{"img2C0","img2C1"});
        mapItems.put("Familia 0G", new String[]{"img2C0","img2C1", "img2C0","img2C1", "img2C0","img2C1", "img2C0","img2C1"});
        
        mapItems.put("Familia 4A", new String[]{"img0A0", "img0A1", "img0A2"});
       
        mapItems.put("Familia 5A", new String[]{"img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6"});
       
        mapItems.put("Familia 6A", new String[]{"img1B0"});
       
        mapItems.put("Familia 7A", new String[]{"img0A1", "img0A2"});
       
        
        
        //productos
        for (Map.Entry<String, String[]> entry : mapItems.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            
            javax.swing.ImageIcon[] imagenes = new javax.swing.ImageIcon[value.length];
            for(Integer i=0; i<value.length; i++) {
                path = "static/"+value[i]+".png";
                javax.swing.ImageIcon ele = new javax.swing.ImageIcon(path);
                imagenes[i] = ele;
            }
            mapImg.put(key,imagenes); 
        }

        this.sector = new tblSector[map.size()]; // ARRAY DE SECTORES
        int j = 0;
        for (Integer s = 0; s < map.size(); s++){
            String key = "Sector "+s.toString();
            String[] value = map.get(key);

            this.sector[j] = new tblSector(key, mapImg.get(key)[0]); // CREO EL SECTOR
            this.sector[j].familia = new  tblFamilia[value.length]; // ARRAY DE FAMILIAS DE ESE SECTOR
            
            for(Integer i = 0; i< value.length; i++ ){ // value = new String[]{"Familia 2A", "Familia 2B", "Familia 2C"}
                this.sector[j].familia[i] = new tblFamilia(value[i],mapImg.get(value[i].substring(0, value[i].length()-1))[i] );
                
                this.sector[j].familia[i].producto = new tblProducto[mapItems.get(value[i]).length];
                
                for(Integer u=0; u< mapItems.get(value[i]).length; u++) {
                    Integer randomInt = ThreadLocalRandom.current().nextInt(10, 50);
                    this.sector[j].familia[i].producto[u] = new tblProducto("Descripcion corta", mapImg.get(value[i])[u], randomInt.toString());
                }
            }
            j++;
        }
        System.out.println("");
    }
    
    
    
}
