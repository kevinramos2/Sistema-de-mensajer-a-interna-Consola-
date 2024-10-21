import java.util.Scanner;


import Mensajeria.Empleados;
import Mensajeria.UserPass;

public class MainLab5 {
    public static void main(String[] args) {
        Empleados empleado = new Empleados();
        UserPass claves = new UserPass();
        try (Scanner scanner = new Scanner(System.in)) {
            // Importamos los empleados
            empleado.importar();
            // Importamos los usuarios y contraseñas
            claves.importar();

            // Booleano para verificar si el programa ejecuta o no
            boolean salir = false;
            boolean salir2 = false;

            // Creación del menú
            while (!salir) {
                System.out.println("======================================================");
                System.out.println("+         BIENVENIDO AL SISTEMA DE MENSAJERÍA        + ");
                System.out.println("======================================================");
                System.out.println();
                System.out.println("[1] Ingresar al sistema");
                System.out.println("[2] Salir");
                System.out.println();
                System.out.println("======================================================");
                System.out.print("Seleccione una opción: ");

                try {
                    int opcion1 = scanner.nextInt();

                    switch (opcion1) {

                        case 1:
                            System.out.println();
                            System.out.println("--- Por favor, ingresa tus credenciales para acceder ---");
                            System.out.println("[*] Ingresa tu ID");
                            System.out.print("---> ");
                            int ID = scanner.nextInt();

							String nombreRemi = empleado.nombre(ID);


                            System.out.println("[*] Ingresa tu contraseña");
                            System.out.print("---> ");
                            String PassWord = scanner.next();

                            // Verificar si el usuario existe
                            if (claves.esUser(ID)) {

                                // se verifica si el usuario es administrador o empleado
                                if (claves.esAdmin(ID) && claves.claveCorrecta(PassWord)) {
                                    while (!salir2) {
                                        System.out.println("======================================================");
                                        System.out.println("+           Bienvenid@, ¿qué deseas hacer?           +");
                                        System.out.println("======================================================");
                                        System.out.println();
                                        System.out.println("[1] Revisar bandeja de entrada.");
                                        System.out.println("[2] Enviar mensajes.");
                                        System.out.println("[3] Registrar nuevo usuario.");
                                        System.out.println("[4] Cambiar contraseñas.");
                                        System.out.println("[5] Eliminar usuarios.");
                                        System.out.println("[6] Salir.");
                                        System.out.println();
                                        System.out.println("======================================================");
                                        System.out.println();
                                        System.out.print("Seleccione una opción: ");
                                    }
                                }
                            }
                        }
                    }catch (Exception e) {
                        System.out.println("Error: Debes ingresar un número válido.");
                        scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                    }
                }
            }
        }
    }
