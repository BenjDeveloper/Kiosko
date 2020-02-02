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
        map.put("Sector 0", new String[]{"Familia 0A" });
        map.put("Sector 1", new String[]{"Familia 1A","Familia 1B", "Familia 1C", "Familia 1D" });
        map.put("Sector 2", new String[]{"Familia 2A", "Familia 2B", "Familia 2C"});
        map.put("Sector 3", new String[]{"Familia 3A", "Familia 3B", "Familia 3C", "Familia 3D"});
        map.put("Sector 4", new String[]{"Familia 4A"});
        map.put("Sector 5", new String[]{"Familia 5A", "Familia 5B", "Familia 5C", "Familia 5D", "Familia 5E", "Familia 5F", "Familia 5G"});
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
        for (Integer i = 0; i< map.size(); i++ ) {
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
        mapItems.put("Familia 0A", new String[]{ "Mokachino", "Capuchino","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5","img1A0", "img1A1"});
        
        mapItems.put("Familia 1A", new String[]{"Mokachino", "img0A0", "img0A1", "Latte", "Capuchino","img0A2","img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 1B", new String[]{"Latte", "Mokachino", "Capuchino"});
        mapItems.put("Familia 1C", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 1D", new String[]{"img0A0", "img0A1", "img0A2"});
        
        mapItems.put("Familia 2A", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 2B", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 2C", new String[]{"img0A0", "img0A1", "img0A2"});
        
        mapItems.put("Familia 3A", new String[]{"img1B0"});
        mapItems.put("Familia 3B", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 3C", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 3D", new String[]{"img0A0", "img0A1", "img0A2"});
        
        mapItems.put("Familia 4A", new String[]{"img0A0", "img0A1", "img0A2"});
       
        mapItems.put("Familia 5A", new String[]{"img1A0", "img1A1", "img1A2", "img1A3", "img1A4", "img1A5", "img1A6"});
        mapItems.put("Familia 5B", new String[]{"img2C0","img2C1"});
        mapItems.put("Familia 5C", new String[]{"img0A0", "img0A1", "img0A2"});
        mapItems.put("Familia 5D", new String[]{"img2C0"});
        mapItems.put("Familia 5E", new String[]{"img2C1"});
        mapItems.put("Familia 5F", new String[]{"img2C0","img2C1"});
        mapItems.put("Familia 5G", new String[]{"img2C0","img2C1", "img2C0","img2C1", "img2C0","img2C1", "img2C0","img2C1"});
        
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
        
        
        Map<String,String> mapVal = new HashMap();
        mapVal.put("Sector 0", "TODOS LOS SECTORES");
        mapVal.put("Sector 1", "CAFETERIA");
        mapVal.put("Sector 2", "HOTEL");
        mapVal.put("Sector 3", "BAR");
        mapVal.put("Sector 4", "TERRAZAS");
        mapVal.put("Sector 5", "PISINA");
        mapVal.put("Sector 6", "RESTAURAN");
        mapVal.put("Sector 7", "SPA");
        
        mapVal.put("Familia 0A", "ARTICULOS MAS VENDIDOS");
 
        mapVal.put("Familia 1A", "ARTICULOS MAS VENDIDOS");
        mapVal.put("Familia 1B", "CAFES");
        mapVal.put("Familia 1C", "BOLLERIA");
        mapVal.put("Familia 1D", "SANDWICH");
        
        mapVal.put("Familia 2A", "ARTICULOS MAS VENDIDOS");
        mapVal.put("Familia 2B", "SERVICIOS DE HABITACION");
        mapVal.put("Familia 2C", "MANTENIMIENTO");
        
        mapVal.put("Familia 3A", "ARTICULOS MAS VENDIDOS");
        mapVal.put("Familia 3B", "COCTELES");
        mapVal.put("Familia 3C", "BATIDOS");
        mapVal.put("Familia 3D", "BEBIDAS");
        
        mapVal.put("Familia 4A", "ARTICULOS MAS VENDIDOS");
        
        mapVal.put("Familia 5A", "ARTICULOS MAS VENDIDOS");
        mapVal.put("Familia 5B", "5B");
        mapVal.put("Familia 5C", "5C");
        mapVal.put("Familia 5D", "5D");
        mapVal.put("Familia 5E", "5E");
        mapVal.put("Familia 5F", "5F");
        mapVal.put("Familia 5G", "5G");
        
        mapVal.put("Familia 6A", "ARTICULOS MAS VENDIDOS");
        
        mapVal.put("Familia 7A", "ARTICULOS MAS VENDIDOS");
        
        
        
        this.sector = new tblSector[map.size()]; // ARRAY DE SECTORES
        int j = 0;
        for (Integer s = 0; s < map.size(); s++){
            String key = "Sector "+s.toString();
            String[] value = map.get(key);
            
            if (!key.isEmpty()){
                //System.err.println("mapVal.get("+key+") = "+mapVal.get(key));
                this.sector[j] = new tblSector(mapVal.get(key), mapImg.get(key)[0]); // CREO EL SECTOR
                this.sector[j].familia = new  tblFamilia[value.length]; // ARRAY DE FAMILIAS DE ESE SECTOR

                for(Integer i = 0; i< value.length; i++ ){ // value = new String[]{"Familia 2A", "Familia 2B", "Familia 2C"}
                    if (!value[i].isEmpty()){
                        //System.err.println("mapVal.get("+value[i]+") = "+mapVal.get(value[i]));
                        this.sector[j].familia[i] = new tblFamilia(mapVal.get(value[i]) ,mapImg.get(value[i].substring(0, value[i].length()-1))[i] );

                        this.sector[j].familia[i].producto = new tblProducto[mapItems.get(value[i]).length];

                        for(Integer u=0; u< mapItems.get(value[i]).length; u++) {
                            Integer randomInt = ThreadLocalRandom.current().nextInt(10, 20);
                            if (this.sector[j].familia[i].getDescripcionCorta().equals("CAFES")) {
                                if (u == 0) this.sector[j].familia[i].producto[u] = new tblProducto("LATTE", mapImg.get(value[i])[u], "3");
                                if (u == 1) this.sector[j].familia[i].producto[u] = new tblProducto("MOKACHINO", mapImg.get(value[i])[u], "5");
                                if (u == 2) this.sector[j].familia[i].producto[u] = new tblProducto("CAPUCHINO", mapImg.get(value[i])[u], "6");
                                 
                            } else if (this.sector[j].familia[i].getDescripcionCorta().equals("ARTICULOS MAS VENDIDOS") && i==0 && j==0) {
                                if (u == 0) this.sector[j].familia[i].producto[u] = new tblProducto("MOKACHINO", mapImg.get(value[i])[u], "5");
                                else if (u == 1) this.sector[j].familia[i].producto[u] = new tblProducto("CAPUCHINO", mapImg.get(value[i])[u], "6"); 
                                else this.sector[j].familia[i].producto[u] = new tblProducto("Descripcion corta", mapImg.get(value[i])[u], randomInt.toString());
                            
                            } else if (this.sector[j].familia[i].getDescripcionCorta().equals("ARTICULOS MAS VENDIDOS") && i==0 && j==1) {
                                if (u == 0) this.sector[j].familia[i].producto[u] = new tblProducto("MOKACHINO", mapImg.get(value[i])[u], "5");
                                else if (u == 3) this.sector[j].familia[i].producto[u] = new tblProducto("LATTE", mapImg.get(value[i])[u], "3");
                                else if (u == 4) this.sector[j].familia[i].producto[u] = new tblProducto("CAPUCHINO", mapImg.get(value[i])[u], "6"); 
                                else this.sector[j].familia[i].producto[u] = new tblProducto("Descripcion corta", mapImg.get(value[i])[u], randomInt.toString());
                            }
                            else
                                this.sector[j].familia[i].producto[u] = new tblProducto("Descripcion corta", mapImg.get(value[i])[u], randomInt.toString());
                        }
                    }
                }
                j++;
            }
        }
    }
    
    
    
}
