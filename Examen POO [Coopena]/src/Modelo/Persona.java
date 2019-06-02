package Modelo;

public class Persona {

    // Atributos

    private String NumeroID;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String TelefonoCasa;
    private String TelefonoMovil;

    // Constructor

    public Persona (String pNumeroID, String pNombre, String pApellido1,
                    String pApellido2, String pTelefonoCasa, String pTelefonoMovil){

        NumeroID = pNumeroID;
        Nombre = pNombre;
        Apellido1 = pApellido1;
        Apellido2 = pApellido2;
        TelefonoCasa = pTelefonoCasa;
        TelefonoMovil = pTelefonoMovil;

    }

    // Metodos

    public String getNumeroID() {
        return NumeroID;
    }

    public void setNumeroID(String numeroID) {
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

    public String getTelefonoCasa() {
        return TelefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        TelefonoCasa = telefonoCasa;
    }

    public String getTelefonoMovil() {
        return TelefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        TelefonoMovil = telefonoMovil;
    }
}
