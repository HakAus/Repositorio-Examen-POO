import Modelo.Modelo;

public class main {

    public static void main (String[] args){
        Modelo modelito = new Modelo();
        modelito.verificarUsuario();
        modelito.agregarPrestamo(34525, 10000);
    }
}
