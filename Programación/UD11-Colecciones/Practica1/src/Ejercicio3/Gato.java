package Ejercicio3;

import Ejercicio1.Colores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Gato {

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String nombre;
    private Enum<Colores> color;
    private String raza;
    private LocalDate fechaNac;

    public Gato(String nombre, String color, String raza, String fechaNac) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = checkColor(color);
        this.fechaNac = LocalDate.parse(fechaNac, formatoFecha);
    }

    private Enum<Colores> checkColor(String color){
        color = color.toLowerCase();
        if (color.matches(".*[á].*")) color = color.replace('á', 'a');
        if (color.matches(".*[é].*")) color = color.replace('é', 'e');
        if (color.matches(".*[í].*")) color = color.replace('í', 'i');
        if (color.matches(".*[ó].*")) color = color.replace('ó', 'o');
        if (color.matches(".*[ú].*")) color = color.replace('ú', 'u');

        color = color.replace(" ", "");

        return Colores.valueOf(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gato gato)) return false;
        return Objects.equals(nombre, gato.nombre) && Objects.equals(color, gato.color) && Objects.equals(raza, gato.raza) && Objects.equals(fechaNac, gato.fechaNac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, color, raza, fechaNac);
    }
}
