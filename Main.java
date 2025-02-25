import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    //creamos un scanner para poder usarlo en toda la clase
    private static Scanner scanner = new Scanner(System.in);

    //creamos un arrayList para poder guardar todos los guerreros
    private static ArrayList<Heroe> heroes = new ArrayList<>();

    //creamos un arrayList para poder guardar nuevas armas
    private static ArrayList<Arma> armas = new ArrayList<>();


    public static void main(String[] args) {
        //creamos objetos armas
        Arma arma1 = new Arma("Bastón Arcano", 50);
        Arma arma2 = new Arma("Orbe Místico", 60);
        Arma arma3 = new Arma("Espada", 40);
        Arma arma4 = new Arma("Hacha", 45);
        Arma arma5 = new Arma("Bomba", 50);

        //añadimos los objetos de armas dentro de la lista de armas
        armas.add(arma1);
        armas.add(arma2);
        armas.add(arma3);
        armas.add(arma4);
        armas.add(arma5);


        System.out.println("Bienvenidos a Héroes 1J");
        boolean continuar = true;

        while (continuar) {
            try {
                imprimirMenu();
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); //limpiamos el buffer
                boolean seguirEligiendoArma = true;
                System.out.println();

                switch (opcion) {
                    case 1: //añadir tipo de héroe
                        boolean seguir = true;

                        while (seguir) {
                            listaDeHeroes(); //mostramos la lista de heroes a elegir
                            try {
                                System.out.print("Elige una subopción:");
                                int seleccion = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();
                                String nombreHeroe;
                                int nivel = 0;
                                int puntosDeVida = 0;
                                int atributo = 0;

                                switch (seleccion) {
                                    case 1: //añadir un guerrero
                                        //validamos el nombre
                                        do {
                                            System.out.print("Nombre del Guerrero/a: ");
                                            nombreHeroe = scanner.next();
                                            scanner.nextLine();

                                            if (!validacionNombre(nombreHeroe)) {
                                                System.out.println("Introduce un nombre válido. Solo letras y espacios.");
                                                continue; // Volver a pedir el nombre sin evaluar duplicados
                                            }
                                            if (validarNombreHeroe(nombreHeroe)) {
                                                System.out.println("Ya existe un héroe con ese nombre.");
                                            }
                                        } while (!validacionNombre(nombreHeroe) || validarNombreHeroe(nombreHeroe));


                                        do {
                                            try {
                                                System.out.print("Nivel: ");
                                                nivel = scanner.nextInt();
                                                if (!validarNumeros(nivel)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(nivel));

                                        //validamos los puntos de vida
                                        do {
                                            try {
                                                System.out.print("Puntos de Vida: ");
                                                puntosDeVida = scanner.nextInt();
                                                if (!validarNumeros(puntosDeVida)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(puntosDeVida));

                                        //validamos la fuerza
                                        do {
                                            try {
                                                System.out.print("Fuerza: ");
                                                atributo = scanner.nextInt();
                                                if (!validarNumeros(atributo)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(atributo));

                                        // escogemos arma para heroe
                                        // IMPORTANTE!!!!! no hace falta llamar al metodo escogerArmasParaHeroe() porque lo estas llamando ya al crear objeto Guerrero
                                        Guerrero guerrero = new Guerrero(nombreHeroe, nivel, puntosDeVida, escogerArmasParaHeroe(), atributo);
                                        heroes.add(guerrero);
                                        break;


                                    case 2: //añadir un mago
                                        //validamos el nombre
                                        do {
                                            System.out.print("Nombre del Mago/a: ");
                                            nombreHeroe = scanner.next();
                                            scanner.nextLine();
                                            if (!validacionNombre(nombreHeroe)) {
                                                System.out.println("Introduce un nombre válido. Solo letras y espacios");
                                                continue; // Volver a pedir el nombre sin evaluar duplicados
                                            }
                                            if (validarNombreHeroe(nombreHeroe)) {
                                                System.out.println("Ya existe un héroe con ese nombre.");
                                            }
                                        } while (!validacionNombre(nombreHeroe) || validarNombreHeroe(nombreHeroe));

                                        do {
                                            try {
                                                System.out.print("Nivel: ");
                                                nivel = scanner.nextInt();
                                                if (!validarNumeros(nivel)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(nivel));

                                        //validamos los puntos de vida
                                        do {
                                            try {
                                                System.out.print("Puntos de Vida: ");
                                                puntosDeVida = scanner.nextInt();
                                                if (!validarNumeros(puntosDeVida)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(puntosDeVida));

                                        //validamos el mana
                                        do {
                                            try {
                                                System.out.print("Mana: ");
                                                atributo = scanner.nextInt();
                                                if (!validarNumeros(atributo)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(atributo));

                                        //escogemos las armas para heroe
                                        // IMPORTANTE!!!!! no hace falta llamar al metodo escogerArmasParaHeroe() porque lo estas llamando ya al crear objeto Mago
                                        Mago mago = new Mago(nombreHeroe, nivel, puntosDeVida, escogerArmasParaHeroe(), atributo);
                                        heroes.add(mago);
                                        break;


                                    case 3: //añadir un arquero
                                        //validamos el nombre
                                        do {
                                            System.out.print("Nombre del Arquero/a: ");
                                            nombreHeroe = scanner.next();
                                            scanner.nextLine();

                                            if (!validacionNombre(nombreHeroe)) {
                                                System.out.println("Introduce un nombre válido. Solo letras y espacios.");
                                                continue; // Volver a pedir el nombre sin evaluar duplicados
                                            }
                                            if (validarNombreHeroe(nombreHeroe)) {
                                                System.out.println("Ya existe un héroe con ese nombre.");
                                            }
                                        } while (!validacionNombre(nombreHeroe) || validarNombreHeroe(nombreHeroe));


                                        do {
                                            try {
                                                System.out.print("Nivel: ");
                                                nivel = scanner.nextInt();
                                                if (!validarNumeros(nivel)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(nivel));

                                        //validamos los puntos de vida
                                        do {
                                            try {
                                                System.out.print("Puntos de Vida: ");
                                                puntosDeVida = scanner.nextInt();
                                                if (!validarNumeros(puntosDeVida)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(puntosDeVida));

                                        //validamos la Precision
                                        do {
                                            try {
                                                System.out.print("Precisión: ");
                                                atributo = scanner.nextInt();
                                                if (!validarNumeros(atributo)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(atributo));


                                        //escogemos arma para heroe
                                        // IMPORTANTE!!!!! no hace falta llamar al metodo escogerArmasParaHeroe() porque lo estas llamando ya al crear objeto Arquero
                                        Arquero arquero = new Arquero(nombreHeroe, nivel, puntosDeVida, escogerArmasParaHeroe(), atributo);
                                        heroes.add(arquero);
                                        break;

                                    case 4: //añadir un asesino
                                        //validamos el nombre
                                        do {
                                            System.out.print("Nombre del Asesino/a: ");
                                            nombreHeroe = scanner.next();
                                            scanner.nextLine();

                                            if (!validacionNombre(nombreHeroe)) {
                                                System.out.println("Introduce un nombre válido. Solo letras y espacios.");
                                                continue; // Volver a pedir el nombre sin evaluar duplicados
                                            }
                                            if (validarNombreHeroe(nombreHeroe)) {
                                                System.out.println("Ya existe un héroe con ese nombre.");
                                            }
                                        } while (!validacionNombre(nombreHeroe) || validarNombreHeroe(nombreHeroe));

                                        do {
                                            try {
                                                System.out.print("Nivel: ");
                                                nivel = scanner.nextInt();
                                                if (!validarNumeros(nivel)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(nivel));

                                        //validamos los puntos de vida
                                        do {
                                            try {
                                                System.out.print("Puntos de Vida: ");
                                                puntosDeVida = scanner.nextInt();
                                                if (!validarNumeros(puntosDeVida)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(puntosDeVida));

                                        //validamos el sigilo
                                        do {
                                            try {
                                                System.out.print("Sigilo: ");
                                                atributo = scanner.nextInt();
                                                if (!validarNumeros(atributo)) {
                                                    System.out.println("Introduce un número entero entre 1 y 999");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Introduce un numero entero");
                                                scanner.nextLine(); //LIMPIAMOS BUFFER SIEMPRE EN EL CATCH
                                            }
                                        } while (!validarNumeros(atributo));


                                        // Escogemos arma para héroe
                                        // IMPORTANTE!!!!! no hace falta llamar al metodo escogerArmasParaHeroe() porque lo estas llamando ya al crear objeto Asesino
                                        Asesino asesino = new Asesino(nombreHeroe, nivel, puntosDeVida, escogerArmasParaHeroe(), atributo);
                                        heroes.add(asesino);
                                        break;

                                    case 5: //dejar de añadir heroes
                                        seguir = false;
                                        System.out.println("Has salido de la opción de añadir jugadores.");
                                        break;

                                    default:
                                        System.out.println("Selecciona una subopción válida.");
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida. Por favor, introduce un número.");
                                scanner.nextLine(); // Limpiar el buffer
                            }


                        }

                        break;

                    case 2: //añadir un arma nueva al arsenal
                        System.out.println("Has escogido la opción de añadir un arma nueva al arsenal.");
                        crearArmaNueva();
                        break;

                    case 3: //eliminar heroe por su nombre
                        System.out.println("Has escogido la opción de eliminar un héroe por su nombre.");
                        eliminarHeroePorNombre();
                        break;

                    case 4: //Buscar héroe y mostrar sus detalles
                        System.out.println("Has escogido la opción de buscar un héroe y mostrar sus detalles.");
                        buscarHeroePorNombre();
                        break;

                    case 5: //listar todos los héros registrados en el gremio
                        System.out.println("Has escogido la opción de listar todos los héros registrados en el gremio.");
                        imprimirListaHeroes();
                        break;

                    case 6: //opción de salir
                        continuar = false;
                        System.out.println("Has salido del juego.");
                        break;

                    default:
                        System.out.println("Selecciona una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }

    //metodo para imprimir el menu
    public static void imprimirMenu() {
        System.out.println();
        System.out.println("1. Añadir un nuevo héroe.");
        System.out.println("2. Añadir un arma nueva al arsenal.");
        System.out.println("3. Eliminar un héroe por su nombre.");
        System.out.println("4. Buscar un héroe y mostrar sus detalles.");
        System.out.println("5. Listar todos los héroes registrados en el gremio.");
        System.out.println("6. Salir del programa.");
    }


    //Imprimir tipo de heroes
    public static void listaDeHeroes() {
        System.out.println();
        System.out.println("¿Qué tipo de héroe deseas añadir?");
        System.out.println("1: Guerrero/a");
        System.out.println("2: Mago/a");
        System.out.println("3: Arquero/a");
        System.out.println("4: Asesino/a");
        System.out.println("5. Salir de la opción de añadir jugadores.");
    }


    //metodo para imprimir la lista de todos los heroes
    public static void imprimirListaHeroes() {
        if (heroes.isEmpty()) {
            System.out.println("No hay ningún héroe en la lista actualmente.");
        } else {
            System.out.println();
            System.out.println("Lista de héroes:");
            for (Heroe heroe : heroes) {
                System.out.println(heroe);
            }
        }
    }


    //IMPORTANTE!!!!!  Hay que hacer un iterator cuando queramos eliminar o añadir algo en un arrayList porque si utilizamos un foreach da problemas
    //Buscar nombre de heroe por nombre, con este metodo podremos añadirlo sin duplicados
    public static boolean validarNombreHeroe(String nombreHeroe) {
        Iterator<Heroe> iterator = heroes.iterator();
        while (iterator.hasNext()) {
            Heroe heroe = iterator.next();
            if (heroe.getNombreHeroe().trim().equalsIgnoreCase(nombreHeroe)) {
                return true; //si existe el nombre
            }
        }
        return false; //si no existe
    }


    //buscar heroe por su nombre e imprimir sus detalles
    public static void buscarHeroePorNombre() {
        System.out.print("Introduce el nombre del héroe: ");
        String nombreHeroe = scanner.nextLine().toLowerCase().trim(); //hacemos el toLoweCase para que no distinga entre mayusculas y minusculas, y el trim para eliminar espacios al inicio y al final
        boolean encontrado = false;

        for (Heroe heroe : heroes) { //buscamos en el arrayList donde tenemos guardados todos los heroes recorriendolo con un foreach
            if (heroe.getNombreHeroe().trim().equalsIgnoreCase(nombreHeroe)) {
                System.out.println();
                System.out.println("Héroe con nombre '" + nombreHeroe + "':");
                System.out.println(heroe);
                encontrado = true;
            }
        }
        if (!encontrado) { //si no encontramos un héroe con ese nombre
            System.out.println("No se encontró un héroe con ese nombre.");
        }
    }


    //buscar heroe por su nombre y eliminar
    public static void eliminarHeroePorNombre() {
        System.out.print("Introduce el nombre del héroe: ");
        String nombreHeroe = scanner.nextLine().toLowerCase(); // Convertir a minúsculas para comparación
        boolean encontrado = false;

        // Usamos un iterador para evitar ConcurrentModificationException
        Iterator<Heroe> iterator = heroes.iterator();

        while (iterator.hasNext()) {
            Heroe heroe = iterator.next();
            if (heroe.getNombreHeroe().trim().equalsIgnoreCase(nombreHeroe)) {
                iterator.remove(); // Eliminar héroe de manera segura
                System.out.println("El héroe con nombre '" + nombreHeroe + "' se ha eliminado correctamente.");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un héroe con ese nombre.");
        }
    }


    //metodo para añadir un arma nueva
    public static void crearArmaNueva() {
        System.out.print("Introduce el nombre del arma nueva: ");
        String nombreArma = scanner.nextLine().toLowerCase().trim(); //hacemos el toLoweCase para que no distinga entre mayusculas y minusculas, y el trim para eliminar espacio al inicio y al final de la palabra
        boolean encontrado = false;

        // Usamos un iterador para evitar ConcurrentModificationException
        Iterator<Arma> iterator = armas.iterator();

        while (iterator.hasNext()) {
            Arma arma = iterator.next();
            if (arma.getNombreArma().trim().equalsIgnoreCase(nombreArma)) {
                System.out.println("Ya existe un arma con ese nombre.");
                encontrado = true;
            }
        }
        if (!encontrado) { //si no existe un arma con ese nombre
            try {
                System.out.print("Introduce el daño de ese arma: ");
                int danio = scanner.nextInt();
                Arma arma = new Arma(nombreArma, danio); //creamos un objeto arma con los datos introducidos por consola
                armas.add(arma); //añadimos el objeto arma dentro de la lista de armas
                System.out.println("El arma con nombre '" + nombreArma + "' se ha creado con éxito.");
            } catch (Exception e) {
                System.out.println("Tienes que introducir un número entero en el daño.");
                scanner.nextLine(); //limpiamos el buffer
            }
        }
    }


    //metodo para imprimir lista de armas
    public static void imprimirListaArmas() {
        int cantidad = 0;
        if (armas.isEmpty()) {
            System.out.println("No hay ningún arma en la lista actualmente.");
        } else {
            for (Arma arma : armas) {
                cantidad++;
                System.out.println(cantidad + ". " + arma);
            }
        }
    }


    //buscar en lista de armas por numero
    public static Arma escogerArma(int numArma) {
        int cantidad = 0;
        for (Arma arma : armas) {
            cantidad++;
            if (cantidad == numArma) {
                return arma;
            }
        }
        return null;
    }


    //metodo para validar numeros (nivel, puntos vida...)
    public static boolean validarNumeros(int numero) {
        if (numero > 0 && numero < 1000) {
            return true;
        }
        return false;
    }


    //validacion nombre
    public static boolean validacionNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"); //solo dejaremos introducir letras y espacios
    }


    // metodo para escoger armas de heroes
    public static ArrayList<Arma> escogerArmasParaHeroe() {
        ArrayList<Arma> armasEscogidas = new ArrayList<>(); // Lista donde guardamos las armas escogidas para ese héroe
        String eleccion;
        int numeroArma;
        Arma armaSeleccionada;
        boolean seguirEligiendoArma = true;

        while (seguirEligiendoArma) {
            // Solicitamos al usuario que elija un arma
            do {
                System.out.println();
                System.out.println("Elige un arma para este héroe: ");
                imprimirListaArmas();
                System.out.print("Elige una subopción: ");
                numeroArma = scanner.nextInt();
                scanner.nextLine(); //limpiamos buffer
                armaSeleccionada = escogerArma(numeroArma); // Seleccionamos el arma

                if (armaSeleccionada == null) {
                    System.out.println("Escoge un número de arma que esté en la lista.");
                }
                if (armasEscogidas.contains(armaSeleccionada)) {
                    System.out.println("Este héroe ya tiene esta arma en su lista.");
                } else {
                    // Si el arma seleccionada no es nula, la agregamos a la lista de armas
                    armasEscogidas.add(armaSeleccionada);
                    System.out.println("Se ha añadido el héroe con su " + armaSeleccionada.getNombreArma() + "!");
                }
            } while (armaSeleccionada == null && armasEscogidas.contains(armaSeleccionada));  // Repite si el arma seleccionada es nula o ya está en la lista

            // Preguntamos si desea añadir otra arma
            do {
                System.out.print("¿Deseas añadir otra arma a este héroe? (S)i o (N)o: ");
                eleccion = scanner.next();
                scanner.nextLine(); // Limpiamos el buffer del scanner

                if (eleccion.trim().equalsIgnoreCase("S")) {
                    seguirEligiendoArma = true;
                }
                else if (eleccion.trim().equalsIgnoreCase("N")) {
                    seguirEligiendoArma = false;
                } else {
                    System.out.println("Escoge una opción válida: (S)i o (N)o");
                }
            } while (!eleccion.equalsIgnoreCase("S") && !eleccion.equalsIgnoreCase("N"));

        }
        return armasEscogidas;
    }
}