import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmBuscar extends JFrame implements ActionListener {
    static JButton btnRegresar;
    static ImageIcon imgRegresar, imgbuscar;
    private ArrayList<Propietario> propietarios1;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            FrmPropietarios.ventana.setVisible(true);
            this.setVisible(false);

        }
    }

    public FrmBuscar(ArrayList<Propietario> propietarios1) {
        super("Buscar Propietario ");
        this.propietarios1 = propietarios1;

        buscar();
    }


    private void buscar() {

        imgRegresar = new ImageIcon(".\\img\\back.png");
        btnRegresar = new JButton("Regresar", imgRegresar);
        btnRegresar.setBounds(150, 320, 110, 30);
        btnRegresar.addActionListener(this);

        JLabel lblNombre = new JLabel("Ingrese el nombre del propietario:");
        lblNombre.setBounds(50, 50, 200, 30);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(250, 50, 200, 30);
        add(txtNombre);

        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        scrollPane.setBounds(50, 100, 400, 200);
        add(scrollPane);

        imgbuscar = new ImageIcon(".\\img\\buscar.png");
        JButton btnBuscar = new JButton("Buscar", imgbuscar);
        btnBuscar.setBounds(300, 320, 100, 30);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreBuscado = txtNombre.getText();
                areaResultado.setText("");

                boolean encontrado = false;
                for (Propietario propietario : propietarios1) {
                    if (propietario.getNombre().equalsIgnoreCase(nombreBuscado)) {
                        areaResultado.append(propietario.toString() + "\n");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    areaResultado.append("No se encontró el propietario: " + nombreBuscado);
                }
            }
        });
        add(btnBuscar);
        add(btnRegresar);

        setLayout(null);

        //Color ventana
        Color c = new Color(173, 216, 230);
        getContentPane().setBackground(c);

        setSize(500,400);
        setTitle("BUSCAR PROPIETARIOS");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,200);
    }
}