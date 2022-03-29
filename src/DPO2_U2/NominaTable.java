package DPO2_U2;

import java.awt.BorderLayout;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NominaTable extends JFrame implements ActionListener{

    Object[][] datosNomina;
    String[] columnasNomina ={"No.Empleado", "Nombre","Apellido Paterno", "Apellido Materno", "Salario Bruto", "Fecha de Ingreso", "Sueldo Neto"};
    DefaultTableModel modelo = new DefaultTableModel();

    JPanel buttonPanel = new JPanel();
    Botones imprimirNomina = new Botones("Imprimir");
    
    
    NominaTable(Object[][] datos) throws PrinterException{

        //Sets ActionsListeners
        imprimirNomina.addActionListener(this);
        datosNomina = datos;
        //Adds items to frame
        buttonPanel.add(imprimirNomina);
        JTable table = new JTable(datosNomina, columnasNomina);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
        this.add(buttonPanel, BorderLayout.SOUTH);
        //Frame properties
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // this.setLayout(null);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = "# Empleado: " + datosNomina[0][0] +"\n" +
                         "Nombre: " + datosNomina[0][1] + " "  +datosNomina[0][2] + " " + datosNomina[0][3] +"\n" +
                         "Fecha de ingreso: " +datosNomina[0][5] + "\n" +
                         "Salario neto: $" + datosNomina[0][6];
        if (e.getSource() == imprimirNomina){
            JOptionPane.showMessageDialog(null, mensaje, "Talón de Nómina", JOptionPane.INFORMATION_MESSAGE);
        }        
    }
}
