/*
 * Lib_Archivo.java
 *
 * Created on 7 de agosto de 2007, 03:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Libs;
import byoscalendario.ByosDate;
import java.io.*;
import java.util.HashMap;
/**
 *
 * @author Informatica
 */
public class Lib_Archivo {
   
    /** Creates a new instance of Lib_Archivo */
    public Lib_Archivo() {
    }
    // Funciones de Manejo de Archivos

   public static int SEC=0;
   
    public static String NombreArchivoFecha(String InicioArchivo, String Extension){
        return InicioArchivo + ByosDate.FormatoFecha(ByosDate.FechaHora(), "yyyyMMddHHmmss") + Extension;
    }
   
    public static class FileListFilter implements FilenameFilter {
       private String name;        // File name filter
       private String extension;   // File extension filter

  // Constructor
       public FileListFilter(String name, String extension) {
           this.name = name;
           this.extension = extension;
       }

       public boolean accept(File directory, String filename) {
           boolean fileOK = true;

          // If there is a name filter specified, check the file name
          if (name != null)
          fileOK &= filename.startsWith(name);

          // If there is an extension filter, check the file extension
          if (extension != null)
             fileOK &= filename.endsWith('.' + extension);

          return fileOK;
       }
   }
    
    public static int Cont_Campos(String xRegistro){
        int c=0;
        if (xRegistro!=null){
           for(int f=0;f<xRegistro.length();f++)
               if (xRegistro.charAt(f)==LIMITE) c++;
           if (c!=0) return c-1;
           else return 0;
        }else return 0;
    }

    public static String Leer_Campos(String xRegistro,int xCampo){
        int c=0;
        int inicio=0;
        int fin=0;
        int f=0;
        
        if (Cont_Campos(xRegistro)>=xCampo){
           for(f=0;f<xRegistro.length();f++)
               if (xRegistro.charAt(f)==LIMITE){
                  c++;
                  if(c==xCampo){
                    inicio=f+1;
                    break;
                  }
               }

           for(f=inicio;f<xRegistro.length();f++)
               if (xRegistro.charAt(f)==LIMITE) {
                  fin=f;
                  break;           
               }
        
           if (inicio==fin) return null;
           else return xRegistro.substring(inicio,fin);
        }
        return null;
    }        


    public static BufferedReader Abrir_Archivo(String xArchivo){
      File xFile = new File(xArchivo);
      try { 
          BufferedReader Entrada = new BufferedReader( new FileReader( xFile ) );
          return Entrada;
          
      } catch ( IOException e ){}
      
      return null;
    }

    public static int Archivo_Len(String xArchivo){
      int c=0;
      try { 
          BufferedReader Entrada=Abrir_Archivo(xArchivo);
          String Line;
          while ((Line=Entrada.readLine()) != null){
                c++;
          }
          Entrada.close();
      } catch ( IOException e ){}
      return c; 
    }
    
    public static String Leer_Linea(String xArchivo,int Linea){
        String Line;
        int c=0;
        if (Archivo_Len(xArchivo)>0){
           try { 
                BufferedReader Entrada=Abrir_Archivo(xArchivo);
                while ((Line=Entrada.readLine()) != null){
                      c++;
                      if (c==Linea){
                          Entrada.close();
                          return Line.toString();
                      }    
               }
               Entrada.close(); 
           } catch ( IOException e ){}
        }
        return null; 
    }
    
// Buscar Si Un Programa Se Esta Ejecutanto Solo Para Windows
    public static int Buscar_Programa(String xTitulo){
           try {
               
               Process p = Runtime.getRuntime().exec("tasklist /FI \"WINDOWTITLE eq " + xTitulo + "*\"");
               BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
               String line;
               if ( ( line = reader.readLine() ) != null ) {
                         reader.close();
                         return 1;
               }
               reader.close();
           } catch ( IOException e ){}
           
           return 0;
    }
    
    public static boolean Ejecutar(String Comando){
        try {
            Runtime.getRuntime().exec(Comando);
            return true;
        } catch ( IOException e ){ return false; }    
    }
    
    public static String Leer_Ini(String Archivo_Ini, String xVariable, String Default){
      File xFile = new File(Archivo_Ini);
      try { 
          BufferedReader Entrada = new BufferedReader( new FileReader( xFile ) );
          if ( xFile.exists() ) {
              String Line;
              while ((Line=Entrada.readLine()) != null){
                    if (Lib_String.Buscar_Palabra(xVariable,Line.toString())>=0 ){
                        for(int f=0;f<Line.toString().length();f++)
                            if(Line.toString().charAt(f)=='='){
                               Entrada.close(); 
                               return Line.toString().substring(f+1,Line.toString().length()).trim(); 
                            }
                    }
               }
          }      
          Entrada.close();
      } catch ( IOException e ){}
      return ""; 
    }
    
    public static String Leer_Dir(String xDir,String FileName,String Extension){
       int f=0;
       FilenameFilter select = new FileListFilter(FileName, Extension);
       File xFile = new File(xDir);
       if (xFile.isDirectory()){
           
           String xList_Dir[] = xFile.list(select);
           if (xList_Dir.length>0)
              if (xFile.getPath().length()<=3)
                  return xFile.getPath()+xList_Dir[0]; 
              else
                  return xFile.getPath()+"\\"+xList_Dir[0];
       }
       return null;
    }
    
    public static boolean Borrar(String xArchivo){
      File xFile = new File(xArchivo);
      if (xFile.isFile()){
          boolean a=xFile.delete();
          return a;
      }
      return false;
    }
    
    public static boolean Buscar_Archivo(String xArchivo){
      File xFile = new File(xArchivo);
      if (xFile.isFile()){
          return true;
      }
      return false;
    }
   
 

    
    
    public static char LIMITE = '|';
    public static HashMap Map_Archivo;
   
// Fin Funcion Manejo de archivo
}