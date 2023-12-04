package co.edu.cue.utils;

public class Nodo {
    public Cancion cancion;
    public Nodo sig; // referencia al siguiente elemento
    public Nodo ant; // referencia al anterior elemento

    public Nodo(Cancion cancion) {
        this.cancion = cancion;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
}
