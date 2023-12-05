package co.edu.cue;

import co.edu.cue.utils.Cancion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Reproductor extends JFrame {
    private List<Cancion> listaCanciones;
    private int indiceActual;

    private JLabel nombreLabel;
    private JLabel artistaLabel;
    private JLabel duracionLabel;
    private JLabel reproduccionesLabel;

    private JButton siguienteButton;
    private JButton volverButton;

    public Reproductor(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
        this.indiceActual = 0;
        initComponents();
        mostrarCancionActual();
    }

    private void initComponents() {
        setTitle("Reproductor de Música");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nombreLabel = new JLabel();
        artistaLabel = new JLabel();
        duracionLabel = new JLabel();
        reproduccionesLabel = new JLabel();

        siguienteButton = new JButton("Siguiente");
        volverButton = new JButton("Volver");

        siguienteButton.addActionListener(e -> reproducirSiguiente());
        volverButton.addActionListener(e -> reproducirAnterior());

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(nombreLabel);
        panel.add(artistaLabel);
        panel.add(duracionLabel);
        panel.add(reproduccionesLabel);
        panel.add(siguienteButton);
        panel.add(volverButton);

        add(panel);
    }

    private void mostrarCancionActual() {
        if (indiceActual >= 0 && indiceActual < listaCanciones.size()) {
            Cancion cancionActual = listaCanciones.get(indiceActual);
            nombreLabel.setText("Nombre: " + cancionActual.getNombre());
            artistaLabel.setText("Artista: " + cancionActual.getArtista());
            duracionLabel.setText("Duración: " + cancionActual.getDuracion());
            reproduccionesLabel.setText("Reproducciones: " + cancionActual.getReproducciones());
        } else {
            dispose();  // Cierra la ventana si el índice está fuera de rango
        }
    }

    private void reproducirSiguiente() {
        if (indiceActual < listaCanciones.size() - 1) {
            indiceActual++;
            mostrarCancionActual();
        } else {
            JOptionPane.showMessageDialog(this, "No hay más canciones.");
        }
    }

    private void reproducirAnterior() {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarCancionActual();
        } else {
            JOptionPane.showMessageDialog(this, "No hay canciones anteriores.");
        }
    }

    public void reproducirPlaylist(List<Cancion> playlist) {
        listaCanciones = playlist;  // Actualiza la lista de canciones a la nueva playlist
        indiceActual = 0;  // Reinicia el índice al inicio de la nueva playlist
        mostrarCancionActual();
        mostrarVentana();
    }

    public void reproducirCola(List<Cancion> cola) {
        // Utiliza la cola como lista de reproducción
        listaCanciones = cola;
        indiceActual = 0;
        volverButton.setEnabled(false);
        mostrarCancionActual();
        mostrarVentana();
    }

    public void mostrarVentana() {
        setVisible(true);
    }
}
