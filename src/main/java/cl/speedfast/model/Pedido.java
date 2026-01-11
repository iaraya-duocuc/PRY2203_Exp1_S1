package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public class Pedido {
    protected int idPedido;
    protected String direccion;
    protected AppConfig.TipoPedido tipoPedido;

    public Pedido(int idPedido, String direccion, AppConfig.TipoPedido tipoPedido) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.tipoPedido = tipoPedido;
    }

    // Para sobreescritura
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor genérico al pedido " + idPedido);
    }

    // Sobrecarga
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor " + nombreRepartidor + " asignado al pedido " + idPedido);
    }
}
