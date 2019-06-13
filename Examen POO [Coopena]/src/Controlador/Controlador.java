package Controlador;

import Modelo.*;
import Vista.Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    // Atributos del controlador
    static final String PANEL_BIENVENIDA = "Panel de selección de usuario";
    static final String PANEL_INGRESO_DATOS_USUARIO = "Menú de ingreso de datos";
    private Interfaz interfaz;
    private Modelo modelo;

    // Atributos del cliente
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private Integer Cedula;
    private Integer TelefonoCasa;
    private Integer TelefonoMovil;

    // Atributos del prestamo
    float montoDelPrestamo;
    float montoMaximoDelPrestamo;

    // Constructor
    public Controlador(Interfaz frame) {
        interfaz = frame;
        modelo = new Modelo(this);
        montoMaximoDelPrestamo = 1000000;
    }

    // Metodos

    private boolean validarDatosIngresados(Persona persona){
        //------Para verificar que los Strings no tengan numeros------//
        Nombre = persona.getNombre();
        Apellido1 = persona.getApellido1();
        Apellido2 = persona.getApellido2();

        // Ese metodo es magico y lo encontre en StackOverflow, utiliza algo que se llama regex(Regular expression)
        // que son expresiones que definen patrones de busqueda. El patron .*\\d.* se encarga de buscar si hay un numero.
        if(Nombre.matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null,"Ups! Hubo un error al ingresar sus datos,\n" +
                    "revise que tengan el formato correcto y que no falte ninguno.");
            return false;
        }
        if(Apellido1.matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null,"Ups! Hubo un error al ingresar sus datos,\n" +
                    "revise que tengan el formato correcto y que no falte ninguno.");
            return false;
        }
        if(Apellido2.matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null,"Ups! Hubo un error al ingresar sus datos,\n" +
                    "revise que tengan el formato correcto y que no falte ninguno.");
            return false;
        }
        //-------------------------------------------------------------//
        //------- Para verificar que los numeros no tengan letras -----//
        try {
            Cedula = persona.getNumeroID();
            TelefonoCasa = persona.getTelefonoCasa();
            TelefonoMovil = persona.getTelefonoMovil();
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ups! Hubo un error al ingresar sus datos,\n" +
                    "revise que tengan el formato correcto y que no falte ninguno.");
            return false;
        }
        //------------------------------------------------------------//
        //--------- Para verificar que no hay campos vacios ----------//
        if (Nombre.isEmpty() || Apellido1.isEmpty() || Apellido2.isEmpty()
                || Cedula == null || TelefonoCasa == null || TelefonoMovil == null){
            return false;

        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == interfaz.bt_CancelarDatos){
            interfaz.tf_CampoNombre.setText("");
            interfaz.tf_CampoApellido1.setText("");
            interfaz.tf_CampoApellido2.setText("");
            interfaz.tf_CampoCedula.setText("");
            interfaz.tf_TelefonoCasa.setText("");
            interfaz.tf_TelefonoMovil.setText("");
            interfaz.LayoutContenedor.show(interfaz.Contenedor,PANEL_BIENVENIDA);
        }
        if(evento.getSource() == interfaz.bt_Cliente){
            interfaz.LayoutContenedor.show(interfaz.Contenedor,PANEL_INGRESO_DATOS_USUARIO);
        }
        if(evento.getSource() == interfaz.bt_AceptarDatos){
            JOptionPane.showMessageDialog(null,"¡Acceso exitoso!");
            Persona cliente = new Persona(Cedula, Nombre,
                    Apellido1, Apellido2, TelefonoCasa, TelefonoMovil);
            if (validarDatosIngresados(cliente)) {
                Prestamo prestamo = new Prestamo(cliente, montoDelPrestamo);
            }
        }
    }
}
