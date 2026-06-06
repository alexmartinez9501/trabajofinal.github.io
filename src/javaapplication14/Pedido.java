/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author USER
 */
import java.time.LocalTime;

public abstract class Pedido {
    // Atributos privados (encapsulamiento)
    private static int contadorId = 1;
    private int id;
    private int numMesa;
    private String nombreItem;
    private double precio;
    private String estado;
    private int tiempoEstimado;
    private LocalTime horaRegistro;
    
    // Constructor
    public Pedido(int numMesa, String nombreItem, double precio) {
        this.id = contadorId++;
        setNumMesa(numMesa);
        setNombreItem(nombreItem);
        setPrecio(precio);
        this.estado = "PENDIENTE";
        this.horaRegistro = LocalTime.now();
    }
    
    // Getters
    public int getId() { return id; }
    public int getNumMesa() { return numMesa; }
    public String getNombreItem() { return nombreItem; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }
    public int getTiempoEstimado() { return tiempoEstimado; }
    public LocalTime getHoraRegistro() { return horaRegistro; }
    
    // Setters con validaciones
    public void setNumMesa(int numMesa) {
        if (numMesa <= 0) {
            throw new IllegalArgumentException("El número de mesa debe ser positivo.");
        }
        this.numMesa = numMesa;
    }
    
    public void setNombreItem(String nombreItem) {
        if (nombreItem == null || nombreItem.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ítem no puede estar vacío.");
        }
        this.nombreItem = nombreItem;
    }
    
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }
    
    protected void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
    // Método concreto
    public void marcarEntregado() {
        if (this.estado.equals("PENDIENTE")) {
            this.estado = "ENTREGADO";
            System.out.println(" Pedido ID " + id + " marcado como entregado.");
        } else {
            System.out.println(" El pedido ID " + id + " ya estaba entregado.");
        }
    }
    
    // Método abstracto
    public abstract void calcularTiempoEstimado();
    
    // Método concreto mostrarInformacion
    public void mostrarInformacion() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│ ID: " + id);
        System.out.println("│ Mesa: " + numMesa);
        System.out.println("│ Ítem: " + nombreItem);
        System.out.println("│ Precio: S/ " + String.format("%.2f", precio));
        System.out.println("│ Estado: " + estado);
        System.out.println("│ Tiempo estimado: " + tiempoEstimado + " minutos");
        System.out.println("│ Hora registro: " + horaRegistro);
        System.out.println("└─────────────────────────────────────────┘");
    }
}