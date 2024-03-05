import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmRegistrar extends JFrame implements ActionListener {
    FrmListar ventanaListar;
    static JButton btnRegresar, btnRegistrar;
    static ImageIcon imgRegresar, imgRegistrar, imgRegistrar2;
    protected JTextField campo1, campo2, campo3, campo4, campo5;

    static JLabel lblNuM4, lblRegistrar2;
    protected ArrayList<Propietario> Propietarioregistro;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            FrmPropietarios.ventana.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource().equals(btnRegistrar)) {
            //datos del nuevo propietario
            int documento = Integer.parseInt(campo1.getText());
            String nombre = campo2.getText();
            String apellido = campo3.getText();
            int edad = Integer.parseInt(campo4.getText());
            int Id_Propietario = Integer.parseInt(campo5.getText());

            // Crea un nuevo objeto Propietario con los datos obtenidos
            Propietario nuevoPropietario = new Propietario(documento,nombre,apellido,edad,Id_Propietario);
            Propietarioregistro.add(nuevoPropietario);


            campo1.setText(" ");
            campo2.setText(" ");
            campo3.setText(" ");
            campo4.setText(" ");
            campo5.setText(" ");

        }
    }

    public FrmRegistrar(FrmListar ventanaListar) {
        this.ventanaListar = ventanaListar;
        imgRegresar = new ImageIcon(".\\img\\back.png");
        btnRegresar = new JButton("Regresar", imgRegresar);
        btnRegresar.setBounds(100, 250, 110, 30);
        btnRegresar.addActionListener(this);
        Propietarioregistro = new ArrayList<>();
        Registro();

        //
        add(btnRegresar);


    }

    protected void Registro() {
        setLayout(null);

        lblNuM4 = new JLabel(" REGISTRO DE PROPIETARIOS");
        lblNuM4.setBounds(30, 10, 200, 30);
        add(lblNuM4);


        JLabel etiqueta1 = new JLabel("Ingrese el documento ");
        etiqueta1.setBounds(50, 40, 200, 30);
        add(etiqueta1);

        campo1 = new JTextField();
        campo1.setBounds(210, 40, 150, 30);
        add(campo1);

        JLabel etiqueta2 = new JLabel("Ingrese el nombre");
        etiqueta2.setBounds(50, 80, 200, 30);
        add(etiqueta2);

        campo2 = new JTextField();
        campo2.setBounds(210, 80, 150, 30);
        add(campo2);

        JLabel etiqueta3 = new JLabel("Ingrese primer apellido ");
        etiqueta3.setBounds(50, 120, 200, 30);
        add(etiqueta3);

        campo3 = new JTextField();
        campo3.setBounds(210, 120, 150, 30);
        add(campo3);

        JLabel etiqueta4 = new JLabel("Ingrese la edad ");
        etiqueta4.setBounds(50, 160, 200, 30);
        add(etiqueta4);

        campo4 = new JTextField();
        campo4.setBounds(210, 160, 150, 30);
        add(campo4);

        JLabel etiqueta5 = new JLabel("ingrese el ID");
        etiqueta5.setBounds(50,200,200,30);
        add(etiqueta5);

        campo5 = new JTextField();
        campo5.setBounds(210,200,150,30);
        add(campo5);


        imgRegistrar = new ImageIcon(".\\img\\registrar.png");
        JButton botonAgregar = new JButton("Registrar Datos", imgRegistrar);
        botonAgregar.setBounds(350, 250, 150, 30);
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int documento = Integer.parseInt(campo1.getText());
                String nombre = campo2.getText();
                String apellido = campo3.getText();
                int edad = Integer.parseInt(campo4.getText());
                int Id_Propietario = Integer.parseInt(campo5.getText());



                Propietario nuevopropietario = new Propietario(documento,nombre,apellido,edad,Id_Propietario);
                Propietarioregistro.add(nuevopropietario);
                FrmPropietarios.propietariosregistrados.add(nuevopropietario);
                ventanaListar.agregarPropietario(Propietarioregistro);


                campo1.setText("");
                campo2.setText("");
                campo3.setText("");
                campo4.setText("");
                campo5.setText("");


            }
        });

        add(botonAgregar);
        Color c = new Color(173, 216, 230);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(550, 350);
        setTitle("Registrar Propietarios");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 200);

    }
}

