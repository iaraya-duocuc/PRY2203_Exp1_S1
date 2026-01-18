package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public abstract class Pedido {
    private int idPedido;
    private String direccion;
    private AppConfig.TipoPedido tipoPedido;
    private double distanciaKm;

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

    // Para sobreescritura
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor genérico al pedido " + idPedido);
    }

    // Sobrecarga
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor " + nombreRepartidor + " asignado al pedido " + idPedido);
    }

    // Abstracta ya que no hay fórmula genérica aplicable a todas las clases que heredan de Pedido
    public abstract int calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("Pedido " + tipoPedido.obtenerNombre() + " #" + idPedido);
        System.out.println("Dirección: " + direccion);
        System.out.println("Distancia: " + distanciaKm + " km");
    }
}
