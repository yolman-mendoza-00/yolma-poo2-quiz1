import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPropietarios extends JFrame implements ActionListener {
    static FrmListar ventanaListar;
    static FrmRegistrar ventanaRegistrar;
    static FrmBuscar ventanaBuscar;
    static ImageIcon imgLogo, imgRegistrar, imgListar, imgBuscar, imgSalir, imgFondo;
    static JLabel lblLogo, lblFondo;
    static JButton btnRegistrar, btnListar, btnBuscar, btnsalir;
    static FrmPropietarios ventana;
    static JLabel lblNumeroUno;
    static ArrayList<Propietario> propietariosregistrados = new ArrayList<>();


    //Seccion ventanas
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrar)) {
            ventanaRegistrar.setVisible(true);
            this.setVisible(false);

        }

        if (e.getSource().equals(btnListar)) {
            ventanaListar.setVisible(true);
            this.setVisible(false);

        }

        if (e.getSource().equals(btnBuscar)) {
            ventanaBuscar.setVisible(true);
            this.setVisible(false);

        }

        if (e.getSource().equals(btnsalir)) {
            dispose();
            
        }
    }


    public FrmPropietarios() {
        ventanaListar = new FrmListar();
        ventanaRegistrar = new FrmRegistrar(ventanaListar);
        ventanaBuscar = new FrmBuscar(propietariosregistrados);
        setLayout(null);

        //Ventanas

        imgRegistrar = new ImageIcon(".\\img\\new.png");
        btnRegistrar = new JButton("REGISTRAR", imgRegistrar);
        btnRegistrar.setBounds(145, 70, 150, 30);
        btnRegistrar.addActionListener(this);

        imgListar = new ImageIcon(".\\img\\lista.png");
        btnListar = new JButton("LISTAR", imgListar);
        btnListar.setBounds(145, 120, 150, 30);
        btnListar.addActionListener(this);

        imgBuscar = new ImageIcon(".\\img\\buscar.png");
        btnBuscar = new JButton("BUSCAR", imgBuscar);
        btnBuscar.setBounds(145, 170, 150, 30);
        btnBuscar.addActionListener(this);

        imgSalir = new ImageIcon(".\\img\\salir.png");
        btnsalir = new JButton("SALIR", imgSalir);
        btnsalir.setBounds(145, 220, 150, 30);
        btnsalir.addActionListener(this);

        imgLogo = new ImageIcon(".\\img\\logo.png");
        lblLogo = new JLabel(imgLogo);
        lblLogo.setBounds(100, 80, 210, 200);


        lblNumeroUno = new JLabel("MENU DE OPCIONES");
        lblNumeroUno.setBounds(160, 20, 200, 30);

        // Fondo de la ventana
        imgFondo = new ImageIcon(".\\img\\fondo.jpg");
        lblFondo = new JLabel(imgFondo);
        lblFondo.setBounds(0, 0, 450, 150);

        // Contenedor del fondo
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        contentPane.add(lblFondo);

        //Adiciones
        lblFondo.add(lblNumeroUno);
        lblFondo.add(lblLogo);
        lblFondo.add(btnRegistrar);
        lblFondo.add(btnListar);
        lblFondo.add(btnBuscar);
        lblFondo.add(btnsalir);

        ///////

        setSize(450, 350);
        setTitle("VENTANA PRINCIPAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 200);

    }

    public static void main(String[] args) {
        ventana = new FrmPropietarios();
        ventana.setVisible(true);

    }
}
