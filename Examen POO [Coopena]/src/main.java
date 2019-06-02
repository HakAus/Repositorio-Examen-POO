import Modelo.Modelo;

public class main {

    public static void main (String[] args){
        Modelo modelito = new Modelo();
        modelito.verificarUsuario();
        modelito.agregarPrestamo(34525, 1000000);
        modelito.agregarPrestamo(4644466, 1000000);
        modelito.agregarPrestamo(456415641, 1000000);
        modelito.eliminarPrestamo(1);
    }
}
