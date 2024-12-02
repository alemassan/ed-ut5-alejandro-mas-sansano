package estudiantes;

public class claseEstudiante {
    String nombre;
    int edad;
    double notaFinal;

    public claseEstudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String toString() {
        return
                "nombre=" + nombre +
                ", edad=" + edad +
                ", notaFinal=" + notaFinal ;
    }
}
