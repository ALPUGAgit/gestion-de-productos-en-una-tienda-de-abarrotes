import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        // Productos de ejemplo
        tienda.agregarProducto(new Producto("Arroz", 25.0, 10));
        tienda.agregarProducto(new Producto("Frijol", 30.0, 5));
        tienda.agregarProducto(new Producto("Aceite", 45.5, 8));
        tienda.agregarProducto(new Producto("Azúcar", 20.0, 12));

        System.out.println("=== Gestión de Productos - Tienda de Abarrotes ===");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nEscribe el nombre del producto que deseas revisar (o 'listar' o 'salir'): ");
                String entrada = sc.nextLine().trim();
                if (entrada.equalsIgnoreCase("salir")) {
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                }

                if (entrada.equalsIgnoreCase("listar")) {
                    System.out.println("\nInventario completo:");
                    tienda.listarProductos();
                    continue;
                }

                Producto encontrado = tienda.buscarProductoPorNombre(entrada);
                if (encontrado != null) {
                    System.out.println("\nDatos del producto:");
                    encontrado.mostrarInfo();
                    System.out.println("Valor total en inventario: $" + String.format("%.2f", encontrado.calcularValorTotal()));

                    // Preguntar si desea modificar
                    System.out.print("\n¿Deseas modificar este producto? (precio/cantidad/no): ");
                    String opcion = sc.nextLine().trim();

                    if (opcion.equalsIgnoreCase("precio")) {
                        System.out.print("Introduce el nuevo precio: ");
                        String precioStr = sc.nextLine().trim();
                        try {
                            double nuevoPrecio = Double.parseDouble(precioStr);
                            if (nuevoPrecio < 0) {
                                System.out.println("El precio no puede ser negativo. No se realizó ningún cambio.");
                            } else {
                                encontrado.actualizarPrecio(nuevoPrecio);
                                System.out.println("Precio actualizado correctamente.");
                                encontrado.mostrarInfo();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. No se realizó ningún cambio.");
                        }
                    } else if (opcion.equalsIgnoreCase("cantidad")) {
                        System.out.print("Introduce la nueva cantidad: ");
                        String cantidadStr = sc.nextLine().trim();
                        try {
                            int nuevaCantidad = Integer.parseInt(cantidadStr);
                            if (nuevaCantidad < 0) {
                                System.out.println("La cantidad no puede ser negativa. No se realizó ningún cambio.");
                            } else {
                                encontrado.actualizarStock(nuevaCantidad);
                                System.out.println("Cantidad actualizada correctamente.");
                                encontrado.mostrarInfo();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. No se realizó ningún cambio.");
                        }
                    } else {
                        System.out.println("No se realizaron cambios.");
                    }
                } else {
                    System.out.println("Producto no encontrado: " + entrada);
                    System.out.println("Escribe 'listar' para ver los productos disponibles.");
                }

                // Continuar o salir
                System.out.print("\n¿Deseas realizar otra operación? (s/n): ");
                String resp = sc.nextLine().trim();
                if (resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("no")) {
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                }
            }
        }
    }
}

