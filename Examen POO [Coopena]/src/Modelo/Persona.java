package Modelo;

public class Persona {

    // Atributos

    private int NumeroID;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private int TelefonoCasa;
    private int TelefonoMovil;

    // Constructor

    public Persona (int pNumeroID, String pNombre, String pApellido1,
                    String pApellido2, int pTelefonoCasa, int pTelefonoMovil){

        NumeroID = pNumeroID;
        Nombre = pNombre;
        Apellido1 = pApellido1;
        Apellido2 = pApellido2;
        TelefonoCasa = pTelefonoCasa;
        TelefonoMovil = pTelefonoMovil;
    }

    // Metodos

    public int getNumeroID() {
        return NumeroID;
    }

    public void setNumeroID(int numeroID) {
        NumeroID = numeroID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public int getTelefonoCasa() {
        return TelefonoCasa;
    }

    public void setTelefonoCasa(int telefonoCasa) {
        TelefonoCasa = telefonoCasa;
    }

    public int getTelefonoMovil() {
        return TelefonoMovil;
    }

    public void setTelefonoMovil(int telefonoMovil) {
        TelefonoMovil = telefonoMovil;
    }
}
