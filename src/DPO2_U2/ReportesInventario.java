/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPO2_U2;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anram
 */
public class ReportesInventario implements ActionListener {
    //Variables
    JFrame reportesInventario = new JFrame();
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
    
    //Panel variables
    JPanel pAltasEquipo = new JPanel();
    JPanel pBajasEquipo = new JPanel();
    JPanel pBajasPersonal = new JPanel();
    
    JLabel eNumeroEmpleado = new JLabel("Número de empleado:");
//    JLabel eNombreEmpleado = new JLabel("Nombre:");
//    JLabel eApellidoPaterno = new JLabel("Apellido paterno:");
//    JLabel eApellidoMaterno = new JLabel("Apellido materno:");
//    JLabel eDepartamentoEmpleado = new JLabel("Departamento:");
//    JLabel eSucursalEmpleado = new JLabel("Sucursal:");
//    JLabel eNAcademicoEmpleado = new JLabel("Nivel academico:");
//    JLabel ePuestoEmpleado = new JLabel("Puesto:");
//    JLabel eSueldoEmpleado = new JLabel("Sueldo Neto:");
//    
    JTextField tNumeroEmpleado = new JTextField();
//    JTextField tNombreEmpleado = new JTextField();
//    JTextField tApellidoPaterno = new JTextField();
//    JTextField tApellidoMaterno = new JTextField();
//    JTextField tDepartamentoEmpleado = new JTextField();
//    JTextField tSucursalEmpleado = new JTextField();
//    JTextField tNAcademicoEmpleado = new JTextField();
//    JTextField tPuestoEmpleado = new JTextField();
//    JTextField tSueldoEmpleado = new JTextField();
//    
//    JButton altasSubmitButton = new JButton("Aceptar");
//    JButton altasSalirButton = new JButton("Salir");
          
    ReportesInventario(){
        
        //Set ActionListener to menu items
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        
        //Adds elements to Reportes SubMenu
        reportesInventarioMenu.add(altasEReporteMenu,"Altas Equipo");
        reportesInventarioMenu.add(bajasEReporteMenu, "Bajas Equipo");
        reportesInventarioMenu.add(bajasReporteMenu, "Bajas Personal");
        
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
        
        reportesInventario.setJMenuBar(barra);      
        
//        reportesInventario.add(eNumeroEmpleado);
//        reportesInventario.add(tNumeroEmpleado);
//        reportesInventario.add(eNombreEmpleado);
//        reportesInventario.add(tNombreEmpleado);
//        reportesInventario.add(eApellidoPaterno);
//        reportesInventario.add(tApellidoPaterno);
//        reportesInventario.add(eApellidoMaterno);
//        reportesInventario.add(tApellidoMaterno);
//        reportesInventario.add(eDepartamentoEmpleado);
//        reportesInventario.add(tDepartamentoEmpleado);
//        reportesInventario.add(eSucursalEmpleado);
//        reportesInventario.add(tSucursalEmpleado);
//        reportesInventario.add(eNAcademicoEmpleado);
//        reportesInventario.add(tNAcademicoEmpleado);
//        reportesInventario.add(ePuestoEmpleado);
//        reportesInventario.add(tPuestoEmpleado);
//        reportesInventario.add(eSueldoEmpleado);
//        reportesInventario.add(tSueldoEmpleado);
//        reportesInventario.add(altasSubmitButton);
//        reportesInventario.add(altasSalirButton);
        
        //Frame
        reportesInventario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesInventario.setLayout(null);
        reportesInventario.setSize(420,500);
        reportesInventario.setLocationRelativeTo(null);
        reportesInventario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            reportesInventario.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            reportesInventario.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            reportesInventario.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            reportesInventario.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == vNomina){
            reportesInventario.dispose();
            Nomina nomina = new Nomina();
        }
    }
}
