/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.gestorarchivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author subie
 */
public class AppArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        GestorArchivos g = new GestorArchivos();

        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            try {
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 ->
                        ejecutarOpcion1(g, entrada);

                    case 2 ->
                        ejecutarOpcion2(g, entrada);

                    case 3 ->
                        ejecutarOpcion3(g, entrada);

                    case 4 ->
                        ejecutarOpcion4(g);

                    case 5 ->
                        ejecutarOpcion5(g, entrada);

                    case 6 ->
                        ejecutarOpcion6(g, entrada);

                    case 7 ->
                        ejecutarOpcion7(g, entrada);

                    case 8 ->
                        ejecutarOpcion8(g, entrada);

                    case 9 ->
                        ejecutarOpcion9(g, entrada);

                    case 10 ->
                        ejecutarOpcion10(g, entrada);

                    case 11 ->
                        ejecutarOpcion11(g, entrada);

                    case 0 -> {
                        System.out.println("Saliendo del programa");
                        salir = true;
                    }
                    default ->
                        System.out.println("OPción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Sólo son válidos los números como opciones");
            }

        }

    }

    private static void mostrarMenu() {
        System.out.println("MENÚ DE OPCIONES");
        System.out.println("1.- Comprobar si es directorio");
        System.out.println("2.- Obtener los ficheros de un Directorio");
        System.out.println("3.- Obtener las propiedades del fichero");
        System.out.println("4.- Obtener el directorio actual");
        System.out.println("5.- Eliminar fichero");
        System.out.println("6.- MOver fichero");
        System.out.println("7.- Renombrar un Fichero");
        System.out.println("8.- Copiar un Fichero");
        System.out.println("9.- Crear un Directorio");
        System.out.println("10.- Buscar por extensión");
        System.out.println("11.- Mostrar la primera línea de un fichero de texto");
        System.out.println("0.- Salir del Programa");
        System.out.println("INtroduce tu opción");
    }

    //aquí irán los métodos que se llaman desde el switch que elige cada opción
    //opción 1 -> comprobar si es directorio
    private static void ejecutarOpcion1(GestorArchivos g, Scanner entrada) {
        System.out.println("Introduce la ruta que deseas comprobar");

        try {
            String ruta = entrada.nextLine();
            //String ruta = "C:\\Users\\usuario\\Desktop\\compartida";

            Path rutaBuscada = Path.of(ruta);

            if (!g.existeRuta(rutaBuscada)) {
                System.out.println("La ruta no existe");
            } else if (g.esDirectorio(rutaBuscada)) {
                System.out.println("La ruta existe y es un directorio");
            } else {
                System.out.println("La ruta existe pero no es un directorio.");
            }
        } catch (InvalidPathException e) {
            System.out.println("LA ruta  no es válida");
        }

    }

    //opción 2-> ver el contenido de una ruta
    private static void ejecutarOpcion2(GestorArchivos g, Scanner entrada) {
        System.out.println("Introduce la ruta que quieres revisar");

        try {
            String ruta = entrada.nextLine();
            //String ruta = "C:\\Users\\usuario\\Desktop\\compartida";

            Path rutaBuscada = Path.of(ruta);

            if (!g.existeRuta(rutaBuscada)) {
                System.out.println("la ruta no existe");
            } else if (!g.esDirectorio(rutaBuscada)) {
                System.out.println("La ruta existe pero no es un directorio");
            } else {
                List<Path> contenido = g.verContenido(rutaBuscada);

                if (contenido.isEmpty()) {
                    System.out.println("El directorio está vacío");
                } else {
                    for (Path elemento : contenido) {
                        String tipo = Files.isDirectory(elemento) ? "D" : "F";
                        System.out.println(elemento.getFileName() + " " + tipo);
                    }
                }

            }
        } catch (InvalidPathException e) {
            System.out.println("La ruta no es válida");
        } catch (IOException e) {
            System.out.println("No se puede acceder al directorio");
        }

    }

    //opción 3-> obtener propiedades de fichero
    private static void ejecutarOpcion3(GestorArchivos g, Scanner entrada) {
        System.out.println("Introduce la ruta del Fichero");

        try {
            String ruta = entrada.nextLine();
            //String ruta = "C:\\Users\\subie\\Desktop\\compartida";

            Path rutaBuscada = Path.of(ruta);
            if (!g.esFichero(rutaBuscada)) {
                System.out.println("El fichero no existe");
            } else {
                System.out.println("El tamaño del fichero es " + g.tamanioFichero(rutaBuscada));

                String mensaje = g.esDeLectura(rutaBuscada) ? " es " : " no es ";
                System.out.println("El fichero" + mensaje + "de lectura");

                mensaje = g.estaOCulto(rutaBuscada) ? " está " : " no está ";
                System.out.println("El fichero" + mensaje + "oculto");

            }

        } catch (InvalidPathException e) {
            System.out.println("La ruta no es válida");
        } catch (IOException e) {
            System.out.println("Error de acceso al fichero");
        }

    }

    //opción 4-> obtener la ruta del directorio actual
    private static void ejecutarOpcion4(GestorArchivos g) {
        System.out.println("El directorio actual es " + g.directorioActual());

    }

    //opción 5-> eliminar fichero
    private static void ejecutarOpcion5(GestorArchivos g, Scanner entrada) {
        System.out.println("Introduce la ruta del Fichero");

        try {
            String ruta = entrada.nextLine();

            Path rutaBuscada = Path.of(ruta);
            if (!g.existeRuta(rutaBuscada)) {
                System.out.println("El fichero no existe");
            } else if (!g.esFichero(rutaBuscada)) {
                System.out.println("LA ruta no corresponde a un fichero");
            } else {
                g.borrarFichero(rutaBuscada);

            }

        } catch (InvalidPathException e) {
            System.out.println("La ruta del fichero no es válida");
        } catch (IOException e) {
            System.out.println("OCurrió un error al borrar el archivo");
        }
        //ocurrió un error es muy genérico: es mejor Error : + e.getMessage() y también incorporar NoSuchFileException
        //AccessDeniedException
        //FileAlreadyExistsException
    }

    //opción 6-> mover fichero
    private static void ejecutarOpcion6(GestorArchivos g, Scanner entrada) {
        System.out.println("INtroduce la ruta del archivo a mover");

        try {
            String ruta = entrada.nextLine();

            Path rutaOrigen = Path.of(ruta);

            System.out.println("Introduce la ruta de destino");

            ruta = entrada.nextLine();
            Path rutaDestino = Path.of(ruta);

            //primero comprobamos la precondición: que el origen exista y sea un fichero
            if (!g.esFichero(rutaOrigen)) {
                System.out.println("el fichero origen no existe");
                return;
            }

            //si la rutaDestino fuera una carpeta es preferible crearla explícitamente
            if (g.esDirectorio(rutaDestino)) {
                rutaDestino = rutaDestino.resolve(rutaOrigen.getFileName());
            }
            //ahora es un archivo

            //evitamos sobrescribir sin avisar, igual que en renombrar y copiar
            if (g.existeRuta(rutaDestino)) {
                System.out.println("Ya existe un fichero con ese nombre en el destino");
                return;
            }

            //ahora procedemos a mover el archivo
            g.moverFichero(rutaOrigen, rutaDestino);
            System.out.println("Fichero movido correctamente");

        } catch (InvalidPathException e) {
            System.out.println("La ruta no es válida");
        } catch (IOException e) {
            System.out.println("OCurrió un error");
        }

    }

    //opción 7-> Renombrar
    private static void ejecutarOpcion7(GestorArchivos g, Scanner entrada) {

        try {

            System.out.println("Nuevo nombre del fichero: ");
            String nombre = entrada.nextLine().trim();
            System.out.println("Ruta del fichero a renombrar: ");
            String aux = entrada.nextLine().trim();

            Path ruta = Path.of(aux);
            
            if (!g.existeRuta(ruta)) {
                System.out.println("No existe la ruta");
            } else {
            
                g.RenombrarFichero(ruta, nombre);
                System.out.println("Fichero renombrado correctamente");
            }

            

        } catch (InvalidPathException e) {
            System.out.println("La ruta no es válida");
        }

    }
    //opción 8 -> copiar fichero
    private static void ejecutarOpcion8(GestorArchivos g, Scanner entrada){}
    
    private static void ejecutarOpcion9(GestorArchivos g, Scanner entrada){}
    
    private static void ejecutarOpcion10(GestorArchivos g, Scanner entrada){}
    
    private static void ejecutarOpcion11(GestorArchivos g, Scanner entrada){}

}
