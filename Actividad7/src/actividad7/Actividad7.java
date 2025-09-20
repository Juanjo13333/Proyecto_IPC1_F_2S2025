package actividad7;

import java.io.*;
import java.util.ArrayList;


class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Año: " + anio;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear lista de libros
        ArrayList<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
        listaLibros.add(new Libro("El principito", "Antoine de Saint-Exupéry", 1943));

        // Serializar la lista en un archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libros.ser"))) {
            oos.writeObject(listaLibros);
            System.out.println("Lista de libros serializada en libros.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar la lista
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libros.ser"))) {
            ArrayList<Libro> listaRecuperada = (ArrayList<Libro>) ois.readObject();
            System.out.println("\nLibros deserializados:");
            for (Libro libro : listaRecuperada) {
                System.out.println(libro);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}