package Modelo;

public interface ObjObservable {

    void notificarObservadores();
    void confirmarCambio();
    void agregarObservador(ObjObservador obs);
    void quitarObservador(ObjObservador obs);

}
