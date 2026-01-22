package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

public class PedidoComida extends Pedido {

    private boolean conMochilaTermica;

    public PedidoComida(int id, String direccion, boolean conMochilaTermica, double distanciaKm) {
        super(id, direccion, AppConfig.TipoPedido.COMIDA, distanciaKm);
        this.conMochilaTermica = conMochilaTermica;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido Comida: buscando repartidor con mochila térmica...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        if (conMochilaTermica) {
            setRepartidorAsignado(nombreRepartidor);
            System.out.println("Repartidor " + getRepartidorAsignado() +
                    " asignado al pedido de comida (tiene mochila térmica).");
        } else {
            System.out.println("ERROR: " + nombreRepartidor +
                    " no tiene mochila térmica. No se puede asignar.");
        }
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int) (2 * getDistanciaKm());
    }

    @Override
    public void despachar() {
        if (!getCancelado()) {
            System.out.println("Pedido Comida despachado correctamente.");
            registrarDespacho();
        } else {
            System.out.println("No se puede despachar un pedido cancelado.");
        }
    }

    @Override
    public void cancelar() {
        setCancelado(true);
        System.out.println("Cancelando Pedido Comida #" + getIdPedido() + "... \nPedido cancelado exitosamente.");
    }
}


