package Vista;

import Controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Interfaz {

    // Atributos
    public JFrame Ventana;
    public JPanel Contenedor;
    public CardLayout LayoutContenedor;
    private Controlador controlador;

    private JPanel PanelMenuInicio, PanelIngresoDatos;
    private JLabel lb_Indicacion, lb_Nombre, lb_Apellido1, lb_Apellido2, lb_Cedula, lb_TelefonoCasa, lb_TelefonoMovil;
    public JButton bt_Administrador, bt_Cliente, bt_AceptarDatos, bt_CancelarDatos;
    public JTextField tf_CampoNombre, tf_CampoApellido1, tf_CampoApellido2, tf_CampoCedula, tf_TelefonoCasa, tf_TelefonoMovil;

    private int WIDTH = 300;
    private int HEIGHT = 300;

    static final String PANEL_BIENVENIDA = "Panel de selección de usuario";
    static final String PANEL_INGRESO_DATOS_USUARIO = "Menú de ingreso de datos";


    // Constructor
    public Interfaz() {
        controlador = new Controlador(this);
        crearMenuInicio();
        crearMenuIngresoDatos();
        crearContenedor();
        crearVentana();
    }

    private void crearVentana(){
        Ventana = new JFrame("Coopena");
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        Ventana.setLocationRelativeTo(null);
        Ventana.add(Contenedor);
        Ventana.pack();
        Ventana.setVisible(true);
    }
    private void crearContenedor(){
        Contenedor = new JPanel();
        LayoutContenedor = new CardLayout();
        Contenedor.setLayout(LayoutContenedor);
        Contenedor.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        Contenedor.add(PanelMenuInicio,PANEL_BIENVENIDA);
        Contenedor.add(PanelIngresoDatos,PANEL_INGRESO_DATOS_USUARIO);
    }
    private void crearMenuInicio(){
        PanelMenuInicio = new JPanel();
        PanelMenuInicio.setSize(WIDTH,HEIGHT);
        JLabel bienvenida = new JLabel("Seleccione el tipo de usuario:");
        bt_Administrador = new JButton("Administrador");
        bt_Cliente = new JButton("Cliente");
        bt_Administrador.addActionListener(controlador);
        bt_Cliente.addActionListener(controlador);
        PanelMenuInicio.add(bienvenida, BorderLayout.NORTH);
        PanelMenuInicio.add(bt_Administrador, BorderLayout.CENTER);
        PanelMenuInicio.add(bt_Cliente, BorderLayout.CENTER);
    }

    private void crearMenuIngresoDatos(){

        PanelIngresoDatos = new JPanel(new GridBagLayout());
        PanelIngresoDatos.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        GridBagConstraints confEtiqueta = new GridBagConstraints();
        GridBagConstraints confCampoTexto = new GridBagConstraints();
        GridBagConstraints confBoton = new GridBagConstraints();

        lb_Nombre = new JLabel("Nombre: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 1;
        PanelIngresoDatos.add(lb_Nombre, confEtiqueta);

        tf_CampoNombre = new JTextField();
        tf_CampoNombre.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 1;
        confCampoTexto.gridwidth = 2;
        confCampoTexto.fill = GridBagConstraints.HORIZONTAL;
        PanelIngresoDatos.add(tf_CampoNombre, confCampoTexto);

        lb_Apellido1 = new JLabel("Primer apellido: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 2;
        PanelIngresoDatos.add(lb_Apellido1, confEtiqueta);

        tf_CampoApellido1 = new JTextField();
        tf_CampoApellido1.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 2;
        confCampoTexto.gridwidth = 2;
        PanelIngresoDatos.add(tf_CampoApellido1, confCampoTexto);

        lb_Apellido2 = new JLabel("Segundo apellido: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 3;
        PanelIngresoDatos.add(lb_Apellido2, confEtiqueta);

        tf_CampoApellido2 = new JTextField();
        tf_CampoApellido2.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 3;
        confCampoTexto.gridwidth = 2;
        PanelIngresoDatos.add(tf_CampoApellido2, confCampoTexto);

        lb_Cedula = new JLabel("Cédula: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 4;
        PanelIngresoDatos.add(lb_Cedula, confEtiqueta);

        tf_CampoCedula= new JTextField();
        tf_CampoCedula.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 4;
        confCampoTexto.gridwidth = 2;
        PanelIngresoDatos.add(tf_CampoCedula, confCampoTexto);

        lb_TelefonoCasa = new JLabel("Telefono del hogar: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 5;
        PanelIngresoDatos.add(lb_TelefonoCasa, confEtiqueta);

        tf_TelefonoCasa= new JTextField();
        tf_TelefonoCasa.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 5;
        confCampoTexto.gridwidth = 2;
        PanelIngresoDatos.add(tf_TelefonoCasa, confCampoTexto);

        lb_TelefonoMovil= new JLabel("Telefono movil: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 6;
        PanelIngresoDatos.add(lb_TelefonoMovil, confEtiqueta);

        tf_TelefonoMovil= new JTextField();
        tf_TelefonoMovil.setSize(WIDTH/3,HEIGHT/3);
        confCampoTexto.gridx = 2;
        confCampoTexto.gridy = 6;
        confCampoTexto.gridwidth = 2;
        PanelIngresoDatos.add(tf_TelefonoMovil, confCampoTexto);

        bt_AceptarDatos = new JButton("Aceptar");
        confBoton.gridx = 1;
        confBoton.gridy = 7;
        bt_AceptarDatos.addActionListener(controlador);
        PanelIngresoDatos.add(bt_AceptarDatos, confBoton);

        bt_CancelarDatos = new JButton("Cancelar");
        confBoton.gridx = 2;
        confBoton.gridy = 7;
        bt_CancelarDatos.addActionListener(controlador);
        PanelIngresoDatos.add(bt_CancelarDatos, confBoton);

        lb_Indicacion = new JLabel("Por favor, ingrese sus datos personales: ");
        confEtiqueta.gridx = 1;
        confEtiqueta.gridy = 0;
        confEtiqueta.gridwidth = 2;
        confEtiqueta.fill = GridBagConstraints.HORIZONTAL;
        PanelIngresoDatos.add(lb_Indicacion, confEtiqueta);
    }
}
