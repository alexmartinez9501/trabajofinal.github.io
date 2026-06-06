/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   RESTAURANTE 'SABORES'                ║");
        System.out.println("║   SISTEMA DE GESTIÓN DE PEDIDOS        ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    registrarPedidoComida();
                    break;
                case 2:
                    registrarPedidoBebida();
                    break;
                case 3:
                    registrarPedidoCombo();
                    break;
                case 4:
                    listarTodosLosPedidos();
                    break;
                case 5:
                    calcularTotalVentas();
                    break;
                case 6:
                    buscarPorMesa();
                    break;
                case 7:
                    cambiarEstadoPedido();
                    break;
                case 8:
                    verPedidosPendientes();
                    break;
                case 0:
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("\n Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              MENÚ PRINCIPAL            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Registrar pedido de comida          ║");
        System.out.println("║ 2. Registrar pedido de bebida          ║");
        System.out.println("║ 3. Registrar pedido combo              ║");
        System.out.println("║ 4. Listar todos los pedidos            ║");
        System.out.println("║ 5. Calcular total de ventas del día    ║");
        System.out.println("║ 6. Buscar pedidos por número de mesa   ║");
        System.out.println("║ 7. Cambiar estado de pedido a entregado║");
        System.out.println("║ 8. Ver pedidos pendientes               ║");
        System.out.println("║ 0. Salir                                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("► Elija una opción: ");
    }
    
    private static int leerOpcion() {
        int opcion = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return opcion;
    }
    
    private static int leerEntero(String mensaje) {
        int valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número entero. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
        return valor;
    }
    
    private static double leerDouble(String mensaje) {
        double valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número válido. Intente nuevamente: ");
                scanner.nextLine();
            }
        }
        return valor;
    }
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
    
    // Opción 1: Registrar pedido de comida
    private static void registrarPedidoComida() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│     REGISTRO DE PEDIDO DE COMIDA       │");
        System.out.println("└─────────────────────────────────────────┘");
        
        try {
            int numMesa = leerEntero("Ingrese número de mesa: ");
            String nombreItem = leerTexto("Ingrese nombre del plato: ");
            double precio = leerDouble("Ingrese precio: S/ ");
            System.out.print("¿Es plato fuerte? (true/false): ");
            boolean esPlatoFuerte = scanner.nextBoolean();
            scanner.nextLine();
            
            PedidoComida pedido = new PedidoComida(numMesa, nombreItem, precio, esPlatoFuerte);
            listaPedidos.add(pedido);
            
            System.out.println("\n ¡Pedido registrado exitosamente!");
            pedido.mostrarInformacion();
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n Error inesperado: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    // Opción 2: Registrar pedido de bebida
    private static void registrarPedidoBebida() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│     REGISTRO DE PEDIDO DE BEBIDA       │");
        System.out.println("└─────────────────────────────────────────┘");
        
        try {
            int numMesa = leerEntero("Ingrese número de mesa: ");
            String nombreItem = leerTexto("Ingrese nombre de la bebida: ");
            double precio = leerDouble("Ingrese precio: S/ ");
            System.out.print("Ingrese tamaño (PEQUENO/MEDIANO/GRANDE): ");
            String tamanio = scanner.nextLine().toUpperCase();
            
            PedidoBebida pedido = new PedidoBebida(numMesa, nombreItem, precio, tamanio);
            listaPedidos.add(pedido);
            
            System.out.println("\n ¡Pedido registrado exitosamente!");
            pedido.mostrarInformacion();
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n Error inesperado: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    // Opción 3: Registrar pedido combo
    private static void registrarPedidoCombo() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│       REGISTRO DE PEDIDO COMBO         │");
        System.out.println("└─────────────────────────────────────────┘");
        
        try {
            int numMesa = leerEntero("Ingrese número de mesa: ");
            
            System.out.println("\n--- Datos de la COMIDA del combo ---");
            String nombreComida = leerTexto("Ingrese nombre del plato: ");
            double precioComida = leerDouble("Ingrese precio de la comida: S/ ");
            System.out.print("¿Es plato fuerte? (true/false): ");
            boolean esPlatoFuerte = scanner.nextBoolean();
            scanner.nextLine();
            
            System.out.println("\n--- Datos de la BEBIDA del combo ---");
            String nombreBebida = leerTexto("Ingrese nombre de la bebida: ");
            double precioBebida = leerDouble("Ingrese precio de la bebida: S/ ");
            System.out.print("Ingrese tamaño (PEQUENO/MEDIANO/GRANDE): ");
            String tamanio = scanner.nextLine().toUpperCase();
            
            PedidoComida comida = new PedidoComida(numMesa, nombreComida, precioComida, esPlatoFuerte);
            PedidoBebida bebida = new PedidoBebida(numMesa, nombreBebida, precioBebida, tamanio);
            PedidoCombo combo = new PedidoCombo(numMesa, comida, bebida);
            
            listaPedidos.add(combo);
            
            System.out.println("\n ¡Pedido combo registrado exitosamente!");
            combo.mostrarInformacion();
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n Error inesperado: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    // Opción 4: Listar todos los pedidos
    private static void listarTodosLosPedidos() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║                 LISTA DE TODOS LOS PEDIDOS           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        
        if (listaPedidos.isEmpty()) {
            System.out.println("\n No hay pedidos registrados en el sistema.");
            return;
        }
        
        System.out.println("\n Total de pedidos: " + listaPedidos.size());
        
        for (Pedido pedido : listaPedidos) {
            pedido.mostrarInformacion();
            System.out.println();
        }
    }
    
    // Opción 5: Calcular total de ventas del día (solo entregados)
    private static void calcularTotalVentas() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║              TOTAL DE VENTAS DEL DÍA                 ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        
        double total = 0;
        int contadorEntregados = 0;
        
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstado().equals("ENTREGADO")) {
                total += pedido.getPrecio();
                contadorEntregados++;
            }
        }
        
        System.out.println("\n? Resumen de ventas:");
        System.out.println("   • Pedidos entregados: " + contadorEntregados);
        System.out.println("   • Total vendido: S/ " + String.format("%.2f", total));
        
        if (contadorEntregados == 0) {
            System.out.println("\n⚠ No hay pedidos entregados aún.");
        }
    }
    
    // Opción 6: Buscar pedidos por número de mesa (mostrar pendientes)
    private static void buscarPorMesa() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│      BUSCAR PEDIDOS POR MESA           │");
        System.out.println("└─────────────────────────────────────────┘");
        
        int numMesa = leerEntero("Ingrese número de mesa a buscar: ");
        
        boolean encontrado = false;
        
        for (Pedido pedido : listaPedidos) {
            if (pedido.getNumMesa() == numMesa && pedido.getEstado().equals("PENDIENTE")) {
                if (!encontrado) {
                    System.out.println("\n Pedidos pendientes para la mesa " + numMesa + ":");
                }
                pedido.mostrarInformacion();
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("\nℹ️ No se encontraron pedidos pendientes para la mesa " + numMesa);
        }
    }
    
    // Opción 7: Cambiar estado de pedido a entregado (por ID)
    private static void cambiarEstadoPedido() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│      CAMBIAR ESTADO DE PEDIDO          │");
        System.out.println("└─────────────────────────────────────────┘");
        
        if (listaPedidos.isEmpty()) {
            System.out.println("\n No hay pedidos registrados.");
            return;
        }
        
        int idBuscado = leerEntero("Ingrese el ID del pedido a entregar: ");
        Pedido pedidoEncontrado = null;
        
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == idBuscado) {
                pedidoEncontrado = pedido;
                break;
            }
        }
        
        if (pedidoEncontrado != null) {
            if (pedidoEncontrado.getEstado().equals("PENDIENTE")) {
                pedidoEncontrado.marcarEntregado();
                System.out.println("\n Estado actualizado correctamente.");
                pedidoEncontrado.mostrarInformacion();
            } else {
                System.out.println("\n El pedido ID " + idBuscado + " ya estaba entregado.");
            }
        } else {
            System.out.println("\n No se encontró un pedido con ID: " + idBuscado);
        }
    }
    
    // Opción 8: Ver pedidos pendientes
    private static void verPedidosPendientes() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║              PEDIDOS PENDIENTES                      ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        
        boolean hayPendientes = false;
        
        for (Pedido pedido : listaPedidos) {
            if (pedido.getEstado().equals("PENDIENTE")) {
                if (!hayPendientes) {
                    System.out.println("\n Lista de pedidos pendientes:");
                }
                pedido.mostrarInformacion();
                hayPendientes = true;
            }
        }
        
        if (!hayPendientes) {
            System.out.println("\n No hay pedidos pendientes. ¡Todos los pedidos han sido entregados!");
        }
    }
}