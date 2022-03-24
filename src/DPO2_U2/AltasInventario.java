/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPO2_U2;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author anram
 */
public class AltasInventario implements ActionListener {
     //Variables
    JFrame altasInventario = new JFrame();
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
    
    JMenuItem altasEReporteMenu = new JMenuItem("Altas de equipo");
    JMenuItem bajasEReporteMenu = new JMenuItem("Bajas de equipo");
    JMenuItem bajasReporteMenu = new JMenuItem("Bajas de personal");
    
    JLabel eNombreProducto = new JLabel("Producto:");
    JLabel eSerie = new JLabel("Serie:");
    JLabel eNoInventario = new JLabel("Numero de Inventario:");
    JLabel eCosto = new JLabel("Costo:");
    JLabel eYEntrada = new JLabel("Año de entrada:");
    JLabel eQProductos = new JLabel("Cantidad en existencia:");
    JLabel eUbicacion = new JLabel("Ubicación:");
    
    JTextField tNombreProducto = new JTextField();
    JTextField tSerie = new JTextField();
    JTextField tNoInventario = new JTextField();
    JTextField tCosto = new JTextField();
    JTextField tYEntrada = new JTextField();
    JTextField tQProducts = new JTextField();
    JTextField tUbicacion = new JTextField();
    
    JButton altasBuscarButton = new JButton("Buscar");
    JButton altasSubmitButton = new JButton("Aceptar");
    JButton altasSalirButton = new JButton("Salir");
          
    AltasInventario(){
        eNombreProducto.setBounds(10, 50, 250, 25);
        eSerie.setBounds(10, 80, 250, 25);
        eNoInventario.setBounds(10, 110, 250, 25);
        eCosto.setBounds(10, 140, 250, 25);
        eYEntrada.setBounds(10, 170, 250, 25);
        eQProductos.setBounds(10, 200, 250, 25);
        eUbicacion.setBounds(10, 230, 250, 25);
        
        tNombreProducto.setBounds(150, 50, 250, 25);
        tSerie.setBounds(150, 80, 250, 25);
        tNoInventario.setBounds(150, 110, 250, 25);
        tCosto.setBounds(150, 140, 250, 25);
        tYEntrada.setBounds(150, 170, 250, 25);
        tQProducts.setBounds(150, 200, 250, 25);
        tUbicacion.setBounds(150, 230, 250, 25);
        
        altasBuscarButton.setBounds(30, 340, 100, 30);
        altasSubmitButton.setBounds(155, 340, 100, 30);
        altasSalirButton.setBounds(275, 340, 100, 30);
        
        //Set ActionListener to menu items
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        reportesInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        altasSubmitButton.addActionListener(this);
        altasBuscarButton.addActionListener(this);
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
        
        altasInventario.setJMenuBar(barra);      
        
        altasInventario.add(eNombreProducto);
        altasInventario.add(tNombreProducto);
        altasInventario.add(eSerie);
        altasInventario.add(tSerie);
        altasInventario.add(eNoInventario);
        altasInventario.add(tNoInventario);
        altasInventario.add(eCosto);
        altasInventario.add(tCosto);
        altasInventario.add(eYEntrada);
        altasInventario.add(tYEntrada);
        altasInventario.add(eQProductos);
        altasInventario.add(tQProducts);
        altasInventario.add(eUbicacion);
        altasInventario.add(tUbicacion);

        altasInventario.add(altasBuscarButton);
        altasInventario.add(altasSubmitButton);
        altasInventario.add(altasSalirButton);
        
        //Frame
        altasInventario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        altasInventario.setLayout(null);
        altasInventario.setSize(420,500);
        altasInventario.setLocationRelativeTo(null);
        altasInventario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            altasInventario.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            altasInventario.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            altasInventario.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            altasInventario.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == altasSalirButton){
            altasInventario.dispose();
            LaunchPage principal = new LaunchPage();
        }
        if(e.getSource() == altasSubmitButton || e.getSource() == altasBuscarButton){
            JOptionPane.showMessageDialog(null, "Aún no hay conexión con la BD", "Precaución", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == vNomina){
            altasInventario.dispose();
            Nomina nomina = new Nomina();
        }
    }
}
