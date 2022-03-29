/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPO2_U2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author anram
 */
public class BajasInventario implements ActionListener {
    JFrame bajasInventario = new JFrame();
    JMenuBar barra = new JMenuBar();
    
    //Menu bar elements variables
    JMenu personal = new JMenu("Personal");
    JMenu inventario = new JMenu("Inventario");
    JMenu nomina = new JMenu("Nómina");
    
    //Personal Menu Variables
    JMenuItem altasPersonalMenu = new JMenuItem("Altas");
    JMenuItem bajasPersonalMenu = new JMenuItem("Bajas");
    
    //Inventario Menu Variables
    JMenuItem altasInventarioMenu = new JMenuItem("Altas");
    JMenuItem bajasInventarioMenu = new JMenuItem("Bajas");
    JMenu reportesInventarioMenu = new JMenu("Reportes");

    //Nomina Menu Items
    JMenuItem vNomina = new JMenuItem("Ver Nómina");
   
    //Reportes SubMenu elements Variables
    JMenuItem altasEReporteMenu = new JMenuItem("Altas de equipo");
    JMenuItem bajasEReporteMenu = new JMenuItem("Bajas de equipo");
    JMenuItem bajasReporteMenu = new JMenuItem("Bajas de personal");
    
    //Components variables
    JLabel eNoInventario = new JLabel("Número de empleado");           
    JLabel eNombreProducto = new JLabel("Producto");           
    JLabel eYSalida = new JLabel("Año de salida");
    
    JTextField tNoInventario = new JTextField();
    JTextField tNombreProducto = new JTextField();
    JTextField tYSalida = new JTextField();
    
    Botones bajasBuscarButton = new Botones("Buscar");
    Botones bajasSubmitButton = new Botones("Aceptar");
    Botones bajasSalirButton = new Botones("Salir");
    
    BajasInventario(){
        
        //Sets components to size and position
        eNoInventario.setBounds(10,50, 250, 25);
        eNombreProducto.setBounds(10,80, 250, 25);
        eYSalida.setBounds(10,110, 250, 25);
        
        tNoInventario.setBounds(150, 50, 250, 25);
        tNombreProducto.setBounds(150, 80, 250, 25);
        tYSalida.setBounds(150, 110, 250, 25);
        
        bajasBuscarButton.setBounds(30, 340, 100, 30);
        bajasSubmitButton.setBounds(155, 340, 100, 30);
        bajasSalirButton.setBounds(275, 340, 100, 30);
        
        //Sets ActionListeners
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        bajasSubmitButton.addActionListener(this);
        bajasBuscarButton.addActionListener(this);
        bajasSalirButton.addActionListener(this);
        
        //Adds elements to Reportes SubMenu
        reportesInventarioMenu.add(altasEReporteMenu);
        reportesInventarioMenu.add(bajasEReporteMenu);
        reportesInventarioMenu.add(bajasReporteMenu);
        
        //Adds elements to Personal Menu
        personal.add(altasPersonalMenu);
        personal.add(bajasPersonalMenu);
        
        //Adds elements to Inventario Menu
        inventario.add(altasInventarioMenu);
        inventario.add(bajasInventarioMenu);
        inventario.add(reportesInventarioMenu);

        //Add Nomina menu Items
        nomina.add(vNomina);
        
        //Adds Menus to MenuBar
        barra.add(personal);
        barra.add(inventario);
        barra.add(nomina);
        
        //Adds components to frame
        bajasInventario.add(eNoInventario);
        bajasInventario.add(eNombreProducto);
        bajasInventario.add(eYSalida);
        
        bajasInventario.add(tNoInventario);
        bajasInventario.add(tNombreProducto);
        bajasInventario.add(tYSalida);
        
        bajasInventario.add(bajasBuscarButton);
        bajasInventario.add(bajasSubmitButton);
        bajasInventario.add(bajasSalirButton);
        
        //Sets MenuBar for the Frame
        bajasInventario.setJMenuBar(barra);
        
        bajasInventario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bajasInventario.setLayout(null);
        bajasInventario.setSize(420, 500);
        bajasInventario.setLocationRelativeTo(null);               
        bajasInventario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            bajasInventario.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            bajasInventario.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            bajasInventario.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            bajasInventario.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == bajasSalirButton){
            bajasInventario.dispose();
            LaunchPage principal = new LaunchPage();
        }
        if(e.getSource() == bajasSubmitButton || e.getSource() == bajasBuscarButton){
            JOptionPane.showMessageDialog(null, "Aún no hay conexión con la BD", "Precaución", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == vNomina){
            bajasInventario.dispose();
            Nomina nomina = new Nomina();
        }
    }
    
}
