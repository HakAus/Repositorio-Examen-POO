package Modelo;
import com.opencsv.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Modelo implements ObjObservable {

    // Atributos

    private Prestamo prestamo;
    private String DireccionRegistro = "Registro_Prueba.csv";
    private ArrayList<String[]> PersonasRegistradas;

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
        if (!verificarUsuario()) {
            prestamo = new Prestamo(pMonto, pMaximo);
        } else {

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


