package co.edu.cue.LDE;

import co.edu.cue.utils.Cancion;
import co.edu.cue.utils.Nodo;
import javax.swing.*;

public class ListaDobleEnlazada {
    Nodo cab;
    Nodo movil;
    Nodo fin;
    private Nodo reproduciendo;

    public ListaDobleEnlazada() {
    }

    public void iniciarListaDobleEnlazada() {
        cab = null;
        fin = null;
    }

    public void insertarNodoInicio(Cancion nuevaCancion) {
        Nodo nuevo = new Nodo(nuevaCancion);

        if (fin == null) {
            cab = fin = nuevo;
            nuevo.ant = nuevo.sig = null;
        } else {
            movil = cab;
            nuevo.sig = movil;
            movil.ant = nuevo;
            cab = nuevo;
            nuevo.ant = null;
        }
    }

    public void borrarNodoPosicion() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la Lista Doble.");
            return;
        }

        int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite la posición de la canción a borrar:"));

        int cn = 1;
        Nodo borra;

        movil = cab;
        if (cab != null) {
            if ((pos == 1) && (movil.sig == null)) {
                borra = movil;
                cab = null;
                fin = null;
                borra = null;
            } else if ((pos == 1) && (movil.sig != null)) {
                borra = movil;
                movil = movil.sig;
                cab = movil;
                movil.ant = null;
                borra = null;
            } else {
                while (movil != null) {
                    if (cn + 1 == pos) {
                        borra = movil.sig;
                        movil.sig = borra.sig;
                        if (fin == borra)
                            fin = movil;
                        if (movil.sig != null) {
                            movil = movil.sig;
                            movil.ant = borra.ant;
                        }
                        borra = null;
                    }
                    movil = movil.sig;
                    cn++;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay nodos en la Lista Doble.");
        }
    }

    public void imprimirListaCab() {
        StringBuilder resultado = new StringBuilder("Lista Doble por la cabeza:\n");
        movil = cab;
        while (movil != null) {
            resultado.append(movil.cancion.nombre).append(" - ").append(movil.cancion.artista).append("\n");
            movil = movil.sig;
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public void imprimirListaFin() {
        StringBuilder resultado = new StringBuilder("Lista Doble por el fin:\n");
        movil = fin;
        while (movil != null) {
            resultado.append(movil.cancion.nombre).append(" - ").append(movil.cancion.artista).append("\n");
            movil = movil.ant;
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public void reproducirLista() {
        movil = cab;

        while (movil != null) {
            reproduciendo = movil;

            StringBuilder mensaje = new StringBuilder("Reproduciendo:\n");
            mensaje.append("Nombre: ").append(reproduciendo.cancion.nombre).append("\n");
            mensaje.append("Artista: ").append(reproduciendo.cancion.artista).append("\n");
            mensaje.append("Duración: ").append(reproduciendo.cancion.duracion).append("\n");
            mensaje.append("Reproducciones: ").append(reproduciendo.cancion.reproducciones).append("\n");

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.toString() +
                            "1. Siguiente Canción\n" +
                            "2. Anterior Canción\n" +
                            "3. Salir"));

            switch (opcion) {
                case 1:
                    if (movil.sig != null) {
                        movil = movil.sig;
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay más canciones.");
                    }
                    break;
                case 2:
                    if (movil.ant != null) {
                        movil = movil.ant;
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay canciones anteriores.");
                    }
                    break;
                case 3:
                    return;  // Salimos de la función si el usuario elige salir
            }
        }
    }
}
