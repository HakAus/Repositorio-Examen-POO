package Modelo;
import com.opencsv.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modelo implements ObjObservable {

    // Atributos

    private Prestamo prestamo;
    private String DireccionRegistro = "Registro_Prueba.csv";
    private String archivoPrestamos = "Prestamos.csv";
    private ArrayList<String[]> PersonasRegistradas = new ArrayList<String[]>();
    private String[] usuarioPrueba = {"90182345", "Pilar", "Solis", "Brenes", "21093458", "87652112","0"};

    // Metodos propios

    public boolean verificarUsuario() {
        // Variables locales
        BufferedReader lector = null;
        String registro = "";
        String separador = ",";
        int cont = 0;

        // Se extraen todos los registros y se ponen en un array de Strings.
        try {

            lector = new BufferedReader(new FileReader(DireccionRegistro));
            while ((registro = lector.readLine()) != null) {

                String[] registros = registro.split(separador);

                System.out.println("Registro [ID= " + registros[0] + " , " +
                        "Nombre=" + registros[1] + " , " + "Apellido1= " + registros[2] +
                        " , " + "Apellido2= " + registros[3] + " , " + "TelefonoCasa= " + registros[4] +
                        " , " + "TelefonoMovil= " + registros[5] + " , " + "IDPrestamo= " + registros[6]);

                PersonasRegistradas.add(registros);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    return true;
    }

    public void agregarPrestamo (float pMonto, float pMaximo){
        Persona usuario = new Persona("90182345", "Pilar", "Solis", "Brenes", "21093458", "87652112");
        if (!verificarUsuario()) {
            prestamo = new Prestamo(pMonto, pMaximo);
        } else {
            prestamo = new Prestamo(pMonto, pMaximo);
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                FileWriter pw = new FileWriter(archivoPrestamos, true);
                String[] linea = {Integer.toString(prestamo.getNumeroPrestamo()), Float.toString(prestamo.getValorPrestamo()),
                        Integer.toString(prestamo.getCuotasPagadas()), dateFormat.format(prestamo.getFechasDePago()[0]),
                        dateFormat.format(prestamo.getFechaLimite())};
                String joinedLinea = String.join(";", linea);
                pw.append(joinedLinea);
                pw.close();
            } catch (IOException e) {
                System.out.println("No se ha podido encontrar el archivo de prestamo");
                e.printStackTrace();
            }
        }
    }

    // Metodos de observador
    @Override
    public void agregarObservador(ObjObservador obs) {

    }

    @Override
    public void quitarObservador(ObjObservador obs) {

    }

    @Override
    public void notificarObservadores() {

    }

    @Override
    public void confirmarCambio() {

    }
}


