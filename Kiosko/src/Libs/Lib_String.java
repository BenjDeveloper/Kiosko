/*
 * Lib_String.java
 *
 * Created on 6 de agosto de 2007, 01:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Libs;

import java.util.Calendar;

/**
 *
 * @author Informatica
 */
public class Lib_String {
    
    /** Creates a new instance of Lib_String */
    public Lib_String() {
    }
// Funciones de Manejo de String    

    public static boolean strchar(String Palabra, String Buscar){
           for(int f=0;f<Palabra.length();f++){
               if(Buscar.equals(Palabra.substring(f, f+1))) return true;
           }
           return false;            
    }
    
    public static int Buscar_Palabra(String xBuscar, String xCadena){
        int c= xBuscar.length();
        
        for (int f=0;f<xCadena.length()-(c-1);f++)
            if(xBuscar.toString().equals(xCadena.substring(f,f+c))) return f;
        
        return -1;    
    }
    
    public static boolean Buscar_Palabra2(String xBuscar, String xCadena){
        String cadenaDondeBuscar =  xCadena;
        String loQueQuieroBuscar = xBuscar;
        String[] palabras = loQueQuieroBuscar.split("\\s+");
        for (String palabra : palabras) {
            if (cadenaDondeBuscar.contains(palabra)) {
                return true;
            }
        }
        return false;
    }
    

    
    public static boolean isNumber(String Numero){
        for (int f=0;f<Numero.length();f++)
            if(!strchar("1234567890+-.",Numero.substring(f,f+1))) return false;
        return true;
    }
            
    public static String Add_String(String Cadena, char Relleno, int Cantidad){
         String Aux=Cadena;
         for(int f=0;f<(Cantidad-Cadena.length());f++)
             Aux = Aux + Relleno;
         return Aux;
    }

     public static String Add_String_D(String Cadena, char Relleno, int Cantidad){
         String Aux=Cadena;
         for(int f=0;f<(Cantidad-Cadena.length());f++)
             Aux = Aux + Relleno;
         return Aux;
    }

    public static String Add_String_I(String Cadena, char Relleno, int Cantidad){
         String Aux=Cadena;
         for(int f=0;f<(Cantidad-Cadena.length());f++)
             Aux = Relleno + Aux;
         return Aux;
    }



    public static String isFecha(String Fecha, String Formato){
        String AuxFecha="";
        //0414-8867518
        Formato=Formato.toUpperCase();
        
        if(Fecha.length()<8) return null;
        
        
        if((Formato.equals("DD/MM/YYYY") | Formato.equals("DD-MM-YYYY")) & Fecha.length()==10){
           AuxFecha=Fecha.substring(6,10) + "-" + Fecha.substring(3,5) + "-" + Fecha.substring(0,2);
        }
        if((Formato.equals("YYYY-MM-DD") | Formato.equals("YYYY-MM-DD")) & Fecha.length()==10){
           AuxFecha=Fecha.substring(0,4) + "-" + Fecha.substring(5,7) + "-" + Fecha.substring(8,10);
        }

        if((Formato.equals("DDMMYYYY") | Formato.equals("DDMMYYYY")) & Fecha.length()==10){
           AuxFecha=Fecha.substring(4,7) + "-" + Fecha.substring(2,3) + "-" + Fecha.substring(0,1);
        }
        if((Formato.equals("YYYYMMDD") | Formato.equals("YYYYMMDD")) & Fecha.length()==10){
           AuxFecha=Fecha.substring(0,3) + "-" + Fecha.substring(4,5) + "-" + Fecha.substring(6,7);
        }
        try{
           java.sql.Date xFecha = java.sql.Date.valueOf(AuxFecha);
           if (!AuxFecha.equals(xFecha.toString())) return null;
        } 
        catch ( IllegalArgumentException e ){ return null; }   
        return AuxFecha;
    }
    
    public static String Filtro(String Palabra, String Filtro){
        String Filtrado="";
        for(int f=0;f<Palabra.length();f++){
           if(strchar(Filtro,Palabra.substring(f, f+1))){
               Filtrado = Filtrado + Palabra.substring(f, f+1);
           }
        }
        return Filtrado;
    }

    public static String ToDay(){
        Calendar Fecha = Calendar.getInstance();

        String Fecha_Actual=
               Add_String_I(String.valueOf(Fecha.get(Calendar.DATE)),'0',2) + "/" +
               Add_String_I(String.valueOf(Fecha.get(Calendar.MONTH)+1),'0',2) + "/" +
               String.valueOf(Fecha.get(Calendar.YEAR));

        return Fecha_Actual;
    }

    public static String ToDaySql(){
        Calendar Fecha = Calendar.getInstance();

        String Fecha_Actual=
               String.valueOf(Fecha.get(Calendar.YEAR)) + "-" +
               Add_String_I(String.valueOf(Fecha.get(Calendar.MONTH)+1),'0',2) + "-" +
               Add_String_I(String.valueOf(Fecha.get(Calendar.DATE)),'0',2);


        return Fecha_Actual;
    }

    public static String Nombre_Mes(String xFecha){
        String xmes01=xFecha.substring(5, 7);
        int xmes=(Integer.valueOf(xmes01)).intValue();
        switch (xmes){
                case 1:
                    return "Enero";
                case 2:
                    return "Febrero";
                case 3:
                    return "Marzo";
                case 4:
                    return "Abril";
                case 5:
                    return "Mayo";
                case 6:
                    return "Junio";
                case 7:
                    return "Julio";
                case 8:
                    return "Agosto";
                case 9:
                    return "Septiembre";
                case 10:
                    return "Obtubre";
                case 11:
                    return "Noviembre";
                case 12:
                    return "Diciembre";
        }
        return "Error";
    }
   // Fin Funciones de Manejo de String    
}

