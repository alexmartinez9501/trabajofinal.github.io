/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author USER
 */
public class PedidoComida extends Pedido {
    private boolean esPlatoFuerte;
    
    public PedidoComida(int numMesa, String nombreItem, double precio, boolean esPlatoFuerte) {
        super(numMesa, nombreItem, precio);
        setEsPlatoFuerte(esPlatoFuerte);
        calcularTiempoEstimado();
    }
    
    public boolean isEsPlatoFuerte() { return esPlatoFuerte; }
    
    public void setEsPlatoFuerte(boolean esPlatoFuerte) {
        this.esPlatoFuerte = esPlatoFuerte;
    }
    
    @Override
    public void calcularTiempoEstimado() {
        if (esPlatoFuerte) {
            setTiempoEstimado(20);
        } else {
            setTiempoEstimado(15);
        }
    }
    
    public String getTipo() {
        return "COMIDA";
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("\n️ [PEDIDO DE COMIDA] " + (esPlatoFuerte ? "(Plato Fuerte)" : "(Plato Normal)"));
        super.mostrarInformacion();
    }
}