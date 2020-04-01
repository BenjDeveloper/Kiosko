/*
 * Lib_String.java
 *
 * Created on 2 de enero de 2007, 01:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package byoscalendario;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.regex.Pattern;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
/**
 *
 * @author Informatica
 */
public class Lib_String {

    /**
     * Creates a new instance of Lib_String
     */
    public Lib_String() {

    }
    // Funciones de Manejo de String    

    public static boolean strchar(String Palabra, String Buscar) {
        for (int f = 0; f < Palabra.length(); f++) {
            if (Buscar.equals(Palabra.substring(f, f + 1))) {
                return true;
            }
        }
        return false;
    }

    public static int Buscar_Palabra(String xBuscar, String xCadena) {
        int c = xBuscar.length();

        for (int f = 0; f < xCadena.length() - (c - 1); f++) {
            if (xBuscar.toString().equals(xCadena.substring(f, f + c))) {
                return f;
            }
        }

        return -1;
    }

    public static boolean isNumber(String Numero) {
        for (int f = 0; f < Numero.length(); f++) {
            if (!strchar("1234567890+-.", Numero.substring(f, f + 1))) {
                return false;
            }
        }
        return true;
    }

    public static String Add_String(String Cadena, char Relleno, int Cantidad) {
        String Aux = Cadena;
        for (int f = 0; f < (Cantidad - Cadena.length()); f++) {
            Aux = Aux + Relleno;
        }
        return Aux;
    }

    public static String Add_String_D(String Cadena, char Relleno, int Cantidad) {
        String Aux = Cadena;
        for (int f = 0; f < (Cantidad - Cadena.length()); f++) {
            Aux = Aux + Relleno;
        }
        return Aux;
    }

    public static String Add_String_I(String Cadena, char Relleno, int Cantidad) {
        String Aux = Cadena;
        for (int f = 0; f < (Cantidad - Cadena.length()); f++) {
            Aux = Relleno + Aux;
        }
        return Aux;
    }

    public static String Fecha_Actual() {
        java.util.Calendar c1 = java.util.Calendar.getInstance();
        String Anio = String.valueOf(c1.get(c1.YEAR));
        String Mes = String.valueOf(c1.get(c1.MONTH));
        String Dia = String.valueOf(c1.get(c1.DAY_OF_MONTH));
        Dia = Dia.length() < 2 ? "0" + Dia : Dia;
        Mes = Mes.length() < 2 ? "0" + Mes : Mes;
        return Anio + Mes + Dia;
    }
    // Fin Funciones de Manejo de String    
    
    
    
    
    public static void CashDrawerOpen() {

        String code1 = "27 112 0 150 250";
        String code = "ESCp0û.";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(code1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.TEXT_PLAIN_US_ASCII;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
