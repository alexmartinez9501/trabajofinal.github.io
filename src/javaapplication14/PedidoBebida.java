/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author USER
 */
public class PedidoBebida extends Pedido {
    private String tamanio; // "PEQUENO", "MEDIANO", "GRANDE"
    
    public PedidoBebida(int numMesa, String nombreItem, double precio, String tamanio) {
        super(numMesa, nombreItem, precio);
        setTamanio(tamanio);
        calcularTiempoEstimado();
    }
    
    public String getTamanio() { return tamanio; }
    
    public void setTamanio(String tamanio) {
        if (tamanio == null || (!tamanio.equals("PEQUENO") && !tamanio.equals("MEDIANO") && !tamanio.equals("GRANDE"))) {
            throw new IllegalArgumentException("Tamaño debe ser PEQUENO, MEDIANO o GRANDE");
        }
        this.tamanio = tamanio;
    }
    
    @Override
    public void calcularTiempoEstimado() {
        switch (tamanio) {
            case "PEQUENO":
                setTiempoEstimado(5);
                break;
            case "MEDIANO":
                setTiempoEstimado(7);
                break;
            case "GRANDE":
                setTiempoEstimado(10);
                break;
        }
    }
    
    public String getTipo() {
        return "BEBIDA";
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("\n🥤 [PEDIDO DE BEBIDA] - Tamaño: " + tamanio);
        super.mostrarInformacion();
    }
}