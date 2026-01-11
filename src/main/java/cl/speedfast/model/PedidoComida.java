package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public class PedidoComida extends Pedido {

    private boolean conMochilaTermica;

    public PedidoComida(int id, String direccion, boolean conMochilaTermica) {
        super(id, direccion, AppConfig.TipoPedido.COMIDA);
        this.conMochilaTermica = conMochilaTermica;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido Comida: buscando repartidor con mochila térmica...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        if (conMochilaTermica) {
            System.out.println("Repartidor " + nombreRepartidor +
                    " asignado al pedido de comida (tiene mochila térmica).");
        } else {
            System.out.println("ERROR: " + nombreRepartidor +
                    " no tiene mochila térmica. No se puede asignar.");
        }
    }
}
