package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un pedido dentro del sistema.
 */
public abstract class Pedido implements Cancelable, Despachable, Rastreable {

    private int idPedido;
    private String direccion;
    private AppConfig.TipoPedido tipoPedido;
    private double distanciaKm;
    private boolean cancelado = false;
    private List<String> historial = new ArrayList<>();
    private String repartidorAsignado = "No asignado";

    /**
     * Constructor base de un pedido.
     */
    public Pedido(int idPedido, String direccion, AppConfig.TipoPedido tipoPedido, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.tipoPedido = tipoPedido;
        this.distanciaKm = distanciaKm;
    }

    // Getters
    public int getIdPedido() { return idPedido; }
    public String getDireccion() { return direccion; }
    public AppConfig.TipoPedido getTipoPedido() { return tipoPedido; }
    public double getDistanciaKm() { return distanciaKm; }
    public boolean getCancelado() { return cancelado; }
    public String getRepartidorAsignado() { return repartidorAsignado; }

    // Setters
    public void setCancelado(boolean cancelado) { this.cancelado = cancelado; }
    public void setRepartidorAsignado(String repartidorAsignado) {this.repartidorAsignado = repartidorAsignado; }

    /**
     * Asignacion generica de repartidor.
     * Puede ser sobreescrita por las subclases.
     */
    public void asignarRepartidor() {
        // Implementacion generica
    }

    /**
     * Asigna un repartidor por nombre.
     */
    public void asignarRepartidor(String nombreRepartidor) {
        // Implementacion genérica con nombre
    }

    /**
     * Calcula el tiempo estimado de entrega.
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Muestra un resumen basico del pedido.
     */
    public void mostrarResumen() {
        System.out.println("Pedido " + tipoPedido.obtenerNombre() + " #" + idPedido);
        System.out.println("Dirección: " + direccion);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    /**
     * Registra un despacho en el historial.
     */
    protected void registrarDespacho() {
        historial.add(
                "Pedido " + tipoPedido.obtenerNombre() +
                        " #" + idPedido +
                        " – entregado por " + repartidorAsignado
        );
    }

    /**
     * Ejecuta el despacho del pedido si no esta cancelado.
     */
    @Override
    public void despachar() {
        if (!getCancelado()) {
            System.out.println("Pedido " + tipoPedido.obtenerNombre() + " despachado correctamente.");
            registrarDespacho();
        } else {
            System.out.println("No se puede despachar un pedido cancelado.");
        }
    }

    /**
     * Cancela el pedido.
     */
    @Override
    public void cancelar() {
        setCancelado(true);
        System.out.println("Cancelando Pedido " + tipoPedido.obtenerNombre() + " #" + getIdPedido() + "... \nPedido cancelado exitosamente.");
    }

    /**
     * Retorna el historial de despachos.
     */
    @Override
    public List<String> verHistorial() {
        return historial;
    }
}
