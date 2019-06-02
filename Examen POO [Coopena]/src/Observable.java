public interface Observable {

    void notificarObservadores();
    void confirmarCambio();
    void agregarObservador(Observador obs);
    void quitarObservador(Observador obs);

}
