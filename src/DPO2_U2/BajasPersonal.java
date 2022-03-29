
package DPO2_U2;

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
public class BajasPersonal implements ActionListener {
     //Variables
    JFrame bajasPersonal = new JFrame();
    JMenuBar barra = new JMenuBar();
    //Elementos de la barra menú
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
    
    JLabel eNumeroEmpleado = new JLabel("Número de empleado:");
    JLabel eNombreEmpleado = new JLabel("Nombre:");
    JLabel eApellidoPaterno = new JLabel("Apellido paterno:");
    JLabel eApellidoMaterno = new JLabel("Apellido materno:");
    
    JTextField tNumeroEmpleado = new JTextField();
    JTextField tNombreEmpleado = new JTextField();
    JTextField tApellidoPaterno = new JTextField();
    JTextField tApellidoMaterno = new JTextField();
    
    Botones bajasBuscarButton = new Botones("Buscar");
    Botones bajasSubmitButton = new Botones("Aceptar");
    Botones bajasSalirButton = new Botones("Salir");
          
    BajasPersonal(){
        eNumeroEmpleado.setBounds(10, 50, 250, 25);
        eNombreEmpleado.setBounds(10, 80, 250, 25);
        eApellidoPaterno.setBounds(10, 110, 250, 25);
        eApellidoMaterno.setBounds(10, 140, 250, 25);
        
        tNumeroEmpleado.setBounds(150, 50, 250, 25);
        tNombreEmpleado.setBounds(150, 80, 250, 25);
        tApellidoPaterno.setBounds(150, 110, 250, 25);
        tApellidoMaterno.setBounds(150, 140, 250, 25);
        
        bajasBuscarButton.setBounds(30, 200, 100, 30);
        bajasSubmitButton.setBounds(155, 200, 100, 30);
        bajasSalirButton.setBounds(275, 200, 100, 30);
        
        //Set ActionListener to menu items
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        reportesInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        bajasSubmitButton.addActionListener(this);
        bajasBuscarButton.addActionListener(this);
        bajasSalirButton.addActionListener(this);
        
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
                
        barra.add(personal);
        barra.add(inventario);
        barra.add(nomina);
        
        bajasPersonal.setJMenuBar(barra);        
        
        //Frame contents
        bajasPersonal.add(eNumeroEmpleado);
        bajasPersonal.add(tNumeroEmpleado);
        bajasPersonal.add(eNombreEmpleado);
        bajasPersonal.add(tNombreEmpleado);
        bajasPersonal.add(eApellidoPaterno);
        bajasPersonal.add(tApellidoPaterno);
        bajasPersonal.add(eApellidoMaterno);
        bajasPersonal.add(tApellidoMaterno);
        bajasPersonal.add(bajasBuscarButton);
        bajasPersonal.add(bajasSubmitButton);
        bajasPersonal.add(bajasSalirButton);
        
        //Frame
        bajasPersonal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bajasPersonal.setLayout(null);
        bajasPersonal.setSize(420,500);
        bajasPersonal.setLocationRelativeTo(null);
        bajasPersonal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            bajasPersonal.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            bajasPersonal.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            bajasPersonal.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            bajasPersonal.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == bajasSalirButton){
            bajasPersonal.dispose();
            LaunchPage principal = new LaunchPage();
        }
        if(e.getSource() == bajasSubmitButton || e.getSource() == bajasBuscarButton){
            JOptionPane.showMessageDialog(null, "Aún no hay conexión con la BD", "Precaución", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource() == vNomina){
            bajasPersonal.dispose();
            Nomina nomina = new Nomina();
        }
    }
    
}
