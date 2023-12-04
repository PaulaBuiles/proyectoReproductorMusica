package co.edu.cue;

import co.edu.cue.LDE.ListaDobleEnlazada;
import co.edu.cue.cola.ListaCola;
import co.edu.cue.utils.Cancion;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestMusica {
    public static void main(String[] args) throws IOException {
        // Crear una lista predefinida de canciones
        List<Cancion> cancionesDisponibles = new ArrayList<>();
        cancionesDisponibles.add(new Cancion("NADIE SABE", "BadBunny", "3:45", 100000));
        cancionesDisponibles.add(new Cancion("AYER Y HOY", "Mora", "4:20", 209999));
        cancionesDisponibles.add(new Cancion("Dile al amor", "Nico Hernandez", "3:10", 34567109));
        cancionesDisponibles.add(new Cancion("Ella Dice", "Khea ft. Tini", "3:15", 150000));
        cancionesDisponibles.add(new Cancion("Delincuente", "Farruko ft. Anuel AA", "3:30", 120000));
        cancionesDisponibles.add(new Cancion("Nadie Más", "Natti Natasha", "2:45", 180000));
        cancionesDisponibles.add(new Cancion("La Modelo", "Ozuna ft. Cardi B", "4:10", 130000));
        cancionesDisponibles.add(new Cancion("Tusa", "Karol G ft. Nicki Minaj", "3:50", 250000));
        cancionesDisponibles.add(new Cancion("Me Gusta", "Shakira ft. Anuel AA", "3:00", 220000));
        cancionesDisponibles.add(new Cancion("Ahora Me Llama", "Karol G ft. Bad Bunny", "3:25", 180000));
        cancionesDisponibles.add(new Cancion("Ey Chory", "Feid", "3:17", 150000));
        cancionesDisponibles.add(new Cancion("Normal", "Feid", "3:20", 120000));
        cancionesDisponibles.add(new Cancion("Lyrical Fate", "Mowks", "3:45", 180000));
        cancionesDisponibles.add(new Cancion("Nieve", "Feid", "3:10", 130000));
        cancionesDisponibles.add(new Cancion("Contigo", "Kevin Roldan", "3:50", 250000));
        cancionesDisponibles.add(new Cancion("MONACO", "BadBunny", "3:40", 220000));
        cancionesDisponibles.add(new Cancion("Quizás, tal vez", "Eladio Carrion", "3:45", 180000));

        // Agregar más canciones según sea necesario

        ListaDobleEnlazada listaDoble = new ListaDobleEnlazada();
        listaDoble.iniciarListaDobleEnlazada();

        ListaCola listaCola = new ListaCola();
        listaCola.iniciarCola();

        int opc;
        do {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(
                        "1. Ver canciones disponibles\n" +
                        "2. Agregar canción a la Playlist\n" +
                        "3. Imprimir playlist por el inicio\n" +
                        "4. Imprimir playlist por el fin\n" +
                        "5. Agregar canción al inicio de la cola de reproducción\n" +
                        "6. Ver canciones en la cola de reproducción\n" +
                        "7. Borrar una cancion de la cola\n" +
                        "8. Borrar una cancion de la playlist por posición\n"+
                        "9. Reproducir Playlist\n" +
                        "10. Reproducir Cola de reproducción\n" +
                        "11. Salir"));

                switch (opc) {
                    case 1 -> {
                        StringBuilder cancionesDisponiblesStr = new StringBuilder("Canciones disponibles:\n");
                        for (int i = 0; i < cancionesDisponibles.size(); i++) {
                            cancionesDisponiblesStr.append((i + 1)).append(". ").append(cancionesDisponibles.get(i).nombre).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, cancionesDisponiblesStr.toString());
                    }
                    case 2 -> {
                        int numCancionDoble = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de la canción que desea agregar a la playlist:"));
                        if (numCancionDoble > 0 && numCancionDoble <= cancionesDisponibles.size()) {
                            listaDoble.insertarNodoInicio(cancionesDisponibles.get(numCancionDoble - 1));
                            JOptionPane.showMessageDialog(null, "Canción agregada a la playlist.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Número de canción no válido.");
                        }
                    }
                    case 3 -> listaDoble.imprimirListaCab();
                    case 4 -> listaDoble.imprimirListaFin();
                    case 5 -> {
                        int numCancionCola = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de la canción que desea agregar a la Cola de reproducción:"));
                        if (numCancionCola > 0 && numCancionCola <= cancionesDisponibles.size()) {
                            listaCola.insertarNodoCola(cancionesDisponibles.get(numCancionCola - 1));
                            JOptionPane.showMessageDialog(null, "Canción agregada a la Cola.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Número de canción no válido.");
                        }
                    }
                    case 6 -> listaCola.imprimirCola();
                    case 7 -> listaCola.borrarNodoCola();
                    case 8 -> listaDoble.borrarNodoPosicion();
                    case 9 -> listaDoble.reproducirLista();
                    case 10 -> listaCola.reproducirCola();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                opc = 0; // Reinicia el bucle si se produce una excepción
            }
        } while (opc != 11);
    }
}
