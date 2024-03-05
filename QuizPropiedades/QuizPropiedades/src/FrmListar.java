import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmListar extends JFrame implements ActionListener {
    static JLabel lbltituloXD;
    static JButton btnRegresar;
    static ImageIcon imgRegresar;
    static JTable tabla;
    static DefaultTableModel model;
    static JScrollPane scrollpane;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)){
            FrmPropietarios.ventana.setVisible(true);
            this.setVisible(false);
        }
    }

    public FrmListar(){
        imgRegresar = new ImageIcon(".\\img\\back.png");
        btnRegresar = new JButton("Regresar", imgRegresar);
        btnRegresar.setBounds(50, 250, 110, 30);
        btnRegresar.addActionListener(this);

        lbltituloXD = new JLabel("Tabla propietarios");
        lbltituloXD.setBounds(40, 10, 200, 30);

        //Tabla Informacion
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("Documento");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("ID");

        scrollpane = new JScrollPane(tabla);
        scrollpane.setLocation(40,40);
        scrollpane.setSize(350,200);

        add(lbltituloXD);
        add(btnRegresar);
        add(scrollpane, BorderLayout.CENTER);

        //Color ventana
        Color c = new Color(173, 216, 230);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(450,350);
        setTitle("LISTADO DE PROPIETARIOS");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocation(300,200);
    }

    public void agregarPropietario(ArrayList<Propietario> propietarios) {
        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Recorre la lista recibida de propietarios y agrégalos a la tabla
        for (Propietario propietario : propietarios) {
            Object[] fila = {propietario.getDocumento(), propietario.getNombre(), propietario.getApellido(),
                    propietario.getEdad(), propietario.getId_Propietario()};
            model.addRow(fila);
        }
    }
}