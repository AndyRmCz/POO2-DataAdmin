

package DPO2_U2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author anram
 */
public class LaunchPage implements ActionListener{
    //Variables
    JFrame launchPage = new JFrame();
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
      
    LaunchPage(){ 
        //Set ActionListener to menu items
        altasPersonalMenu.addActionListener(this);
        bajasPersonalMenu.addActionListener(this);
        altasInventarioMenu.addActionListener(this);
        bajasInventarioMenu.addActionListener(this);
        vNomina.addActionListener(this);
        reportesInventarioMenu.addActionListener(this);
        
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
        
        launchPage.setJMenuBar(barra);
        
        //Frame
        
        launchPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launchPage.setSize(500,500);
        launchPage.setLocationRelativeTo(null);
        launchPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == altasPersonalMenu){
            launchPage.dispose();
            AltasPersonal altas = new AltasPersonal();
        }
        if(e.getSource() == bajasPersonalMenu){
            launchPage.dispose();
            BajasPersonal bajas = new BajasPersonal();
        }
        if(e.getSource() == altasInventarioMenu){
            launchPage.dispose();
            AltasInventario altas = new AltasInventario();
        }
        if(e.getSource() == bajasInventarioMenu){
            launchPage.dispose();
            BajasInventario bajas = new BajasInventario();
        }
        if(e.getSource() == vNomina){
            launchPage.dispose();
            Nomina nomina = new Nomina();
        }
    }
    
    
}
