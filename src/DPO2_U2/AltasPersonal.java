/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPO2_U2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author anram
 */
public class AltasPersonal implements ActionListener {
     //Variables
    JFrame altasPersonal = new JFrame();
    JMenuBar barra = new JMenuBar();
    
    //elementos de la barra menu
    JMenu personal = new JMenu("Personal");
    JMenu inventario = new JMenu("Inventario");
    JMenu nomina = new JMenu("Nómina");
    
    //elementos menú Personal
    JMenuItem altasPersonalMenu = new JMenuItem("Altas");
    JMenuItem bajasPersonalMenu = new JMenuItem("Bajas");
    
    //elementos menú Inventario
    JMenuItem bajasInventarioMenu = new JMenuItem("Bajas");
    JMenuItem altasInventarioMenu = new JMenuItem("Altas");
    JMenu reportesInventarioMenu = new JMenu("Reportes");

    //Nomina Menu Items
    JMenuItem vNomina = new JMenuItem("Ver Nómina");
    
    //Reportes SubMenu Items
    JMenuItem altasEReporteMenu = new JMenuItem("Altas de equipo");
    JMenuItem bajasEReporteMenu = new JMenuItem("Bajas de equipo");
    JMenuItem bajasReporteMenu = new JMenuItem("Bajas de personal");
    
    //Form items
    JLabel eNumeroEmpleado = new JLabel("Número de empleado:");
    JLabel eNombreEmpleado = new JLabel("Nombre:");
    JLabel eApellidoPaterno = new JLabel("Apellido paterno:");
    JLabel eApellidoMaterno = new JLabel("Apellido materno:");
    JLabel eDepartamentoEmpleado = new JLabel("Departamento:");
    JLabel eSucursalEmpleado = new JLabel("Sucursal:");
    JLabel eNAcademicoEmpleado = new JLabel("Nivel academico:");
    JLabel ePuestoEmpleado = new JLabel("Puesto:");
    JLabel eSueldoEmpleado = new JLabel("Sueldo Neto:");
    
    JTextField tNumeroEmpleado = new JTextField();
    JTextField tNombreEmpleado = new JTextField();
    JTextField tApellidoPaterno = new JTextField();
    JTextField tApellidoMaterno = new JTextField();
    JTextField tDepartamentoEmpleado = new JTextField();
    JTextField tSucursalEmpleado = new JTextField();
    JTextField tNAcademicoEmpleado = new JTextField();
    JTextField tPuestoEmpleado = new JTextField();
    JTextField tSueldoEmpleado = new JTextField();
    
    JButton altasSubmitButton = new JButton("Aceptar");
    JButton altasSalirButton = new JButton("Salir");

    //Connection variables
    Conexion cx = new Conexion();
          
    AltasPersonal(){
        eNumeroEmpleado.setBounds(10, 50, 250, 25);
        eNombreEmpleado.setBounds(10, 80, 250, 25);
        eApellidoPaterno.setBounds(10, 110, 250, 25);
        eApellidoMaterno.setBounds(10, 140, 250, 25);
        eDepartamentoEmpleado.setBounds(10, 170, 250, 25);
        eSucursalEmpleado.setBounds(10, 200, 250, 25);
        eNAcademicoEmpleado.setBounds(10, 230, 250, 25);
        ePuestoEmpleado.setBounds(10, 260, 250, 25);
        eSueldoEmpleado.setBounds(10, 290, 250, 25);
        
        tNumeroEmpleado.setBounds(150, 50, 250, 25);
        tNombreEmpleado.setBounds(150, 80, 250, 25);
        tApellidoPaterno.setBounds(150, 110, 250, 25);
        tApellidoMaterno.setBounds(150, 140, 250, 25);
        tDepartamentoEmpleado.setBounds(150, 170, 250, 25);
        tSucursalEmpleado.setBounds(150, 200, 250, 25);
        tNAcademicoEmpleado.setBounds(150, 230, 250, 25);
        tPuestoEmpleado.setBounds(150, 260, 250, 25);
        tSueldoEmpleado.setBounds(150, 290, 250, 25);
        
        altasSubmitButton.setBounds(60, 340, 120, 30);
        altasSalirButton.setBounds(220, 340, 120, 30);
        
        //Set ActionListener to menu items
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        reportesInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        altasSubmitButton.addActionListener(this);
        altasSalirButton.addActionListener(this);
        
        //Adds elements to Reportes SubMenu
        reportesInventarioMenu.add(altasEReporteMenu);
        reportesInventarioMenu.add(bajasEReporteMenu);
        reportesInventarioMenu.add(bajasReporteMenu);

        //Add Personal menu Items
        personal.add(altasPersonalMenu);
        personal.add(bajasPersonalMenu);
        
        //Add Inventario menu items
        inventario.add(altasInventarioMenu);
        inventario.add(bajasInventarioMenu);
        inventario.add(reportesInventarioMenu);

        //Add Nomina menu Items
        nomina.add(vNomina);
        
        //Add items to menu bar
        barra.add(personal);
        barra.add(inventario);
        barra.add(nomina);
        
        altasPersonal.add(eNumeroEmpleado);
        altasPersonal.add(tNumeroEmpleado);
        altasPersonal.add(eNombreEmpleado);
        altasPersonal.add(tNombreEmpleado);
        altasPersonal.add(eApellidoPaterno);
        altasPersonal.add(tApellidoPaterno);
        altasPersonal.add(eApellidoMaterno);
        altasPersonal.add(tApellidoMaterno);
        altasPersonal.add(eDepartamentoEmpleado);
        altasPersonal.add(tDepartamentoEmpleado);
        altasPersonal.add(eSucursalEmpleado);
        altasPersonal.add(tSucursalEmpleado);
        altasPersonal.add(eNAcademicoEmpleado);
        altasPersonal.add(tNAcademicoEmpleado);
        altasPersonal.add(ePuestoEmpleado);
        altasPersonal.add(tPuestoEmpleado);
        altasPersonal.add(eSueldoEmpleado);
        altasPersonal.add(tSueldoEmpleado);
        altasPersonal.add(altasSubmitButton);
        altasPersonal.add(altasSalirButton);
        
        altasPersonal.setJMenuBar(barra);
        //Frame
        altasPersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        altasPersonal.setLayout(null);
        altasPersonal.setSize(420,500);
        altasPersonal.setLocationRelativeTo(null);
        altasPersonal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            altasPersonal.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            altasPersonal.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            altasPersonal.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            altasPersonal.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == altasSalirButton){
            altasPersonal.dispose();
            LaunchPage principal = new LaunchPage();
        }
        if(e.getSource() == altasSubmitButton){
            try {
                Statement st = cx.conectar().createStatement();
                st.executeUpdate("insert into empleados (EmpleadoId, NombreEmpleado, SueldoBruto, FechaIngresoEmpleado) values(" + tNumeroEmpleado.getText() +", '" + tNombreEmpleado.getText() +"'," + tSueldoEmpleado.getText() + ",'Enero');");
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            //JOptionPane.showMessageDialog(null, "Aún no hay conexión con la BD", "Precaución", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == vNomina){
            altasPersonal.dispose();
            Nomina nomina = new Nomina();
        }
        
    }
}
