package Modelo;
import Controlador.Controlador;
import com.opencsv.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Modelo implements ObjObservable {

    // Atributos

    // Sobre usuarios
    private ArrayList<Persona> Clientes;

    // Sobre prestamos
    private Prestamo prestamo;
    private String DireccionRegistro = "Registro_Prueba.csv";
    private String archivoPrestamos = "Prestamos.csv";
    private ArrayList<String[]> PersonasRegistradas = new ArrayList<String[]>();
    private String[] usuarioPrueba = {"90182345", "Pilar", "Solis", "Brenes", "21093458", "87652112","0"};
    public Controlador controlador;

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

    public void agregarPrestamo (Persona pCliente, float pMonto, float pMaximo){
        if (!verificarUsuario()) {
            prestamo = new Prestamo(pMonto, pMaximo);
        } else {
            prestamo = new Prestamo(pMonto, pMaximo);
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                FileWriter pw = new FileWriter(archivoPrestamos, true);
                String[] linea = {Integer.toString(prestamo.getNumeroPrestamo()), Float.toString(prestamo.getValorPrestamo()),
                        Integer.toString(prestamo.getCuotasPagadas()), dateFormat.format(prestamo.getFechasDePago()[0]),
                        dateFormat.format(prestamo.getFechaLimite()), "\n"};
                String joinedLinea = String.join(";", linea);
                pw.append(joinedLinea);
                pw.close();
            } catch (IOException e) {
                System.out.println("No se ha podido encontrar el archivo de prestamo");
                e.printStackTrace();
            }
        }
    }

    public void eliminarPrestamo(int ID) {
        try {
            BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream(archivoPrestamos), StandardCharsets.UTF_8));
            FileWriter archivoTemporal = new FileWriter("prestamosTemp.csv", true);
            String linea;
            while ((linea = archivo.readLine()) != null) {
                String[] partes = linea.split(";");
                if (!partes[0].equals(Integer.toString(ID))) {
                    archivoTemporal.write(linea+"\n");
                }
            }
            archivoTemporal.close();
            archivo.close();
            File archivoParaBorrar = new File(archivoPrestamos);
            boolean borrar = archivoParaBorrar.delete();
            File f1 = new File("prestamosTemp.csv");
            File f2 = new File(archivoPrestamos);
            boolean renombrar = f1.renameTo(f2);
        } catch (IOException e) {
            e.printStackTrace();
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


