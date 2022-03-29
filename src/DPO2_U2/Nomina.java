/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPO2_U2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
// import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anram
 */
public class Nomina extends JFrame implements ActionListener {
    //Constants
    static final int CUOTA_SINDICAL = 5;
    static final int SERVICIOS_MEDICOS = 5;
    static final int CREDITOS = 0;
    static final int DESCUENTOS_INACTIVIDAD = 0;

    //Variables
    JMenuBar barra =new JMenuBar();

    float cuotaSindical;
    float cuotaServMedicos;
    float creditos;
    float descInactividad;
    float bonosDesp;
    float ayudaServ;

    //Elementos de la barra de menu
    JMenu personal = new JMenu("Personal");
    JMenu inventario = new JMenu("Inventario");
    JMenu nomina = new JMenu("Nomina");

    //Personal menu elements
    JMenuItem altasPersonalMenuItem = new JMenuItem("Altas");
    JMenuItem bajasPersonalMenuItem = new JMenuItem("Bajas");
    
    //Inventario menu elemets
    JMenuItem bajasInventarioMenu = new JMenuItem("Bajas");
    JMenuItem altasInventarioMenu = new JMenuItem("Altas");
    JMenu reportesInventarioMenu = new JMenu("Reportes");

    //Nomima menu elements

    //Nomina Menu Items
    JMenuItem vNomina = new JMenuItem("Ver Nómina");

    //Reportes SubMenu elements
    JMenuItem altasEReporteMenu = new JMenuItem("Altas de equipo");
    JMenuItem bajasEReporteMenu = new JMenuItem("Bajas de equipo");
    JMenuItem bajasReporteMenu = new JMenuItem("Bajas de personal");

    //Form Items
    JLabel eNEmpleado = new JLabel("Número de empleado");
    JLabel eNombreEmpleado = new JLabel("Nombre");
    JLabel eApellidoPaterno = new JLabel("Apellido Paterno");
    JLabel eApellidoMaterno  = new JLabel("Apellido Materno");
    JLabel eSalarioEmpleado  = new JLabel("Salario Bruto");
    JLabel eFechaIngreso  = new JLabel("Fecha de Ingreso");

    JTextField tNEmpleado = new JTextField();
    JTextField tNombreEmpleado = new JTextField();
    JTextField tApellidoPaterno = new JTextField();
    JTextField tApellidoMaterno = new JTextField();
    JTextField tSalarioEmpleado = new JTextField();
    JTextField tFechaIngreso = new JTextField();

    JCheckBox cuotaSindicalChBox = new JCheckBox("Cuota sindical",null,false);
    JCheckBox cuotaServMedicosChBox = new JCheckBox("Cuota Servicios Medicos",null,false);
    JCheckBox creditosChBox = new JCheckBox("Total creitos",null,false);
    JCheckBox descInactividadChBox = new JCheckBox("Descuento por inactividad",null,false);

    JCheckBox bonosDespChBox = new JCheckBox("Bonos de despensa",null,false);
    JCheckBox ayudaServChBox = new JCheckBox("Ayuda de Servicio",null,false);

    JTextField cuotaSindicalField = new JTextField(String.valueOf(CUOTA_SINDICAL)+"%");
    JTextField cuotaServMedicosField = new JTextField(String.valueOf(SERVICIOS_MEDICOS)+"%");
    JTextField creditosField = new JTextField(String.valueOf(CREDITOS));
    JTextField descInactividadField = new JTextField(String.valueOf(DESCUENTOS_INACTIVIDAD));

    JTextField bonosDespField = new JTextField(String.valueOf(0));
    JTextField ayudaServField = new JTextField(String.valueOf(0));

    Botones altasAltaEmpleadoButon = new Botones("Agregar");
    Botones reporteEmpleadosButon = new Botones("Ver Empleados");
    Botones cancelarButon = new Botones("Cancelar");
    

    
    Nomina(){
        //Items size and location
        eNEmpleado.setBounds(10, 50, 250, 25);
        eNombreEmpleado.setBounds(10, 80, 250, 25);
        eApellidoPaterno.setBounds(10, 110, 250, 25);
        eApellidoMaterno.setBounds(10, 140, 250, 25);
        eSalarioEmpleado.setBounds(10, 170, 250, 25);
        eFechaIngreso.setBounds(10, 200, 250, 25);
        
        tNEmpleado.setBounds(150, 50, 250, 25);
        tNombreEmpleado.setBounds(150, 80, 250, 25);
        tApellidoPaterno.setBounds(150, 110, 250, 25);
        tApellidoMaterno.setBounds(150, 140, 250, 25);
        tSalarioEmpleado.setBounds(150, 170, 250, 25);
        tFechaIngreso.setBounds(150, 200, 250, 25);

        cuotaSindicalChBox.setBounds(10, 240, 200, 25);
        cuotaSindicalField.setBounds(10, 270, 160, 25);
        cuotaSindicalField.setEnabled(false);
        cuotaSindicalField.setHorizontalAlignment(JTextField.TRAILING);
        cuotaServMedicosChBox.setBounds(10, 300, 200, 25);
        cuotaServMedicosField.setBounds(10, 330, 160, 25);
        cuotaServMedicosField.setEnabled(false);
        cuotaServMedicosField.setHorizontalAlignment(JTextField.TRAILING);
        creditosChBox.setBounds(10, 360, 200, 25);
        creditosField.setBounds(10, 390, 160, 25);
        creditosField.setEnabled(false);
        creditosField.setHorizontalAlignment(JTextField.TRAILING);
        descInactividadChBox.setBounds(10, 420, 200, 25);
        descInactividadField.setBounds(10, 450, 160, 25);
        descInactividadField.setEnabled(false);
        descInactividadField.setHorizontalAlignment(JTextField.TRAILING);
       
        bonosDespChBox.setBounds(220, 240, 200, 25);
        bonosDespField.setBounds(220,270,160,25);
        bonosDespField.setEnabled(false);
        bonosDespField.setHorizontalAlignment(JTextField.TRAILING);
        ayudaServChBox.setBounds(220, 300, 200, 25);
        ayudaServField.setBounds(220, 330, 160, 25);
        ayudaServField.setEnabled(false);
        ayudaServField.setHorizontalAlignment(JTextField.TRAILING);

        altasAltaEmpleadoButon.setBounds(15, 485, 120, 30);
        reporteEmpleadosButon.setBounds(145, 485, 120, 30);
        cancelarButon.setBounds(275, 485, 120, 30);

        //Sets actionlisteners
        altasPersonalMenuItem.addActionListener(this);
        bajasPersonalMenuItem.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        reportesInventarioMenu.addActionListener(this);
        altasAltaEmpleadoButon.addActionListener(this);
        reporteEmpleadosButon.addActionListener(this);
        cancelarButon.addActionListener(this);
        cuotaSindicalChBox.addActionListener(this);
        cuotaServMedicosChBox.addActionListener(this);
        creditosChBox.addActionListener(this);
        descInactividadChBox.addActionListener(this);
        bonosDespChBox.addActionListener(this);
        ayudaServChBox.addActionListener(this);


        //Adds elements to Reportes SubMenu
        reportesInventarioMenu.add(altasEReporteMenu);
        reportesInventarioMenu.add(bajasEReporteMenu);
        reportesInventarioMenu.add(bajasReporteMenu);

        //Add Personal menu Items
        personal.add(altasPersonalMenuItem);
        personal.add(bajasPersonalMenuItem);
        
        //Add Inventario menu items
        inventario.add(altasInventarioMenu);
        inventario.add(bajasInventarioMenu);
        inventario.add(reportesInventarioMenu);
        
        //Add items to menu bar
        barra.add(personal);
        barra.add(inventario);
        barra.add(nomina);

        // Adds items to frame
        this.add(eNEmpleado);
        this.add(eNombreEmpleado);
        this.add(eApellidoPaterno);
        this.add(eApellidoMaterno);
        this.add(eSalarioEmpleado);
        this.add(eFechaIngreso);
        this.add(tNEmpleado);
        this.add(tNombreEmpleado);
        this.add(tApellidoPaterno);
        this.add(tApellidoMaterno);
        this.add(tSalarioEmpleado);
        this.add(tFechaIngreso);
        this.add(cuotaSindicalChBox);
        this.add(cuotaSindicalField);
        this.add(cuotaServMedicosChBox);
        this.add(cuotaServMedicosField);
        this.add(creditosChBox);
        this.add(creditosField);
        this.add(descInactividadChBox);
        this.add(descInactividadField);
        this.add(bonosDespChBox);
        this.add(bonosDespField);
        this.add(ayudaServChBox);
        this.add(ayudaServField);

        this.add(altasAltaEmpleadoButon);
        this.add(reporteEmpleadosButon);
        this.add(cancelarButon);

        this.setJMenuBar(barra);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(420,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == altasPersonalMenuItem){
            this.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenuItem){
            this.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            this.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            this.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        
        if(e.getSource() == cancelarButon){
            this.dispose();
            LaunchPage principal = new LaunchPage();
        }
        if(e.getSource() == cuotaSindicalChBox){
            if(cuotaSindicalChBox.isSelected()){
                cuotaSindicalField.setEnabled(true);

                if(cuotaSindicalChBox.getText().contains("%")){
                    cuotaSindical = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    cuotaSindical = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                } 
            }
            else{
                cuotaSindicalField.setEnabled(false);
                cuotaSindical = 0;
            }
        }
        if(e.getSource() == cuotaServMedicosChBox){
            if(cuotaServMedicosChBox.isSelected()){
                cuotaServMedicosField.setEnabled(true);
                
                if(cuotaSindicalChBox.getText().contains("%")){
                    cuotaServMedicos = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    cuotaServMedicos = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
            }
            else{
                cuotaServMedicosField.setEnabled(false);
                cuotaServMedicos = 0;
            }
        }
        if(e.getSource() == creditosChBox){
            if(creditosChBox.isSelected()){
                creditosField.setEnabled(true);
                
                if(cuotaSindicalChBox.getText().contains("%")){
                    creditos = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    creditos = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
            }
            else{
                creditosField.setEnabled(false);
                creditos = 0;
            }
        }
        if(e.getSource() == descInactividadChBox){
            if(descInactividadChBox.isSelected()){
                descInactividadField.setEnabled(true);
                
                if(cuotaSindicalChBox.getText().contains("%")){
                    descInactividad = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    descInactividad = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
            }
            else{
                descInactividadField.setEnabled(false);
                descInactividad = 0;
            }
        }
        if(e.getSource() == bonosDespChBox){
            if(bonosDespChBox.isSelected()){
                bonosDespField.setEnabled(true);
                
                if(cuotaSindicalChBox.getText().contains("%")){
                    bonosDesp = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    bonosDesp = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
            }
            else{
                bonosDespField.setEnabled(false);
                bonosDesp = 0;
            }
        }
        if(e.getSource() == ayudaServChBox){
            if(ayudaServChBox.isSelected()){
                ayudaServField.setEnabled(true);
                
                if(cuotaSindicalChBox.getText().contains("%")){
                    ayudaServ = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
                else{
                    ayudaServ = Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
                }
            }
            else{
                ayudaServField.setEnabled(false);
                ayudaServ = 0;
            }
        }
        if(e.getSource() == altasAltaEmpleadoButon){
            Float salarioBruto = Float.parseFloat(tSalarioEmpleado.getText());
            Float salarioNeto = salarioBruto-(salarioBruto * (cuotaSindical/100)) - (salarioBruto * (cuotaServMedicos/100)) - creditos - descInactividad + bonosDesp + ayudaServ;
            Object[][] datos = {{
                Integer.valueOf(tNEmpleado.getText()),
                tNombreEmpleado.getText(),
                tApellidoPaterno.getText(),
                tApellidoMaterno.getText(),
                salarioBruto,
                tFechaIngreso.getText(),
                salarioNeto
            }};
            try {
                NominaTable table = new NominaTable(datos);
            } 
            catch (PrinterException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == reporteEmpleadosButon){
            Conexion cx = new Conexion();
            try {
                Statement st = cx.conectar().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM empleados WHERE EmpleadoID = '" + tNEmpleado.getText() + "'");
                //java.sql.ResultSetMetaData rsmt = rs.getMetaData();
                // int columnsCount = rsmt.getColumnCount();
                // while (rs.next()){
                //     for (int i = 1; i <= columnsCount; i++){
                //         if (i > 1) System.out.print(" | ");
                //         System.out.print(rs.getString(i));
                //     }
                //     System.out.println();
                // }
                if (rs.next()){
                tNombreEmpleado.setText(rs.getString(2));
                tSalarioEmpleado.setText(rs.getString(3));
                tFechaIngreso.setText(rs.getString(4));
                }
                
            }
            catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cx.desconectar();
        }
        //get text from textfield to cast to int and divide by 100
        // if(cuotaSindicalChBox.getText().contains("%")){
        //     Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1)));
        // }
        // else{
        //     Float.parseFloat(cuotaSindicalField.getText().substring(0, cuotaSindicalField.getText().length()-1));
        // }    
    }
    
}
