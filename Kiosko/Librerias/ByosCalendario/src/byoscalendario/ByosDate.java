package byoscalendario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ByosDate {

    public ByosDate() {
    }

    public static java.sql.Date Fecha() {
        java.util.Date FechaActual = new java.util.Date();
        java.sql.Date ff = new java.sql.Date(FechaActual.getTime());
        return ff;
    }

    public static java.sql.Time Hora() {
        java.util.Date FechaActual = new java.util.Date();
        java.sql.Time hh = new java.sql.Time(FechaActual.getTime());
        return hh;
    }

    public static String FormatoFecha(java.util.Date Fecha, String Formato) {
        DateFormat df = new SimpleDateFormat(Formato);
        return df.format(Fecha);
    }

    public static java.util.Date StringAFecha(String Fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date FechaDate = null;
        try {
            FechaDate = formato.parse(Fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return FechaDate;
    }
    
    public static java.sql.Date UtilFechaASqlFecha(java.util.Date Fecha) {
      return new java.sql.Date( Fecha.getTime() );       
    }
    
    public static int UltimoDiaMes(Date Fecha){
        int Mes = getMes(Fecha);
        int Anio = getAnio(Fecha);
        Mes++;
        if(Mes>12){
            Mes = 1;
            Anio++;
        }
        String FechaString = "01/" + Lib_String.Add_String_I("" + Mes,'0',2) + "/" + Anio;       
        return getDia(CalculoFecha(StringAFecha(FechaString), -1));      
    }

    public static Date CalculoFecha(Date date, int Dias) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        calendarDate.add(Calendar.DAY_OF_MONTH, Dias);

        java.sql.Date ff = new java.sql.Date(calendarDate.getTime().getTime());
        //System.out.println(date.toString() + " " + ff.toString());
        return ff;
    }
    
    public static Date CalculoFecha(java.util.Date date, int Dias) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        calendarDate.add(Calendar.DAY_OF_MONTH, Dias);

        java.sql.Date ff = new java.sql.Date(calendarDate.getTime().getTime());
        //System.out.println(date.toString() + " " + ff.toString());
        return ff;
    }


    public static int getAnio(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "yyyy"));
    }

    public static int getMes(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "MM"));
    }

    public static int getDia(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "dd"));
    }

    public static int getHora(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "HH"));
    }

    public static int getMinuto(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "mm"));
    }

    public static int getSegundo(Date Fecha) {
        return Integer.valueOf(FormatoFecha(Fecha, "ss"));
    }

    public static java.sql.Timestamp FechaHora() {
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
        return sqlTimestamp;
    }

    public static java.sql.Timestamp DateToTimestamp(java.util.Date Fecha) {
        if (Fecha != null) {
            java.sql.Timestamp Fecha01 = new java.sql.Timestamp(Fecha.getTime());
            return Fecha01;
        } else {
            return null;
        }
    }

    public static int compararFechas(java.util.Date xFecha1, java.util.Date xFechaActual) {
        java.util.Date Conversor = new java.util.Date();
        Conversor.setTime(xFecha1.getTime());
        String fecha1 = FormatoFecha(Conversor, "dd/MM/yyyy");
        Conversor.setTime(xFechaActual.getTime());
        String fechaActual = FormatoFecha(Conversor, "dd/MM/yyyy");

        int resultado = 0;
        try {
            /**
             * Obtenemos las fechas enviadas en el formato a comparar
             */
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaDate1 = formateador.parse(fecha1);
            java.util.Date fechaDate2 = formateador.parse(fechaActual);
            if (fechaDate1.before(fechaDate2)) {
                resultado = 1;
            } else {
                if (fechaDate2.before(fechaDate1)) {
                    resultado = -1;
                } else {
                    resultado = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return resultado;
    }

    public static int compararFechas(Date xFecha1, Date xFechaActual) {
        java.util.Date Conversor = new java.util.Date();
        Conversor.setTime(xFecha1.getTime());
        String fecha1 = FormatoFecha(Conversor, "dd/MM/yyyy");
        Conversor.setTime(xFechaActual.getTime());
        String fechaActual = FormatoFecha(Conversor, "dd/MM/yyyy");

        int resultado = 0;
        try {
            /**
             * Obtenemos las fechas enviadas en el formato a comparar
             */
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaDate1 = formateador.parse(fecha1);
            java.util.Date fechaDate2 = formateador.parse(fechaActual);
            if (fechaDate1.before(fechaDate2)) {
                resultado = 1;
            } else {
                if (fechaDate2.before(fechaDate1)) {
                    resultado = -1;
                } else {
                    resultado = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Se Produjo un Error!!!  " + e.getMessage());
        }
        return resultado;
    }

    public static String getEdad(java.util.Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
            }
            return result.toString();
        }
        return "";
    }

    public static String getEdad(Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
            }
            return result.toString();
        }
        return "";
    }

    public static int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si est� en ese a�o pero todav�a no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        return diffYear;
    }

    public static int calculoDias(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
        return dias;
    }

    public static java.util.Date SumaRestarFecha(java.util.Date fecha, int sumaresta, String opcion) {
        Calendar calendar = Calendar.getInstance();
        try {

            calendar.setTime(fecha);
            switch (opcion) {
                case "DIAS":
                    calendar.add(Calendar.DAY_OF_WEEK, sumaresta);

                    break;

                case "MESES":
                    calendar.add(Calendar.MONTH, sumaresta);

                    break;

                case "AÑOS":
                    calendar.add(Calendar.YEAR, sumaresta);

                    break;

                default:
                    System.out.println("parametro enviado al Switch no concuerda");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error:\n" + e);
        }
        return calendar.getTime();
    }

    public static int DiaSemana(java.util.Date Fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Fecha);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String NombreDiaSemana(java.util.Date Fecha) {
        return NombreDiaSemana(DiaSemana(Fecha));
    }

    public static String NombreDiaSemana(int DiaSemana) {
        String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        return dias[DiaSemana];
    }

    public static String NombreDiaSemanaDomingo(int DiaSemana) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return dias[DiaSemana];
    }    
    
}
