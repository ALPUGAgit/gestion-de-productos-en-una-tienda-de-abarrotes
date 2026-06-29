public class Producto {
    private final String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre +
                           " | Precio: $" + String.format("%.2f", precio) +
                           " | Cantidad: " + cantidad);
    }

    public double calcularValorTotal() {
        return precio * cantidad;
    }

    public void actualizarStock(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
}
