package byoscalendario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PrometeoNew666
 */
public class ByosCalendario extends javax.swing.JPanel {

    /**
     * Creates new form ByosCalendario
     */
    JLabel JLabelTituloDias[] = new JLabel[7];
    public JLabel JButtonDiasCalendario[] = new JLabel[42];
    javax.swing.JComboBox Mes = new javax.swing.JComboBox<>();
    javax.swing.JComboBox Anio = new javax.swing.JComboBox<>();
    JButton JButtonProximo = new JButton();
    JButton JButtonAnterior = new JButton();


    
    JLabel JLabelVinculado = new JLabel();
    JButton JButtonVinculado = new JButton();
    JTextField JTextFieldVinculado = new JTextField();
    
    ByosCalendario ByosCalendarioVinculado;

    public ByosCalendario getByosCalendarioVinculado() {
        return ByosCalendarioVinculado;
    }

    public void setByosCalendarioVinculado(ByosCalendario ByosCalendarioVinculado) {
        this.ByosCalendarioVinculado = ByosCalendarioVinculado;
    }
    
    
    JTextField JTextFieldFechaInicial;
    JTextField JTextFieldFechaFinal;

    public JTextField getJTextFieldFechaInicial() {
        return JTextFieldFechaInicial;
    }

    public void setJTextFieldFechaInicial(JTextField JTextFieldFechaInicial) {
        this.JTextFieldFechaInicial = JTextFieldFechaInicial;
    }

    public JTextField getJTextFieldFechaFinal() {
        return JTextFieldFechaFinal;
    }

    public void setJTextFieldFechaFinal(JTextField JTextFieldFechaFinal) {
        this.JTextFieldFechaFinal = JTextFieldFechaFinal;
    }
    
    
    
    Color ColorIntervaloDias = new java.awt.Color(204,255,255);

    
    Color ColorDias = new java.awt.Color(236,235,235);
    Color ColorTituloDias = new java.awt.Color(156,182,209);
    Color ColorTitulo = new java.awt.Color(156,182,209);
    Color ColorPie = new java.awt.Color(156,182,209);
    //Color ColorCalendario = new java.awt.Color(255,255,255);
    Color ColorDomingo = new java.awt.Color(250, 128, 114);
    Color ColorDiaActual = new java.awt.Color(255, 160, 122);
    Color ColorFondoDias = new java.awt.Color(255, 255, 255);
    Color ColorDiaSeleccionado = new java.awt.Color(156,182,209);


    
    java.awt.Font FuenteDiasSemana = new java.awt.Font("Tahoma", 0, 10);
    java.awt.Font FuenteDias = new java.awt.Font("Tahoma", 0, 14);
    java.awt.Font FuenteDomingos = new java.awt.Font("Tahoma", 1, 14);
    java.awt.Font FuenteDiaActual = new java.awt.Font("Tahoma", 1, 14);
    java.awt.Font FuenteMesAno = new java.awt.Font("Tahoma", 1, 14);
    
    JLabel JLabelDiaMesPie = new JLabel(); 

    int TamanoCabezera=30;
    int TamanoPie=30;
    String FechaSeleccionada="";
    int DiaSeleccionado=0;

    boolean MostrarPie = true;
    boolean MostrarCabezera = true;
    boolean EnableMenorFechaActual=true;
    boolean ClickSeleccion = false;
    
    
    public Color getColorIntervaloDias() {
        return ColorIntervaloDias;
    }

    public void setColorIntervaloDias(Color ColorIntervaloDias) {
        this.ColorIntervaloDias = ColorIntervaloDias;
    }
    
    
    
    
    public boolean isEnableMenorFechaActual() {
        return EnableMenorFechaActual;
    }

    public void setEnableMenorFechaActual(boolean EnableMenorFechaActual) {
        this.EnableMenorFechaActual = EnableMenorFechaActual;
        CargarDiasMes(ByosDate.Fecha());
    }
 
    
    public JTextField getJTextFieldVinculado() {
        return JTextFieldVinculado;
    }

    public void setJTextFieldVinculado(JTextField JTextFieldVinculado) {
        this.JTextFieldVinculado = JTextFieldVinculado;
    }   
    
    public JLabel getJLabelVinculado() {
        return JLabelVinculado;
    }

    public void setJLabelVinculado(JLabel JLabelVinculado) {
        this.JLabelVinculado = JLabelVinculado;
    }

    public JButton getJButtonVinculado() {
        return JButtonVinculado;
    }

    public void setJButtonVinculado(JButton JButtonVinculado) {
        this.JButtonVinculado = JButtonVinculado;
    }

    public int getDiaSeleccionado() {
        return DiaSeleccionado;
    }

    public void setDiaSeleccionado(int DiaSeleccionado) {
        this.DiaSeleccionado = DiaSeleccionado;
    }
    
    public boolean isMostrarPie() {
        return MostrarPie;
    }

    public void setMostrarPie(boolean MostrarPie) {
        this.MostrarPie = MostrarPie;
        CargarDiasMes(ByosDate.Fecha());
    }

    public boolean isMostrarCabezera() {
        return MostrarCabezera;
    }

    public void setMostrarCabezera(boolean MostrarCabezera) {
        this.MostrarCabezera = MostrarCabezera;
        CargarDiasMes(ByosDate.Fecha());
    }
    
    public Color getColorFondoDias() {
        return ColorFondoDias;
    }

    public void setColorFondoDias(Color ColorFondoDias) {
        this.ColorFondoDias = ColorFondoDias;
        CargarDiasMes(ByosDate.Fecha());
    }
    
    public Font getFuenteMesAno() {
        return FuenteMesAno;
    }

    public void setFuenteMesAno(Font FuenteMesAno) {
        this.FuenteMesAno = FuenteMesAno;
        CargarDiasMes(ByosDate.Fecha());
    }
    
    public int getTamanoPie() {
        return TamanoPie;
    }

    public void setTamanoPie(int TamanoPie) {
        this.TamanoPie = TamanoPie;
        CargarDiasMes(ByosDate.Fecha());
    }

    public int getTamanoCabezera() {
        return TamanoCabezera;
    }

    public void setTamanoCabezera(int TamanoCabezera) {
        this.TamanoCabezera = TamanoCabezera;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Font getFuenteDiasSemana() {
        return FuenteDiasSemana;
    }

    public void setFuenteDiasSemana(Font FuenteDiasSemana) {
        this.FuenteDiasSemana = FuenteDiasSemana;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Font getFuenteDias() {
        return FuenteDias;
    }

    public void setFuenteDias(Font FuenteDias) {
        this.FuenteDias = FuenteDias;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Font getFuenteDomingos() {
        return FuenteDomingos;
    }

    public void setFuenteDomingos(Font FuenteDomingos) {
        this.FuenteDomingos = FuenteDomingos;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Font getFuenteDiaActual() {
        return FuenteDiaActual;
    }

    public void setFuenteDiaActual(Font FuenteDiaActual) {
        this.FuenteDiaActual = FuenteDiaActual;
        CargarDiasMes(ByosDate.Fecha());
    }
/*
    public Color getColorCalendario() {
        return ColorCalendario;
    }

    public void setColorCalendario(Color ColorCalendario) {
        this.ColorCalendario = ColorCalendario;
        CargarDiasMes(ByosDate.Fecha());
    }
*/
    public Color getColorDomingo() {
        return ColorDomingo;
    }

    public void setColorDomingo(Color ColorDomingo) {
        this.ColorDomingo = ColorDomingo;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Color getColorDiaActual() {
        return ColorDiaActual;
    }

    public void setColorDiaActual(Color ColorDiaActual) {
        this.ColorDiaActual = ColorDiaActual;
        CargarDiasMes(ByosDate.Fecha());
    }    
    
    public Color getColorTituloDias() {
        return ColorTituloDias;
    }

    public void setColorTituloDias(Color ColorTituloDias) {
        this.ColorTituloDias = ColorTituloDias;
        CargarDiasMes(ByosDate.Fecha());
    }
   
    public Color getColorDias() {
        return ColorDias;
    }

    public void setColorDias(Color ColorDias) {
        this.ColorDias = ColorDias;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Color getColorTitulo() {
        return ColorTitulo;
    }

    public void setColorTitulo(Color ColorTitulo) {
        this.ColorTitulo = ColorTitulo;
        CargarDiasMes(ByosDate.Fecha());
    }

    public Color getColorPie() {
        return ColorPie;
    }

    public void setColorPie(Color ColorPie) {
        this.ColorPie = ColorPie;
        CargarDiasMes(ByosDate.Fecha());
    }
    
    public String getFechaSeleccionada(){
        return FechaSeleccionada;
    }
    
    public void setMesSiguiente(){
        MesSigiente();
    }
 
    public ByosCalendario() {
        initComponents();
        InizializarComponentes();        
    }

    public void InizializarComponentes(){
        InizializarPanel();
        InicializarDias();  
    }
    
    public void InizializarPanel(){
        
        for(int f=1800;f<2200;f++){
            Anio.addItem("" + f);
        }
        Anio.setSelectedItem("" + ByosDate.getAnio(ByosDate.Fecha()));
        Anio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JMesItemStateChanged(evt);
            }
        });
        
        Mes.addItem("Enero");
        Mes.addItem("Febrero");
        Mes.addItem("Marzo");
        Mes.addItem("Abril");
        Mes.addItem("Mayo");
        Mes.addItem("Junio");
        Mes.addItem("Julio");
        Mes.addItem("Agosto");
        Mes.addItem("Septiembre");
        Mes.addItem("Octubre");
        Mes.addItem("Noviembre");
        Mes.addItem("Diciembre");
        
        Mes.setSelectedIndex(ByosDate.getMes(ByosDate.Fecha())-1);
        Mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JMesItemStateChanged(evt);
            }
        });
        
        MostrarMesAnio();
        
        JPanelTitulo.setBackground(ColorTitulo);
        JPanelTitulo.setPreferredSize(new java.awt.Dimension(300, 20));
        JPanelTitulo.setLayout(new GridLayout(1,2,1,1)); 
        JPanelTitulo.add(Mes);
        JPanelTitulo.add(Anio);
        ((JLabel)Mes.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)Anio.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanelPie.setPreferredSize(new java.awt.Dimension(300, 20));
        JPanelPie.setBackground(ColorPie);
        
        JPanelDiasCalendario.setLayout(new GridLayout(7,7,1,1));   

        JButtonAnterior.setPreferredSize(new java.awt.Dimension(30, 50));
        JButtonAnterior.setMargin(new Insets(0, 0, 0, 0));
        JButtonAnterior.setText("<");       
        JButtonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAnteriorMouseClicked(evt);
            }
        });
        JPanelPie.add(JButtonAnterior, java.awt.BorderLayout.WEST);
        
        
        JButtonProximo.setPreferredSize(new java.awt.Dimension(30, 50));
        JButtonProximo.setMargin(new Insets(0, 0, 0, 0));
        JButtonProximo.setText(">");
        JButtonProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonProximoMouseClicked(evt);
            }
        });
        JPanelPie.add(JButtonProximo, java.awt.BorderLayout.EAST);
        
        
        JLabelDiaMesPie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelDiaMesPie.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JPanelPie.add(JLabelDiaMesPie, java.awt.BorderLayout.CENTER);
        
        //JPanelDiasCalendario.setBackground(ColorCalendario);
    }
    
    public void InicializarDias(){
        
        for(int f=0;f<7;f++){
            JLabelTituloDias[f] = new JLabel();

            JLabelTituloDias[f].setText(ByosDate.NombreDiaSemanaDomingo(f).substring(0, 3));
            JLabelTituloDias[f].setFont(FuenteDiasSemana); // NOI18N
            JLabelTituloDias[f].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            JLabelTituloDias[f].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            JLabelTituloDias[f].setOpaque(true);
            JLabelTituloDias[f].setBackground(ColorTituloDias);
            JPanelDiasCalendario.add(JLabelTituloDias[f]);
        }
        
        for(int f=0;f<JButtonDiasCalendario.length;f++){
            JButtonDiasCalendario[f] = new JLabel();
            
            JButtonDiasCalendario[f].setFont(FuenteDias); // NOI18N
            JButtonDiasCalendario[f].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            JButtonDiasCalendario[f].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            JButtonDiasCalendario[f].setOpaque(true);
            JButtonDiasCalendario[f].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JButtonDiasCalendarioMouseClicked(evt);   
                }       
            });
            JButtonDiasCalendario[f].setFont(FuenteDias);
            JButtonDiasCalendario[f].setBackground(ColorDias);
            JPanelDiasCalendario.add(JButtonDiasCalendario[f]);
        }
        CargarDiasMes(ByosDate.Fecha());     
    }
    
    public void setFechaActual(java.sql.Date Fecha){
        Mes.setSelectedIndex(ByosDate.getMes(Fecha)-1);
        Anio.setSelectedItem(ByosDate.getAnio(Fecha));
        CargarDiasMes(Fecha);
    }
    
    public void CargarDiasMes(java.sql.Date Fecha){

        JPanelTitulo.setPreferredSize(new java.awt.Dimension(400, getTamanoCabezera()));
        JPanelTitulo.setVisible(MostrarCabezera);
        
        JPanelPie.setPreferredSize(new java.awt.Dimension(400, this.getTamanoPie()));
        JPanelPie.setVisible(MostrarPie);
        JLabelDiaMesPie.setFont(FuenteMesAno);
        
        JPanelTitulo.setBackground(ColorTitulo);
        JPanelPie.setBackground(ColorPie);
        JPanelDiasCalendario.setBackground(ColorFondoDias);
        
        Mes.setFont(FuenteMesAno);
        Anio.setFont(FuenteMesAno);
        
        for(int f=0;f<7;f++){
            JLabelTituloDias[f].setFont(FuenteDiasSemana);
            JLabelTituloDias[f].setBackground(ColorTituloDias); 
        }
        
        for(int f=0;f<JButtonDiasCalendario.length;f++){
            JButtonDiasCalendario[f].setFont(FuenteDias); 
            JButtonDiasCalendario[f].setText(""); 
        }
        
        ActulizarColores(Fecha);
        
    }

    
    public void ActulizarColores(java.sql.Date Fecha){

        java.sql.Date FechaActual = Fecha;
        String FechaActualString = "01/" + Lib_String.Add_String_I("" + ByosDate.getMes(FechaActual),'0',2) + "/" + ByosDate.getAnio(FechaActual);
        int UltimoDiaMes = ByosDate.UltimoDiaMes(Fecha);
        
        int DiaActual=0; 
        if(ByosDate.getAnio(Fecha)==ByosDate.getAnio(ByosDate.Fecha()) && ByosDate.getMes(Fecha)==ByosDate.getMes(ByosDate.Fecha())){
            DiaActual=ByosDate.getDia(ByosDate.Fecha());
        }


        int ContarDias=0;
        int Domingos =0;
        int InicioMes=ByosDate.DiaSemana(ByosDate.StringAFecha(FechaActualString))-2;
        if(InicioMes<0){
           InicioMes=6;     
        }
        
        for(int f=0;f<JButtonDiasCalendario.length;f++){
            JButtonDiasCalendario[f].setFont(FuenteDias);
            JButtonDiasCalendario[f].setBackground(ColorDias);
            if(f>=InicioMes){
               ContarDias++;
               if(ContarDias<=UltimoDiaMes){
                   JButtonDiasCalendario[f].setText("" + ContarDias);   
                   JButtonDiasCalendario[f].setName(Lib_String.Add_String_I("" + ContarDias,'0',2) + "/" + Lib_String.Add_String_I("" + (Mes.getSelectedIndex()+1),'0',2) + "/" + Anio.getSelectedItem());
               }      
            }
            if(DiaActual>0 && DiaActual==ContarDias){
                JButtonDiasCalendario[f].setFont(FuenteDiaActual);                
                JButtonDiasCalendario[f].setBackground(ColorDiaActual);
            }else{

            }
            if(Domingos==6 && !JButtonDiasCalendario[f].getText().equals("") && DiaActual!=ContarDias){
                JButtonDiasCalendario[f].setFont(FuenteDomingos);
                JButtonDiasCalendario[f].setBackground(ColorDomingo);
            }
            Domingos++;
            if(Domingos>=7) Domingos=0;   
            
            if(DiaActual>0 && DiaSeleccionado==ContarDias){              
                JButtonDiasCalendario[f].setBackground(ColorDiaSeleccionado);
            }
            
            if (!isEnableMenorFechaActual()) {
                if (JButtonDiasCalendario[f] != null && JButtonDiasCalendario[f].getName() != null) {
                    if (ByosDate.compararFechas(ByosDate.StringAFecha(JButtonDiasCalendario[f].getName()), ByosDate.Fecha()) > 0) {
                        JButtonDiasCalendario[f].setEnabled(false);
                    } else {
                        JButtonDiasCalendario[f].setEnabled(true);
                    }
                }
            }
                         
        }
        InicializarIntervalo();
     
    }
    
    public void MesSigiente(){
        int xAnio = Integer.valueOf(Anio.getSelectedItem().toString());
        
        int xMes = Mes.getSelectedIndex()+1;
        xMes++;
        if(xMes>12){
            xMes=1;
            xAnio++;
        }
        Mes.setSelectedIndex(xMes-1);
        Anio.setSelectedItem(""+xAnio);
        
        
        String FechaActualString = "01/" + Lib_String.Add_String_I("" + (xMes),'0',2) + "/" + "" + xAnio;
        
        CargarDiasMes(ByosDate.UtilFechaASqlFecha(ByosDate.StringAFecha(FechaActualString)));
        MostrarMesAnio();
        
    }
    
    public void ActualizarFecha(){
        int xAnio = Integer.valueOf(Anio.getSelectedItem().toString());
        int xMes = Mes.getSelectedIndex()+1;
        String FechaActualString = "01/" + Lib_String.Add_String_I("" + (xMes),'0',2) + "/" + "" + xAnio;
        CargarDiasMes(ByosDate.UtilFechaASqlFecha(ByosDate.StringAFecha(FechaActualString)));
        MostrarMesAnio();
    }
    
    
    public void ActualizarFechaSeleccion(){
        int xAnio = Integer.valueOf(Anio.getSelectedItem().toString());
        int xMes = Mes.getSelectedIndex()+1;
        String FechaActualString = "01/" + Lib_String.Add_String_I("" + (xMes),'0',2) + "/" + "" + xAnio;
        ActulizarColores(ByosDate.UtilFechaASqlFecha(ByosDate.StringAFecha(FechaActualString)));
        MostrarMesAnio();
        ActualizarFechaSeleccionVinculado();
    }
    
    public void ActualizarFechaSeleccionVinculado(){
        if(ByosCalendarioVinculado!=null){
           int xAnio = Integer.valueOf(ByosCalendarioVinculado.Anio.getSelectedItem().toString());
           int xMes = ByosCalendarioVinculado.Mes.getSelectedIndex()+1;
           String FechaActualString = "01/" + Lib_String.Add_String_I("" + (xMes),'0',2) + "/" + "" + xAnio;
           ByosCalendarioVinculado.ActulizarColores(ByosDate.UtilFechaASqlFecha(ByosDate.StringAFecha(FechaActualString)));
           ByosCalendarioVinculado.MostrarMesAnio();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelFondoCalendario = new javax.swing.JPanel();
        JPanelDiasCalendario = new javax.swing.JPanel();
        JPanelTitulo = new javax.swing.JPanel();
        JPanelPie = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(290, 270));
        setLayout(new java.awt.BorderLayout());

        JPanelFondoCalendario.setLayout(new java.awt.BorderLayout());

        JPanelDiasCalendario.setBackground(new java.awt.Color(255, 255, 255));
        JPanelDiasCalendario.setForeground(new java.awt.Color(204, 255, 255));
        JPanelDiasCalendario.setPreferredSize(new java.awt.Dimension(290, 269));

        javax.swing.GroupLayout JPanelDiasCalendarioLayout = new javax.swing.GroupLayout(JPanelDiasCalendario);
        JPanelDiasCalendario.setLayout(JPanelDiasCalendarioLayout);
        JPanelDiasCalendarioLayout.setHorizontalGroup(
            JPanelDiasCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        JPanelDiasCalendarioLayout.setVerticalGroup(
            JPanelDiasCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        JPanelFondoCalendario.add(JPanelDiasCalendario, java.awt.BorderLayout.CENTER);

        JPanelTitulo.setBackground(new java.awt.Color(156, 182, 209));
        JPanelTitulo.setPreferredSize(new java.awt.Dimension(290, 30));
        JPanelTitulo.setLayout(new java.awt.GridLayout(1, 0));
        JPanelFondoCalendario.add(JPanelTitulo, java.awt.BorderLayout.PAGE_START);

        JPanelPie.setBackground(new java.awt.Color(236, 235, 235));
        JPanelPie.setPreferredSize(new java.awt.Dimension(290, 30));
        JPanelPie.setLayout(new java.awt.BorderLayout());
        JPanelFondoCalendario.add(JPanelPie, java.awt.BorderLayout.PAGE_END);

        add(JPanelFondoCalendario, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void JMesItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        ActualizarFecha();
    }

    private void JButtonDiasCalendarioMouseClicked(java.awt.event.MouseEvent evt) {       
        if (((JLabel) evt.getSource()).isEnabled()) {           
            String FechaSeleccionada = ((JLabel) evt.getSource()).getName();
            String DiaSeleccionado = ((JLabel) evt.getSource()).getText();
            if (DiaSeleccionado != null && !DiaSeleccionado.equals("")) {
                if (!ClickSeleccion) {
                    this.FechaSeleccionada = FechaSeleccionada;
                    this.DiaSeleccionado = Integer.valueOf(DiaSeleccionado);
                
                    if (JLabelVinculado != null) {
                        JLabelVinculado.setText(this.FechaSeleccionada);
                    }
                    if (JButtonVinculado != null) {
                        JButtonVinculado.setText(this.FechaSeleccionada);
                    }
                    if (JTextFieldVinculado != null) {
                        JTextFieldVinculado.setText(this.FechaSeleccionada);
                    }
                    if(ByosCalendarioVinculado!=null){
                       ClickSeleccion=true;
                    }
                    
                } else {
                    if(ByosCalendarioVinculado!=null){
                       ByosCalendarioVinculado.FechaSeleccionada = FechaSeleccionada;
                       ByosCalendarioVinculado.DiaSeleccionado = Integer.valueOf(DiaSeleccionado);

                       if (JTextFieldFechaFinal != null) {
                           JTextFieldFechaFinal.setText(ByosCalendarioVinculado.FechaSeleccionada);
                       }
                       ClickSeleccion=false;
                    }
                }
                ActualizarFechaSeleccion();
            }
        }
    }
    
    private void JButtonProximoMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int xMes = Mes.getSelectedIndex();
        int xAnio = Integer.valueOf(Anio.getSelectedItem().toString());
        xMes++;
        if(xMes>11){
            xMes=0;
            xAnio++;
        }
        Mes.setSelectedIndex(xMes);
        Anio.setSelectedItem(String.valueOf(xAnio));
        
        ActualizarFecha();
    }
    
    private void JButtonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int xMes = Mes.getSelectedIndex();
        int xAnio = Integer.valueOf(Anio.getSelectedItem().toString());
        xMes--;
        if(xMes<0){
            xMes=11;
            xAnio--;
        }
        Mes.setSelectedIndex(xMes);
        Anio.setSelectedItem(String.valueOf(xAnio));
        
        ActualizarFecha();        
    }
    
    private void MostrarMesAnio(){
        JLabelDiaMesPie.setText(Mes.getSelectedItem() + " De " + Anio.getSelectedItem());
    }
    
    private void InicializarIntervalo() {
        
        if (ByosCalendarioVinculado != null && JTextFieldFechaInicial!=null && JTextFieldFechaFinal!=null) {
            
            if (!JTextFieldFechaFinal.getText().equals("") && !JTextFieldFechaInicial.getText().equals("")) {
                long xFechaInical = Long.valueOf(ByosDate.FormatoFecha(ByosDate.StringAFecha(JTextFieldFechaInicial.getText()), "YYYYMMdd"));
                long xFechaFinal = Long.valueOf(ByosDate.FormatoFecha(ByosDate.StringAFecha(JTextFieldFechaFinal.getText()), "YYYYMMdd"));
                
                long xFechaActual = 0;
                
                for (int f = 0; f < JButtonDiasCalendario.length; f++) {

                    if (JButtonDiasCalendario[f] != null && JButtonDiasCalendario[f].getName() != null && !JButtonDiasCalendario[f].getName().equals("")) {
                        xFechaActual = Long.valueOf(ByosDate.FormatoFecha(ByosDate.StringAFecha(JButtonDiasCalendario[f].getName()), "YYYYMMdd"));

                        if (xFechaActual >= xFechaInical && xFechaActual <= xFechaFinal) {
                            if(!JButtonDiasCalendario[f].getText().equals("")){
                               JButtonDiasCalendario[f].setBackground(ColorIntervaloDias);
                            }
                        }
                    }

                    if (ByosCalendarioVinculado.JButtonDiasCalendario[f] != null && ByosCalendarioVinculado.JButtonDiasCalendario[f].getName() != null && !ByosCalendarioVinculado.JButtonDiasCalendario[f].getName().equals("")) {
                        xFechaActual = Long.valueOf(ByosDate.FormatoFecha(ByosDate.StringAFecha(ByosCalendarioVinculado.JButtonDiasCalendario[f].getName()), "YYYYMMdd"));

                        if (xFechaActual >= xFechaInical && xFechaActual <= xFechaFinal) {
                            if(!ByosCalendarioVinculado.JButtonDiasCalendario[f].getText().equals("")){
                                ByosCalendarioVinculado.JButtonDiasCalendario[f].setBackground(ColorIntervaloDias);
                            }
                        }
                    }
                    
                }

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelDiasCalendario;
    private javax.swing.JPanel JPanelFondoCalendario;
    private javax.swing.JPanel JPanelPie;
    private javax.swing.JPanel JPanelTitulo;
    // End of variables declaration//GEN-END:variables
}
