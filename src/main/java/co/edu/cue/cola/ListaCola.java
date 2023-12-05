package co.edu.cue.cola;

import co.edu.cue.utils.Cancion;
import co.edu.cue.utils.Nodo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListaCola {
    Nodo cab;
    Nodo movil;
    Nodo fin;
    private Nodo reproduciendo;

    public ListaCola() {
    }

    public void iniciarCola() {
        cab = null;
    }

    public void insertarNodoCola(Cancion nuevaCancion) {
        Nodo nuevo = new Nodo(nuevaCancion);

        if (cab == null) {
            nuevo.sig = cab;
            cab = nuevo;
            fin = cab;
        } else {
            fin.sig = nuevo;
            nuevo.sig = null;
            fin = nuevo;
        }
    }
    public void borrarNodoCola() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la Cola.");
            return;
        }

        Nodo borra = cab;
        cab = borra.sig;
        borra = null;
    }

    public void imprimirCola() {
        StringBuilder resultado = new StringBuilder("Cola:\n");
        movil = cab;
        while (movil != null) {
            resultado.append(movil.cancion.nombre).append(" - ").append(movil.cancion.artista).append("\n");
            movil = movil.sig;
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public void destruirCola() {
        Nodo borra;
        while (cab != null) {
            borra = cab;
            cab = borra.sig;
            borra = null; // Liberar el nodo
        }
        fin = null; // Asegurar que fin apunte a null al vaciar la cola
    }

    public List<Cancion> getCanciones() {
        List<Cancion> canciones = new ArrayList<>();
        movil = cab;

        while (movil != null) {
            canciones.add(movil.cancion);
            movil = movil.sig;
        }

        return canciones;
    }

    public void reproducirCola() {
        movil = cab;

        while (movil != null) {
            reproduciendo = movil;

            StringBuilder mensaje = new StringBuilder("Reproduciendo desde la Cola:\n");
            mensaje.append("Nombre: ").append(reproduciendo.cancion.nombre).append("\n");
            mensaje.append("Artista: ").append(reproduciendo.cancion.artista).append("\n");
            mensaje.append("Duración: ").append(reproduciendo.cancion.duracion).append("\n");
            mensaje.append("Reproducciones: ").append(reproduciendo.cancion.reproducciones).append("\n");

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    mensaje.toString() +
                            "1. Siguiente Canción\n" +
                            "2. Salir"));

            switch (opcion) {
                case 1:
                    if (movil.sig != null) {
                        movil = movil.sig;
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay más canciones en la cola.");
                        destruirCola();  // Vaciamos la cola cuando se reproducen todas las canciones
                        return;  // Salimos de la función si no hay más canciones
                    }
                    break;
                case 2:
                    destruirCola();  // Eliminamos la canción actual de la cola
                    break;
            }
        }
    }
}
