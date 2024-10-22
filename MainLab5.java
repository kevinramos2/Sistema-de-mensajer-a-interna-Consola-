import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Mensajeria.BandejaDeEntrada;
import Mensajeria.Empleados;
import Mensajeria.Mensaje;
import Mensajeria.UserPass;
import Pack.Direccion;
import Pack.Fecha;
import Pack.Usuario;

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

                                        try {
                                            int opcion2 = scanner.nextInt();

                                            switch (opcion2) {
                                                case 1: // Bandeja de entrada
													BandejaDeEntrada bandeja = new BandejaDeEntrada(ID);
													System.out.println("======================================================");
													System.out.println("+         Bienvenido a tu bandeja de entrada         +");
												    System.out.println("======================================================");

													bandeja.mostrarBandejaDeEntrada();

													System.out.println("[*] Seleccione el número del mensaje que desea leer (o 0 para salir): ");
													System.out.print("---> ");
													int numeroMensaje = scanner.nextInt();
																									
													if (numeroMensaje > 0) {
														bandeja.leerMensaje(numeroMensaje);
												    }

                                                    break;

                                                case 2: // Enviar mensajes
                                                    System.out.println("======================================================");
                                                    System.out.println("[*] Cédula del destinatario.");
                                                    System.out.print("---> ");
                                                    int ccDest = scanner.nextInt();

                                                    scanner.nextLine();

                                                    System.out.println("[*] Título de tu mensaje.");
                                                    System.out.print("---> ");
                                                    String titulo = scanner.nextLine();

                                                    System.out.println("[*] Cuerpo del mensaje.");
                                                    System.out.print("---> ");
                                                    String cuerpo = scanner.nextLine();
                                                    LocalDateTime fecha = LocalDateTime.now();
                                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                                    String fechaHora = fecha.format(formatter);
                                                    Mensaje mensajeAEnviar = new Mensaje(nombreRemi,ccDest, titulo, cuerpo, fechaHora);

                                                    System.out.println();
                                                    System.out.println("======================================================");
                                                    System.out.println("+            Mensaje enviado exitosamente            +");
                                                    System.out.println("======================================================");
                                                    System.out.println();

													//Agregar el mensaje a la bandeja del destinatario
													BandejaDeEntrada bandejaDestinatario = new BandejaDeEntrada(ccDest);
												    bandejaDestinatario.agregar(mensajeAEnviar);
																										

                                                    break;

                                                case 3: // Registrar usuarios nuevos
                                                    Usuario nuevoUsuario = new Usuario();

                                                    System.out.println("[*] Nombre.");
                                                    System.out.print("---> ");
                                                    String nombre = scanner.next();
                                                    nuevoUsuario.setNombre(nombre);

                                                    System.out.println("[*] Identificación.");
                                                    System.out.print("---> ");
                                                    int id = scanner.nextInt();
                                                    scanner.nextLine();
                                                    nuevoUsuario.setId(id);

                                                    System.out.println("[*] Fecha de nacimiento (dd-mm-aaaa).");
                                                    System.out.print("---> ");
                                                    String fechaI = scanner.nextLine();
                                                    nuevoUsuario.setFecha_nacimiento(Fecha.StringAFecha(fechaI));

                                                    System.out.println("[*] Ciudad de nacimiento.");
                                                    System.out.print("---> ");
                                                    String ciudadN = scanner.nextLine();
                                                    nuevoUsuario.setCiudad_nacimiento(ciudadN);

                                                    System.out.println("[*] Teléfono.");
                                                    System.out.print("---> ");
                                                    long tel = scanner.nextLong();
                                                    scanner.nextLine();
                                                    nuevoUsuario.setTel(tel);

                                                    System.out.println("[*] Email.");
                                                    System.out.print("---> ");
                                                    String email = scanner.nextLine();
                                                    nuevoUsuario.setEmail(email);

                                                    System.out.println("¿La dirección incluye edificio y apartamento? (Si/No)");
                                                    System.out.print("---> ");
                                                    String tieneApto = scanner.nextLine();

                                                    if (tieneApto.equalsIgnoreCase("si")) {
                                                        System.out.println("[*] Dirección (Calle nomenclatura barrio ciudad edificio apartamento).");
                                                        System.out.print("---> ");
                                                        String dir = scanner.nextLine();
                                                        nuevoUsuario.setDir(Direccion.CambiarStringADir(dir));

                                                    } else {
                                                        System.out.println("[*] Dirección (Calle nomenclatura barrio ciudad).");
                                                        System.out.print("---> ");
                                                        String dir = scanner.nextLine();
                                                        nuevoUsuario.setDir(Direccion.CambiarStringADir2(dir));
                                                    }

                                                    // Creación de la clave y cargo del usuario
                                                    Usuario nuevoUser = new Usuario();

                                                    System.out.println("[*] Asignale una contraseña.");
                                                    System.out.print("---> ");
                                                    String contra = scanner.nextLine();
                                                    nuevoUser.setPassword(contra);

                                                    System.out.println("[*] Asignale un cargo.");
                                                    System.out.print("---> ");
                                                    String cargo = scanner.nextLine();
                                                    nuevoUser.setCargo(cargo);
                                                    nuevoUser.setId(id);

                                                    empleado.agregar(nuevoUsuario);
                                                    claves.agregar(nuevoUser);

                                                    System.out.println("======================================================");
                                                    System.out.println("+      Usuario y credenciales creados con éxito      +");
                                                    System.out.println("======================================================");
                                                    System.out.println();


                                                    break;

                                                case 4: // Cambiar contraseñas
																										System.out.println();
                                                    System.out.println("Por favor proporciona la identificación del usuario  \n"
                                                            + "al cual le deseas cambiar la contraseña.");
                                                    System.out.print("---> ");
                                                    int idCambio = scanner.nextInt();
                                                    scanner.nextLine();

                                                    System.out.println("Ahora, digita la nueva contraseña que será asignada al usuario correspondiente.");
                                                    System.out.print("---> ");
                                                    String nuevaPass = scanner.nextLine();

                                                    // hay que hacer el toFile para actualizar los archivos txt
                                                    claves.cambiarClave(idCambio, nuevaPass);

                                                    System.out.println("======================================================");
                                                    System.out.println("+     Contraseña del usuario cambiada con éxito      +");
                                                    System.out.println("======================================================");
                                                    System.out.println();
                                                    break;

                                                case 5: // Eliminar usuarios
													System.out.println();
													System.out.println("Por favor proporciona la identificación del usuario  \n"
														+ "al cual deseas eliminar del sistema.");
													System.out.print("---> ");
                                                    int idEliminar = scanner.nextInt();
                                                    scanner.nextLine();

													claves.eliminar(idEliminar);
													empleado.eliminar(idEliminar);


													System.out.println("======================================================");
                                                    System.out.println("+     Usuario eliminado exitosamente del sistema     +");
                                                    System.out.println("======================================================");
                                                    System.out.println();

                                                    break;

                                                case 6: // Salir
                                                    salir2 = true;
                                                    break;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Error: Debes ingresar un número válido.");
                                            scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                                        }
                                    }
                                } else if (!claves.esAdmin(ID) && claves.claveCorrecta(PassWord)) {

                                    boolean salirEmpleado = false;

                                    while (!salirEmpleado) {
                                        System.out.println("======================================================");
                                        System.out.println("+           Bienvenido, ¿qué deseas hacer?           +");
                                        System.out.println("======================================================");
                                        System.out.println();
                                        System.out.println("[1] Revisar bandeja de entrada.");
                                        System.out.println("[2] Enviar mensajes.");
                                        System.out.println("[3] Salir.");
                                        System.out.println();
                                        System.out.println("======================================================");
                                        System.out.println();
                                        System.out.print("Seleccione una opción: ");

                                        try {
                                            int opcion2 = scanner.nextInt();

                                            switch (opcion2) {
                                                case 1: // Bandeja de entrada
													BandejaDeEntrada bandeja = new BandejaDeEntrada(ID);
												    System.out.println("======================================================");
												    System.out.println("+         Bienvenido a tu bandeja de entrada         +");
													System.out.println("======================================================");

													bandeja.mostrarBandejaDeEntrada();

													System.out.println("[*] Seleccione el número del mensaje que desea leer (o 0 para salir): ");
													System.out.print("---> ");
													int numeroMensaje = scanner.nextInt();
																								
													if (numeroMensaje > 0) {
														bandeja.leerMensaje(numeroMensaje);
												    }
                                                    break;

                                                case 2: // Enviar mensajes
												    System.out.println("======================================================");
													System.out.println("[*] Cédula del destinatario.");
											        System.out.print("---> ");
													int ccDest = scanner.nextInt();

												    scanner.nextLine();

													System.out.println("[*] Título de tu mensaje.");
													System.out.print("---> ");
													String titulo = scanner.nextLine();

											        System.out.println("[*] Cuerpo del mensaje.");
													System.out.print("---> ");
													String cuerpo = scanner.nextLine();
													LocalDateTime fecha = LocalDateTime.now();
													DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
													String fechaHora = fecha.format(formatter);
													Mensaje mensajeAEnviar = new Mensaje(nombreRemi,ccDest, titulo, cuerpo, fechaHora);

													System.out.println();
													System.out.println("======================================================");
													System.out.println("+            Mensaje enviado exitosamente            +");
												    System.out.println("======================================================");
													System.out.println();

													//Agregar el mensaje a la bandeja del destinatario
													BandejaDeEntrada bandejaDestinatario = new BandejaDeEntrada(ccDest);
													bandejaDestinatario.agregar(mensajeAEnviar);
																								

													break;

                                                case 3: // Salir
                                                    salirEmpleado = true;
                                                    break;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Error: Debes ingresar un número válido.");
                                            scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                                        }
                                    }
                                } else {
                                    System.out.println("Error: Clave incorrecta.");
                                    scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                                }
                            } else {
                                System.out.println("Error: Usuario no encontrado.");
                            }
                            break; // Añadir break aquí para salir del primer switch

                        case 2:
                            System.out.println("Saliendo del sistema ...");
                            salir = true;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Debes ingresar un número válido.");
                    scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                }
            }
        }
    }
}

