package Controlador;

import Modelo.*;
import Vista.Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    // Atributos
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private Integer Cedula;
    private Integer TelefonoCasa;
    private Integer TelefonoMovil;
    static final String PANEL_BIENVENIDA = "Panel de selección de usuario";
    static final String PANEL_INGRESO_DATOS_USUARIO = "Menú de ingreso de datos";
    private Interfaz interfaz;

    // Constructor

    public Controlador(Interfaz frame) {
        interfaz = frame;
    }

    // Metodos

    private boolean validarDatosIngresados(){
        //------Para verificar que los Strings no tengan numeros------//
        Nombre = interfaz.tf_CampoNombre.getText();
        Apellido1 = interfaz.tf_CampoApellido1.getText();
        Apellido2 = interfaz.tf_CampoApellido2.getText();

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
            String cedulaTemp = interfaz.tf_CampoCedula.getText();
            Cedula = Integer.parseInt(cedulaTemp);
            String casaTempo = interfaz.tf_TelefonoCasa.getText();
            TelefonoCasa = Integer.parseInt(casaTempo);
            String movilTemp = interfaz.tf_TelefonoMovil.getText();
            TelefonoMovil = Integer.parseInt(movilTemp);
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
            if (validarDatosIngresados()) {
                JOptionPane.showMessageDialog(null,"¡Acceso exitoso!");
                Persona cliente = new Persona(Cedula, Nombre,
                        Apellido1, Apellido2, TelefonoCasa, TelefonoMovil);
            }




        }


    }
}
