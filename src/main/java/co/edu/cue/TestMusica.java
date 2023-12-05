package co.edu.cue;

import co.edu.cue.LDE.ListaDobleEnlazada;
import co.edu.cue.cola.ListaCola;
import co.edu.cue.utils.Cancion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMusica extends JFrame {

    private final ListaDobleEnlazada listaDoble = new ListaDobleEnlazada();
    private final ListaCola listaCola = new ListaCola();
    private final List<Cancion> cancionesDisponibles = new ArrayList<>();
    private final JTextArea cancionesTextArea = new JTextArea();

    public TestMusica() throws IOException {
        super("Reproductor de Música");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Crear una lista predefinida de canciones
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

        // ... (resto de las canciones)

        // Agregar más canciones según sea necesario

        // Crear botones
        JButton verCancionesBtn = new JButton("Ver Canciones Disponibles");
        JButton agregarPlaylistBtn = new JButton("Agregar a la Playlist");
        JButton imprimirPlaylistInicioBtn = new JButton("Imprimir Playlist por el Inicio");
        JButton imprimirPlaylistFinBtn = new JButton("Imprimir Playlist por el Fin");
        JButton agregarColaBtn = new JButton("Agregar a la Cola de Reproducción");
        JButton verColaBtn = new JButton("Ver Canciones en la Cola");
        JButton borrarColaBtn = new JButton("Borrar Canción de la Cola");
        JButton borrarPlaylistPosicionBtn = new JButton("Borrar Canción de la Playlist por Posición");
        JButton reproducirPlaylistBtn = new JButton("Reproducir Playlist");
        JButton reproducirColaBtn = new JButton("Reproducir Cola de Reproducción");
        JButton salirBtn = new JButton("Salir");

        // Configurar diseños y eventos
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(5, 2, 10, 10));
        agregarBoton(botonesPanel, verCancionesBtn);
        agregarBoton(botonesPanel, agregarPlaylistBtn);
        agregarBoton(botonesPanel, imprimirPlaylistInicioBtn);
        agregarBoton(botonesPanel, imprimirPlaylistFinBtn);
        agregarBoton(botonesPanel, agregarColaBtn);
        agregarBoton(botonesPanel, verColaBtn);
        agregarBoton(botonesPanel, borrarColaBtn);
        agregarBoton(botonesPanel, borrarPlaylistPosicionBtn);
        agregarBoton(botonesPanel, reproducirPlaylistBtn);
        agregarBoton(botonesPanel, reproducirColaBtn);
        agregarBoton(botonesPanel, salirBtn);

        // Panel de canciones
        JScrollPane cancionesScrollPane = new JScrollPane(cancionesTextArea);
        cancionesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cancionesScrollPane.setPreferredSize(new Dimension(200, getHeight()));
        cancionesScrollPane.setBorder(BorderFactory.createTitledBorder("Canciones Disponibles"));

        // Agregar paneles al contenedor principal
        add(botonesPanel, BorderLayout.WEST);
        add(cancionesScrollPane, BorderLayout.EAST);

        // Configurar eventos
        verCancionesBtn.addActionListener(e -> mostrarCancionesDisponibles());
        agregarPlaylistBtn.addActionListener(e -> agregarAPlaylist());
        imprimirPlaylistInicioBtn.addActionListener(e -> listaDoble.imprimirListaCab());
        imprimirPlaylistFinBtn.addActionListener(e -> listaDoble.imprimirListaFin());
        agregarColaBtn.addActionListener(e -> agregarACola());
        verColaBtn.addActionListener(e -> listaCola.imprimirCola());
        borrarColaBtn.addActionListener(e -> listaCola.borrarNodoCola());
        borrarPlaylistPosicionBtn.addActionListener(e -> listaDoble.borrarNodoPosicion());
        reproducirPlaylistBtn.addActionListener(e -> reproducirPlaylist());
        reproducirColaBtn.addActionListener(e -> reproducirCola());
        salirBtn.addActionListener(e -> System.exit(0));
        setSize(1234, 600);
    }

    private void agregarBoton(Container container, JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        container.add(button);
    }

    private void mostrarCancionesDisponibles() {
        StringBuilder cancionesDisponiblesStr = new StringBuilder("Canciones disponibles:\n");
        for (int i = 0; i < cancionesDisponibles.size(); i++) {
            cancionesDisponiblesStr.append((i + 1)).append(". ").append(cancionesDisponibles.get(i).nombre).append("\n");
        }
        cancionesTextArea.setText(cancionesDisponiblesStr.toString());
    }

    private void agregarAPlaylist() {
        int numCancionDoble = obtenerNumeroCancion("Digite el número de la canción que desea agregar a la playlist:");
        if (numCancionDoble > 0 && numCancionDoble <= cancionesDisponibles.size()) {
            listaDoble.insertarNodoInicio(cancionesDisponibles.get(numCancionDoble - 1));
            mostrarAlerta("Éxito", "Canción agregada a la playlist.");
        } else {
            mostrarAlerta("Error", "Número de canción no válido.");
        }
    }

    private void agregarACola() {
        int numCancionCola = obtenerNumeroCancion("Digite el número de la canción que desea agregar a la Cola de reproducción:");
        if (numCancionCola > 0 && numCancionCola <= cancionesDisponibles.size()) {
            listaCola.insertarNodoCola(cancionesDisponibles.get(numCancionCola - 1));
            mostrarAlerta("Éxito", "Canción agregada a la Cola.");
        } else {
            mostrarAlerta("Error", "Número de canción no válido.");
        }
    }

    private int obtenerNumeroCancion(String mensaje) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Ingrese un número válido.");
            return -1;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void reproducirPlaylist() {
        Reproductor reproductorFrame = new Reproductor(listaDoble.getCanciones()); // O listaCola.getCanciones()
        reproductorFrame.reproducirPlaylist(listaDoble.getCanciones());
    }

    private void reproducirCola() {
        Reproductor reproductorFrame = new Reproductor(listaCola.getCanciones()); // O listaCola.getCanciones()
        reproductorFrame.reproducirCola(listaCola.getCanciones());

    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> {
                try {
                    new TestMusica().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}