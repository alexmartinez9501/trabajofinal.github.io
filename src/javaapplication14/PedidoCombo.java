/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author USER
 */
public class PedidoCombo extends Pedido {
    private PedidoComida comida;
    private PedidoBebida bebida;
    
    public PedidoCombo(int numMesa, PedidoComida comida, PedidoBebida bebida) {
        // El nombre se forma automáticamente, precio se calcula después
        super(numMesa, "", 0);
        this.comida = comida;
        this.bebida = bebida;
        this.setNombreItem("Combo: " + comida.getNombreItem() + " + " + bebida.getNombreItem());
        calcularPrecioCombo();
        calcularTiempoEstimado();
    }
    
    private void calcularPrecioCombo() {
        double precioCombo = comida.getPrecio() + bebida.getPrecio();
        double descuento = precioCombo * 0.10; // 10% descuento
        double precioFinal = precioCombo - descuento;
        setPrecio(precioFinal);
    }
    
    @Override
    public void calcularTiempoEstimado() {
        int tiempoCombo = comida.getTiempoEstimado() + bebida.getTiempoEstimado() - 5;
        setTiempoEstimado(tiempoCombo);
    }
    
    public String getTipo() {
        return "COMBO";
    }
    
    public PedidoComida getComida() { return comida; }
    public PedidoBebida getBebida() { return bebida; }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("\n [PEDIDO COMBO] - 10% DESCUENTO APLICADO");
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│ ID: " + getId());
        System.out.println("│ Mesa: " + getNumMesa());
        System.out.println("│ Ítem: " + getNombreItem());
        System.out.println("│ Precio original: S/ " + String.format("%.2f", comida.getPrecio() + bebida.getPrecio()));
        System.out.println("│ Descuento (10%): S/ " + String.format("%.2f", (comida.getPrecio() + bebida.getPrecio()) * 0.10));
        System.out.println("│ Precio final: S/ " + String.format("%.2f", getPrecio()));
        System.out.println("│ Estado: " + getEstado());
        System.out.println("│ Tiempo estimado: " + getTiempoEstimado() + " minutos");
        System.out.println("│ Hora registro: " + getHoraRegistro());
        System.out.println("│");
        System.out.println("│ ─── Componentes del Combo ───");
        System.out.println("│   • Comida: " + comida.getNombreItem());
        System.out.println("│   • Bebida: " + bebida.getNombreItem());
        System.out.println("└─────────────────────────────────────────┘");
    }
}