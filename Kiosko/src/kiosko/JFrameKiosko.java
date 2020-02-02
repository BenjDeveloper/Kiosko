/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kiosko;

import Libs.Datos;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author TPV
 */
public class JFrameKiosko extends javax.swing.JFrame {
 
    ////////////////////////////////////////////////////////////////////////////
    //*               VALIABLES DE CONFIGUARACION POR DEFECTO                 */
    ////////////////////////////////////////////////////////////////////////////
    public int elementosPorPaginaSectores = 5; //edit
    public int elementosPorPaginaFamilias = 5; //edit
    public int elementosPorPaginaProductos = 20; //edit
    public int numeroDeInstruncciones = 5; //edit
    public int blinkTime = 400;
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                             CONSTANTES                                */
    ////////////////////////////////////////////////////////////////////////////
    public String TYPE_PRODUCTO = "PRODUCTO";
    public String TYPE_FAMILIA = "FAMILIA";
    public String TYPE_SECTOR = "SECTOR";
    
    public String TYPE_SUMA = "SUMA";
    public String TYPE_RESTA = "RESTA";
    
    public String TYPE_UP = "UP";
    public String TYPE_DONW = "DONW";
    public String TYPE_LEFT = "LEFT";
    public String TYPE_RIGHT = "RIGHT";
    
    public String SIN_ASIGNAR = "Sin Asignar";
    public String TODO_APAGADO = "APAGADOS";
    public String TODO_ACTIVO = "ACTIVOS";
    
    public String INSTR_1 = "SECTOR";
    public String INSTR_2 = "FAMILIA";
    public String INSTR_3 = "ARTICULO";
    public String INSTR_4 = "PAGO";
    public String INSTR_5 = "TICKET";
    
    public java.awt.Color ORANGE = new java.awt.Color(246, 149, 9);
    public java.awt.Color BLACK = new java.awt.Color(0, 0, 0);
    public java.awt.Color GREEN = new java.awt.Color(38, 255, 0);
    public java.awt.Color GRAY = new java.awt.Color(178, 179, 179);
    public java.awt.Color GRAY_2 = new java.awt.Color(91,91,91);
    public java.awt.Color WHITE = new java.awt.Color(215,233,214);
    //public java.awt.Color WHITE = new java.awt.Color(255,255,255);
    public java.awt.Color ROSA = new java.awt.Color(210,205,231);
    
    public java.awt.Color YELLOW_OFF = new java.awt.Color(255, 251, 219);
    public java.awt.Color YELLOW_ON = new java.awt.Color(255, 255, 0);
    public java.awt.Color CIAN_OFF = new java.awt.Color(120, 109, 159);
    public java.awt.Color CIAN_ON = new java.awt.Color(121, 107, 173);
    
    public String LEFT_ON = "/kiosko/imagenes/left_on.png";
    public String LEFT_OFF = "/kiosko/imagenes/left_off.png";
    public String RIGHT_ON = "/kiosko/imagenes/right_on.png";
    public String RIGHT_OFF = "/kiosko/imagenes/right_off.png";
    public String UP_ON = "/kiosko/imagenes/up_on.png";
    public String UP_OFF = "/kiosko/imagenes/up_off.png";
    public String DOWN_ON = "/kiosko/imagenes/down_on.png";
    public String DOWN_OFF = "/kiosko/imagenes/down_off.png";
    
    public java.awt.Font NORMAL = new java.awt.Font("Arial", Font.PLAIN, 15);
    public java.awt.Font BOLD = new java.awt.Font("Arial", Font.BOLD, 15);
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                 VALIABLES PARA EL MANEJO DE EVENTOS                   */
    ////////////////////////////////////////////////////////////////////////////
    public int numeroDePaginaSectores = 0; 
    public int numeroDePaginaFamilias = 0; 
    public int numeroDePaginaProductos = 0;
    
    public int PaginaActualSectores = 0;
    public int PaginaActualFamilias = 0; 
    public int PaginaActualProductos = 0; 

    public String SectorActual = "TODOS LOS SECTORES"; // carga inicial por defecto dinamica
    public String FamiliaActual = "ARTICULOS MAS VENDIDOS"; // carga inicial por defecto dinamica
    
    public String SectorInicial = "SELECCIONE UN SECTOR"; // carga inicial por defecto estatica
    public String FamiliaInicial = "SELECIONE UNA FAMILIA"; // carga inicial por defecto dinamica
    public String ProductoInicial = "SELECCIONE ARTICULOS"; // carga inicial por defecto dinamica
    public String ProductoProceso = "YA PUEDE SELECCIONAR UN ARTICULO"; // carga inicial por defecto dinamica
    
    public Boolean SectorThread = false;
    public Boolean FamiliaThread = false;
    public Boolean ProductoThread = false;
    
    public Thread ThreadSectorBlink;
    public Thread ThreadFamiliaBlink;
    public Thread ThreadProductoBlink;
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                             ELEMENTOS                                 */
    ////////////////////////////////////////////////////////////////////////////
    public javax.swing.JLabel[] JLabelSector = null;
    public javax.swing.JLabel[] JLabelFamilia = new javax.swing.JLabel[elementosPorPaginaFamilias];
    public javax.swing.JLabel[] JLabelProductos = new javax.swing.JLabel[elementosPorPaginaProductos];
    
    public javax.swing.JLabel[] JLabelInstrucciones = new javax.swing.JLabel[numeroDeInstruncciones];
    
    public Object items[][] = new Object[20][2];
    public String headerTable[] =  new String [] {"Producto", "Importe"};
    public javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(items, headerTable);
    public Integer fila = 0;

    public JDialogPagar dialog = null;
    
    ////////////////////////////////////////////////////////////////////////////
    //*                 VARIABLES PARA EL MANEJOS DE DATOS                     */
    ////////////////////////////////////////////////////////////////////////////
    public Datos datos = new Datos();

    public String[] instrucciones = new String[]{ 
        "1 - Seleccionar Sector",
        "2 - Seleccionar Familia",
        "3 - Seleccionar Articulos",
        "4 - pagar", 
        "5 - retire el ticket y entregelo en barra"
    };
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                     CONSTRUCTOR JFrameKiosko                        */
    ////////////////////////////////////////////////////////////////////////////
    public JFrameKiosko() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setType(Type.UTILITY);
        initComponents();
        initComponentsCustom();
        //this.setLocationRelativeTo(null);
        this.setSize(1080, 1920);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*            FUNCIONDES DE INICIALIZACION  DE ELEMENTOS                 */
    ////////////////////////////////////////////////////////////////////////////
    private void initComponentsCustom(){
        
        datos.CargaDatos();
        
        initVariablesDefecto();
        initTableModel();
        initPaginacion();
        
        initJPanel(jPanelSector, JLabelSector, TYPE_SECTOR);
        initJPanel(jPanelFamilia, JLabelFamilia, TYPE_FAMILIA);
        initJPanel(jPanelProductos, JLabelProductos, TYPE_PRODUCTO);

        initContentPanel(JLabelSector, TYPE_SECTOR);
        initContentPanel(JLabelFamilia, TYPE_FAMILIA);
        initContentPanel(JLabelProductos, TYPE_PRODUCTO);
        
        initVariablesActuales();

        setActiveBanner(TYPE_SECTOR, true);
        setActiveBanner(TYPE_FAMILIA, false);
        setActiveBanner(TYPE_PRODUCTO, false);
        
        jLabelPagar.setEnabled(false);
        jLabelPagar.setBackground(WHITE);
        
        
        initJLabelInstruccion();
        setActiveInstruccion(INSTR_1);
        
        jLabelTituloSector.setText(SectorInicial);
        jLabelTituloFamilia.setText(FamiliaInicial);
        
        jPanelProductos.setOpaque(true);
        
        setElementChoise(JLabelSector, TODO_ACTIVO);
        setElementChoise(JLabelFamilia, TODO_APAGADO);
        setElementChoise(JLabelProductos, TODO_APAGADO); 
                
        if (JLabelSector.length == 1) eventSectorConditional( JLabelSector[0].getName());
    }
    
    private void initVariablesDefecto(){
        if (datos.sector.length >= 1 && datos.sector.length <5 ) elementosPorPaginaSectores = datos.sector.length;
        JLabelSector = new javax.swing.JLabel[elementosPorPaginaSectores];
    }
    
    private void initJLabelInstruccion(){
        for(Integer i=0; i<JLabelInstrucciones.length; i++){
            JLabelInstrucciones[i] = new javax.swing.JLabel();
            JLabelInstrucciones[i].setFont(NORMAL);
            JLabelInstrucciones[i].setText(instrucciones[i]);
            JLabelInstrucciones[i].setOpaque(false);
            JLabelInstrucciones[i].setBackground(YELLOW_ON);
            jPanelInstruncciones.add(JLabelInstrucciones[i]); 
        }
    }

    private void initJPanel(javax.swing.JPanel JPanel, javax.swing.JLabel[] array, String tipo) {
        for(Integer i=0; i<array.length; i++){
            array[i] = new javax.swing.JLabel();
            array[i].setOpaque(true);
            array[i].setBackground(java.awt.Color.WHITE);
            array[i].setMaximumSize(new java.awt.Dimension(0,0));
            array[i].setFont(new java.awt.Font("Tahoma", 0, 1));
            array[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (tipo.equals(TYPE_SECTOR))eventSectorMouseClicked(evt);
                    if (tipo.equals(TYPE_FAMILIA))eventFamiliaMouseClicked(evt);
                    if (tipo.equals(TYPE_PRODUCTO))eventProductoMouseClicked(evt);
                }
            } );
            JPanel.add(array[i]);
        }
    }       

    private void initTableModel(){
        model = new javax.swing.table.DefaultTableModel(items, headerTable);
        jLabelTotal.setText(this.getTotal("0", "0", "NEW"));
        fila = 0;
        int[] Tamaños = {180, 52};
        Font Fuente = new Font("Arial", Font.BOLD, 12);
        jTableFactura.setShowGrid(false);
        jTableFactura.setFont(Fuente);
        jTableFactura.setModel(model);
        jTableFactura.setCellSelectionEnabled(true);
        jTableFactura.setRowHeight(25);        
        jTableFactura.setColumnSelectionAllowed(false);
        jTableFactura.setRowSelectionAllowed(true);
        JTableHeader header = jTableFactura.getTableHeader();
        header.setFont(Fuente);
        TableColumnModel ColumnModel = jTableFactura.getColumnModel();
        ColumnModel.setColumnSelectionAllowed(true);
        for (int f = 0; f < headerTable.length; f++) {
            ColumnModel.getColumn(f).setHeaderValue(headerTable[f]);
            ColumnModel.getColumn(f).setPreferredWidth(Tamaños[f]);
        }
        DefaultTableCellRenderer Alineacion = new DefaultTableCellRenderer();
        Alineacion.setHorizontalAlignment(SwingConstants.RIGHT);
        ColumnModel.getColumn(1).setCellRenderer(Alineacion);

        //jScrollPaneFactura.setViewportView(jTableFactura);
    }

    private void initContentPanel( javax.swing.JLabel[] array, String tipo){
        if (tipo.equals(TYPE_SECTOR)){
            for(Integer i=0; i<array.length; i++){
                if (i < datos.sector.length){
                    array[i].setName(datos.sector[i].getDescripcionCorta());
                    array[i].setIcon(datos.sector[i].getImagen());
                } else {
                    array[i].setName(SIN_ASIGNAR);
                    array[i].setIcon(new javax.swing.ImageIcon("static/sec.png"));
                }  
            }
            this.numeroDePaginaSectores = configPag(datos.sector.length, elementosPorPaginaSectores);
        }
        if (tipo.equals(TYPE_FAMILIA)){
            for(Integer j=0; j<datos.sector.length; j++){
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())){
                    for(Integer i=0; i<array.length; i++){ 
                        if (i < datos.sector[j].familia.length){
                            array[i].setName(datos.sector[j].familia[i].getDescripcionCorta());
                            array[i].setIcon(datos.sector[j].familia[i].getImagen());
                        } else {
                            array[i].setName(SIN_ASIGNAR);
                            array[i].setIcon(new javax.swing.ImageIcon("static/fam.png"));
                        } 
                    }
                    this.numeroDePaginaFamilias = configPag(datos.sector[j].familia.length, elementosPorPaginaFamilias);
                    FamiliaActual = array[0].getName();
                }
            }
        }
        if (tipo.equals(TYPE_PRODUCTO)) {
            for(Integer j=0; j<datos.sector.length; j++) {
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())) {
                    for(Integer jj=0; jj<datos.sector[j].familia.length; jj++){ 
                        if (FamiliaActual.equals(datos.sector[j].familia[jj].getDescripcionCorta())) {
                            for(Integer i=0; i<array.length; i++) { 
                                if (i < datos.sector[j].familia[jj].producto.length) {
                                    array[i].setName(datos.sector[j].familia[jj].producto[i].getDescripcionCorta());
                                    array[i].setIcon(datos.sector[j].familia[jj].producto[i].getImagen());
                                    array[i].setText(datos.sector[j].familia[jj].producto[i].getcosto());
                                } else {
                                    array[i].setName(SIN_ASIGNAR);
                                    array[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                                    array[i].setText("0.00");
                                }
                            }
                            this.numeroDePaginaProductos = configPag(datos.sector[j].familia[jj].producto.length, elementosPorPaginaProductos);
                        }
                    }
                }
            }
        }
    }
 
    private void initPaginacion(){
        PaginaActualSectores = 1;
        PaginaActualFamilias = 1;
        PaginaActualProductos = 1;
    }

    private void initContentTable(){
        jLabelTotal.setText(this.getTotal("0", "0", "NEW"));
        for (int i = this.fila - 1; i >= 0  ; i-- ){
            jTableFactura.setValueAt("", i, 0);
            jTableFactura.setValueAt("", i, 1);
        }
        fila = 0;
    }

    private void initVariablesActuales(){
        SectorActual = JLabelSector[0].getName();
        FamiliaActual = JLabelFamilia[0].getName();
    }
    
    private void initJDialogPagar(){
        dialog = new JDialogPagar(this, true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    eventPagarMouseClicked(evt);
                }
            } );
        dialog.setVisible(true);
        /*dialog.jLabelPago.setText("Realiazando Pago");
        dialog.jProgressBarPago.setValue(20);
        dialog.jProgressBarPago.repaint();*/
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                       FUNCIONDES DE EVENTOS                           */
    ////////////////////////////////////////////////////////////////////////////
    
    private void eventSectorConditional(String sector) { 
        SectorActual = sector;
        setContentPanel(TYPE_SECTOR);

        setActiveBanner(TYPE_SECTOR, false);
        setActiveBanner(TYPE_FAMILIA, true);
        setActiveBanner(TYPE_PRODUCTO, false);

        setActiveInstruccion(INSTR_2);

        jLabelTituloSector.setText("SECTOR "+sector);
        jLabelTituloFamilia.setText(FamiliaInicial);

        setElementChoise(JLabelSector, SectorActual);
        setElementChoise(JLabelFamilia, TODO_ACTIVO);
        setElementChoise(JLabelProductos, TODO_APAGADO); 

        jPanelProductos.setBackground(ROSA);
        
    }
    
    private void eventSectorMouseClicked(java.awt.event.MouseEvent evt) { 
        javax.swing.JLabel ele = (javax.swing.JLabel) evt.getSource();
        System.out.println(ele.getName());
        if (!ele.getName().equals(SIN_ASIGNAR)) {
            SectorActual = ele.getName();
            setContentPanel(TYPE_SECTOR);
            
            setActiveBanner(TYPE_SECTOR, false);
            setActiveBanner(TYPE_FAMILIA, true);
            setActiveBanner(TYPE_PRODUCTO, false);
            
            setActiveInstruccion(INSTR_2);
            
            jLabelTituloSector.setText("USTED HA SELECCIONADO "+ele.getName());
            jLabelTituloFamilia.setText(FamiliaInicial);
            
            setElementChoise(JLabelSector, SectorActual);
            setElementChoise(JLabelFamilia, TODO_ACTIVO);
            setElementChoise(JLabelProductos, TODO_APAGADO); 
            
            jPanelProductos.setBackground(ROSA);
        }
    }  
    
    private void eventFamiliaMouseClicked(java.awt.event.MouseEvent evt) { 
        javax.swing.JLabel ele = (javax.swing.JLabel) evt.getSource();
        System.out.println(ele.getName());
        if (!ele.getName().equals(SIN_ASIGNAR)) {
            FamiliaActual = ele.getName();
            setContentPanel(TYPE_FAMILIA);
            
            setActiveBanner(TYPE_SECTOR, false);
            setActiveBanner(TYPE_FAMILIA, false);
            setActiveBanner(TYPE_PRODUCTO, true);
            
            setActiveInstruccion(INSTR_3);
            
            jLabelTituloSector.setText("USTED HA SELECCIONADO "+SectorActual);
            jLabelTituloFamilia.setText("USTED HA SELECCIONADO "+ele.getName());
            jLabelTituloProducto.setText(ProductoProceso);
            
            setElementChoise(JLabelSector, SectorActual);
            setElementChoise(JLabelFamilia, FamiliaActual);
            setElementChoise(JLabelProductos, TODO_ACTIVO); 

            jPanelProductos.setBackground(ROSA);
        }
    }
    
    private void eventProductoMouseClicked(java.awt.event.MouseEvent evt) { 
        javax.swing.JLabel ele = (javax.swing.JLabel) evt.getSource();
        System.out.println(ele.getName());
        if (!ele.getName().equals(SIN_ASIGNAR)) {
            
            jLabelTotal.setText(getTotal(jLabelTotal.getText(), ele.getText(), this.TYPE_SUMA));
            jTableFactura.setValueAt(ele.getName(), this.fila, 0);
            jTableFactura.setValueAt(ele.getText(), this.fila, 1);
            this.fila++;

            setActiveBanner(TYPE_SECTOR, false);
            setActiveBanner(TYPE_FAMILIA, false);
            setActiveBanner(TYPE_PRODUCTO, false);
            
            setActiveInstruccion(INSTR_3);
            
            jLabelTituloSector.setText("USTED HA SELECCIONADO "+SectorActual);
            jLabelTituloFamilia.setText("USTED HA SELECCIONADO "+FamiliaActual); 
            jLabelTituloProducto.setText("USTED HA SELECCIONADO "+ele.getName());
            
            setElementChoise(JLabelSector, SectorActual);
            setElementChoise(JLabelFamilia, FamiliaActual);
            setElementChoise(JLabelProductos, TODO_ACTIVO); 
            
            jPanelProductos.setBackground(CIAN_ON);
            
            jLabelPagar.setEnabled(true);
            jLabelPagar.setBackground(YELLOW_ON);
        }
    }
    
    private void eventPagarMouseClicked(java.awt.event.MouseEvent evt) { 
        if (jLabelPagar.isEnabled()){
            SectorActual = JLabelSector[0].getName();
            FamiliaActual = JLabelFamilia[0].getName();
            setContentPanel(TYPE_SECTOR);
            setContentPanel(TYPE_FAMILIA);
            setContentPanel(TYPE_PRODUCTO);
            
            setActiveBanner(TYPE_SECTOR, true);
            setActiveBanner(TYPE_FAMILIA, false);
            setActiveBanner(TYPE_PRODUCTO, false);

            initPaginacion();
            initContentTable();
            initVariablesActuales();
            
            jLabelPagar.setEnabled(false);
            jLabelPagar.setBackground(WHITE);
            
            //setActiveInstruccion(INSTR_4);
            
            setActiveInstruccion(INSTR_1);
            
            jLabelTituloSector.setText(SectorInicial);
            jLabelTituloFamilia.setText(FamiliaInicial);
            jLabelTituloProducto.setText(ProductoInicial);
            
            setElementChoise(JLabelSector, TODO_ACTIVO);
            setElementChoise(JLabelFamilia, TODO_APAGADO);
            setElementChoise(JLabelProductos, TODO_APAGADO); 
            
           jPanelProductos.setBackground(ROSA);

           dialog.event();
        }
    }
    
    private void eventBorrarUltimoMouseClicked(java.awt.event.MouseEvent evt) { 
        if (this.fila > 0 ){
            this.fila--;
            String value = (String)jTableFactura.getValueAt(this.fila, 1);
            jLabelTotal.setText(getTotal(jLabelTotal.getText(), value, this.TYPE_RESTA));
            jTableFactura.setValueAt("", this.fila, 0);
            jTableFactura.setValueAt("", this.fila, 1);
        }
    }
    
    private void eventPagarProceso(java.awt.event.MouseEvent evt) { 
        if (jLabelPagar.isEnabled()){
            setActiveInstruccion(INSTR_4);
            initJDialogPagar();
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelKiosko = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanelFamilia = new javax.swing.JPanel();
        jLayeredPaneFamilia = new javax.swing.JLayeredPane();
        jLabelLeftFamilia = new javax.swing.JLabel();
        jLabelRightFamilia = new javax.swing.JLabel();
        jLabelTituloFamilia = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanelSector = new javax.swing.JPanel();
        jLayeredPaneSector = new javax.swing.JLayeredPane();
        jLabelRightSector = new javax.swing.JLabel();
        jLabelLeftSector = new javax.swing.JLabel();
        jLabelTituloSector = new javax.swing.JLabel();
        jPanelProductos = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLayeredPaneProducto = new javax.swing.JLayeredPane();
        jLabelUpProducto = new javax.swing.JLabel();
        jLabelDownProducto = new javax.swing.JLabel();
        jLabelTituloProducto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelPagar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTableFactura = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabelCancelarPedido = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelInstruncciones = new javax.swing.JPanel();
        jLabelBorrarUltimo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelUp = new javax.swing.JPanel();
        jPanelDown = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1080, 1020));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelKiosko.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelKiosko.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(210, 205, 231));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(91, 91, 91));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelFamilia.setOpaque(false);
        jPanelFamilia.setLayout(new java.awt.GridLayout(1, 5, 3, 3));
        jPanel7.add(jPanelFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 790, 115));

        jLayeredPaneFamilia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLeftFamilia.setBackground(new java.awt.Color(255, 255, 0));
        jLabelLeftFamilia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftFamiliaMouseClicked(evt);
            }
        });
        jLayeredPaneFamilia.add(jLabelLeftFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 77, 50));

        jLabelRightFamilia.setBackground(new java.awt.Color(255, 255, 0));
        jLabelRightFamilia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightFamiliaMouseClicked(evt);
            }
        });
        jLayeredPaneFamilia.add(jLabelRightFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 0, 77, 50));

        jLabelTituloFamilia.setBackground(new java.awt.Color(255, 255, 0));
        jLabelTituloFamilia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloFamilia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloFamilia.setText("2º - SELECCIONE FAMILIA DE ARTICULOS");
        jLabelTituloFamilia.setOpaque(true);
        jLayeredPaneFamilia.add(jLabelTituloFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        jPanel7.add(jLayeredPaneFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 790, 50));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 179, 790, 175));

        jPanel8.setBackground(new java.awt.Color(91, 91, 91));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSector.setOpaque(false);
        jPanelSector.setLayout(new java.awt.GridLayout(1, 5, 3, 0));
        jPanel8.add(jPanelSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 790, 115));

        jLayeredPaneSector.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRightSector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelRightSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightSectorMouseClicked(evt);
            }
        });
        jLayeredPaneSector.add(jLabelRightSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 0, 77, 50));

        jLabelLeftSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftSectorMouseClicked(evt);
            }
        });
        jLayeredPaneSector.add(jLabelLeftSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 77, 50));

        jLabelTituloSector.setBackground(new java.awt.Color(255, 255, 51));
        jLabelTituloSector.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloSector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloSector.setText("1º - SELECCIONE EL SECTOR");
        jLabelTituloSector.setOpaque(true);
        jLayeredPaneSector.add(jLabelTituloSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        jPanel8.add(jLayeredPaneSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 790, 50));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 4, 790, 175));

        jPanelProductos.setOpaque(false);
        jPanelProductos.setLayout(new java.awt.GridLayout(4, 5, 3, 3));
        jPanel2.add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 415, 788, 534));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(121, 118, 130), 2));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPaneProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUpProducto.setBackground(new java.awt.Color(128, 122, 179));
        jLabelUpProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUpProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUpProductoMouseClicked(evt);
            }
        });
        jLayeredPaneProducto.add(jLabelUpProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 100, 50));

        jLabelDownProducto.setBackground(new java.awt.Color(128, 122, 179));
        jLabelDownProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDownProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDownProductoMouseClicked(evt);
            }
        });
        jLayeredPaneProducto.add(jLabelDownProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 100, 50));

        jLabelTituloProducto.setBackground(new java.awt.Color(128, 122, 179));
        jLabelTituloProducto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloProducto.setForeground(new java.awt.Color(51, 255, 0));
        jLabelTituloProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloProducto.setText("SELECCIONE ARTICULO");
        jLabelTituloProducto.setOpaque(true);
        jLayeredPaneProducto.add(jLabelTituloProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 790, 50));

        jPanel10.add(jLayeredPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 359, -1, 50));

        jPanelKiosko.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 1, 798, 955));

        jPanel3.setBackground(new java.awt.Color(210, 205, 231));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPagar.setBackground(new java.awt.Color(255, 255, 0));
        jLabelPagar.setFont(new java.awt.Font("Arial", 0, 34)); // NOI18N
        jLabelPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPagar.setText("PAGAR");
        jLabelPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelPagar.setOpaque(true);
        jLabelPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPagarMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 805, 270, 50));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTotal.setBackground(new java.awt.Color(255, 241, 219));
        jLabelTotal.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("0.00€");
        jLabelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelTotal.setOpaque(true);
        jPanel6.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 250, 60));

        jPanel9.setLayout(new java.awt.BorderLayout());

        jTableFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jPanel9.add(jTableFactura, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 240, 270));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TOTAL con IVA INCLUIDO");
        jLabel7.setOpaque(true);
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 230, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 270, 390));

        jLabelCancelarPedido.setBackground(new java.awt.Color(237, 246, 195));
        jLabelCancelarPedido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelCancelarPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelarPedido.setText("CANCELAR PEDIDO");
        jLabelCancelarPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelCancelarPedido.setOpaque(true);
        jLabelCancelarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCancelarPedidoMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelCancelarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 905, 270, 40));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 152, 70));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INSTRUCCIONES");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 261, 50));

        jPanelInstruncciones.setLayout(new java.awt.GridLayout(5, 1, 3, 3));
        jPanel5.add(jPanelInstruncciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 240, 260));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 350));

        jLabelBorrarUltimo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelBorrarUltimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBorrarUltimo.setText("BORRAR ULTIMO");
        jLabelBorrarUltimo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelBorrarUltimo.setOpaque(true);
        jLabelBorrarUltimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBorrarUltimoMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelBorrarUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 860, 270, 40));

        jLabel5.setBackground(new java.awt.Color(234, 222, 108));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TICKET DEL PEDIDO");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(121, 118, 130)));
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 355, 270, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 270, -1));

        jPanelKiosko.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 280, 955));

        getContentPane().add(jPanelKiosko, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 482, 1080, 957));

        jPanelUp.setBackground(new java.awt.Color(210, 205, 231));
        jPanelUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1079, 483));

        jPanelDown.setBackground(new java.awt.Color(210, 205, 231));
        jPanelDown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanelDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1438, 1079, 482));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPagarMouseClicked
        // TODO add your handling code here:
        eventPagarProceso(evt);
        //eventPagarMouseClicked(evt);
    }//GEN-LAST:event_jLabelPagarMouseClicked

    private void jLabelCancelarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarPedidoMouseClicked
        // TODO add your handling code here:
        initContentTable();
    }//GEN-LAST:event_jLabelCancelarPedidoMouseClicked

    private void jLabelBorrarUltimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBorrarUltimoMouseClicked
        // TODO add your handling code here:
        eventBorrarUltimoMouseClicked(evt);
    }//GEN-LAST:event_jLabelBorrarUltimoMouseClicked

    private void jLabelDownProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDownProductoMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_PRODUCTO, TYPE_RIGHT);
    }//GEN-LAST:event_jLabelDownProductoMouseClicked

    private void jLabelUpProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpProductoMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_PRODUCTO, TYPE_LEFT);
    }//GEN-LAST:event_jLabelUpProductoMouseClicked

    private void jLabelRightFamiliaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightFamiliaMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_FAMILIA, TYPE_RIGHT);
    }//GEN-LAST:event_jLabelRightFamiliaMouseClicked

    private void jLabelLeftFamiliaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftFamiliaMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_FAMILIA, TYPE_LEFT);
    }//GEN-LAST:event_jLabelLeftFamiliaMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        eventPagarMouseClicked(evt);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabelRightSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightSectorMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_SECTOR, TYPE_RIGHT);
    }//GEN-LAST:event_jLabelRightSectorMouseClicked

    private void jLabelLeftSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftSectorMouseClicked
        // TODO add your handling code here:
        setContentPanel(TYPE_SECTOR, TYPE_LEFT);
    }//GEN-LAST:event_jLabelLeftSectorMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBorrarUltimo;
    private javax.swing.JLabel jLabelCancelarPedido;
    private javax.swing.JLabel jLabelDownProducto;
    private javax.swing.JLabel jLabelLeftFamilia;
    private javax.swing.JLabel jLabelLeftSector;
    private javax.swing.JLabel jLabelPagar;
    private javax.swing.JLabel jLabelRightFamilia;
    private javax.swing.JLabel jLabelRightSector;
    private javax.swing.JLabel jLabelTituloFamilia;
    private javax.swing.JLabel jLabelTituloProducto;
    private javax.swing.JLabel jLabelTituloSector;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelUpProducto;
    private javax.swing.JLayeredPane jLayeredPaneFamilia;
    private javax.swing.JLayeredPane jLayeredPaneProducto;
    private javax.swing.JLayeredPane jLayeredPaneSector;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JPanel jPanelFamilia;
    private javax.swing.JPanel jPanelInstruncciones;
    private javax.swing.JPanel jPanelKiosko;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelSector;
    private javax.swing.JPanel jPanelUp;
    private javax.swing.JTable jTableFactura;
    // End of variables declaration//GEN-END:variables
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                      FUNCIONDES DE PAGINAS                            */
    ////////////////////////////////////////////////////////////////////////////
    public int configPag(int numeroProductos, int ElePorPag){
        int operacion = numeroProductos / ElePorPag;
        if  (numeroProductos % ElePorPag > 0) operacion++;
        return operacion; 
    }
    
    private int PaginacionElemento(String sentido, int pagActualProducto, int NumeroDePaginasMaxima ){
        
        if ((pagActualProducto > 1)&&(pagActualProducto <= NumeroDePaginasMaxima)&&(sentido.equals(TYPE_UP) || sentido.equals(TYPE_LEFT))) 
                pagActualProducto--;
        else if ((pagActualProducto > 1)&&(pagActualProducto < NumeroDePaginasMaxima)&&(sentido.equals(TYPE_DONW) || sentido.equals(TYPE_RIGHT))) 
                pagActualProducto++;
        else if ((pagActualProducto == 1)&&(pagActualProducto < NumeroDePaginasMaxima)&&(sentido.equals(this.TYPE_DONW) || sentido.equals(TYPE_RIGHT))) 
                pagActualProducto++;
        else if ((pagActualProducto == NumeroDePaginasMaxima)&&(sentido.equals(this.TYPE_DONW) || sentido.equals(TYPE_RIGHT)))
                System.out.println("No hace nada");
        else pagActualProducto = 1;
        return pagActualProducto;
    }
    
    private void setContentPanel(String tipo, String sentido){
        int primerPosicion = 0;
        int pivote = 0;
        if (tipo.equals(TYPE_SECTOR)){
            PaginaActualSectores = PaginacionElemento(sentido, PaginaActualSectores, numeroDePaginaSectores );
            if (PaginaActualSectores > 1) primerPosicion = ( PaginaActualSectores - 1 ) * JLabelSector.length;
            SectorActual = datos.sector[primerPosicion].getDescripcionCorta();
            PaginaActualFamilias = 1;
            pivote = primerPosicion;
            for(Integer i=0; i<JLabelSector.length; i++){
                if (primerPosicion < datos.sector.length){
                    JLabelSector[i].setName(datos.sector[primerPosicion].getDescripcionCorta());
                    JLabelSector[i].setIcon(datos.sector[primerPosicion++].getImagen());
                } else {
                    JLabelSector[i].setName(SIN_ASIGNAR);
                    JLabelSector[i].setIcon(new javax.swing.ImageIcon("static/sec.png"));
                }  
            }
            primerPosicion = 0;
            FamiliaActual = datos.sector[pivote].familia[primerPosicion].getDescripcionCorta();
            for(Integer i=0; i<JLabelFamilia.length; i++){ 
                if (primerPosicion < datos.sector[pivote].familia.length){
                    JLabelFamilia[i].setName(datos.sector[pivote].familia[primerPosicion].getDescripcionCorta());
                    JLabelFamilia[i].setIcon(datos.sector[pivote].familia[primerPosicion++].getImagen());
                } else {
                    JLabelFamilia[i].setName(SIN_ASIGNAR);
                    JLabelFamilia[i].setIcon(new javax.swing.ImageIcon("static/fam.png"));
                } 
            }
            primerPosicion = 0;
            for(Integer i=0; i<JLabelProductos.length; i++) { 
                if (i < datos.sector[pivote].familia[0].producto.length) {
                    JLabelProductos[i].setName(datos.sector[pivote].familia[0].producto[primerPosicion].getDescripcionCorta());
                    JLabelProductos[i].setIcon(datos.sector[pivote].familia[0].producto[primerPosicion].getImagen());
                    JLabelProductos[i].setText(datos.sector[pivote].familia[0].producto[primerPosicion++].getcosto());
                } else {
                    JLabelProductos[i].setName(SIN_ASIGNAR);
                    JLabelProductos[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                    JLabelProductos[i].setText("0.00");
                }
            }

        }
        if (tipo.equals(TYPE_FAMILIA) && (numeroDePaginaFamilias > 1)){
            primerPosicion = 0;
            PaginaActualFamilias = PaginacionElemento(sentido, PaginaActualFamilias, numeroDePaginaFamilias );
            if (PaginaActualFamilias > 1) primerPosicion = (PaginaActualFamilias-1)*JLabelFamilia.length;
            pivote = primerPosicion;
            for(Integer j=0; j < datos.sector.length; j++){
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())){
                    for(Integer i=0; i<JLabelFamilia.length; i++){ 
                        if (primerPosicion < datos.sector[j].familia.length){
                            JLabelFamilia[i].setName(datos.sector[j].familia[primerPosicion].getDescripcionCorta());
                            JLabelFamilia[i].setIcon(datos.sector[j].familia[primerPosicion++].getImagen());
                        } else {
                            JLabelFamilia[i].setName(SIN_ASIGNAR);
                            JLabelFamilia[i].setIcon(new javax.swing.ImageIcon("static/fam.png"));
                        } 
                    }
                    primerPosicion = 0;
                    for(Integer i=0; i<JLabelProductos.length; i++) { 
                        if (i < datos.sector[j].familia[pivote].producto.length) {
                            JLabelProductos[i].setName(datos.sector[j].familia[pivote].producto[primerPosicion].getDescripcionCorta());
                            JLabelProductos[i].setIcon(datos.sector[j].familia[pivote].producto[primerPosicion].getImagen());
                            JLabelProductos[i].setText(datos.sector[j].familia[pivote].producto[primerPosicion++].getcosto());
                        } else {
                            JLabelProductos[i].setName(SIN_ASIGNAR);
                            JLabelProductos[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                            JLabelProductos[i].setText("0.00");
                        }
                    }
                    FamiliaActual = datos.sector[j].familia[pivote].getDescripcionCorta();
                    numeroDePaginaFamilias = configPag(datos.sector[j].familia.length, elementosPorPaginaFamilias);
                }
            }
        }
        if (tipo.equals(TYPE_PRODUCTO)) {
            primerPosicion = 0;
            PaginaActualProductos = PaginacionElemento(sentido, PaginaActualProductos, numeroDePaginaProductos );
            if (PaginaActualProductos > 1) primerPosicion = (PaginaActualProductos-1)*JLabelProductos.length;
            for(Integer j=0; j<datos.sector.length; j++) {
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())) {
                    for(Integer jj=0; jj<datos.sector[j].familia.length; jj++){ 
                        if (FamiliaActual.equals(datos.sector[j].familia[jj].getDescripcionCorta())) {
                            for(Integer i=0; i<JLabelProductos.length; i++) { 
                                if (primerPosicion < datos.sector[j].familia[jj].producto.length) {
                                    JLabelProductos[i].setName(datos.sector[j].familia[jj].producto[primerPosicion].getDescripcionCorta());
                                    JLabelProductos[i].setIcon(datos.sector[j].familia[jj].producto[primerPosicion].getImagen());
                                    JLabelProductos[i].setText(datos.sector[j].familia[jj].producto[primerPosicion++].getcosto());
                                } else {
                                    JLabelProductos[i].setName(SIN_ASIGNAR);
                                    JLabelProductos[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                                    JLabelProductos[i].setText("0.00");
                                }
                            }
                            numeroDePaginaProductos = configPag(datos.sector[j].familia[jj].producto.length, elementosPorPaginaProductos);
                        }
                    }
                }
            }
        }
        setArrowVisible(tipo);
    }
    
    private void setContentPanel(String tipo){
        if (tipo.equals(TYPE_SECTOR)) {
            int primerPosicion = 0;
            if (PaginaActualFamilias > 1) primerPosicion = (PaginaActualFamilias-1)*JLabelFamilia.length;
            int pivote = primerPosicion;
            for(Integer j=0; j < datos.sector.length; j++){
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())){
                    for(Integer i=0; i<JLabelFamilia.length; i++) { 
                        if (primerPosicion < datos.sector[j].familia.length) {
                            JLabelFamilia[i].setName(datos.sector[j].familia[primerPosicion].getDescripcionCorta());
                            JLabelFamilia[i].setIcon(datos.sector[j].familia[primerPosicion++].getImagen());
                        } else {
                            JLabelFamilia[i].setName(SIN_ASIGNAR);
                            JLabelFamilia[i].setIcon(new javax.swing.ImageIcon("static/fam.png"));
                        } 
                    }
                    numeroDePaginaFamilias = configPag(datos.sector[j].familia.length, elementosPorPaginaFamilias);
                    FamiliaActual = datos.sector[j].familia[pivote].getDescripcionCorta();
                    numeroDePaginaProductos = configPag(datos.sector[j].familia[pivote].producto.length, elementosPorPaginaProductos);
                    primerPosicion = 0;
                    for(Integer i=0; i<JLabelProductos.length; i++) { 
                            if (i < datos.sector[j].familia[0].producto.length) {
                                JLabelProductos[i].setName(datos.sector[j].familia[pivote].producto[primerPosicion].getDescripcionCorta());
                                JLabelProductos[i].setIcon(datos.sector[j].familia[pivote].producto[primerPosicion].getImagen());
                                JLabelProductos[i].setText(datos.sector[j].familia[pivote].producto[primerPosicion++].getcosto());
                            } else {
                                JLabelProductos[i].setName(SIN_ASIGNAR);
                                JLabelProductos[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                                JLabelProductos[i].setText("0.00");
                            }
                    }
                break;
                }
            }

        }
        
        if (tipo.equals(TYPE_FAMILIA)){
            for(Integer j=0; j<datos.sector.length; j++) {
                if (SectorActual.equals(datos.sector[j].getDescripcionCorta())) {
                    for(Integer jj=0; jj<datos.sector[j].familia.length; jj++){ 
                        if (FamiliaActual.equals(datos.sector[j].familia[jj].getDescripcionCorta())) {
                            for(Integer i=0; i<JLabelProductos.length; i++) { 
                                if (i < datos.sector[j].familia[jj].producto.length) {
                                    JLabelProductos[i].setName(datos.sector[j].familia[jj].producto[i].getDescripcionCorta());
                                    JLabelProductos[i].setIcon(datos.sector[j].familia[jj].producto[i].getImagen());
                                    JLabelProductos[i].setText(datos.sector[j].familia[jj].producto[i].getcosto());
                                } else {
                                    JLabelProductos[i].setName(SIN_ASIGNAR);
                                    JLabelProductos[i].setIcon(new javax.swing.ImageIcon("static/img.png"));
                                    JLabelProductos[i].setText("0.00");
                                }
                            }
                            numeroDePaginaProductos = configPag(datos.sector[j].familia[jj].producto.length, elementosPorPaginaProductos);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        
    }

    
    ////////////////////////////////////////////////////////////////////////////
    //*                      FUNCIONDES DE ESTILOS                            */
    ////////////////////////////////////////////////////////////////////////////
    private void setPosition(String tipo){
        if (tipo.equals(TYPE_SECTOR)){
            jLayeredPaneSector.setPosition(jLabelTituloSector, -1);
            jLayeredPaneSector.setPosition(jLabelRightSector, 0);
            jLayeredPaneSector.setPosition(jLabelLeftSector, 1);
        }
        if (tipo.equals(TYPE_FAMILIA)){
            jLayeredPaneFamilia.setPosition(jLabelTituloFamilia, -1);
            jLayeredPaneFamilia.setPosition(jLabelRightFamilia, 0);
            jLayeredPaneFamilia.setPosition(jLabelLeftFamilia, 1);
        }
        if (tipo.equals(TYPE_PRODUCTO)){
            jLayeredPaneProducto.setPosition(jLabelTituloProducto, -1);
            jLayeredPaneProducto.setPosition(jLabelUpProducto, 0);
            jLayeredPaneProducto.setPosition(jLabelDownProducto, 1);
        }
    }
    
    public void setBlinkSector() {        
        ThreadSectorBlink = new Thread() {
            @Override
            public void run() {
                try {
                    SectorThread = true;
                    while(SectorThread) {
                        setActiveTitle(jLabelTituloSector, YELLOW_ON, BLACK);
                        jLabelRightSector.repaint();
                        jLabelLeftSector.repaint();
                        setPosition(TYPE_SECTOR);
                        Thread.sleep(blinkTime);
                        setActiveTitle(jLabelTituloSector, WHITE, GRAY);
                        jLabelRightSector.repaint();
                        jLabelLeftSector.repaint();
                        setPosition(TYPE_SECTOR);
                        Thread.sleep(blinkTime);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(JFrameKiosko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ThreadSectorBlink.start();
    }
    
    public void setBlinkFamilia() {        
        ThreadFamiliaBlink = new Thread() {
            @Override
            public void run() {
                try {
                    FamiliaThread = true;
                    while(FamiliaThread) {
                        setActiveTitle(jLabelTituloFamilia, YELLOW_ON, BLACK);
                        jLabelRightFamilia.repaint();
                        jLabelLeftFamilia.repaint();
                        setPosition(TYPE_FAMILIA);
                        Thread.sleep(blinkTime);
                        setActiveTitle(jLabelTituloFamilia, WHITE, GRAY);
                        jLabelRightFamilia.repaint();
                        jLabelLeftFamilia.repaint();
                        setPosition(TYPE_FAMILIA);
                        Thread.sleep(blinkTime);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(JFrameKiosko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ThreadFamiliaBlink.start();
    }

    public void setBlinkProducto() {        
        ThreadProductoBlink = new Thread() {
            @Override
            public void run() {
                try {
                    ProductoThread = true;
                    while(ProductoThread) {
                        setActiveTitle(jLabelTituloProducto, CIAN_ON, GREEN);
                        jLabelUpProducto.repaint();
                        jLabelDownProducto.repaint();
                        setPosition(TYPE_PRODUCTO);
                        Thread.sleep(blinkTime);
                        setActiveTitle(jLabelTituloProducto, WHITE, GRAY);
                        jLabelUpProducto.repaint();
                        jLabelDownProducto.repaint();
                        setPosition(TYPE_PRODUCTO);
                        Thread.sleep(blinkTime);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(JFrameKiosko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ThreadProductoBlink.start();
    }

    private void setActiveTitle(javax.swing.JLabel jlabel, java.awt.Color BackgroundColor, java.awt.Color ForegroundColor){
        jlabel.setBackground(BackgroundColor);
        jlabel.setForeground(ForegroundColor);
    }
    
    private void setElementChoise(javax.swing.JLabel[] jlabels, String itemActual){
        for (JLabel jLabel : jlabels) {
            if (itemActual.equals(TODO_APAGADO)){
                jLabel.setBorder(javax.swing.BorderFactory.createLineBorder(GRAY_2, 1));
                jLabel.setEnabled(false);
            }else if (itemActual.equals(TODO_ACTIVO)) {
                jLabel.setBorder(javax.swing.BorderFactory.createLineBorder(GRAY_2, 1));
                jLabel.setEnabled(true);
            } else {
                if (itemActual.equals(jLabel.getName()) && !itemActual.equals(SIN_ASIGNAR)) {
                    jLabel.setBorder(javax.swing.BorderFactory.createLineBorder(ORANGE, 3));
                    jLabel.setEnabled(true);
                }else{
                    jLabel.setBorder(javax.swing.BorderFactory.createLineBorder(GRAY_2, 1));
                    jLabel.setEnabled(false);
                }
            }
            
            
        }
    }
    
    private void setArrowVisible(String tipo){
        
        if (tipo.equals(TYPE_SECTOR)){
            jLabelLeftSector.setIcon(new javax.swing.ImageIcon(getClass().getResource(LEFT_ON)));
            jLabelRightSector.setIcon(new javax.swing.ImageIcon(getClass().getResource(RIGHT_ON)));
            //ELIMINA IZQ - DER
            if (PaginaActualSectores==1 && numeroDePaginaSectores==1){
                jLabelLeftSector.setIcon(null);
                jLabelRightSector.setIcon(null);
            }
            //ELIMINA IZQ
            else if (PaginaActualSectores==1){
                jLabelLeftSector.setIcon(null);
            }
            //ELIMINA DER
            else if (PaginaActualSectores==numeroDePaginaSectores){
                jLabelRightSector.setIcon(null);
            }
            jLabelLeftSector.repaint();
            jLabelRightSector.repaint();
        }
        else if (tipo.equals(TYPE_FAMILIA)){
            jLabelLeftFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource(LEFT_ON)));
            jLabelRightFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource(RIGHT_ON)));
            //ELIMINA IZQ - DER
            if (PaginaActualFamilias==1 && numeroDePaginaFamilias==1){
                jLabelLeftFamilia.setIcon(null);
                jLabelRightFamilia.setIcon(null);
            }
            //ELIMINA IZQ
            else if (PaginaActualFamilias==1){
                jLabelLeftFamilia.setIcon(null);
            }
            //ELIMINA DER
            else if (PaginaActualFamilias==numeroDePaginaFamilias){
                jLabelRightFamilia.setIcon(null);
            }
            jLabelLeftFamilia.repaint();
            jLabelRightFamilia.repaint();
        }
        else if (tipo.equals(TYPE_PRODUCTO)){
            jLabelUpProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource(UP_ON)));
            jLabelDownProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource(DOWN_ON)));
            //ELIMINA IZQ - DER
            if (PaginaActualProductos==1 && numeroDePaginaProductos==1){
                jLabelUpProducto.setIcon(null);
                jLabelDownProducto.setIcon(null);
            }
            //ELIMINA IZQ
            else if (PaginaActualProductos==1){
                jLabelUpProducto.setIcon(null);
            }
            //ELIMINA DER
            else if (PaginaActualProductos==numeroDePaginaProductos){
                jLabelDownProducto.setIcon(null);
            }
            jLabelUpProducto.repaint();
            jLabelDownProducto.repaint();
        }
    }
 
    private void setActiveBanner(String tipo, Boolean activate){
        if (tipo.equals(this.TYPE_SECTOR)) {
            setArrowVisible(tipo);
            if (activate){ 
                setBlinkSector();
            } else {
                SectorThread = false;
                setActiveTitle(jLabelTituloSector, WHITE, GRAY);
                setPosition(TYPE_SECTOR);
            }
        }
        if (tipo.equals(this.TYPE_FAMILIA)) {
            setArrowVisible(tipo);
            if (activate){ 
                setBlinkFamilia(); 
            } else {
                FamiliaThread = false;
                setActiveTitle(jLabelTituloFamilia, WHITE, GRAY);
                setPosition(TYPE_FAMILIA);
            }
        }
        if (tipo.equals(this.TYPE_PRODUCTO)) {
            if (activate) {
                setBlinkProducto();
            } else {
                ProductoThread = false;
                setActiveTitle(jLabelTituloProducto, WHITE, GRAY);
            }
            setArrowVisible(tipo);
            setPosition(TYPE_PRODUCTO);
        }
    }
    
    private void setActiveInstruccion(String instruccion){
        int length = 0;
        if (instruccion.equals(INSTR_1)) length = 0;
        if (instruccion.equals(INSTR_2)) length = 1;
        if (instruccion.equals(INSTR_3)) length = 2;
        if (instruccion.equals(INSTR_4)) length = 3;
        if (instruccion.equals(INSTR_5)) length = 4;
        
        for(Integer i=0; i<JLabelInstrucciones.length; i++){
            JLabelInstrucciones[i].setFont(NORMAL);
            JLabelInstrucciones[i].setOpaque(false);
        }

        for(Integer i=0; i<=length; i++){
            JLabelInstrucciones[i].setFont(NORMAL);
            if (i==0){
                JLabelInstrucciones[0].setFont(BOLD);
                JLabelInstrucciones[i].setOpaque(true);
                setActiveTitle(jLabelTituloSector, WHITE, BLACK);
            }
            if (i==1){
                JLabelInstrucciones[1].setFont(BOLD);
                JLabelInstrucciones[i].setOpaque(true);
                setActiveTitle(jLabelTituloFamilia, WHITE, BLACK);
            }
            if (i==2){
                JLabelInstrucciones[2].setFont(BOLD);
                JLabelInstrucciones[i].setOpaque(true);
                setActiveTitle(jLabelTituloProducto, WHITE, BLACK);
            }
            if (i==3){
                JLabelInstrucciones[3].setFont(BOLD);
                JLabelInstrucciones[i].setOpaque(true);
            }
            if (i==4){
                JLabelInstrucciones[4].setFont(BOLD);
                JLabelInstrucciones[i].setOpaque(true);
            }
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //*                      FUNCIONDES DE CALCULOS                            */
    ////////////////////////////////////////////////////////////////////////////
    private String getTotal(String total, String producto, String type) {
        String euro = "€";
        String output = "0.00";
        Double opeTotal;
        Double opeProducto;
        if ((type.equals(this.TYPE_SUMA)) || (type.equals(this.TYPE_RESTA))){
            opeTotal = new Double(total.substring(0, total.length()-1));
            opeProducto = new Double(producto);
            if (type.equals(this.TYPE_SUMA)) opeTotal = opeTotal + opeProducto;  
            if (type.equals(this.TYPE_RESTA)) opeTotal = opeTotal - opeProducto; 
            output = opeTotal.toString();
        }
        return output + euro;
    }   

    
}

/*
        NOTAS 

        <<<<< Cambios marte 21 de enero

        1) seleccione secto selecionado
        2) familia de los mas vendidos por defecto siempre aparecen
        3) al inicio solo sector esta encendido, banner familia

        <<<<< Cambios Domingo 26 de enero 

        1) lista de instrucciones en el area de pedido
            1 - selecione sector
            2 - seleccione familia
            3 - selecione acticulos
            4 - pagar
            5 - retire el ticket y entregelo en barra
        2) el banner cambiar de nombre segun el sector y familia  
        3) colocar fonto al selecionar acticulos al panel

        <<<<< Cambios Domingo 2 de Febrero

        * Manejos de datos desde de BD solo procedimientos en  SQL
        * Integrar imagenes nuevas de sectores, familias y articulos
        * Integrar nuevos botones borders azules
        * conectar con la BD
        * Integrar los procedimientos BD con el Kiosko
        
*/