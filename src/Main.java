import estudiantes.claseEstudiante;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Metodo principal con el menu y las opciones para elegir que quieres hacer con el estudiante.
public class Main {
    private static claseEstudiante claseEstudiante;
    private static ArrayList<claseEstudiante> estudiantes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Llama a la funcion para que inicie los estudiantes y los tenga cargados
        inicializarEstudiantes();
        boolean continuar = true;
        int opcion;
        //Deja el menu abierto mientras no se le diga que se cierre
        while (continuar) {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    introducirNotaEstudiante();
                    break;
                case 2:
                    calcularNotaMedia();
                    break;
                case 3:
                    mostrarEstudiantes();
                    break;
                case 4:
                    mostrarEstudiantesPorInicial();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

    //Funcion que inicia los estudiantes con nombre y edad para que los use el programa
    private static void inicializarEstudiantes() {
        estudiantes.add(new claseEstudiante("Ana", 20));
        estudiantes.add(new claseEstudiante("Luis", 22));
        estudiantes.add(new claseEstudiante("Carlos", 21));
        estudiantes.add(new claseEstudiante("Laura", 19));
        estudiantes.add(new claseEstudiante("Lourdes", 30));
        estudiantes.add(new claseEstudiante("Isabel", 32));
        estudiantes.add(new claseEstudiante("Maria", 16));
        estudiantes.add(new claseEstudiante("Mario", 26));
    }

    //Muestra el menu cada vez que hacemos alguna operacion
    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Introducir nota de un estudiante");
        System.out.println("2. Calcular la nota media del curso");
        System.out.println("3. Mostrar información de los estudiantes");
        System.out.println("4. Mostrar estudiantes por inicial");
        System.out.println("5. Salir");
    }

    //Muestra los estudiantes
    private static void mostrarEstudiantes() {
        System.out.println("\n--- Lista de Estudiantes ---");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i).toString());
        }
    }

    //Funcion que sirve para diferenciar los estudiantes a la hora de poner notas
    private static void mostrarEstudiantesPonerNotas() {
        System.out.println("\n--- Lista de Estudiantes ---");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(i + " " + estudiantes.get(i).toString());
        }
    }

    //Funcion que sirve para poner una nota al estudiante
    private static void introducirNotaEstudiante() {
        //Muestra los estudiantes con un numero identificativo para poner una nota
        mostrarEstudiantesPonerNotas();
        System.out.println("Elige un estudiante seleccionando el numero antes del nombre");
        int elegir;
        elegir = sc.nextInt();
        if (elegir >= estudiantes.size()) {
            System.out.println("Estudiante no encontrado");
        } else {
            //for que recorre el array para ponerle la nota al estudiante seleccionado, simpre que sea una nota entre 0 y 10
            for (int i = 0; i <= estudiantes.size(); i++) {
                if (elegir == i) {
                    System.out.println("Pon una nota al estudiante");
                    double nota = sc.nextDouble();
                    if (nota >= 0 && nota <= 10) {
                        estudiantes.get(i).setNotaFinal(nota);
                        System.out.println("Nota añadida");
                        break;
                    } else {
                        System.out.println("Error: La nota debe estar entre 0 y 10.");
                    }
                }

            }
        }


    }

    //Calcula la nota media de los estudiantes que tengan una nota media sumandolos y dividiendo entre los que tienen
    private static void calcularNotaMedia() {

        double notaMedia = 0;
        int contador = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNotaFinal() != -1) {
                notaMedia = notaMedia + estudiantes.get(i).getNotaFinal();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay notas puestas");
        } else {
            System.out.println("La nota media es: " + notaMedia / contador);
        }
    }

    //Muestra los estudiantes por la letra indicada, la busqueda se hace con una expresion regular y despues muestra la nota media de esos alumnos
    private static void mostrarEstudiantesPorInicial() {
        System.out.println("\n--- Ingrese la inicial del estudiante ---");
        sc.nextLine();
        String inicial = sc.nextLine().toUpperCase();
        String regex = "^" + inicial + ".*";
        Pattern pattern = Pattern.compile(regex);
        double notaMedia = 0;
        int contador = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            Matcher matcher = pattern.matcher(estudiantes.get(i).getNombre());
            if (matcher.matches()) {
                System.out.println(estudiantes.get(i));
                if (estudiantes.get(i).getNotaFinal() != -1) {
                    notaMedia = notaMedia + estudiantes.get(i).getNotaFinal();
                    contador++;
                }
            }
        }
        if (contador > 0) {
            System.out.println("La nota media de los estudiantes mostrados es " + notaMedia / contador);
        } else {
            System.out.println("No se encontraron estudiantes con esa letra");
        }
    }
}