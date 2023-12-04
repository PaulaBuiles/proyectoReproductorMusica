package co.edu.cue.utils;

public class Cancion {
    public String nombre;
    public String artista;
    public String duracion;
    public Integer reproducciones;

    public Cancion(String nombre, String artista, String duración, Integer reproducciones) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duración;
        this.reproducciones = reproducciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(Integer reproducciones) {
        this.reproducciones = reproducciones;
    }
}
